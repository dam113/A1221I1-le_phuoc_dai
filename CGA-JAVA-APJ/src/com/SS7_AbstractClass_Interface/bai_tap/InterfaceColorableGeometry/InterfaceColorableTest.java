package com.SS7_AbstractClass_Interface.bai_tap.InterfaceColorableGeometry;
public class InterfaceColorableTest {
    public static void main(String[] args) {
        Geometry[] geometrys = new Geometry[3];
        geometrys[0] = new Circle();
        geometrys[1] = new Rectangle();
        geometrys[2] = new Square();
        for (Geometry geometry: geometrys) {
            System.out.println(geometry.resize(10));

            if (geometry instanceof Square) {
                System.out.println(((Square) geometry).howToColor());
            }
        }

    }
}
