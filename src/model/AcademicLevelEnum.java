package model;

import lombok.Data;

public enum AcademicLevelEnum {
    ELEMENTARY_SCHOOL("elementarySchool","Elementary_School"),
    HIGH_SCHOOL("highSchool", "High_School"),
    TECHNICIAN("technician", "Technician"),
    UNDERGRAD("undergrad","Undergrad");

    String keyDb;
    String viewText;

    AcademicLevelEnum(String key, String view){
        this.keyDb = key;
        this.viewText = view;
    }

    @Data
    public static class AcademicLevel{
        private String keyDb;
        private String viewText;

    }
}
