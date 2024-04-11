package net.mikoto.laplace.statistics.model;

import com.mybatisflex.annotation.Table;
import lombok.Data;

/**
 * @author mikoto
 * &#064;date 2024/4/10
 * Create for laplace-statistics
 */
@Data
@Table("battle")
public class Battle {
    private int id;
    private String battleName;
    private long sampleCount;
    private int cellCost;
}
