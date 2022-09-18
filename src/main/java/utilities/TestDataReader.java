package utilities;

import org.ini4j.Ini;
import java.io.File;

public class TestDataReader {

    public String readIni(String header, String key) {
        try {
            Ini ini = new Ini(new File("src/test/resources/data/testdata.ini"));
            return ini.get(header, key);
        } catch (Exception e){
            System.out.println("No file exist");
        }

        return null;
    }
}
