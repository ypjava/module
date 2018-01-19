package xyz.yp.module.qx.mapper;

import org.springframework.stereotype.Repository;
import xyz.yp.module.core.mapper.BaseMapper;
import xyz.yp.module.qx.domain.Permission;

import java.util.List;

@Repository
public interface PermissionMapper extends BaseMapper<Permission, Long> {

    List<Permission> selectByUserName(String userName);

}
