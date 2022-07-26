package com.kgpco.secure.demo.config;

import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;

import com.azure.spring.cloud.autoconfigure.aad.AadWebSecurityConfigurerAdapter;

@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends AadWebSecurityConfigurerAdapter {

	
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        super.configure(http);
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.NEVER);
        http.authorizeRequests().antMatchers("/", "/index.html", "/public").permitAll()
            .anyRequest().authenticated();
        
    }
   
}

