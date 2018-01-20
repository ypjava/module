package xyz.yp.module.qx.service;

import com.github.pagehelper.PageInfo;
import xyz.yp.module.qx.domain.User;

import java.util.List;
import java.util.Map;

public interface UserService {

    User findByUserName(String userName);

    List<User> findByParams(Map<String, Object> params);

    PageInfo<User> findByParams(Map<String, Object> params, int currentPage, int pageSize);

    void create(User user);

    void deleteById(long id);

    void updatePassword(long userId, String oldPassword, String newPassword);

    void updatePassword(long userId, String newPassword);

}
