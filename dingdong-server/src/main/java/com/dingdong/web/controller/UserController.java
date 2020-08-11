package com.dingdong.web.controller;

import com.dingdong.domain.model.Result;
import com.dingdong.domain.model.User;
import com.dingdong.domain.query.UserQuery;
import com.dingdong.service.UserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 用户控制类
 * @author pjl
 * @since 2020/08/11
 */
 @RestController
 @RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;


    @ApiOperation(value = "用户登录")
    @GetMapping("login")
    @ResponseBody
    public Result login(UserQuery userQuery){
        Result result = userService.login(userQuery);
        return result;
    }

    @ApiOperation(value = "修改用户资料")
    @PostMapping("update")
    public User update(User user){
        return userService.update(user);
    }



}
