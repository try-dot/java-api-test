package model.order;

import com.fasterxml.jackson.annotation.JsonValue;

public enum Status {

    PLACED("placed"),
    APPROVED("approved"),
    DELIVERED("delivered");

    private final String value;

    Status(String value) {
        this.value = value;
    }

    @JsonValue
    public String returnValue() {
        return value;
    }
}
