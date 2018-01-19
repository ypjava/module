package xyz.yp.module.qx.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.yp.module.qx.domain.Permission;
import xyz.yp.module.qx.mapper.PermissionMapper;
import xyz.yp.module.qx.service.PermissionService;

import java.util.List;
import java.util.Map;

@Service
public class PermissionServiceImpl implements PermissionService {
    @Autowired
    private PermissionMapper permissionMapper;

    @Override
    public List<Permission> findByUserName(String userName) {
        List<Permission> permissions = permissionMapper.selectByUserName(userName);
        return permissions;
    }

    @Override
    public List<Permission> findByParams(Map<String, Object> params) {
        List<Permission> permissions = permissionMapper.selectByParams(params);
        return permissions;
    }

    @Override
    public void create(Permission permission) {
        permissionMapper.insert(permission);
    }

}
