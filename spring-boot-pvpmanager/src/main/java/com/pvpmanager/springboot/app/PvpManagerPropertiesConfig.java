package com.pvpmanager.springboot.app;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

@Configuration
@PropertySources({
	@PropertySource("classpath:pvpmanager.properties")
})
public class PvpManagerPropertiesConfig {

}
