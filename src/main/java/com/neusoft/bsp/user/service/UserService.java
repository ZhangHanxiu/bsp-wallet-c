package com.neusoft.bsp.user.service;

import com.neusoft.bsp.user.entity.User;

import java.util.List;
import java.util.Map;

public interface UserService {

    int insert(User user);

    int update(User user);

    int delete(String userid);

    List<User> getAll();

    List<User> getAllByFilter(Map<String,Object> map);


}
