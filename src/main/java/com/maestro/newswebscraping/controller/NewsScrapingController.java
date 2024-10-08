package com.maestro.newswebscraping.controller;

import com.maestro.newswebscraping.dto.Response;
import com.maestro.newswebscraping.service.ScrapingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "v1")
@RequiredArgsConstructor
public class NewsScrapingController {
    private final ScrapingService scrapingService;
    @GetMapping("news")
    public ResponseEntity<Response> news() {
        return ResponseEntity.ok(scrapingService.getNews());
    }

    @GetMapping("entertainment")
    public ResponseEntity<Response> getEntertainmentNews() {
        return ResponseEntity.ok(scrapingService.getEntertainmentNews());
    }

    @GetMapping("business")
    public ResponseEntity<Response> getBusinessNews() {
        return ResponseEntity.ok(scrapingService.getBusinessNews());
    }

    @GetMapping("sports")
    public ResponseEntity<Response> getSportsNews() {
        return ResponseEntity.ok(scrapingService.getSportsNews());
    }

    @GetMapping("opinion")
    public ResponseEntity<Response> getOpinionNews() {
        return ResponseEntity.ok(scrapingService.getOpinionNews());
    }

    @GetMapping("research")
    public ResponseEntity<Response> getResearchNews() {
        return ResponseEntity.ok(scrapingService.getResearchNews());
    }

    @GetMapping("election")
    public ResponseEntity<Response> getElectionNews() {
        return ResponseEntity.ok(scrapingService.getElectionsNews());
    }
}
