package br.com.digitalhouse.bootcampbrspring.usecase.model.response;

import br.com.digitalhouse.bootcampbrspring.domain.entity.Room;

import java.util.List;

public class HouseResponse {

    private String name;
    private double totalArea;
    private double housePrice;
    private Room biggestRoom;
    private List<RoomResponse> areaPerRoot;

    public HouseResponse() {
    }

    public HouseResponse(String name, double totalArea, double housePrice, Room biggestRoom, List<RoomResponse> areaPerRoot) {
        this.name = name;
        this.totalArea = totalArea;
        this.housePrice = housePrice;
        this.biggestRoom = biggestRoom;
        this.areaPerRoot = areaPerRoot;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getTotalArea() {
        return totalArea;
    }

    public void setTotalArea(double totalArea) {
        this.totalArea = totalArea;
    }

    public double getHousePrice() {
        return housePrice;
    }

    public void setHousePrice(double housePrice) {
        this.housePrice = housePrice;
    }

    public Room getBiggestRoom() {
        return biggestRoom;
    }

    public void setBiggestRoom(Room biggestRoom) {
        this.biggestRoom = biggestRoom;
    }

    public List<RoomResponse> getAreaPerRoot() {
        return areaPerRoot;
    }

    public void setAreaPerRoot(List<RoomResponse> areaPerRoot) {
        this.areaPerRoot = areaPerRoot;
    }
}
