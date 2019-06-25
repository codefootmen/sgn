package model;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.ArrayList;

public enum StatusEnum {
    NORMAL("normal", "Normal"),
    ON_LEAVE("on_leave", "On Leave");

    String keyDb;
    String viewText;

    StatusEnum(String keyDb, String viewText) {
        this.keyDb = keyDb;
        this.viewText = viewText;
    }

    public static final ArrayList<Status> status(){
        ArrayList<Status> all = new ArrayList<>();
        for (StatusEnum value : StatusEnum.values()) {
            Status status = new Status()
                    .setKeyDb(value.keyDb)
                    .setViewText(value.viewText);
            all.add(status);
        }
        return all;
    }

    @Data
    @Accessors(chain = true)
    public static class Status {
        private String keyDb;
        private String viewText;
    }
}
