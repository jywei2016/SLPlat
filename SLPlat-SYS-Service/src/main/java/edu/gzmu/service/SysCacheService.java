package edu.gzmu.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;
import top.ibase4j.core.Constants;
import top.ibase4j.core.util.CacheUtil;

import java.util.Map;

/**
 * <p>
 * 缓存  服务实现类
 * </p>
 *
 * @author JiaYinWei
 * @since 2018-04-08
 */
@Service
public class SysCacheService {
	Logger logger = LogManager.getLogger();

	// 清缓存
	public void flush() {
		logger.info("清缓存开始......");
		CacheUtil.getCache().delAll(Constants.CACHE_NAMESPACE + "*");
		logger.info("清缓存结束!");
	}

	// 清缓存
	public void flush(Map<String, String> param) {
		String key = param.get("key");
		logger.info("清缓存[{}]开始......", key);
		CacheUtil.getCache().delAll(Constants.CACHE_NAMESPACE + "*" + key + "*");
		if (key.contains("Permission")) {
			CacheUtil.getCache().delAll(Constants.CACHE_NAMESPACE + "*shiro_redis_cache*");
		}
		logger.info("清缓存[{}]结束!", key);
	}
}