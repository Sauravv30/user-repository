//package com.hrs.user.configuration;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.web.SecurityFilterChain;
//
//import static org.springframework.security.config.Customizer.withDefaults;
//
//@Configuration
//  @EnableWebSecurity
//  public class SecurityConfig  {
//
//      private static final String GATEWAY_IP_ADDRESS = "192.168.1.100"; // Replace with your gateway's IP address
//
//    @Bean
//    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//        http
//                .authorizeRequests()
//                .antMatchers("/**").hasIpAddress(GATEWAY_IP_ADDRESS)
//                .and()
//                .csrf().disable()
//                .headers().frameOptions().disable(); // Disable CSRF and frame options
//    }
//
//      @Override
//      protected void configure(HttpSecurity http) throws Exception {
//          http
//             .authorizeRequests()
//                  .antMatchers("/**").hasIpAddress(GATEWAY_IP_ADDRESS)
//              .and()
//              .csrf().disable()
//             .headers().frameOptions().disable(); // Disable CSRF and frame options for simplicity, adjust as needed
//      }
//  }
