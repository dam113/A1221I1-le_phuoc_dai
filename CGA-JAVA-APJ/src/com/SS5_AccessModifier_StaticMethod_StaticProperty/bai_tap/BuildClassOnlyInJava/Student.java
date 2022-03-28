package com.SS5_AccessModifier_StaticMethod_StaticProperty.bai_tap.BuildClassOnlyInJava;

public class Student {
    private String name = "Join";
    private String classes = "C02";

    public Student() {
    }

    public String getName() {
        return name;
    }

    protected void setName(String name) {
        this.name = name;
    }

    public String getClasses() {
        return classes;
    }

    protected void setClasses(String classes) {
        this.classes = classes;
    }
}
