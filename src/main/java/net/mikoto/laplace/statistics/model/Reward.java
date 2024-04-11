package net.mikoto.laplace.statistics.model;

import com.mybatisflex.annotation.Table;
import lombok.Data;

import java.util.Date;

/**
 * @author mikoto
 * &#064;date 2024/4/10
 * Create for laplace-statistics
 */
@Data
@Table("reward")
public class Reward {
    private int itemId;
    private int battleId;
    private long quantity;
    private Date rangeStartTime;
    private Date rangeEndTime;
}
