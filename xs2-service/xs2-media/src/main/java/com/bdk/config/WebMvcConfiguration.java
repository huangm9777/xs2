package com.bdk.config;

import com.bdk.interceptor.JwtAuthInterceptor;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@RequiredArgsConstructor
public class WebMvcConfiguration implements WebMvcConfigurer {

    /**
     * add interceptor
     * @param registry
     */
    public void addInterceptors(InterceptorRegistry registry) {

        registry.addInterceptor(new JwtAuthInterceptor())
                .addPathPatterns("/**");

    }

}
