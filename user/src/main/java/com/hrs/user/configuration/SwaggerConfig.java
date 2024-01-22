package com.hrs.user.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.function.Predicate;

/**
 * The type Swagger config.
 */
@Configuration

public class SwaggerConfig {

    /**
     * Produce api docket.
     *
     * @return the docket
     */
    @Bean
    public Docket produceApi(){
        return new Docket(DocumentationType.SWAGGER_2).
                apiInfo(apiInfo()).select().apis(RequestHandlerSelectors.basePackage("com.hrs.user.controller")).paths(paths()).build();
    }

    private ApiInfo apiInfo(){
        return new ApiInfoBuilder().title("User Specification").description("This is an app to get user information").version("0.1").build();
    }

    private Predicate<String> paths(){
        return PathSelectors.regex("/.*");
    }
}
/**
 * @Configuration
 * @EnableWebSecurity
 * public class SecurityConfig extends WebSecurityConfigurerAdapter {
 *
 *     private static final String GATEWAY_IP_ADDRESS = "192.168.1.100"; // Replace with your gateway's IP address
 *
 *     @Override
 *     protected void configure(HttpSecurity http) throws Exception {
 *         http
 *             .authorizeRequests()
 *                 .antMatchers("/**").hasIpAddress(GATEWAY_IP_ADDRESS)
 *             .and()
 *             .csrf().disable()
 *             .headers().frameOptions().disable(); // Disable CSRF and frame options for simplicity, adjust as needed
 *     }
 * }
 */