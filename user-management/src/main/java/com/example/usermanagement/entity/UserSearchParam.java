package com.example.usermanagement.entity;

public enum UserSearchParam {
    USERNAME(1),
    FIRST_NAME(2),
    LAST_NAME(3);

    private final int index;

    UserSearchParam(int index) {
        this.index = index;
    }

    public static UserSearchParam from(String value) {

        for(var param : UserSearchParam.values()) {
            if(param.name().equalsIgnoreCase(value)) {
                return param;
            }

            try {
                var asInt = Integer.parseInt(value);
                if(asInt == param.index) {
                    return param;
                }
            } catch (IllegalArgumentException | NullPointerException ignored) {}
        }
        return null;
    }
}
