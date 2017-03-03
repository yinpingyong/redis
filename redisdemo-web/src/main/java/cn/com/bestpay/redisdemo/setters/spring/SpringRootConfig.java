package cn.com.bestpay.redisdemo.setters.spring;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;

/**
 * Created by yfzx_gd_yanghh pec_masteron 2016/9/28.
 *
 * 启动Spring 容器（非MVC）
 *
 */
@Configuration
@ComponentScan({})
@PropertySource(value = {"classpath:properties/system.properties"})
@ImportResource({ "classpath:spring/spring-session.xml" } )
public class SpringRootConfig {
}
