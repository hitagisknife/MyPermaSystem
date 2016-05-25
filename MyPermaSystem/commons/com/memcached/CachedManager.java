package com.memcached;

import java.time.LocalDateTime;

import org.apache.log4j.Logger;

import com.alisoft.xplatform.asf.cache.ICacheManager;
import com.alisoft.xplatform.asf.cache.IMemcachedCache;
import com.alisoft.xplatform.asf.cache.memcached.CacheUtil;
import com.alisoft.xplatform.asf.cache.memcached.MemcachedCacheManager;

public class CachedManager {

	private CachedManager() {
	};

	static ICacheManager<IMemcachedCache> manager;// 可以直接设定为静态的单例
	static Logger logger;

	private static class ClassHolder {
		private static final CachedManager instance = new CachedManager();
	}

	public static final CachedManager getInstance() {
		return ClassHolder.instance;
	}

	static {
		try {
			logger = Logger.getLogger(CachedManager.class);
			startManager();
			logger.info("CachedManager start @: " + LocalDateTime.now());
			System.out.println("CachedManager start @: " + LocalDateTime.now());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
	}

	private static void startManager() throws Exception {
		manager = CacheUtil.getCacheManager(IMemcachedCache.class,
				MemcachedCacheManager.class.getName());// manager初始化，可以通过配置来替换CacheManager实现
		manager.setConfigFile("memcached.xml");// 设置Cache Client配置文件
		manager.setResponseStatInterval(5 * 1000);// 设置Cache响应统计间隔时间，不设置则不进行统计
		manager.start();// Manager启动
	}

	public static void stopManager() throws Exception {
		manager.stop();// manager结束
	}
}