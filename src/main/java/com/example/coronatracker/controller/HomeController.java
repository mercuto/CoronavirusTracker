package com.example.coronatracker.controller;

import com.example.coronatracker.models.LocationStats;
import com.example.coronatracker.services.CoronaVirusTracker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    CoronaVirusTracker coronaVirusTracker;

    @GetMapping("/")
    public String home(Model model) {
        List<LocationStats> allStats = coronaVirusTracker.getAllStats();
        int totalCases = allStats.stream().mapToInt(stat -> stat.getLatestTotalCases()).sum();
        model.addAttribute("locationStats", allStats);
        model.addAttribute("totalCases", totalCases);
        return "home";
    }
}
