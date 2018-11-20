package com.tradeshift.triangle.calculator.service;

import com.tradeshift.triangle.calculator.exception.InvalidTriangleException;
import com.tradeshift.triangle.calculator.model.TriangleDataInput;
import com.tradeshift.triangle.calculator.model.TriangleType;
import org.springframework.stereotype.Service;
import static com.tradeshift.triangle.calculator.model.TriangleType.EQUILATERAL;
import static com.tradeshift.triangle.calculator.model.TriangleType.ISOSCELES;
import static com.tradeshift.triangle.calculator.model.TriangleType.SCALENE;

@Service
public class TriangleDiscoverService {
    //TODO add log info sizes
    public TriangleType discoverTriangleType(TriangleDataInput triangleDataInput) throws InvalidTriangleException {
        if (triangleDataInput.getSide1() <= 0 || triangleDataInput.getSide2() <= 0 ||
                triangleDataInput.getSide3() <= 0) throw new InvalidTriangleException("The Side Values Can't be 0 or less");
        if (triangleDataInput.getSide1() >= triangleDataInput.getSide2() + triangleDataInput.getSide3() ||
                triangleDataInput.getSide3() >= triangleDataInput.getSide2() + triangleDataInput.getSide1() ||
                triangleDataInput.getSide2() >= triangleDataInput.getSide1() + triangleDataInput.getSide3()) throw new InvalidTriangleException("Invalid triangle format");
        if (triangleDataInput.getSide1().equals(triangleDataInput.getSide2()) &&
                triangleDataInput.getSide2().equals(triangleDataInput.getSide3())) return EQUILATERAL;
        if (!triangleDataInput.getSide1().equals(triangleDataInput.getSide2()) &&
                !triangleDataInput.getSide2().equals(triangleDataInput.getSide3()) &&
                !triangleDataInput.getSide1().equals(triangleDataInput.getSide3())) return SCALENE;
        return ISOSCELES;
    }
}