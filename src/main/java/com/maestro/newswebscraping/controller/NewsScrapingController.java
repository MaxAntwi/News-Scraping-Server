package com.maestro.newswebscraping.controller;

import com.maestro.newswebscraping.service.ScrapingService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "v1")
@RequiredArgsConstructor
public class NewsScrapingController {
    private final ScrapingService scrapingService;
    @GetMapping("news")
    public String news() {
        scrapingService.scrape("news");
        return "Scraping";
    }
}
