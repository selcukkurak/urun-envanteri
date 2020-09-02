package tr.gov.tuik.urunenvanteri.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import tr.gov.tuik.ed.security.SecurityConfigHelper;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    private final SecurityConfigHelper securityConfigHelper;

    public SecurityConfig(SecurityConfigHelper securityConfigHelper) {
        this.securityConfigHelper = securityConfigHelper;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        securityConfigHelper.temelAyarlar(http)
                .formLogin().disable()
                .authorizeRequests()
                .antMatchers(SecurityConfigHelper.AUTH_TOKEN_URL).permitAll()
                .antMatchers(SecurityConfigHelper.VARSAYILAN_PERMIT_ALL_DURUMLARI).permitAll()
                .antMatchers("/api/**").permitAll()
                .antMatchers("/actuator/**").permitAll()
                .anyRequest().authenticated();
    }
}
