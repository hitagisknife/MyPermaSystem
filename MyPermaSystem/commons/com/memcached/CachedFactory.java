package com.memcached;

import java.io.IOException;

import org.apache.log4j.Logger;

import net.spy.memcached.AddrUtil;
import net.spy.memcached.BinaryConnectionFactory;
import net.spy.memcached.MemcachedClient;

public class CachedFactory {

	private static MemcachedClient memClient = null;
	private static Logger logger = Logger.getLogger(CachedFactory.class);

	private CachedFactory() {
	};

	public static MemcachedClient getCached() {
		if (memClient == null) {
			synchronized (CachedFactory.class) {
				if (memClient == null) {
					creatCached();
				}
			}
		}
		return memClient;
	}

	private static void creatCached() {
		String host = "127.0.0.1";
		String port = "11211";
		try {
			memClient = new MemcachedClient(new BinaryConnectionFactory(),
					AddrUtil.getAddresses(host + ":" + port));
		} catch (IOException e) {
			logger.error(e.getMessage(), e);
		}
	}

	public static void disConnect() {
		memClient.shutdown();
	}
}