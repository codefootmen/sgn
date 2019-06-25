package model;

import lombok.Data;

public enum PriorityEnum{
    URGENT("urgent","Urgent"),
    NORMAL("normal", "Normal");

    String keyDb;
    String viewText;

    PriorityEnum(String key, String view){
        this.keyDb = key;
        this.viewText = view;
    }

    @Data
    public static class Priority{
        private String keyDb;
        private String viewText;

    }
}
