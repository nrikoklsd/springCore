import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.HashMap;
import java.util.Map;

public class App {
    public App(Client client, EventLogger eventLogger, Map<EventType,EventLogger> loggers) {
        this.client = client;
        this.eventLogger = eventLogger;
        this.loggers = new HashMap<EventType, EventLogger>();
        this.loggers = loggers;



    }
    Map<EventType,EventLogger> loggers;
    Client client;
    EventLogger eventLogger;

    void logEvent(String msg, EventType type){

        EventLogger logger = loggers.get(type);




        if(type == null) eventLogger.logEvent(msg); //cacheFileEventLogger
        if(type == EventType.ERROR)logger.logEvent(msg); //consoleEventLogger
        if(type == EventType.INFO) logger.logEvent(msg); //consoleEventLogger fileEventLogger

    }

    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
        App app = (App) ctx.getBean("app");


        app.logEvent("cache ", null);

        app.logEvent("console", EventType.ERROR);
        app.logEvent("console and file", EventType.INFO);
        ctx.close();


    }
}
