package com.dingdong.service;

import com.alibaba.fastjson.JSON;
import com.dingdong.domain.model.Result;
import com.dingdong.domain.model.User;
import com.dingdong.domain.query.UserQuery;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @Test
    public void testLogin(){
        UserQuery userQuery = new UserQuery();
        userQuery.setUserName("dingding");
        userQuery.setPassWord("123");
        Result result = userService.login(userQuery);
        String toJSONString = JSON.toJSONString(result);
        System.out.println("--->> "+toJSONString);
    }
}
