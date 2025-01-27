package com.warpaintly.corepaint.service.paint.dto;

public class CreatePaintRequestDTO {

    private String name;

    private String brand;

    private String colorGroup;

    public CreatePaintRequestDTO(String name, String brand, String colorGroup) {
        this.name = name;
        this.brand = brand;
        this.colorGroup = colorGroup;
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

    public String getColorGroup() {
        return colorGroup;
    }

    public void setColorGroup(String colorGroup) {
        this.colorGroup = colorGroup;
    }

}
