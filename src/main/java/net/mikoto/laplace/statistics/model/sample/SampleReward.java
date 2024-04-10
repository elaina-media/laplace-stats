package net.mikoto.laplace.statistics.model.sample;

import lombok.Data;

/**
 * @author mikoto
 * &#064;date 2024/4/8
 * Create for laplace-statistics
 */
@Data
public class SampleReward {
    private long sampleId;
    private int itemId;
    private int quantity;
}
