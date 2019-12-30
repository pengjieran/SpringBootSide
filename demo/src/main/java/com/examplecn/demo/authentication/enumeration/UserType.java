package com.examplecn.demo.authentication.enumeration;

public enum UserType {

    ANONYMOUS(0, "匿名用户"),

    PUBLIC(100, "开放授权用户"),

    CUSTOMER(200, "普通用户级别"),

    AGENCY(300, "机构用户"),

    SUPER_ADMIN(400, "超级用户");


    private int level;
    private String label;


    UserType(int level, String label) {
        this.level = level;
        this.label = label;
    }


    public static UserType getUserTypeByLevel(int level) {
        UserType userType = null;
        for (UserType ut : UserType.values()) {
            if (ut.level == level) {
                userType = ut;
                break;
            }
        }
        return userType;
    }


    public int getLevel() {
        return level;
    }

    public String getLabel() {
        return label;
    }
}
