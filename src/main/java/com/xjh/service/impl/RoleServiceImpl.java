package com.xjh.service.impl;

import com.xjh.bean.Role;
import com.xjh.bean.UserRole;
import com.xjh.dao.IRoleDao;
import com.xjh.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class RoleServiceImpl implements IRoleService {
    @Autowired
    private IRoleDao roleDao;

    @Override
    public List<Integer> findRoleByUserId(int id) {
        return roleDao.findRoleIdsByUserId(id);
    }

    @Override
    public List<Role> findNotRoleByUserId(int id) {
        return roleDao.findNotRoleByUserId(id);
    }

    @Override
    public void addRole(List<Integer> ids,int userId) {
        for(int i:ids){
            UserRole userRole = new UserRole();
            userRole.setRoleId(i);
            userRole.setUserId(userId);
            
        }
    }
}
