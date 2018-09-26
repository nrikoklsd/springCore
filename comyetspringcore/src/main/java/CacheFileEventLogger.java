import java.util.LinkedList;
import java.util.List;

public class CacheFileEventLogger extends FileEventLogger implements EventLogger{
    int cacheSize;
    List<String> cache;

    public CacheFileEventLogger(String filename, int cacheSize) {
        super(filename);
        this.cacheSize = cacheSize;
        cache = new LinkedList<String>();
    }

    public void logEvent(String msg){
        cache.add(msg);

        if(cache.size() > cacheSize){
            super.logEvent(msg);
            cache.clear();
        }
    }
    void writeEventsFromCache(){
        super.logEvent(cache.toString());

    }


    public void destroy(){
        if(!cache.isEmpty()){
            writeEventsFromCache();}
    }

}
