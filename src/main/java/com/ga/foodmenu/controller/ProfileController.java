package com.ga.foodmenu.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class ProfileController {
    @GetMapping("/")
    public Map<String, String> getProfile() {
        Map<String, String> info = new HashMap<>();
        info.putAll(Map.of(
                "Name", "Batool Isa",
                "Role", "DevOps Engineer",
                "Interests", "Technology, Baking",
                "Technology Current Mission", "Finish Java Bootcamp Successfully"
        ));
        return info;
    }

}
