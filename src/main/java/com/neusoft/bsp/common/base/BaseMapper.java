package com.neusoft.bsp.common.base;

import java.util.List;
import java.util.Map;

public interface BaseMapper<S,T> {
    int insert(T t);

    int update(T t);

    T getById(S pk);

    List<T> getALl();

    List<T> getAllByFilter(Map<String,Object> map);

    int delete(String id);
}
