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

	static ICacheManager<IMemcachedCache> manager;// ����ֱ���趨Ϊ��̬�ĵ���
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
				MemcachedCacheManager.class.getName());// manager��ʼ��������ͨ���������滻CacheManagerʵ��
		manager.setConfigFile("memcached.xml");// ����Cache Client�����ļ�
		manager.setResponseStatInterval(5 * 1000);// ����Cache��Ӧͳ�Ƽ��ʱ�䣬�������򲻽���ͳ��
		manager.start();// Manager����
	}

	public static void stopManager() throws Exception {
		manager.stop();// manager����
	}
}