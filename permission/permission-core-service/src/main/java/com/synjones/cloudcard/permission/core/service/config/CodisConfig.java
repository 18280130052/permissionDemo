package com.synjones.cloudcard.permission.core.service.config;

import com.synjones.cloudcard.permission.core.service.utils.JodisClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.JedisPoolConfig;

@Configuration
public class CodisConfig {
	
	@Value("${codis.zkHost}")
	private String zkHost;

	@Value("${codis.zkSessionTimeoutMs}")
	private Integer zkSessionTimeoutMs;

	@Value("${codis.zkProxyDir}")
	private String zkProxyDir;
	
	
	@Value("${codis.maxIdle}")
	private Integer maxIdle;
	
	@Value("${codis.maxWaitMillis}")
	private Integer maxWaitMillis;
	
	
	
	 @Bean
	 public JodisClient jedisConnectionFactory() {
		 JodisClient	jodis=new JodisClient( );
		 jodis.setZkHost(zkHost);
		 jodis.setZkSessionTimeoutMs(zkSessionTimeoutMs);
		 jodis.setZkProxyDir(zkProxyDir);
		 jodis.setPoolConfig(jedisPoolConfig());
		 
		 jodis.createJodisPool();
		 
		 return	jodis;
	 }
	 
	 
	 @Bean
	 public JedisPoolConfig	jedisPoolConfig( ) {
		 JedisPoolConfig poolConfig=new JedisPoolConfig();
		 poolConfig.setMaxIdle(maxIdle);
		 poolConfig.setMaxWaitMillis(maxWaitMillis);
		 
		 return poolConfig;
	 }
	

}
