package com.maestro.newswebscraping.service;

import com.maestro.newswebscraping.dto.Response;
import org.springframework.stereotype.Service;

@Service
public interface ScrapingService {
    public void scrape(String url);

    public Response getNews();
}
