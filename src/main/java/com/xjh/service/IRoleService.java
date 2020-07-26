package com.xjh.service;

import com.xjh.bean.Role;
import org.springframework.stereotype.Service;

import java.util.List;

public interface IRoleService {
    List<Integer> findRoleByUserId(int id);
    List<Role> findNotRoleByUserId(int id);
    void addRole(List<Integer> ids,int userId);
}
