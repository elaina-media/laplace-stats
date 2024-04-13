package net.mikoto.laplace.statistics.service;

import net.mikoto.laplace.statistics.model.Admin;

/**
 * @author mikoto
 * &#064;date 2024/4/14
 * Create for laplace-statistics
 */
public interface AdminService {
    int checkAdmin(String username, String password);
    Admin register(Admin admin, String rawPassword);
}
