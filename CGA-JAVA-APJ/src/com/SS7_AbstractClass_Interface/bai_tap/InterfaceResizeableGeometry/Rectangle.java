package com.SS7_AbstractClass_Interface.bai_tap.InterfaceResizeableGeometry;

import com.SS7_AbstractClass_Interface.bai_tap.InterfaceColorableGeometry.Colorable;

public class Rectangle extends Geometry {
    double area = 23;
    @Override
    public String resize(double percent) {
        return "Rectangle " + area*percent + "%";
    }
}
