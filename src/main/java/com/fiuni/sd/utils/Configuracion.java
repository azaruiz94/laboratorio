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
	
	public Integer getPageSize() {
		return page_size;
	}
	
	public String getCacheName() {
		return cache_name;
	}
}