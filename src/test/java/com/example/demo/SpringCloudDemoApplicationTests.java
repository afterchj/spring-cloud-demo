package com.example.demo;

import com.alibaba.fastjson.JSON;
import com.example.demo.entitys.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class SpringCloudDemoApplicationTests {

	@Autowired
	private RedisTemplate redisTemplate;

	@Autowired
	private StringRedisTemplate stringRedisTemplate;


	@Test
	public void contextLoads() {
	}

	@Test
	public void testPush(){
		User u =new User();
		u.setId(101);
		u.setName("小陈测试");
		Map map = new HashMap();
		map.put("id", 1);
		map.put("name", "test is ok");
		String params= JSON.toJSONString(map);
		log.warn("params {}",params);
		stringRedisTemplate.convertAndSend("test_topic",params);
//		redisTemplate.convertAndSend("test_topic",u);
	}

}
