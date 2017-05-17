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
     * @return
     */
    public static <T> T getService(Class<T> tClass) {
        return context.getBean(tClass);
    }

}
