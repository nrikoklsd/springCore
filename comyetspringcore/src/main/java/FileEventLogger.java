import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

public class FileEventLogger implements  EventLogger {

    String filename;
    File file;

    public FileEventLogger(String filename) {

        this.filename = filename;

    }

    public void logEvent(String msg){
        try {
            FileUtils.writeStringToFile(file, msg,true);

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("create");
        }

    }

    public void init() throws IOException{
        this.file = new File(filename);
        file.canWrite();

    }





}
