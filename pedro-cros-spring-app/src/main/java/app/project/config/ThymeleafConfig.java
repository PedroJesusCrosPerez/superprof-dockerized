package app.project.config;//package app.project.config;
//
//import lombok.RequiredArgsConstructor;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.crypto.password.PasswordEncoder;
//
////@Configuration
////public class ThymeleafConfig {
////
////    @Bean
////    public SpringSecurityDialect springSecurityDialect(){
////        return new SpringSecurityDialect();
////    }
////}
//@Configuration
//@EnableWebSecurity
//@RequiredArgsConstructor
//public class ThymeleafConfig {
////        extends WebSecurityConfigurerAdapter {
////
////    @Override
////    protected void configure(HttpSecurity http) throws Exception {
////        http
////                .httpBasic()
////                .and()
////                .authorizeRequests()
////                .antMatchers("/admin/**").hasAnyRole("ADMIN","USER")
////                .and()
////                .csrf().disable().headers().frameOptions().disable()
////                .and()
////                .formLogin()
////                .and()
////                .logout();
////    }
////    @Autowired
////    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
////        auth.inMemoryAuthentication()
////                .withUser("bleau83").password("{noop}bleau83").roles("ADMIN")
////                .and()
////                .withUser("user").password("{noop}user").roles("USER");
////    }
//private final PasswordEncoder passwordEncoder;
//
//    @Autowired
//    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//        auth
//                .inMemoryAuthentication()
//                .withUser("user").password(passwordEncoder.encode("password")).roles("ROLE_USER")
//                .and()
//                .withUser("admin").password(passwordEncoder.encode("admin")).roles("ROLE_ADMIN");
//    }
//
////    @Bean
////    public BCryptPasswordEncoder passwordEncoder() {
////        return new BCryptPasswordEncoder();
////    }
//
//
//
//
//}
