## Theoretical Questions Solution

1. ###### What is JEE? What I can do with JEE?

    JEE compounds the technologies of java API and java platform, and is used to develop enterprise applications, that support scalability, availability among others.
2. ###### What is the different between JPA and Hibernate?

    JPA is like a framework used in Java for persistence API, Hibernate just implements the classes and all the stuff the JPA has, using its ORM implementation.
3. ###### What is an entity in terms of JPA?

    An entity is the class that represents the data that is stored in the database.
4. ###### What is a named query?

    Named queries provide a more flexible functionality since they are SQL strings that can create a query and generate an output that maybe JPA methods cannot. It is created by using the `@NamedQuery` annotation.
5. ###### What is the difference between persist and merge methods of Entity Manager class

    Merge manages detached and new entities while persist deals with new ones. Also persist does not return value while merge returns the entity. Persist also makes an entity to be managed again.
6. ###### What is the difference between a SOAP service and REST service?
    
    A key difference is that SOAP only uses XML format, while REST uses XML, JSON and HTML. Also while SOAP cannot make use of REST, REST can make use of SOAP.

7. ###### In order to build a REST service, the JSON protocol is mandatory. [true or false]
    
    False
8. ###### What strategies can you recommend in order to protect a REST service (Security)?
   
    1. The design should be as simple as possible either the API or the security design.
    2. Encrypt sensible information as passwords, or credit card numbers.
    3. Never expose that sensible information in the API urls.
    4. Make use of authentication and authorization for accessing the API.
9. ###### What are the advantages of Singleton Pattern?
   
    1. Singleton pattern can implement interfaces.
    2. Singleton allows polymorphism.
    3. singleton can exchange the instances.
    4. Singleton instance's fields do not take space in the global namespace.
    
10. ###### Please explain two design patterns which you have used previously (Excepting Singleton Pattern)

    1. Factory Pattern: this pattern is used to avoid exposing the logic to the customer, to achieve it we first 
       need to create an interface, and some concrete classes to implement it and generate some objects, after that
       we can create a factory which takes as fields, some instances of those concrete created classes by accessing its 
       getters, thus we can access the methods.
    2. Builder pattern: This pattern allows us to create objects in a flexible way by adding builders to their classes, 
       this is now being addressed by lombok as well, so that we only call the fields of that instance that we need.   
11. ###### Please mention 2 advantages of microservices-oriented architecture.
    
    1. It allows an application to be efficient and distributes the workload properly, so that each microservice can focus
       on what is really needed, instead of a large and cumbersome monolith.
    2. This approach is good since front end applications can act independently and if they need the microservice,
       just need to make an AJAX call to it, in case of JS or TS based applications.  
12. ###### What are advantages/disadvantages of Spring Boot Framework?
    
    **Advantages**:
    1. It brings some built in libraries and structure that reduces the effort in development and configuration.
    2. Facilitates testing of java applications because provides a default set up to do so.
    3. Has an embedded server which comes in handy when running the app automatically.
    
    **Disadvantages**:
    1. If you have never worked with spring it would be complicated to understand spring by just knowing Spring boot (SB).
    2. SB is not recommended for building large monolithic applications.
    3. Maybe just by learning SB will result in missing some other key concepts of spring like AOP or proxies.
    
13. ###### Spring allows creating special objects called EJB which provide business services. [true or false]
    
    True.

14. ###### What is the difference between a service and component in Spring?
    
    A `@Service` is a kind of `@Component` but it stays only in the service layer and holds the logic. But it's also has the same behaviour of the components, and the ability to inject them in the Spring context. 
15. ###### Please explain the difference between a Virtual Machine and Docker container (Docker)
    
    Docker uses containerization technology, so when running containers, they share the space of the OS, so they are lightweight.
    On the other hand VMs take as guest the OS, it's space, and the kernel space, which make them heavy in terms of performance.
16. ###### What is the difference between image and instance (Docker)?
    
    An instance of an image is a container. An image is the template that holds instructions to run a container.
17. ###### What is the importance of Kubernetes?
    
    Kubernetes is important because while with Docker we can containerize our applications, it does
    not offer orchestration as kubernetes does, also because it allows to 'cluster' the containers,
    a functionality that is pretty useful in production environments, where a single node of a docker compose cannot do much as in local.
18. ###### What is the difference between SVN and GIT? Which do you consider as the best option?
    
    GIT is a distributed version control system, while SVN is centralized. I prefer GIT because it has a community behind that is 
    pretty helpful when something fails, also when committing to SVN it would take long and maybe interfere with other developers,
    while in GIT I can commit every often to the central repository without worrying about that. 
19. ###### Have you worked with GCP (Google Cloud Platform)? If “yes”, please mention some services used by you with, please describe how were they used

    Yes, I had the chance to work with GCP, I used App Engine to host the applications that the team created to be operated from the cloud, also using 
    it mixed with some GPU and CPU, and some cloud storage to get the data stored in the Google cloud. To do so, we migrated some services to GCP
    by running some jobs and setting up spinnaker to run the build jobs so that the service gets deployed in the GCP, there by using the Google UI we 
    can monitor the services and the way the build id getting done.
    Also, I made use of kubernetes to access to the logs of the services in production or lower environments, and to see the pods
    there running and perform some basic operations such as scaling them.
20. ###### Please mention a framework to create Unit Tests in Java. In addition, describe how can you manage the data for your tests.
    
    Junit, is the most popular framework in the java context. To manage data, there are various ways of doing this, it could be by
    using `mockito`, to mock the data, by using random data e.g. the one created by the `easy random` library, or if the data 
    needed are endpoints, could be `wiremock`.