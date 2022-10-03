// WEB LAYER
(RestController) -> View -> HTTP Methods -> @Autowired Service -> Method implementations
                    whenever a request shows up

// Business Layer
(Service layer) -> Dependent on (has dependency) -> DAO layer -> Repository as Dependency Injection 
                -> method implementation as service


// DAO Layer
1. Entity => Hibernate trying to create tables, alter tables
2. Reposiotry => JPA Repository => CRUD Operations