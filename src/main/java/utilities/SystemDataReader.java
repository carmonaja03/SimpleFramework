package utilities;

import DataModels.PersonalData;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.Constructor;

import java.io.InputStream;

public class SystemDataReader {

    public PersonalData loadPersonalData(String location) {
        try {
            Yaml yaml = new Yaml(new Constructor(PersonalData.class));
            InputStream inputStream = yaml.getClass().getClassLoader().getResourceAsStream("environment/"+location+".yml");
            return yaml.load(inputStream);
        } catch (Exception e){
            System.out.println("file not found");
            return null;
        }
    }
}
