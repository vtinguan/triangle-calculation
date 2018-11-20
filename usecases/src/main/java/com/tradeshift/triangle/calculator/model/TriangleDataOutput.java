package com.tradeshift.triangle.calculator.model;

import lombok.Getter;


public class TriangleDataOutput {
    @Getter
    public TriangleType type;

    public TriangleDataOutput(TriangleType type) {
        this.type = type;
    }

}
