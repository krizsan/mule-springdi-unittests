package se.ivankrizsan.mule.springditest;

/**
 * Simple Java bean class used in the example.
 */
public class Person {
    protected String mName;

    public String getName() {
        return mName;
    }

    public void setName(final String inName) {
        mName = inName;
    }
}
