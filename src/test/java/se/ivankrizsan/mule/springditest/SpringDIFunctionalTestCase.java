package se.ivankrizsan.mule.springditest;

import org.mule.api.registry.RegistrationException;
import org.mule.api.registry.Registry;
import org.mule.tck.junit4.FunctionalTestCase;
import org.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor;

/**
 * Mule functional test case that will perform Spring dependency injection on the test class instance
 * prior to executing tests.
 * For dependency injection to be performed, the Mule context must be started before the {@code doSetUp}
 * method is executed.
 * For details on dependency injection performed, please refer to {@code AutowiredAnnotationBeanPostProcessor}.
 *
 * @author Ivan Krizsan
 * @see AutowiredAnnotationBeanPostProcessor
 */
public abstract class SpringDIFunctionalTestCase extends FunctionalTestCase {

    @Override
    protected void doSetUp() throws RegistrationException {
        if (muleContext.isStarted()) {
            final Registry theRegistry = muleContext.getRegistry();
            final AutowiredAnnotationBeanPostProcessor theAutowiredAnnotationBeanPostProcessor;
            try {
                theAutowiredAnnotationBeanPostProcessor =
                    theRegistry.lookupObject(AutowiredAnnotationBeanPostProcessor.class);
            } catch (final RegistrationException theException) {
                logger.error("An error occurred retrieving AutowiredAnnotationBeanPostProcessor", theException);
                throw theException;
            }

            if (theAutowiredAnnotationBeanPostProcessor != null) {
                theAutowiredAnnotationBeanPostProcessor.processInjection(this);
            } else {
                logger.warn("No AutowiredAnnotationBeanPostProcessor in the Mule registry, "
                    + "could not perform dependency injection on the test instance.");
            }
        } else {
            logger.warn("Mule context is not started, no dependency injection on test instance performed.");
        }
    }
}
