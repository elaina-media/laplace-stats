package net.mikoto.laplace.statistics.controller;

import cn.dev33.satoken.stp.StpUtil;
import com.alibaba.fastjson2.JSONObject;
import net.mikoto.laplace.statistics.model.Admin;
import net.mikoto.laplace.statistics.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author mikoto
 * &#064;date 2024/4/14
 * Create for laplace-statistics
 * <p>
 * todo:
 * /_register 和 /_login 都使用明文传输
 * </p>
 */
@RestController
@RequestMapping("/admin")
public class AdminRestController {
    private final AdminService adminService;

    @Autowired
    public AdminRestController(AdminService adminService) {
        this.adminService = adminService;
    }


    @RequestMapping(
            value = "/_register",
            method = RequestMethod.POST
    )
    public JSONObject register(@RequestBody JSONObject params) {
        JSONObject result = new JSONObject();

        if (!StpUtil.isLogin()) {
            result.put("success", false);
            result.put("msg", "请先登录");
            return result;
        }

        if (!StpUtil.hasRole("super-admin")) {
            result.put("success", false);
            result.put("msg", "无权限访问");
            return result;
        }

        Admin admin = new Admin();
        admin.setName(params.getString("name"));
        admin.setQq(params.getLongValue("qq"));
        admin.setMail(params.getString("mail"));

        admin = adminService.register(admin, params.getString("rawPassword"));

        StpUtil.login(admin.getId());

        result.put("success", true);
        result.put("msg", "");
        return result;
    }

    @RequestMapping(
            value = "/_login",
            method = RequestMethod.POST
    )
    public JSONObject login(@RequestBody JSONObject params) {
        JSONObject result = new JSONObject();

        int adminId = adminService.checkAdmin(
                params.getString("name"),
                params.getString("password")
        );
        if (adminId != 0) {
            StpUtil.login(adminId);
        }
        result.put("success", adminId != 0);
        result.put("msg", adminId != 0 ? "" : "登录失败");
        return result;
    }
}
