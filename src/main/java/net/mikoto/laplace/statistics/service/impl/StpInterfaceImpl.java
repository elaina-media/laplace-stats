package net.mikoto.laplace.statistics.service.impl;

import cn.dev33.satoken.stp.StpInterface;
import com.mybatisflex.core.query.QueryWrapper;
import net.mikoto.laplace.statistics.mapper.PermissionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @author mikoto
 * &#064;date 2024/4/14
 * Create for laplace-statistics
 */
@Component
public class StpInterfaceImpl implements StpInterface {
    private final PermissionMapper permissionMapper;

    @Autowired
    public StpInterfaceImpl(PermissionMapper permissionMapper) {
        this.permissionMapper = permissionMapper;
    }

    @Override
    public List<String> getPermissionList(Object loginId, String loginType) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("admin_id", loginId);

        return permissionMapper.selectListByQueryAs(queryWrapper, String.class);
    }

    @Override
    public List<String> getRoleList(Object loginId, String loginType) {
        List<String> roleList = new ArrayList<>();
        roleList.add("admin");
        if (Integer.valueOf(1).equals(loginId)) {
            roleList.add("super-admin");
        }
        return roleList;
    }
}
