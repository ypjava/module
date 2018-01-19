package xyz.yp.module.qx.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.yp.module.qx.domain.Role;
import xyz.yp.module.qx.mapper.RoleMapper;
import xyz.yp.module.qx.service.RoleService;

import java.util.List;
import java.util.Map;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleMapper roleMapper;

    @Override
    public List<Role> findByUserName(String userName) {
        List<Role> roles = roleMapper.selectByUserName(userName);
        return roles;
    }

    @Override
    public List<Role> findByParams(Map<String, Object> params) {
        List<Role> roles = roleMapper.selectByParams(params);
        return roles;
    }

    @Override
    public PageInfo<Role> findByParams(Map<String, Object> params, int currentPage, int pageSize) {
        PageHelper.startPage(currentPage, pageSize);
        List<Role> roles = roleMapper.selectByParams(params);
        PageInfo<Role> page = new PageInfo<Role>(roles);
        return page;
    }

    @Override
    public void create(Role role) {
        roleMapper.insert(role);
    }

}
