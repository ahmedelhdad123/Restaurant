package com.spring.restaurant.config;

import com.spring.restaurant.entity.Category;
import com.spring.restaurant.entity.Order;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

@Configuration
public class ConfigureRepositoryRestConfigration implements RepositoryRestConfigurer {

    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config, CorsRegistry cors) {
        HttpMethod[] unSupport={HttpMethod.GET,HttpMethod.DELETE,HttpMethod.POST,HttpMethod.PUT};
        disableHttpMethod(Category.class,config,unSupport);
        disableHttpMethod(Order.class,config,unSupport);
    }
    public void disableHttpMethod(Class theClass, RepositoryRestConfiguration config, HttpMethod[] methods)
    {
        config.getExposureConfiguration()
                .forDomainType(theClass)
                .withItemExposure((metdata, httpMethods) -> httpMethods.disable(methods))
                .withCollectionExposure((metdata, httpMethods) -> httpMethods.disable(methods));
    }
}
