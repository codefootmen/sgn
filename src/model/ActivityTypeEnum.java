package model;

import lombok.Data;


public enum ActivityTypeEnum {

    RESEARCH("research", "Research"),
    EDUCATION("education", "Education"),
    EXTENSION_SERVICE("extensionService", "Extension_Service");

    String keyDb;
    String viewText;

    ActivityTypeEnum(String key, String view){
        this.keyDb = key;
        this.viewText = view;
    }

    @Data
    public static class ActivityType{
        private String keyDb;
        private String viewText;
    }
}
