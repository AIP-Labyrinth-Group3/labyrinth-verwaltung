package com.mci.verwaltungsserver.model;


public enum ServerStatusEnum {
    LOBBY((String)"LOBBY"), IN_GAME((String)"IN_GAME"), FINISHED((String)"FINISHED");
    private final String status;
    ServerStatusEnum(String serverInfo) {
        this.status = serverInfo;
    }

    public String getValue() {
        return status;
    }

    public static ServerStatusEnum fromValue(String value) {
        for (ServerStatusEnum e : ServerStatusEnum.values()) {
            if (e.status.equals(value)) {
                return e;
            }
        }
        throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }

    @Override
    public String toString() {
        return String.valueOf(status);
    }
}

