package com.warpaintly.corepaint.service.paint.dto;

public class CreatePaintRequestDTO {

    private String name;

    private String brand;

    private String colorGroup;

    private String code;

    private String paintType;

    public CreatePaintRequestDTO(String name, String brand, String colorGroup, String paintType, String code) {
        this.name = name;
        this.brand = brand;
        this.colorGroup = colorGroup;
        this.paintType = paintType;
        this.code = code;
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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getPaintType() {
        return paintType;
    }

    public void setPaintType(String paintType) {
        this.paintType = paintType;
    }

}
