package net.mikoto.laplace.statistics.controller;

import com.alibaba.fastjson2.JSONObject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author mikoto
 * &#064;date 2024/4/16
 * Create for laplace-statistics
 */
@RestController
@RequestMapping("/item")
public class ItemRestController {
    @RequestMapping("/_add")
    public JSONObject add() {
        return null;
    }
    @RequestMapping("/_remove")
    public JSONObject remove() {
        return null;
    }
    @RequestMapping("/_update")
    public JSONObject update() {
        return null;
    }
    @RequestMapping("/_get")
    public JSONObject get() {
        return null;
    }
}
