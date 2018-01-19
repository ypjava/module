package xyz.yp.module.qx.service;

import xyz.yp.module.qx.domain.Permission;
import xyz.yp.module.qx.domain.Role;
import xyz.yp.module.qx.domain.User;

import java.util.List;
import java.util.Map;

public interface UserService {

    User findByUserName(String userName);

    List<Role> findRolesByUserName(String userName);

    List<Permission> findPermissionsByUserName(String userName);

    List<User> findByParams(Map<String, Object> params);

}
