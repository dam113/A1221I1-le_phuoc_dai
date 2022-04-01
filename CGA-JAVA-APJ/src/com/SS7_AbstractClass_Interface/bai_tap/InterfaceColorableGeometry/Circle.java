package com.SS7_AbstractClass_Interface.bai_tap.InterfaceColorableGeometry;

public class Circle extends Geometry implements Colorable {
    double area = 10;
    @Override
    public String resize(double percent) {
        return "Circle " + area*percent + "%";
    }

    @Override
    public String howToColor() {
        return "Circle is black color";
    }
}
