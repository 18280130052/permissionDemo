package com.synjones.cloudcard.permission.core.service.utils;

import io.codis.jodis.RoundRobinJedisPool;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPoolConfig;

public class JodisClient {

	private static final Logger logger = LoggerFactory.getLogger(JodisClient.class);

	private static final String LOCK_SUCCESS = "OK";

	private static final String SET_IF_NOT_EXIST = "NX";

	private static final String SET_WITH_EXPIRE_TIME = "PX";

	private String zkHost;

	private Integer zkSessionTimeoutMs;

	private String zkProxyDir;

	private JedisPoolConfig poolConfig;

	private static RoundRobinJedisPool jodisPool;

	public void createJodisPool() {
		jodisPool = RoundRobinJedisPool.create().curatorClient(zkHost, zkSessionTimeoutMs).zkProxyDir(zkProxyDir)
				.poolConfig(poolConfig).build();
	}

	/**
	 * 尝试获取分布式锁
	 * 
	 * @param jedis      Redis客户端
	 * @param lockKey    锁
	 * @param requestId  请求标识
	 * @param expireTime 超期时间
	 * @return 是否获取成功
	 */
	public static boolean tryGetDistributedLock( String lockKey, String requestId, int expireTime) {

		Jedis jedis = null;
		try {
			jedis = jodisPool.getResource();
			
			String result = jedis.set(lockKey, requestId, SET_IF_NOT_EXIST, SET_WITH_EXPIRE_TIME, expireTime);
			if (LOCK_SUCCESS.equals(result)) {
				return true;
			}
			
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return false;
		} finally {
			jedis.close();
		}
		
		
		return false;

	}

	public static boolean setKv(String key, String value) {
		return setKv(key, value, 0);
	}

	public static boolean setKv(String key, String value, int seconds) {
		if (StringUtils.isBlank(key)) {
			throw new IllegalArgumentException("key is null");
		}
		if (StringUtils.isBlank(value)) {
			throw new IllegalArgumentException("set value is null");
		}

		Jedis jedis = null;
		try {
			jedis = jodisPool.getResource();
			jedis.set(key, value);
			if (seconds != 0) {
				jedis.expire(key, seconds);
			}
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return false;
		} finally {
			jedis.close();
		}

		return true;
	}

	public static String getKv(String key) {
		if (StringUtils.isBlank(key)) {
			throw new IllegalArgumentException("key is null");
		}
		String value = null;
		Jedis jedis = null;
		try {
			jedis = jodisPool.getResource();
			if (null == jedis) {
				return null;
			}
			value = jedis.get(key);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		} finally {
			jedis.close();
		}
		return value;
	}

	public static void deleteKv(String key) {
		if (StringUtils.isBlank(key)) {
			throw new IllegalArgumentException("key is null");
		}
		Jedis jedis = null;
		try {
			jedis = jodisPool.getResource();
			if (null == jedis) {
				return;
			}
			jedis.del(key);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		} finally {
			jedis.close();
		}
	}

	public String getZkHost() {
		return zkHost;
	}

	public void setZkHost(String zkHost) {
		this.zkHost = zkHost;
	}

	public String getZkProxyDir() {
		return zkProxyDir;
	}

	public void setZkProxyDir(String zkProxyDir) {
		this.zkProxyDir = zkProxyDir;
	}

	public JedisPoolConfig getPoolConfig() {
		return poolConfig;
	}

	public void setPoolConfig(JedisPoolConfig poolConfig) {
		this.poolConfig = poolConfig;
	}

	public Integer getZkSessionTimeoutMs() {
		return zkSessionTimeoutMs;
	}

	public void setZkSessionTimeoutMs(Integer zkSessionTimeoutMs) {
		this.zkSessionTimeoutMs = zkSessionTimeoutMs;
	}

	public static RoundRobinJedisPool getJodisPool() {
		return jodisPool;
	}

	public static void setJodisPool(RoundRobinJedisPool jodisPool) {
		JodisClient.jodisPool = jodisPool;
	}

}
