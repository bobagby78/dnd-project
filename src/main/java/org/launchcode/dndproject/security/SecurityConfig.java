//package org.launchcode.dndproject.security;
//
//import org.hibernate.NonUniqueObjectException;
//import org.springframework.context.annotation.Bean;
////import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
////import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
////import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.NoOpPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//
//@EnableWebSecurity
//public class SecurityConfig extends WebSecurityConfigurerAdapter {
//
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception{
//        //Set configuration on the auth object
//        auth.inMemoryAuthentication()
//                .withUser("user")
//                .password("user")
//                .roles("USER");
//
//    }
//
//    @Bean
//    public PasswordEncoder getPasswordEncoder(){
//        return NoOpPasswordEncoder.getInstance(); //this is just to get rolling
////        return new BCryptPasswordEncoder(10); this is what we would really use
//
//    }
//
//}
