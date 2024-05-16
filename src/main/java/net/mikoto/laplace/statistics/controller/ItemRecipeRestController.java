package net.mikoto.laplace.statistics.controller;

import cn.dev33.satoken.stp.StpUtil;
import com.alibaba.fastjson2.JSONObject;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author mikoto
 * &#064;date 2024/4/16
 * Create for laplace-statistics
 */
@RestController
@RequestMapping("/itemRecipe")
public class ItemRecipeRestController {
    @RequestMapping(
            value = "/_add",
            method = RequestMethod.POST
    )
    public JSONObject add(@RequestBody JSONObject params) {
        JSONObject result = new JSONObject();
        if (!StpUtil.isLogin()) {
            result.put("success", false);
            result.put("msg", "请先登录");
            return result;
        }
        if (!StpUtil.hasRole("admin")) {
            result.put("success", false);
            result.put("msg", "无权限访问");
            return result;
        }

        return null;
    }


    @RequestMapping(
            value = "/_update",
            method = RequestMethod.POST
    )
    public JSONObject update(@RequestBody JSONObject params) {
        JSONObject result = new JSONObject();
        if (!StpUtil.isLogin()) {
            result.put("success", false);
            result.put("msg", "请先登录");
            return result;
        }
        if (!StpUtil.hasRole("admin")) {
            result.put("success", false);
            result.put("msg", "无权限访问");
            return result;
        }

        return null;
    }

    @RequestMapping(
            value = "/_get",
            method = RequestMethod.POST
    )
    public JSONObject get(@RequestBody JSONObject params) {
        JSONObject result = new JSONObject();

        return null;
    }

    @RequestMapping(
            value = "/_remove",
            method = RequestMethod.POST
    )
    public JSONObject remove(@RequestBody JSONObject params) {
        JSONObject result = new JSONObject();
        if (!StpUtil.isLogin()) {
            result.put("success", false);
            result.put("msg", "请先登录");
            return result;
        }
        if (!StpUtil.hasRole("admin")) {
            result.put("success", false);
            result.put("msg", "无权限访问");
            return result;
        }

        return null;
    }
}
