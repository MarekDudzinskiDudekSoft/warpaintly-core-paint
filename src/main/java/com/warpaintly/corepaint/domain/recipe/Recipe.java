package com.warpaintly.corepaint.domain.recipe;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "t_recipe")
public class Recipe {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

}
