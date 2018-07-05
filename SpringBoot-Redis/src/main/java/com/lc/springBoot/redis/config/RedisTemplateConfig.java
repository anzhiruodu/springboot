package com.lc.springBoot.redis.config;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ser.std.StringSerializer;
import com.lc.springBoot.redis.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * @author lsj <lishuijun1992@gmail.com>
 * @date 17-4-19
 */
@Configuration
public class RedisTemplateConfig {

	@Autowired
	private JedisConnectionFactory jedisConnectionFactory;


//	@Bean
//	public RedisSerializer jackson2JsonRedisSerializer(ObjectMapper objectMapper) {
//		Jackson2JsonRedisSerializer jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer(User.class);
//		jackson2JsonRedisSerializer.setObjectMapper(objectMapper);
//		return jackson2JsonRedisSerializer;
//	}

//	@Bean
//	public ObjectMapper objectMapper() {
//		ObjectMapper objectMapper = new ObjectMapper();
//		return objectMapper;
//	}


//	@Bean
//	public RedisTemplate redisTemplate(RedisSerializer redisSerializer) {
//		StringRedisTemplate redisTemplate = new StringRedisTemplate(jedisConnectionFactory);
//		redisTemplate.setValueSerializer(redisSerializer);
//		redisTemplate.afterPropertiesSet();
//		return redisTemplate;
//	}
//



	@Bean
	public RedisTemplate<?, ?> redisTemplate(RedisConnectionFactory connectionFactory) {
		RedisTemplate<String, Object> template = new RedisTemplate<String, Object>();
		template.setConnectionFactory(connectionFactory);
		setMySerializer(template);
		template.afterPropertiesSet();
		return template;
	}

	/**
	 * 设置序列化方法
	 */
	private void setMySerializer(RedisTemplate template) {
		Jackson2JsonRedisSerializer<Object> jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer<Object>(
				Object.class);
		ObjectMapper om = new ObjectMapper();

		om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
		om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);

		jackson2JsonRedisSerializer.setObjectMapper(om);

		template.setKeySerializer(template.getStringSerializer());
		template.setValueSerializer(jackson2JsonRedisSerializer);


	}
}
