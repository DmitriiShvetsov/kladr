package com.javainuse.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration
//public class SpringCloudConfig {
//
//    @Bean
//    public RouteLocator gatewayRoutes(RouteLocatorBuilder builder) {
//        return builder.routes()
//                .route(p -> p
//                        .path("/database/**")
//                        .uri("http://localhost:8092/")
//                        .id("databaseModule"))
//                .route(p -> p
//                        .path("/dadata/**")
//                        .uri("http://localhost:8091/")
//                        .id("dadataModule"))
//                .build();
//    }
//
//}

