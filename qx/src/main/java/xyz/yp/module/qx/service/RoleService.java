package xyz.yp.module.qx.service;

import com.github.pagehelper.PageInfo;
import xyz.yp.module.qx.domain.Role;

import java.util.List;
import java.util.Map;

public interface RoleService {

    List<Role> findByUserName(String userName);

    List<Role> findByParams(Map<String, Object> params);

    PageInfo<Role> findByParams(Map<String, Object> params, int currentPage, int pageSize);

    void create(String code, String name);

    void update(String roleId, String code, String name);

}
