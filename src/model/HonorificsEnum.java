package model;

import lombok.Data;

public enum HonorificsEnum {
    DR("dr", "Dr"),
    MR("mr", "Mr"),
    MRS("mrs", "Mrs");

    String keyDb;
    String viewText;

    HonorificsEnum(String key, String view) {
        this.keyDb = key;
        this.viewText = view;
    }

    @Data
    public static class Honorifics {
        private String keyDb;
        private String viewText;
    }
}
