package hu.transfet.unideb.application;

import org.springframework.context.ApplicationContext;

 /**
 * Service locator.
 *
 */
public class ServiceLocator {

     /**
      * ServiceLocator Application context-je.
      */
    private static ApplicationContext context;

     /**
     * Beallitja az application context-et.
     * @param ctx application context.
     */
    public static void setApplicationContext(ApplicationContext ctx) {

        context = ctx;

    }

    /**
     * Az application context egy osztaly objektumat adja vissza.
     * @param tClass Egy objektum.
     * @param <T> Egy osztaly.
     * @return Visszaadja az osztalyban talalhato bean-eket.
     **/
    public static <T> T getService(Class<T> tClass) {
        return context.getBean(tClass);
    }

}
