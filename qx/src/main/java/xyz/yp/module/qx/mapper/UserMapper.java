package xyz.yp.module.qx.mapper;

import org.springframework.stereotype.Repository;
import xyz.yp.module.core.mapper.BaseMapper;
import xyz.yp.module.qx.domain.User;

@Repository
public interface UserMapper extends BaseMapper<User, Long> {

    User selectByUserName(String userName);

}
