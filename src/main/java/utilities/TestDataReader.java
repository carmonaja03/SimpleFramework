package utilities;

import org.ini4j.Ini;

import java.io.File;
import java.io.IOException;

public class TestDataReader {

    public String readIni(String header, String key) throws IOException {
        try {
            Ini ini = new Ini(new File("src/test/resources/data/testdata.ini"));
            System.out.println(ini.get(header, key));
            return ini.get(header, key);
        } catch (Exception e){
            System.out.println("No file exist");
        }

        return null;
    }
}
