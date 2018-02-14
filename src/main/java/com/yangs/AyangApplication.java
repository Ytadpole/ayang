package com.yangs;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;

@SpringBootApplication
@MapperScan("com.yangs.dao")
public class AyangApplication {

	@Bean(initMethod = "init" , destroyMethod = "close")
	@ConfigurationProperties(prefix = "spring.dataSource")
	public DataSource dataSource(){
		return new DruidDataSource();
	}

	@Bean
	public SqlSessionFactory sqlSessionFactoryBean() throws Exception {
		//set mybatis mapper
		PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();

		SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
		sqlSessionFactoryBean.setDataSource(this.dataSource());
		sqlSessionFactoryBean.setMapperLocations(resolver.getResources("classpath*:/mapper/*Mapper.xml"));
		return sqlSessionFactoryBean.getObject();
	}

	public static void main(String[] args) {
		SpringApplication.run(AyangApplication.class, args);
	}
}
