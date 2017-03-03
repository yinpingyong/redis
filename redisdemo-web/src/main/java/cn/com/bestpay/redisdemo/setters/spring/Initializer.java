package cn.com.bestpay.redisdemo.setters.spring;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.ServletRegistration;

/**
 *
 * 监听Servlet容器初始化，当容器启动的时候，开始加载Spring MVC。
 *
 * 将MVC和ApplicationContext启动分离了。
 *
 * Created by yfzx_gd_yanghh on 2016/9/28.
 */
public class Initializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    /**
     * 启动Spring 容器
     * @return
     */
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[] { SpringRootConfig.class };
    }

    /**
     * 启动Spring MVC
     * @return
     */
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[] { SpringWebConfig.class };
    }

    @Override
    protected String[] getServletMappings() {
        return new String[] { "/" };
    }

    @Override
    protected void customizeRegistration(ServletRegistration.Dynamic registration) {
        registration.setAsyncSupported(true);
        registration.setLoadOnStartup(1);
        super.customizeRegistration(registration);
    }
}

