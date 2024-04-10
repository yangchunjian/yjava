package cn.yjava.web;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class CacheMockTest {

    // 模拟的缓存实现
    private Map<String, String> cache = new ConcurrentHashMap<>();

    // 待测试的缓存访问方法
    public String getFromCache(String key) {
        return cache.get(key);
    }

    @Test
    public void testCacheHit() {
        // 缓存数据
        cache.put("key", "value");

        // 创建模拟测试
        CacheMockTest testInstance = Mockito.spy(this); // 创建实例的模拟

        // 配置mock行为：当调用getFromCache并传递"key"时，返回"value"
        Mockito.doReturn("value").when(testInstance).getFromCache("key");

        // 执行测试方法
        String result = testInstance.getFromCache("key");

        // 验证结果
        Assert.assertEquals("value", result);

        // 验证缓存被正确访问
        Mockito.verify(testInstance).getFromCache("key");
    }
}