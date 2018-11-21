package com.tradeshift.triangle.calculator;

import com.tradeshift.triangle.calculator.model.TriangleDataInput;
import java.util.HashMap;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.test.context.junit4.SpringRunner;
import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TriangleDiscoverIntegrationTest {

    public TriangleDiscoverIntegrationTest() {}

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void testHealth() throws Exception {
        // when
        HashMap result = restTemplate.getForObject("http://localhost:" + port + "/health", HashMap.class);
        // then
        assertEquals("ok", result.get("status"));
    }

    @Test
    public void testTriangleDiscover() throws Exception {
        // when
        HttpEntity<TriangleDataInput> request = new HttpEntity<>(new TriangleDataInput(5.0, 2.0, 6.0 ));
        HashMap response = restTemplate.postForObject("http://localhost:" + port + "/discover", request, HashMap.class);
        // then
        assertEquals("SCALENE", response.get("type"));
    }
}
