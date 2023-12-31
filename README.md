Steps:
========
1. Create a new spring boot 3.0 project
2. Add Data source: we can skip by using default datasource by adding h2 dependency in pom.xml
3. Connect to the database
4. Create user class
5. Transform the User to an entity
6. Extend the user to UserDeatils class
7. Create the user repository
8. Create the JWT authentication filter (Base class for JWT authentication)
9. Create the JWT service (In this project that is JwtUtil)
10. Add the JJWT dependencies: impl, jackson, api

    Add the following methods in JwtUtil class:
    ===============================================
1. Extract claims from JWT token in JwtUtil
2. Implement the getSignInKey method in JwtUtil
3. Extract a single claim from JWT
4. Extract the username from the token
5. Generate the JWT token
6. Check if the token is valid

11. Check the user existence in the database (JwtAuthFilter)
12. Inject the UserDetailsService
13. Update the SecurityContextHolder and finalise the filter
  
  Add the security configuration:
================================
1. Create the authentication provider bean
2. Create the authentication manager bean


15. Create the authentication controller
16. Create the authentication response class
17. Create the register request object
18. Create the authentication request class
19. Create the authentication service
20. Implement the register method
21. Implement the authenticate method
22. Update the security configuration whitelist in SecurityConfigurer class: in securityFilterChain() method
23. Create a test controller
24. Test the changes
