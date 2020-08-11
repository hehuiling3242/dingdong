package com.dingdong.service;

import com.dingdong.domain.model.Result;
import com.dingdong.domain.model.User;
import com.dingdong.domain.query.UserQuery;
import com.dingdong.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import org.springframework.util.CollectionUtils;

import java.util.Collection;
import java.util.List;

@Service
public class UserService {


    @Autowired
    private UserMapper userMapper;

    public Result login(UserQuery userQuery){

        Result result = new Result();

        List<User> users = userMapper.queryList(userQuery);
        if(CollectionUtils.isEmpty(users)){
            result.setCode("400");
            result.setMessage("用户名或密码错误");
            return result;
        }

        User user = users.get(0);
        result.setCode("200");
        result.setMessage("登录成功");
        result.setData(user);
        return result;
    }

    @Transactional
    public User update(User user){
        Assert.notNull(user,"用户不能为空");
        Assert.notNull(user.getId(),"用户id不能为空");

        userMapper.update(user);

        return user;
    }
}
