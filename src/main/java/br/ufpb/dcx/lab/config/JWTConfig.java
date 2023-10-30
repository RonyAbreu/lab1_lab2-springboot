package br.ufpb.dcx.lab.config;

import br.ufpb.dcx.lab.filter.FiltroDeToken;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JWTConfig {
    @Bean
    public FilterRegistrationBean<FiltroDeToken> filtroDeRotas(){
        FilterRegistrationBean<FiltroDeToken> filterRegistrationBean = new FilterRegistrationBean<>();
        filterRegistrationBean.setFilter(new FiltroDeToken());
        filterRegistrationBean.addUrlPatterns("/auth/usuarios/*");
        return filterRegistrationBean;
    }
}
