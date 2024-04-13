package net.mikoto.laplace.statistics.model;

import com.mybatisflex.annotation.Id;
import com.mybatisflex.annotation.Table;
import lombok.Data;

/**
 * @author mikoto
 * &#064;date 2024/4/14
 * Create for laplace-statistics
 */
@Data
@Table("admin")
public class Admin {
    @Id
    private int id;
    private String name;
    private long qq;
    private String mail;
    private String salt;
    private String password;
}
