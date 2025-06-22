package com.warpaintly.corepaint.domain.paint;

import jakarta.persistence.*;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "t_paint")
public class PaintEntity {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    private String name;

    private String code;

    @Enumerated(EnumType.STRING)
    private PaintType paintType;

    @Enumerated(EnumType.STRING)
    private PaintBrand brand;

    @Enumerated(EnumType.STRING)
    private ColorGroup colorGroup;

    public PaintEntity(String name, PaintBrand brand, ColorGroup colorGroup, PaintType paintType, String code) {
        this.name = name;
        this.brand = brand;
        this.colorGroup = colorGroup;
        this.paintType = paintType;
        this.code = code;
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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public PaintType getPaintType() {
        return paintType;
    }

    public void setPaintType(PaintType paintType) {
        this.paintType = paintType;
    }
}
