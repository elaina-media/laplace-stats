package net.mikoto.laplace.statistics.model.sample;

import com.mybatisflex.annotation.Id;
import com.mybatisflex.annotation.Table;
import lombok.Data;

import java.util.Date;

/**
 * @author mikoto
 * &#064;date 2024/4/7
 * Create for laplace-statistics
 */
@Data
public class Sample {
    @Id
    private long id;
    private long battleId;
    private String battleName;
    private SampleLifeCycle sampleLifeCycle;
    private Date createTime;
    private int battleCount;

    public enum SampleLifeCycle {
        Queue,
        Stored
    }
}
