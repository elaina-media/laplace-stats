package net.mikoto.laplace.statistics.service.impl;

import com.mybatisflex.core.query.QueryWrapper;
import net.mikoto.laplace.statistics.mapper.AdminMapper;
import net.mikoto.laplace.statistics.model.Admin;
import net.mikoto.laplace.statistics.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author mikoto
 * &#064;date 2024/4/14
 * Create for laplace-statistics
 */
@Service
public class AdminServiceImpl implements AdminService {
    private final AdminMapper adminMapper;

    @Autowired
    public AdminServiceImpl(AdminMapper adminMapper) {
        this.adminMapper = adminMapper;
    }

    @Override
    public boolean checkAdmin(String username, String password) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("name", username);
        Admin admin = adminMapper.selectOneByQuery(queryWrapper);
        if (admin == null) {
            return false;
        }

        String encryptedPassword = admin.getSalt() + "_" + password + "_laplace-stats";
        return admin.getPassword().equals(encryptedPassword);
    }
}
