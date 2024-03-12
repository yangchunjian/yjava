package cn.yjava.web;

import lombok.extern.slf4j.Slf4j;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@SpringBootTest(classes = YJavaWebApplication.class)
@RunWith(SpringJUnit4ClassRunner.class)
@Slf4j
public class BaseTest {
    @BeforeClass
    public static void before() {
    }


}
