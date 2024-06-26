package com.diit.gateway.security;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**　
 * 这是一个过滤器，用来添加请求头参数，用于配合Sentenial知晓调用方来源
 * 所有的业务都是通过网关来调用接口，通过网关是无法知道applicationName的，所以需要添加
 * @author yjxbz
 */
@Component
@Slf4j
@RequiredArgsConstructor
public class PortalFilter implements GlobalFilter, Ordered {

    @Value("${spring.application.name}")
    private String applicationName;

    /**　
     * 向请求头添加参数，因为在网关中，请求头中没有serviceName参数，所以需要添加
     * @param exchange
     * @param chain
     * @return　Mono<Void>
     */
    @SneakyThrows
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {

        ServerHttpRequest request = exchange.getRequest().mutate()
                .header("serviceName", applicationName)
                .build();
        exchange = exchange.mutate().request(request).build();
        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return -1;
    }
}