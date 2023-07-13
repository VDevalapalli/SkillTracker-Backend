package com.iiht.fse4.skilltracker.api.gateway.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;
import org.springframework.security.web.server.util.matcher.NegatedServerWebExchangeMatcher;
import org.springframework.security.web.server.util.matcher.ServerWebExchangeMatchers;

@Configuration
@EnableGlobalMethodSecurity(jsr250Enabled = true)
public class ApiGatewayConfig {

    private static final String[] ALLOWED_PATHS =
            {"/api-gateway/**", "/skill-tracker/**",
                    "/auth/**", "/actuator/**"};

    @Bean
    public SecurityWebFilterChain securityWebFilterChain(ServerHttpSecurity http) {

        http
                .csrf().requireCsrfProtectionMatcher(getURLsForDisabledCSRF())
                .and()
                .authorizeExchange()
                .pathMatchers(ALLOWED_PATHS).permitAll()
                //.pathMatchers(HttpMethod.OPTIONS).permitAll()
                .anyExchange()
                .authenticated();
        return http.build();
    }

    public NegatedServerWebExchangeMatcher getURLsForDisabledCSRF() {
        return new NegatedServerWebExchangeMatcher(exchange ->
                ServerWebExchangeMatchers.pathMatchers(ALLOWED_PATHS).matches(exchange));
    }
}
