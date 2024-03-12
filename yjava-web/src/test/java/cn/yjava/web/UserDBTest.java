package cn.yjava.web;

import cn.yjava.web.demos.web.User;
import cn.yjava.web.demos.web.UserMapper;
import cn.yjava.web.demos.web.UserService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;

@Slf4j
public class UserDBTest extends BaseTest {

    @Resource
    private UserService userService;
    @Resource
    private UserMapper userMapper;

    @Test
    public void testInsert() throws Exception {
        User u = User.builder().name("zhongguo").build();
        int i = userService.insert(u);
        Assert.assertEquals(1, i);
    }

}