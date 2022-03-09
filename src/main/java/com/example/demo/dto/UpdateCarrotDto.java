package com.example.demo.dto;

public class UpdateCarrotDto {
    private Long id;
    private Long carrotAmount;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCarrotAmount() {
        return carrotAmount;
    }

    public void setCarrotAmount(Long carrotAmount) {
        this.carrotAmount = carrotAmount;
    }
}
