# **Annotations**

### `@Bean`

- **Function:** Defines the object returned by a method as a Spring Bean.
- **Usage:** Used on methods within the `@Configuration` class. The method's return value is managed as a bean.

---

### `@Configuration`

- **Function:** Specifies that a class is a configuration class that Spring uses for bean definitions and configurations.
- **Usage:** Used on classes that host `@Bean` methods. Spring's IoC container scans these classes.

---

### `@Primary`

- **Function:** Specifies which bean to choose by default when multiple beans of the same type exist.
- **Usage:** Used on top of bean definition annotations such as `@Bean` or `@Component`.

---

### `@Qualifier`

- **Function:** Specifies which specific bean to use by name during dependency injection.
- **Usage:** Used with injection annotations such as `@Autowired`.

---

### `@Component`

- **Function:** Indicates that a class is a general-purpose Spring bean.
- **Usage:** Used on top of a class. Spring's `@ComponentScan` feature automatically finds these classes and converts them into beans. Annotations such as `@Service`, `@Repository`, and `@Controller` are more specialized forms of `@Component`.

---

### `@ComponentScan("modulePath")`

- **Function:** Scans the specified package and subpackages to find classes with annotations derived from `@Component` and registers them as Spring Beans.
- **Usage:** Since `@SpringBootApplication` already does this by default, it is typically used when adding beans from different packages.

---

### `@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)`

- **Function:** Determines the scope of a bean's lifecycle. The two most commonly used scopes are `singleton` and `prototype`.
- **Usage:** Used on bean definition annotations (`@Component`, `@Bean`).

---

### `@Lazy`

- **Function:** Specifies that a bean be created when it is first needed, rather than at application startup. This can help reduce application startup time.
- **Usage:** Used in dependency definition nodes such as `@Bean`, `@Component`, or `@Autowired`.

---

### `@Eager`

- **Function:** Causes a normally lazy bean to be created immediately at application startup. It is often used to achieve the opposite effect of `@Lazy`. Spring's default bean behavior is already eager.
- **Usage:** This is not a specific annotation, but rather a concept. If all beans are made lazy by setting `spring.main.lazy-initialization=true`, `@Lazy` is not used directly to make a specific bean eager, but rather the opposite of this concept.

---

### `@Named`

- **Function:** Defines a class as a bean managed by CDI. It is the CDI standard equivalent of the `@Component` annotation used in Spring. As a result of the scan with `@ComponentScan`, Spring recognizes classes marked with `@Named` and registers them in its container as a Spring bean.
- **Usage:** Used directly on a class.

---

### `@Injec`

- **Function:** Used to perform dependency injection. This annotation performs a similar function to Spring's `@Autowired` annotation. When Spring sees the `@Inject` annotation, it finds the required dependency (bean) from the IoC container and injects it into the targeted field, constructor method, or setter method.

- **Usage:** It can be used on constructor methods, fields, or setter methods. In the code example you provided, **Setter Injection** was performed using the `setDataService` method.

# **Terms**

### Tight Coupling

- **Definition:** A class is directly dependent on other classes on which it depends. This means that changes made to one class affect other classes that depend on it. The DI principle aims to prevent this.

---

### Loose Coupling

- **Definition:** A class is abstractly dependent on other classes on which it depends. This means that changing the dependent class does not directly affect the dependent class. Spring's DI mechanism ensures this.

---

### Java Bean

- **Definition:** A class that follows the rules set by the Java language, such as default constructor methods, private fields, and public access methods (getter/setter).
- **Management:** Created by the developer. This is a concept independent of Spring.

---

### Spring Bean

- **Definition:** Any object managed by Spring's IoC container throughout its lifecycle.
- **Management:** Managed by the Spring container and can take advantage of all the features offered by Spring. Every Spring Bean can be a Java Bean, but not every Java Bean is a Spring Bean.

---

### IoC (Inversion of Control)
- **Definition:** Inversion of control.

- **Definition:** It refers to the inversion of control. It is a software principle that transfers control of creating objects and managing their dependencies from the developer to a container (Spring Container).

---

### IoC Container (Inversion of Control Container)

**Definition:** It is a software framework component that handles tasks such as creating objects, managing their lifecycle, and injecting their dependencies. This provides centralized management by transferring control from the code itself to this container.

**Purpose of Use:**

- Encourages loose coupling by reducing dependencies between classes.
- Simplifies the management of application components.
- Increases the testability and flexibility of code.

---

### Spring Container / Application Context

- **Definition:** It is the core component through which Spring implements the IoC principle. It creates, configures, and manages beans, and provides their dependencies. ApplicationContext is the most commonly used Spring container type.

---

### Spring Container, Spring Application Context, and IoC Container

These three terms are often used to refer to the same thing, but there are technically minor differences between them:

- **IoC Container (General Concept): This is an abstract concept that implements the "Inversion of Control" principle in any software framework. Spring implements this principle with its own container.
- **Spring Container: This is the general name given by the Spring Framework to its IoC Container. The Spring Container creates, configures, and manages beans' dependencies.
- **Application Context: This is the most commonly used Spring container type, represented by the `org.springframework.context.ApplicationContext` interface. In addition to the IoC Container, the ApplicationContext also provides more advanced features such as event handling, resource loading, and internationalization (i18n).

**In summary,** "IoC Container" is a general principle. "Spring Container" is the embodiment of this principle in Spring. "Application Context" is a commonly used, feature-rich implementation of this Spring Container. Therefore, in practical use and in most cases, these terms are interchangeable.

---

### Dependency

- **Definition:** The principle that an object provides its required dependencies to an external source (usually an IoC container), rather than having to create its own dependencies.
- **Purpose:** This method encourages loose coupling by reducing tight coupling between classes. This makes code more flexible, reusable, and, in particular, easier to write unit tests.

---

### Dependency Injection (DI)

- **Definition:** This is the principle of providing dependencies externally (by the Spring Container) rather than directly creating them.
- **Purpose:** Abstracts dependencies from a class, providing loose coupling and making code easier to test.

---

### Dependency Injection Types

1. **Constructor Injection:** Dependencies are provided through the class's constructor method. **This is the most recommended method.**
2. **Setter Injection:** Dependencies are injected through the class's `setter` methods.
3. **Field Injection:** Dependencies are injected directly by annotating the field with `@Autowired`.

---

### Auto-wiring

- **Definition:** Spring's mechanism for automatically finding and injecting an object's dependencies. It prevents developers from manually binding dependencies. It is most commonly implemented with the `@Autowired` annotation.

---

### CDI (Contexts and Dependency Injection)

**CDI** is a Java EE (now Jakarta EE) standard. Its purpose is to facilitate the creation of loosely coupled and reusable components using dependency injection. The Spring Framework supports CDI, enabling the use of this standard's annotations within its own container.
