package net.mikoto.laplace.statistics.controller;

import com.alibaba.fastjson2.JSONObject;
import net.mikoto.laplace.statistics.model.Sample;
import net.mikoto.laplace.statistics.service.SampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author mikoto
 * &#064;date 2024/4/11
 * Create for laplace-statistics
 */
@RestController
@RequestMapping("/sample")
public class SampleRestController {
    private final SampleService sampleService;

    @Autowired
    public SampleRestController(SampleService sampleService) {
        this.sampleService = sampleService;
    }

    @RequestMapping("/_create")
    public void createSample(@RequestBody JSONObject sampleJson) {
        Sample sample = sampleJson.toJavaObject(Sample.class);
        sampleService.save(sample);
    }
}
