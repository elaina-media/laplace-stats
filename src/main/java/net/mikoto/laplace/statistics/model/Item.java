package net.mikoto.laplace.statistics.model;

import com.mybatisflex.annotation.Id;
import com.mybatisflex.annotation.Table;
import lombok.Data;

/**
 * @author mikoto
 * &#064;date 2024/4/10
 * Create for laplace-statistics
 */
@Data
@Table("item")
public class Item {
    @Id
    private int id;
    private String itemName;
}
