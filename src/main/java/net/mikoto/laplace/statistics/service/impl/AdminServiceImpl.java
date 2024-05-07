package net.mikoto.laplace.statistics.service.impl;

import cn.hutool.core.util.HashUtil;
import cn.hutool.core.util.RandomUtil;
import cn.hutool.crypto.digest.DigestUtil;
import cn.hutool.crypto.digest.Digester;
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
    public int checkAdmin(String username, String password) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("name", username);
        Admin admin = adminMapper.selectOneByQuery(queryWrapper);
        if (admin == null) {
            return 0;
        }

        String encryptedPassword = DigestUtil.sha256Hex(admin.getSalt() + "_" + password + "_laplace-stats");
        return admin.getPassword().equals(encryptedPassword) ? admin.getId() : 0;
    }

    @Override
    public Admin register(Admin admin, String rawPassword) {
        admin.setSalt(RandomUtil.randomString(10));
        String encryptedPassword = DigestUtil.sha256Hex(admin.getSalt() + "_" + rawPassword + "_laplace-stats");
        admin.setPassword(encryptedPassword);

        adminMapper.insert(admin);

        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("name", admin.getName());
        admin = adminMapper.selectOneByQuery(queryWrapper);

        return admin;
    }
}
