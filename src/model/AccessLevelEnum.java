package model;

import lombok.Data;


public enum AccessLevelEnum {

    ADMIN("admin", "Admin"),
    HEAD("head", "Head"),
    PROFESSOR("professor", "Professor"),
    NONE("none", "None");

    String keyDb;
    String viewText;

    AccessLevelEnum(String key, String view){
        this.keyDb = key;
        this.viewText = view;
    }

    @Data
    public static class AccessLevel{
        private String keyDb;
        private String viewText;
    }
}
