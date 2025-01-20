package com.warpaintly.corepaint.service.paint.dto;

public class GetPaintRequestDTO {

    private String name;

    private String brand;

    public GetPaintRequestDTO(String name, String brand) {
        this.name = name;
        this.brand = brand;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

}
