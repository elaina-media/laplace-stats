package net.mikoto.laplace.statistics.model;

import com.mybatisflex.annotation.Table;
import lombok.Data;

/**
 * @author mikoto
 * &#064;date 2024/4/14
 * Create for laplace-statistics
 */
@Data
@Table("permission")
public class Permission {
    private int adminId;
    private String permission;
}
