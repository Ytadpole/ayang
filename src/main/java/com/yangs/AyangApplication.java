package com.yangs;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.ErrorPage;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.http.HttpStatus;

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

	/**
	 * 自定义错误界面
	 * 之前想过在 interceptor里面添加， 但这代码更优美一点
	 * @return
	 */
	@Bean
	public EmbeddedServletContainerCustomizer embeddedServletContainerCustomizer(){
		// TODO: 2018/2/24 后续改成lambda
		return new EmbeddedServletContainerCustomizer() {
			@Override
			public void customize(ConfigurableEmbeddedServletContainer configurableEmbeddedServletContainer) {
				configurableEmbeddedServletContainer.addErrorPages(new ErrorPage(HttpStatus.NOT_FOUND, "/error/error404"));
				configurableEmbeddedServletContainer.addErrorPages(new ErrorPage(HttpStatus.BAD_REQUEST, "/error/404"));// TODO: 2018/2/24 暂时用404
				configurableEmbeddedServletContainer.addErrorPages(new ErrorPage(HttpStatus.INTERNAL_SERVER_ERROR, "/error/500"));
				configurableEmbeddedServletContainer.addErrorPages(new ErrorPage(java.lang.Throwable.class, "/error/500"));
//				configurableEmbeddedServletContainer.addErrorPages(new ErrorPage(HttpStatus.));
			}
		};
	}

	public static void main(String[] args) {
		SpringApplication.run(AyangApplication.class, args);
	}
}
