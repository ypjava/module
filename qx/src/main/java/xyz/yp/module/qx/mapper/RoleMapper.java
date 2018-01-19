package xyz.yp.module.qx.mapper;

import org.springframework.stereotype.Repository;
import xyz.yp.module.core.mapper.BaseMapper;
import xyz.yp.module.qx.domain.Role;

import java.util.List;

@Repository
public interface RoleMapper extends BaseMapper<Role, Long> {

    List<Role> selectByUserName(String userName);

}
