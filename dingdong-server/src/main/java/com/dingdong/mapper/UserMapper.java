package com.dingdong.mapper;

import com.dingdong.domain.model.User;
import com.dingdong.domain.query.UserQuery;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

public interface UserMapper {

    List<User> queryList(UserQuery query);

    void update(User user);
}
