package net.mikoto.laplace.statistics.controller;

import cn.dev33.satoken.stp.StpUtil;
import com.alibaba.fastjson2.JSONObject;
import net.mikoto.laplace.statistics.mapper.BattleMapper;
import net.mikoto.laplace.statistics.model.metadata.Battle;
import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("/battle")
public class BattleRestController {
    private final BattleMapper battleMapper;

    @Autowired
    public BattleRestController(BattleMapper battleMapper) {
        this.battleMapper = battleMapper;
    }

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

        battleMapper.insert(params.toJavaObject(Battle.class));

        Battle battle = battleMapper.selectOneById(params.getInteger("id"));
        result.put("success", true);
        result.put("msg", "");
        result.put("body", JSONObject.from(battle));
        return result;
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

        battleMapper.update(params.toJavaObject(Battle.class));

        Battle battle = battleMapper.selectOneById(params.getInteger("id"));
        result.put("success", true);
        result.put("msg", "");
        result.put("body", JSONObject.from(battle));
        return result;
    }

    @RequestMapping(
            value = "/_get",
            method = RequestMethod.POST
    )
    public JSONObject get(@RequestBody JSONObject params) {
        JSONObject result = new JSONObject();

        Battle battle = battleMapper.selectOneById(params.getInteger("id"));
        result.put("success", true);
        result.put("msg", "");
        result.put("body", JSONObject.from(battle));
        return result;
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

        battleMapper.delete(params.toJavaObject(Battle.class));

        result.put("success", true);
        result.put("msg", "");
        result.put("body", new JSONObject());
        return result;
    }
}
