import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class CombinedEventLogger implements EventLogger {

    List<EventLogger> list;

    public void logEvent(String msg) {
        for(EventLogger str: list)
        {
            str.logEvent(msg);
        }



    }

    public CombinedEventLogger(List<EventLogger> list) {
        this.list = new LinkedList<EventLogger>();
        this.list = list;

    }


}
