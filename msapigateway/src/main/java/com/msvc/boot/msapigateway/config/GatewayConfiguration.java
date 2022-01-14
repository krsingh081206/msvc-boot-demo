package com.msvc.boot.msapigateway.config;

import java.util.function.Function;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.route.Route;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.Buildable;
import org.springframework.cloud.gateway.route.builder.PredicateSpec;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.web.reactive.function.client.WebClient;

import io.netty.resolver.DefaultAddressResolverGroup;
import reactor.netty.http.client.HttpClient;

@Configuration
public class GatewayConfiguration {
	
	private static Logger logger = LoggerFactory.getLogger(GatewayConfiguration.class);
	
	@Autowired
	AuthFilter authFilter;
	
	@Bean
	public RouteLocator getRoutes(RouteLocatorBuilder routeBuilder) {
		
		Function<PredicateSpec, Buildable<Route>> routeFunction1 =  
				route -> route.path("/api/v1/auth/**")
				               .filters(filter -> filter.filter(authFilter))
				              .uri("lb://msauthservice");
				
		Function<PredicateSpec, Buildable<Route>> routeFunction2 = 
				route -> route.path("/api/v1/guest/**")
                              .filters(filter -> filter.filter(authFilter))
                              .uri("lb://msguestservice");
		
		return routeBuilder.routes()
				           .route("authservice", routeFunction1 )
				           .route("guestservice", routeFunction2)
				           .build();
				           
				           
		
	}
	
	    @Bean
	    @Primary
	    public WebClient webClient() {
	        HttpClient httpClient = HttpClient.create().resolver(DefaultAddressResolverGroup.INSTANCE);
	        return WebClient.builder()
	                .clientConnector(new ReactorClientHttpConnector(httpClient))
	                .build();
	    }
	

}
