package se.ivankrizsan.mule.springditest;

import org.junit.Test;
import org.mule.tck.junit4.FunctionalTestCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;

/**
 * Example Mule functional test case with Spring autowiring and injection of values from properties file.
 *
 * @author Ivan Krizsan
 */
public class TestSpringDIWithMuleFunctionalTestCase extends SpringDIFunctionalTestCase {
    /* Constant(s): */

    /* Instance variable(s): */
    @Value("${WEBPAGE_URL}")
    protected String mWebpageUrl;
    @Value("${RETRY_COUNT}")
    protected Integer mRetryCount;
    @Autowired
    @Qualifier("ivanPerson")
    protected Person mIvanPerson;


    @Override
    protected String getConfigFile() {
        return "src/main/app/mule-config.xml";
    }

    @Test
    public void testDependencyInjection() throws Exception {
        System.out.println("Webpage URL: " + mWebpageUrl);
        System.out.println("Retry count: " + mRetryCount);
        System.out.println("Person bean: " + mIvanPerson);
        if (mIvanPerson != null) {
            System.out.println("Person bean name: " + mIvanPerson.getName());
        }
    }
}
