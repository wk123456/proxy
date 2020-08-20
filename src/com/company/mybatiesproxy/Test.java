package com.company.mybatiesproxy;

import com.company.commonproxy.Student;

import java.lang.annotation.Annotation;
import java.lang.reflect.*;
import java.util.Arrays;
import java.util.List;

public class Test {

    public static void main(String[] args) {
        UserMapper userMapper = (UserMapper)Proxy.newProxyInstance(UserMapper.class.getClassLoader(), new Class<?>[]{UserMapper.class}, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] arsgs) throws Throwable {
                final String oriSql = method.getAnnotation(Select.class).value();
                String[] split = oriSql.split("#");
                String sql = split[0]+"'"+arsgs[0]+"';";
                System.out.println("打印sql语句:"+sql);
                return Arrays.asList(new User(1,"小明",18));
            }
        });
        List<User> userList = userMapper.findUserById(1);
        System.out.println("查询结果:"+userList.toString());

    }
}
