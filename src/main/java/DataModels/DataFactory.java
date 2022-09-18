package DataModels;

import utilities.SystemDataReader;

public class DataFactory {
    PersonalData personalInfo = new PersonalData();
    SystemDataReader systemDataReader = new SystemDataReader();


    public PersonalData createPersonalData(String info){
        loadPersonalInfo(info);
        return personalInfo;
    }

    public void loadPersonalInfo(String info){
        personalInfo = systemDataReader.loadPersonalData(info);
        personalInfo.setFirstName(personalInfo.getFirstName());
        personalInfo.setLastName(personalInfo.getLastName());
        personalInfo.setAge(personalInfo.getAge());
    }

}
