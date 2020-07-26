package com.xjh.service.impl;

import com.xjh.bean.PageInfo;
import com.xjh.bean.User;
import com.xjh.dao.IUserDao;
import com.xjh.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    private IUserDao userDao;

    @Override
    public int login(String username, String password) {
        User user = userDao.findUserByUsername(username);
        if(user!=null&&user.getPassword().equals(password)){
            return user.getId();
        }
        return -1;
    }

    @Override
    public PageInfo<User> findAll(int currentPage,String username) {
        PageInfo pageInfo = new PageInfo();
        pageInfo.setSize(5);
        int totalCount = userDao.getTotalCount(username);
        pageInfo.setTotalCount(totalCount);
        double d = totalCount/5.0;
        int tp = (int)Math.ceil(d);
        pageInfo.setTotalPage(tp);
        if(currentPage<=0){
            pageInfo.setCurrentPage(1);
        }else if(currentPage>tp){
            pageInfo.setCurrentPage(tp);
        }else{
            pageInfo.setCurrentPage(currentPage);
        }
        int start = (pageInfo.getCurrentPage()-1)*5;
        pageInfo.setList(userDao.findAll(start,5,username));
        return pageInfo;
    }

    @Override
    public void deleteById(int id) {
        userDao.deleteById(id);
    }

    @Override
    public void add(User user) {
        userDao.add(user);
    }

    @Override
    public User selectUserById(int id) {
        return userDao.selectUserById(id);
    }

    @Override
    public void update(User user) {
        userDao.update(user);
    }

    @Override
    public void deleteAll(List<Integer> ids) {
        userDao.deleteAll(ids);
    }
}
