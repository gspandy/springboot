package com.liuh.config;

import com.alibaba.druid.support.http.StatViewServlet;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.embedded.ServletRegistrationBean;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

/**
 * Created by liuhui.
 */

@Configuration
public class ServletConfig extends SpringBootServletInitializer {

    @Bean
    @Order
    public ServletRegistrationBean statViewServlet() {
        StatViewServlet servlet = new StatViewServlet();
        ServletRegistrationBean bean = new ServletRegistrationBean(servlet, "/druid/*");
        return bean;
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(ServletConfig.class);
    }
}
