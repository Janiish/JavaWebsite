package com.example.leetcodeclone.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/health")
public class HealthController {

    @GetMapping
    public Map<String, String> health() {
        java.util.Map<String, String> result = new java.util.HashMap<>();
        result.put("status", "OK");
        result.put("service", "leetcode-clone");
        result.put("version", "1");
        return result;
    }
}
