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
}
