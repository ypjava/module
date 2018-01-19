package xyz.yp.module.core.mapper;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public interface BaseMapper<E, ID extends Serializable> {

    void insert(E e);

    void delete(ID id);

    void update(E e, ID id);

    List<E> selectAll();

    E selectById(ID id);

    List<E> selectByParams(Map<String, Object> params);

}
