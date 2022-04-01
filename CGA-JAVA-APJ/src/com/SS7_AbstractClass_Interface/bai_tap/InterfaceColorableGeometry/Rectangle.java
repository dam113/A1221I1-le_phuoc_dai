package com.SS7_AbstractClass_Interface.bai_tap.InterfaceColorableGeometry;

public class Rectangle extends Geometry implements Colorable {
    double area = 23;
    @Override
    public String resize(double percent) {
        return "Rectangle " + area*percent + "%";
    }

    @Override
    public String howToColor() {
        return "Rectangle is blue color";
    }
}
