package com.warpaintly.corepaint.domain.paint;

import jakarta.persistence.*;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
public class PaintEntity {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    private String name;

    @Enumerated(EnumType.STRING)
    private PaintBrand brand;

    @Enumerated(EnumType.STRING)
    private ColorGroup colorGroup;

    public PaintEntity(String name, PaintBrand brand, ColorGroup colorGroup) {
        this.name = name;
        this.brand = brand;
        this.colorGroup = colorGroup;
    }

    public PaintEntity() {
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PaintBrand getBrand() {
        return brand;
    }

    public void setBrand(PaintBrand brand) {
        this.brand = brand;
    }

    public ColorGroup getColorGroup() {
        return colorGroup;
    }

    public void setColorGroup(ColorGroup colorGroup) {
        this.colorGroup = colorGroup;
    }

}
