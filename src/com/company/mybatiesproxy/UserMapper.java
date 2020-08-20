package com.company.mybatiesproxy;

import java.util.List;

public interface UserMapper {
    @Select("select * from user where id=#{id}")
    List<User> findUserById(Integer id);
}
