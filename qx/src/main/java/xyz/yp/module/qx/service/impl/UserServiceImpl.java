package xyz.yp.module.qx.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.yp.module.qx.domain.Permission;
import xyz.yp.module.qx.domain.Role;
import xyz.yp.module.qx.domain.User;
import xyz.yp.module.qx.mapper.PermissionMapper;
import xyz.yp.module.qx.mapper.RoleMapper;
import xyz.yp.module.qx.mapper.UserMapper;
import xyz.yp.module.qx.service.UserService;

import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private RoleMapper roleMapper;
    @Autowired
    private PermissionMapper permissionMapper;

    @Override
    public User findByUserName(String userName) {
        User user = userMapper.selectByUserName(userName);
        return user;
    }

    @Override
    public List<User> findByParams(Map<String, Object> params) {
        List<User> users = userMapper.selectByParams(params);
        return users;
    }

    @Override
    public PageInfo<User> findByParams(Map<String, Object> params, int currentPage, int pageSize) {
        PageHelper.startPage(currentPage, pageSize);
        List<User> users = userMapper.selectByParams(params);
        PageInfo<User> page = new PageInfo<User>(users);
        return page;
    }

    @Override
    public void create(User user) {
        userMapper.insert(user);
    }

    @Override
    public void deleteById(long id) {
        userMapper.delete(id);
    }

}
