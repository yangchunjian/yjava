package cn.yjava.web;

import cn.yjava.web.demos.web.User;
import cn.yjava.web.demos.web.UserMapper;
import cn.yjava.web.demos.web.UserService;
import jakarta.annotation.Resource;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;

/**
 * 启动容器单测
 */
public class UserTest extends BaseTest {

    @Resource
    private UserService userService;

    @MockBean
    private UserMapper userMapper;

    @Test
    public void testInsert() throws Exception {

        User u = User.builder().name("共产").build();

        Mockito.when(userMapper.insert(u)).thenReturn(2);

        int i = userService.insert(u);

        Assert.assertEquals(2, i);

    }

}

