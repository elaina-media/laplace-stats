package net.mikoto.laplace.statistics.controller;

import com.alibaba.fastjson2.JSONObject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author mikoto
 * &#064;date 2024/4/14
 * Create for laplace-statistics
 */
@RestController
@RequestMapping("/admin")
public class AdminRestController {
    @RequestMapping("/_register")
    public JSONObject register() {
        return null;
    }

    @RequestMapping("/_login")
    public JSONObject login(String username, String password) {
        return null;
    }
}
