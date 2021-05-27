package br.com.digitalhouse.bootcampbrspring.usecase.model;

public class RoomResponse {

    private String name;
    private double area;

    public RoomResponse(String name, double area) {
        this.name = name;
        this.area = area;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }
}
