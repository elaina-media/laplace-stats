package net.mikoto.laplace.statistics.model;

import com.mybatisflex.annotation.Table;
import lombok.Data;

/**
 * @author mikoto
 * &#064;date 2024/4/10
 * Create for laplace-statistics
 */
@Data
@Table("item_recipe")
public class ItemRecipe {
    private int sourceItemId;
    private int targetItemId;
}
