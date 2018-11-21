package com.tradeshift.triangle.calculator.controller;

import com.tradeshift.triangle.calculator.exception.InvalidTriangleException;
import com.tradeshift.triangle.calculator.model.TriangleDataOutput;
import com.tradeshift.triangle.calculator.service.TriangleDiscoverService;
import com.tradeshift.triangle.calculator.model.TriangleDataInput;
import java.util.HashMap;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TriangleDiscoverController {

    private TriangleDiscoverService triangleDiscoverService;

    public TriangleDiscoverController(TriangleDiscoverService triangleDiscoverService) {
        this.triangleDiscoverService = triangleDiscoverService;
    }

    @GetMapping("/health")
    public Map<String, String> health() {
        Map<String,String> status = new HashMap<>();
        status.put("status", "ok");
        return status;
    }

    @PostMapping("/discover")
    public ResponseEntity<TriangleDataOutput> discoverTriangleType(@RequestBody TriangleDataInput triangleDataInput) throws InvalidTriangleException {
        TriangleDataOutput output = new TriangleDataOutput(triangleDiscoverService.discoverTriangleType(triangleDataInput));
        return new ResponseEntity<>(output, HttpStatus.CREATED);
    }

    @ExceptionHandler(InvalidTriangleException.class)
    public Map<String, String> handleException(InvalidTriangleException exception) {
        Map<String,String> status = new HashMap<>();
        status.put("status", "failed");
        status.put("reason", exception.getMessage());
        return status;

    }
}
