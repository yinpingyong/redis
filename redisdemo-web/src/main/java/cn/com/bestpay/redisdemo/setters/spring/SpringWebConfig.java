package cn.com.bestpay.redisdemo.setters.spring;

import cn.com.bestpay.redisdemo.setters.exception.MyAsyncExceptionHandler;
import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.context.annotation.*;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.web.servlet.config.annotation.AsyncSupportConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.concurrent.Executor;

/**
 * Created by yfzx_gd_yanghh on 2016/9/28.
 *
 * 启动Spring MVC
 * @EnableWebMvc：表明当前是MVC配置
 * @EnableAsync：支持使用异步方式，调用业务层
 *
 */
@EnableWebMvc
@EnableAsync
@Configuration
@EnableAspectJAutoProxy(proxyTargetClass=true)
@ComponentScan({
        "cn.com.bestpay"
})
@ImportResource({ "classpath:spring/springmvc-servlet.xml" })
public class SpringWebConfig extends WebMvcConfigurerAdapter  implements AsyncConfigurer {

    @Bean
    public PropertySourcesPlaceholderConfigurer propertyConfigInDev() {
        return new PropertySourcesPlaceholderConfigurer();
    }

    @Override
    public void configureAsyncSupport(AsyncSupportConfigurer configurer) {
        super.configureAsyncSupport(configurer);
        configurer.setDefaultTimeout(7500);
    }

    @Override
    public Executor getAsyncExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(7);
        executor.setMaxPoolSize(42);
        executor.setQueueCapacity(11);
        executor.setThreadNamePrefix("MyExecutor-");
        executor.initialize();
        return executor;
    }

    @Override
    public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
        return new MyAsyncExceptionHandler();
    }
}

