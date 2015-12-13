package se.ivankrizsan.mule.springditest;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

/**
 * Spring Java configuration for the application.
 *
 * @author Ivan Krizsan
 */
@Configuration
public class SpringJavaConfiguration {
    /* Constant(s): */
    public final static String PROPERTY_FILENAME = "configuration.properties";

    /**
     * Example {@code Person} bean representing Ivan.
     *
     * @return Ivan person bean.
     */
    @Bean
    public Person ivanPerson() {
        final Person thePerson = new Person();
        thePerson.setName("Ivan Krizsan");
        return thePerson;
    }

    /**
     * Example {@code Person} bean representing Steven.
     *
     * @return Steven person bean.
     */
    @Bean
    public Person stevenPerson() {
        final Person thePerson = new Person();
        thePerson.setName("Steven Seagal");
        return thePerson;
    }

    /**
     * Property placeholder configurer bean.
     *
     * @return Property placeholder configurer bean.
     */
    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        final PropertySourcesPlaceholderConfigurer thePropertyConfigurer =
            new PropertySourcesPlaceholderConfigurer();
        thePropertyConfigurer.setIgnoreResourceNotFound(false);
        final Resource thePropertyFileLocation = new ClassPathResource(PROPERTY_FILENAME);
        thePropertyConfigurer.setLocation(thePropertyFileLocation);
        return thePropertyConfigurer;
    }
}
