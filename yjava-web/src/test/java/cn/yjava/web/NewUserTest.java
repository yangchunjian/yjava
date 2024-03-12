package cn.yjava.web;

import cn.yjava.web.demos.web.User;
import cn.yjava.web.demos.web.UserMapper;
import cn.yjava.web.demos.web.UserServiceImpl;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;

public class NewUserTest extends NewBaseTest {

    @Mock
    UserMapper userMapper;


    @InjectMocks
    UserServiceImpl userService;


    @Test
    public void testQuery() {

        User u = User.builder().name("62ac4113a831dda570e59820fdf11351").age(11).build();

        List<User> ret = new ArrayList<>();

        User b = new User();

        BeanUtils.copyProperties(u, b);

        ret.add(b);

        Mockito.when(userMapper.insert(Mockito.any())).thenReturn(2).thenThrow(new RuntimeException("111"));

        int i = userService.insert(u);

        Assert.assertEquals(2, i);

    }

}
