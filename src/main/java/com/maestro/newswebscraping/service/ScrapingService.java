package com.maestro.newswebscraping.service;

import org.springframework.stereotype.Service;

@Service
public interface ScrapingService {
    public void scrape(String url);
}
