1- CustomUserDetails: This class implements the UserDetails interface provided by Spring Security. It holds user details including username, password, and roles.

2- StateController: This is a REST controller responsible for handling requests related to states. It has methods to retrieve all states and states by country code.

3- CustomUserDetailsService: This class implements the UserDetailsService interface provided by Spring Security. It loads user-specific data for authentication.

4- SpringSecurityConfig: This class configures Spring Security for the application, specifying authorization rules and password encryption.

5- ConfigureRepositoryRestConfigration: This class configures the repository REST API, disabling certain HTTP methods for specific entities.

6- CategoryController, CountryController, OrderController: These are REST controllers responsible for handling requests related to categories, countries, and orders respectively. They provide various endpoints to perform CRUD operations on these entities.

7-  PurchaseController: This controller handles purchase-related requests, such as adding a purchase request.
