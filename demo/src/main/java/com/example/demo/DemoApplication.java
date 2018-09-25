package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;

import javax.servlet.MultipartConfigElement;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class DemoApplication extends SpringBootServletInitializer	{

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(DemoApplication.class);
	}
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	//设置上传文件大小
	@Bean
	public MultipartConfigElement multipartConfigElement() {
		MultipartConfigFactory factory = new MultipartConfigFactory();
		//单个文件最大
		factory.setMaxFileSize("10240KB"); //KB,MB
		/// 设置总上传数据总大小
		factory.setMaxRequestSize("1024000KB");
		return factory.createMultipartConfig();
	}
}



