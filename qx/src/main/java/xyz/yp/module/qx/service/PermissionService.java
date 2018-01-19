package xyz.yp.module.qx.service;

import xyz.yp.module.qx.domain.Permission;

import java.util.List;
import java.util.Map;

public interface PermissionService {

    List<Permission> findByUserName(String userName);

    List<Permission> findByParams(Map<String, Object> params);

    void create(Permission permission);

}
