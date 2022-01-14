package com.msvc.boot.msapigateway.config;

import java.util.Arrays;
import java.util.function.Predicate;

import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;

@Component
public class RouteValidator {
	
	public Predicate<ServerHttpRequest> isSecured = 
			request ->
			Arrays.asList("/api/v1/auth/").stream().noneMatch(uri -> request.getURI().getPath().contains(uri));

}
