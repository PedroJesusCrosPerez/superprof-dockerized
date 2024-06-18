package app.project.config.security;

import app.project.config.security.jwt.AuthEntryPointJwt;
import app.project.config.security.jwt.AuthTokenFilter;
import app.project.content.user.application.impl.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableMethodSecurity
// (securedEnabled = true,
// jsr250Enabled = true,
// prePostEnabled = true) // by default
public class WebSecurityConfig { // extends WebSecurityConfigurerAdapter {
//  @Autowired
//  UserDetailsServiceImpl userDetailsService;

  @Autowired
  private AuthEntryPointJwt unauthorizedHandler;

  @Bean
  public AuthTokenFilter authenticationJwtTokenFilter() {
    return new AuthTokenFilter();
  }

//  @Override
//  public void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
//    authenticationManagerBuilder.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
//  }

//  @Bean
//  public DaoAuthenticationProvider authenticationProvider() {
//      DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
//
//      authProvider.setUserDetailsService(userDetailsService);
//      authProvider.setPasswordEncoder(passwordEncoder());
//
//      return authProvider;
//  }

//  @Bean
//  @Override
//  public AuthenticationManager authenticationManagerBean() throws Exception {
//    return super.authenticationManagerBean();
//  }

  @Bean
  public AuthenticationManager authenticationManager(AuthenticationConfiguration authConfig) throws Exception {
    return authConfig.getAuthenticationManager();
  }

  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }

//  @Override
//  protected void configure(HttpSecurity http) throws Exception {
//    http.cors().and().csrf().disable()
//      .exceptionHandling().authenticationEntryPoint(unauthorizedHandler).and()
//      .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
//      .authorizeRequests().antMatchers("/api/auth/**").permitAll()
//      .antMatchers("/api/test/**").permitAll()
//      .anyRequest().authenticated();
//
//    http.addFilterBefore(authenticationJwtTokenFilter(), UsernamePasswordAuthenticationFilter.class);
//  }

  @Bean
  public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
      /* Normal auth poject */
      /*
    http.csrf(csrf -> csrf.disable())
        .exceptionHandling(exception -> exception.authenticationEntryPoint(unauthorizedHandler))
        .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
        .authorizeHttpRequests(auth ->
          auth
                  //Roles
                  .requestMatchers("/admin/**").hasRole("ADMIN")
                  .requestMatchers("/teacher/**").hasRole("TEACHER")
                  // Swagger
                  .requestMatchers("/swagger-ui/**").permitAll()
                  .requestMatchers("/v3/api-docs/**").permitAll()
                  // Routes
//                  .requestMatchers("/home/**").permitAll()
//                  .requestMatchers("/auth/signin/**").anonymous()
                  .requestMatchers("/auth/**").permitAll()
                  // API
//                  .requestMatchers("/api/auth/**").permitAll()
//                  .requestMatchers("/api/test/**").permitAll()
//              .anyRequest().authenticated()
//                  .requestMatchers("/teacher/my_agreements/**").hasRole("TEACHER")
//                  .anyRequest().permitAll()
                  .requestMatchers("/index").permitAll()
                  .requestMatchers("/login").permitAll()
                  .requestMatchers("/register").permitAll()
                  .anyRequest().permitAll()
        )
            .formLogin(
                    form -> form
                            .loginPage("/login")
                            .loginProcessingUrl("/login")
                            .defaultSuccessUrl("/dashboard")
                            .permitAll()
            ).logout(
                    logout -> logout
                            .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                            .permitAll()

            );

    http.authenticationProvider(authenticationProvider());

    http.addFilterBefore(authenticationJwtTokenFilter(), UsernamePasswordAuthenticationFilter.class);

    return http.build();
    */
      http.csrf().disable()
              .authorizeHttpRequests()
              .requestMatchers("/register/**").permitAll()
              .requestMatchers("/auth/register/**").permitAll()
              .requestMatchers("/index").permitAll() //For matching http request requests.
              .requestMatchers("/dashboard").hasAnyRole("ADMIN","TEACHER")

              // Service REST
              .requestMatchers("/auth/**").permitAll()
              .requestMatchers("/agreements/**").permitAll()
              //Roles
              .requestMatchers("/admin/**").hasRole("ADMIN")
              .requestMatchers("/teacher/**").hasRole("TEACHER")
              // Swagger
              .requestMatchers("/swagger-ui/**").permitAll()
              .requestMatchers("/v3/api-docs/**").permitAll()
              // Routes
//                  .requestMatchers("/home/**").permitAll()
//                  .requestMatchers("/auth/signin/**").anonymous()
              // API
//                  .requestMatchers("/api/auth/**").permitAll()
//                  .requestMatchers("/api/test/**").permitAll()

              //.requestMatchers("/users").hasRole("USER")
              .anyRequest().permitAll()
              .and()
              .formLogin(
                      form -> form
                              .loginPage("/login")
                              .loginProcessingUrl("/login")
                              .defaultSuccessUrl("/dashboard")
                              .permitAll()
              ).logout(
                      logout -> logout
                              .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                              .permitAll()

              );
      return http.build();
  }


  /* Normal auth poject */
//    @Autowired
//    public void configureGlobal(AuthenticationManagerBuilder builder) throws Exception {
//        builder.userDetailsService(userDetailsService)
//                .passwordEncoder(passwordEncoder());
//    }
}
