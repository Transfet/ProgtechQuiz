package application;

import org.springframework.context.ApplicationContext;

/**
 *
 */
public class ServiceLocator {

    private static ApplicationContext context;

    /**
     * set the application context.
     * @param ctx application context
     */
    public static void setApplicationContext(ApplicationContext ctx) {

        context = ctx;

    }

    /**
     * get a specific class's service.
     * @param tClass
     * @param <T>
     * @return get the class's beans
     */
    public static <T> T getService(Class<T> tClass) {
        return context.getBean(tClass);
    }

}
