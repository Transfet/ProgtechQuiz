package application;

import org.springframework.context.ApplicationContext;

/**
 * Created by Transfet on 2017. 05. 03..
 */
public class ServiceLocator {

    private static ApplicationContext context;

    public static void setApplicationContext(ApplicationContext ctx) {

        context = ctx;

    }

    public static <T> T getService(Class<T> tClass) {
        return context.getBean(tClass);
    }

}
