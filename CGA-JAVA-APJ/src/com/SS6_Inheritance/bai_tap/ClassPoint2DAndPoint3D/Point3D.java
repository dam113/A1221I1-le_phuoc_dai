package com.SS6_Inheritance.bai_tap.ClassPoint2DAndPoint3D;

public class Point3D extends Point2D{
    private float z;

    public Point3D() {
        this.z = z;
    }

    public Point3D(float x, float y, float z) {
        super(x, y);
        this.z = z;
    }

    public float getZ() {
        return z;
    }

    public void setZ(float z) {
        this.z = z;
    }

    public void setXYZ(float x, float y, float z){
        setXY(x,y);
        this.z = z;
    }

    public float[] getXYZ(){
        float[] arr = getXY();
        arr[2] = z;
        return arr;
    }

    @Override
    public String toString() {
        return "Point3D{" +
                "z=" + z +
                '}' + " ,which is a subclass of"
                + super.toString();
    }
}
