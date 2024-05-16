package net.mikoto.laplace.statistics.model;

import com.mybatisflex.annotation.Id;
import lombok.Data;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * @author mikoto
 * &#064;date 2024/4/7
 * Create for laplace-statistics
 */
@Data
public class Sample {
    private long id;
    private long battleId;
    private String battleName;
    private Set<SampleReward> sampleRewards = new HashSet<>();
    private int battleCount;
    private String server;
    private Date createTime;

    public Sample() {
        createTime = new Date();
    }

    @Data
    public static class SampleReward {
        private long sampleId;
        private int itemId;
        private int quantity;
    }
}
