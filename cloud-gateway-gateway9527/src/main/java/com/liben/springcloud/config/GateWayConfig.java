package com.liben.springcloud.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author liben
 * @date 2020/4/24 23:35
 */
@Configuration
public class GateWayConfig {

    /**
     * gateway动态路由
     * 当我们访问http://localhost:9527/guonei时会自动转发到https://news.baidu.com/guonei
     * @param routeLocatorBuilder
     * @return
     */
    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder routeLocatorBuilder){
        RouteLocatorBuilder.Builder routes = routeLocatorBuilder.routes();
        routes.route("path_route_liben",
                t->t.path("/guonei")
                        .uri("https://news.baidu.com/guonei")).build();
        routes.route("path_route_liben1",
                t->t.path("/guoji")
                        .uri("https://news.baidu.com/guoji")).build();
        return routes.build();
    }
}
