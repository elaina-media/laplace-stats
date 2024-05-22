package net.mikoto.laplace.statistics.controller;

import cn.dev33.satoken.stp.StpUtil;
import com.alibaba.fastjson2.JSONObject;
import net.mikoto.laplace.statistics.mapper.ItemRecipeMapper;
import net.mikoto.laplace.statistics.model.metadata.ItemRecipe;
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
@RequestMapping("/itemRecipe")
public class ItemRecipeRestController {
    private final ItemRecipeMapper itemRecipeMapper;

    @Autowired
    public ItemRecipeRestController(ItemRecipeMapper itemRecipeMapper) {
        this.itemRecipeMapper = itemRecipeMapper;
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

        itemRecipeMapper.insert(params.toJavaObject(ItemRecipe.class));

        ItemRecipe itemRecipe = itemRecipeMapper.selectOneByMap(params);
        result.put("success", true);
        result.put("msg", "");
        result.put("body", JSONObject.from(itemRecipe));
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

        itemRecipeMapper.update(params.toJavaObject(ItemRecipe.class));

        ItemRecipe itemRecipe = itemRecipeMapper.selectOneById(params.getInteger("id"));
        result.put("success", true);
        result.put("msg", "");
        result.put("body", JSONObject.from(itemRecipe));
        return result;
    }

    @RequestMapping(
            value = "/_get",
            method = RequestMethod.POST
    )
    public JSONObject get(@RequestBody JSONObject params) {
        JSONObject result = new JSONObject();

        ItemRecipe itemRecipe = itemRecipeMapper.selectOneById(params.getInteger("id"));
        result.put("success", true);
        result.put("msg", "");
        result.put("body", JSONObject.from(itemRecipe));
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

        itemRecipeMapper.delete(params.toJavaObject(ItemRecipe.class));

        ItemRecipe itemRecipe = itemRecipeMapper.selectOneById(params.getInteger("id"));
        result.put("success", true);
        result.put("msg", "");
        result.put("body", JSONObject.from(itemRecipe));
        return result;
    }
}
