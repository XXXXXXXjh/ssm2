package com.xjh.dao;

import com.xjh.bean.Role;

import java.util.List;

public interface IRoleDao {
    List<Integer> findRoleIdsByUserId(int id);
    List<Role> findNotRoleByUserId(int id);
}
