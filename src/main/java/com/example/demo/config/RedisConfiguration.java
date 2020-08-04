package com.example.demo.config;

import com.example.demo.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.listener.PatternTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * Created by hongjian.chen on 2019/6/21.
 */

@Configuration
public class RedisConfiguration {

    @Autowired
    private RedisConnectionFactory redisConnectionFactory;

    @Bean
    public RedisTemplate redisTemplate() {
        StringRedisTemplate stringRedisTemplate = new StringRedisTemplate();
        stringRedisTemplate.setConnectionFactory(this.redisConnectionFactory);
        stringRedisTemplate.setKeySerializer(new StringRedisSerializer());
        stringRedisTemplate.setValueSerializer(new GenericJackson2JsonRedisSerializer());
        return stringRedisTemplate;
    }

    /**
     *
     * @param connectionFactory
     * @param redisService 自定义实现消息订阅并消费消息
     * @return
     */

    @Bean
    public RedisMessageListenerContainer container(RedisConnectionFactory connectionFactory, RedisService redisService) {
        RedisMessageListenerContainer container = new RedisMessageListenerContainer();
        container.setConnectionFactory(connectionFactory);
        //订阅了test_topic，demo_topic的通道
        container.addMessageListener(listenerAdapter1(redisService), new PatternTopic("test_topic"));
        container.addMessageListener(listenerAdapter2(redisService), new PatternTopic("demo_topic"));
        return container;
    }

    @Bean
    public MessageListenerAdapter listenerAdapter1(RedisService redisService) {
        //与channel绑定的适配器,收到消息时执行RedisConsumer类中的consumeMsg方法
        return new MessageListenerAdapter(redisService, "consumeMsg");
    }

    @Bean
    public MessageListenerAdapter listenerAdapter2(RedisService redisService) {
        //与channel绑定的适配器,收到消息时执行RedisConsumer类中的consumeMsg方法
        return new MessageListenerAdapter(redisService, "receiverMessage");
    }
}
