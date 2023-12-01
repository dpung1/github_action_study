package com.server.deploy.Controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class HealthCheckController {

    // yml 데이터 가져오기
    @Value("${serverName}")
    private String serverName;
    @Value("${server.env}")
    private String env;
    private Integer visitedCount = 0;

    @GetMapping("/hc")
    public ResponseEntity<?> healthCheck() {

        // 메소드 실행마다 visitedCount 1씩 증가
        visitedCount++;

        Map<String, Object> healthCheckData = new HashMap<>();

        healthCheckData.put("actor", "정대풍");
        healthCheckData.put("serverName", serverName);
        healthCheckData.put("env", env);
        healthCheckData.put("visitedCount", visitedCount);

        return ResponseEntity.ok(healthCheckData);
    }

    @GetMapping("/env")
    public ResponseEntity<String> getEnv() {
        return ResponseEntity.ok(env);
    }

}
