package com.tradeshift.triangle.calculator.model;

import lombok.Getter;

public class TriangleDataInput {
    @Getter
    private Double side1;
    @Getter
    private Double side2;
    @Getter
    private Double side3;

    public TriangleDataInput(Double side1, Double side2, Double side3) {
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    public TriangleDataInput(){}
}
