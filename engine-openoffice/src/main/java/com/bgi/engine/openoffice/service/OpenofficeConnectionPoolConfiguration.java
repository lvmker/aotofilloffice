package com.bgi.engine.openoffice.service;
import java.io.File;
import java.io.InputStream;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import com.aspose.words.FontSettings;
import com.aspose.words.License;
import com.bgi.engine.openoffice.connectionpool.OpenofficeConnectionFactory;
import com.bgi.engine.openoffice.connectionpool.OpenofficeConnectionPool;
@Configuration
public class OpenofficeConnectionPoolConfiguration {
	@Value("${openoffice.host}")
	private String host;
	@Value("${fonts.folder}")
	private String fontFolder;
	@Bean
	public OpenofficeConnectionFactory openofficeConnectionFactory() {
		return new OpenofficeConnectionFactory(host);
	}
	
	@Bean
	@SuppressWarnings("rawtypes")
	public OpenofficeConnectionPool openofficeConnectionPool(OpenofficeConnectionFactory openofficeConnectionFactory) {
        GenericObjectPoolConfig config = new GenericObjectPoolConfig();
        config.setMaxTotal(5);
        config.setJmxEnabled(false);
        //设置获取连接超时时间
        config.setMaxWaitMillis(1000);
		return new OpenofficeConnectionPool(openofficeConnectionFactory, config);
	}
	
	@Bean
	public License asposeLicense() throws Exception {
		File fonts=new File(fontFolder);
		if(fonts.exists()) {
			FontSettings.getDefaultInstance().setFontsFolder(fontFolder, true);
		}
		Resource resource = new ClassPathResource("license.xml");
		InputStream is = resource.getInputStream();
		License license=new License();
		license.setLicense(is);
		return license;
	}
}
