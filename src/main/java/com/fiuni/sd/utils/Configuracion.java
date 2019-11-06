package com.fiuni.sd.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:fiuni_sd.properties")
public class Configuracion {
	
	@Value("${page.size}")
	private Integer page_size;
	
	@Value("${cache.name}")
	private String cache_name;
	
	@Value("${cache.server.address}")
	private String memcachedServerAddress;
	
	@Value("${cache.allow_clear}")
	private String allowClear;
	
	@Value("${cache.expiration}")
	private Integer expirationTime;
	
	@Value("${cache.server.name}")
	private String cacheServerName;
	
	@Value("${cache.consistentHashing}")
	private String cacheConsistentHashing;
	
	@Value("${cache.useBinaryProtocol}")
	private String cacheUseBinaryProtocol;
	
	public String getCacheName() {
		return cache_name;
	}
	
	public String getServerAddress() {
		return memcachedServerAddress;
	}
	
	public String getAllowClear() {
		return allowClear;
	}
	
	public Integer getExpirationTime() {
		return expirationTime;
	}
	
	public String getCacheServerName() {
		return cacheServerName;
	}
	
	public String getCacheConsistentHahing() {
		return cacheConsistentHashing;
	}
	
	public String getUseBinaryProtocol() {
		return cacheUseBinaryProtocol;
	}
	
	public Integer getPageSize() {
		return page_size;
	}
	
}