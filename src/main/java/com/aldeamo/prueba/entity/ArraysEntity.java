package com.aldeamo.prueba.entity;

import javax.persistence.*;

@Table(name = "arrays")
@Entity
public class ArraysEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "input_array", nullable = false, length = 20)
    private String inputArray;

    public String getInputArray() {
        return inputArray;
    }

    public void setInputArray(String inputArray) {
        this.inputArray = inputArray;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}