package com.wangkang.test.Stream流测试;

import com.wangkang.entity.User;
import org.junit.Test;

import java.util.Optional;

/**
 * @Description:
 * @Author: wangkang
 * @Date: Created in 16:41 2019/1/29
 * @Modified By:
 */
/**
 * 1. ofNullable 返回的就是传入的参数类型 -- testNull</br>
 * 2. map为null的时候，执行orElse，而不是返回null --testMap</br>
 */
public class OptionalTest {

    @Test
    public void testNull() throws Exception {
        User user = new User("wk",11);
        user = null;
        System.out.println(Java7ReturnUsername(user));
        System.out.println(Java8ReturnUsername(user));

        //user.setName(null);
        System.out.println(ofNullableUser(user).toString());

        System.out.println(ofNullableString(user));

    }

    @Test
    public void testMap() {
        User user = new User();
        System.out.println(Optional.ofNullable(user).orElse(new User("orElse",11)).toString());
        System.out.println(Optional.ofNullable(user).map(x->x.getName()).orElse("orElse"));
    }


    private User ofNullableUser(User user) {
        return Optional.ofNullable(user).orElse(new User("wkwkw",12));
    }

    private String ofNullableString(User user) {

        return Optional.ofNullable(user.getName()).orElse("wkk");
    }


    private String Java8ReturnUsername(User user) throws Exception {
        Optional<User> userOpt = Optional.ofNullable(user);

//        userOpt.map(User::getName)
//                .map(String::toUpperCase)
//                .orElseThrow(()->new Exception("wangkang"));

        return userOpt.map(User::getName)
                .map(String::toUpperCase)
                .orElse(null);
    }

    private String Java7ReturnUsername(User user) {
        if (user != null) {
            String userName = user.getName();
            if (userName != null) {
                return userName.toUpperCase();
            } else {
                return null;
            }
        } else {
            return null;
        }
    }
}
