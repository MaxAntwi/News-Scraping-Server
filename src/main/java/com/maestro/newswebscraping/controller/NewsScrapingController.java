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
        return ResponseEntity.ok(scrapingService.getBusinessNews());
    }

    @GetMapping("business")
    public ResponseEntity<Response> getBusinessNews() {
        return ResponseEntity.ok(scrapingService.getEntertainmentNews());
    }
}
