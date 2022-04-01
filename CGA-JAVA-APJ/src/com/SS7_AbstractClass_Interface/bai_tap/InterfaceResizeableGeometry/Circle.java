package com.SS7_AbstractClass_Interface.bai_tap.InterfaceResizeableGeometry;

import com.SS7_AbstractClass_Interface.bai_tap.InterfaceColorableGeometry.Colorable;

public class Circle extends Geometry{
    double area = 10;
    @Override
    public String resize(double percent) {
        return "Circle " + area*percent + "%";
    }

}
