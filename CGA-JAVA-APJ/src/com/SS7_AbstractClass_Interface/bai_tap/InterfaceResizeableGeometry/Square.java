package com.SS7_AbstractClass_Interface.bai_tap.InterfaceResizeableGeometry;

import com.SS7_AbstractClass_Interface.bai_tap.InterfaceColorableGeometry.Colorable;

public class Square extends Geometry{
    double area = 14;
    @Override
    public String resize(double percent) {
        return "Square " +area*percent + "%";
    }
}
