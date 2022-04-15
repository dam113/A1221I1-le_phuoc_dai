package com.SS7_AbstractClass_Interface.bai_tap.InterfaceColorableGeometry;

public class Square extends Geometry implements Colorable {

    private double area = 14;
    @Override
    public String resize(double percent) {
        return "Square " +area*percent + "%";
    }

    @Override
    public String howToColor() {
        return "Square is red Color";
    }
}
