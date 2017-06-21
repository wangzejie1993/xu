package com.wangsocial.app.redis;

import com.wangsocial.app.Application;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * redis读写测试
 * Created by Lenovo on 2017/6/21.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
public class RedisCacheTest {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Test
    public void redisTest() throws Exception {
        //保存字符串
        stringRedisTemplate.opsForValue().set("aaa", "111");
        //读取字符串
        String aaa = stringRedisTemplate.opsForValue().get("aaa");
        System.out.println(aaa);
    }
}
