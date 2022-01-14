package com.msvc.boot.msapigateway.config;

import java.nio.charset.StandardCharsets;
import java.util.Objects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;


import reactor.core.publisher.Mono;

@RefreshScope
@Component
public class AuthFilter implements GatewayFilter {

	@Autowired
	private JWTUtils jwtUtil;

	@Autowired
	private RouteValidator routeValidator;

	private static Logger logger = LoggerFactory.getLogger(AuthFilter.class);

	@Override
	public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
		// TODO Auto-generated method stub
		ServerHttpRequest request = exchange.getRequest();
		if (routeValidator.isSecured.test(request)) {
			// if request is other than auth service
			// extract token from authorization header
			// validate token expiry
			// if token is valid let the service go through to requested micro-service
			// if token is expired or invalid ask user for refresh token

			final String token = getHeaderValue(request);
			logger.info("Token in the Request {}", token);

			if (Objects.nonNull(token) && !isAuthHeaderMissing(request)) {

				if (jwtUtil.isInvalid(token)) {
					return this.onError(exchange, "Invalid Token", HttpStatus.UNAUTHORIZED);
				} else {
					populateRequestWithHeaders(exchange, token);
				}

			} else {
				return this.onError(exchange, "Token Not Present", HttpStatus.UNAUTHORIZED);
			}

		}

		return chain.filter(exchange);
	}

	private String getHeaderValue(ServerHttpRequest request) {

		return request.getHeaders().getFirst("Authorization");

	}

	private Boolean isAuthHeaderMissing(ServerHttpRequest request) {

		return request.getHeaders().getOrEmpty("Authorization").isEmpty();

	}

	private Mono<Void> onError(ServerWebExchange exchange, String err, HttpStatus httpStatus) {

		ServerHttpResponse response = exchange.getResponse();
		DataBuffer buffer = response.bufferFactory().wrap(err.getBytes(StandardCharsets.UTF_8));
		response.setStatusCode(httpStatus);
		response.getHeaders().add("errorMsg", err);
		return response.writeWith(Mono.just(buffer));

	}

	private void populateRequestWithHeaders(ServerWebExchange exchange, String token) {

		exchange.getRequest().mutate().header("Authorization", token).build();
	}

}
