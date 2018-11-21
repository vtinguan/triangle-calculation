package com.tradeshift.trangle.calculator.service;

import com.tradeshift.triangle.calculator.exception.InvalidTriangleException;
import com.tradeshift.triangle.calculator.model.TriangleDataInput;
import com.tradeshift.triangle.calculator.model.TriangleType;
import com.tradeshift.triangle.calculator.service.TriangleDiscoverService;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.TestInstance;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DisplayName("Tests for Triangle Discover Service Cases")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TriangleDiscoverServiceTest {
    public TriangleDiscoverServiceTest() { }

    TriangleDiscoverService triangleDiscoverService = new TriangleDiscoverService();

    @Test
    @DisplayName("should throw exception when some side of tringle is 0.0")
    public void someSideIsZero() {
        // given
        TriangleDataInput triangleDataInput = new TriangleDataInput(0.0,0.0,0.0);
        // then
        assertThrows(InvalidTriangleException.class,
                ()->{ triangleDiscoverService.discoverTriangleType(triangleDataInput); });
    }

    @Test
    @DisplayName("should throw exception when some side of tringle is greater than sum of two other sides")
    public void someSideIsGreaterThanSum() {
        // given
        TriangleDataInput triangleDataInput = new TriangleDataInput(5.0,2.0,2.0);
        // then
        assertThrows(InvalidTriangleException.class,
                ()->{ triangleDiscoverService.discoverTriangleType(triangleDataInput); });
    }

    @Test
    @DisplayName("When there is a scalene triangle")
    public void scaleneTriangle() throws InvalidTriangleException {
        // given
        TriangleDataInput triangleDataInput = new TriangleDataInput(5.0,2.0,6.0);
        // when
        TriangleType result = triangleDiscoverService.discoverTriangleType(triangleDataInput);
        // then
        assertEquals(TriangleType.SCALENE, result);
    }

    @Test
    @DisplayName("When there is an equilateral triangle")
    public void equilateralTriangle() throws InvalidTriangleException {
        // given
        TriangleDataInput triangleDataInput = new TriangleDataInput(5.0,5.0,5.0);
        // when
        TriangleType result = triangleDiscoverService.discoverTriangleType(triangleDataInput);
        // then
        assertEquals(TriangleType.EQUILATERAL, result);
    }

    @Test
    @DisplayName("When there is an isosceles triangle")
    public void isoscelesTriangle() throws InvalidTriangleException {
        // given
        TriangleDataInput triangleDataInput = new TriangleDataInput(5.0,5.0,8.0);
        // when
        TriangleType result = triangleDiscoverService.discoverTriangleType(triangleDataInput);
        // then
        assertEquals(TriangleType.ISOSCELES, result);
    }
}
