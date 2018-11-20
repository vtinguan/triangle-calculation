package com.tradeshift.triangle.calculator.controller;

import java.util.HashMap;
import java.util.Map;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TriangleCalculationController {

    @GetMapping("/health")
    public Map<String, String> health() {
        Map<String,String> status = new HashMap<>();
        status.put("status", "ok");
        return status;
    }

}
