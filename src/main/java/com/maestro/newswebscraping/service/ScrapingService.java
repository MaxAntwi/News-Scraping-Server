package com.maestro.newswebscraping.service;

import com.maestro.newswebscraping.dto.Response;
import org.springframework.stereotype.Service;

@Service
public interface ScrapingService {

    public Response getNews();

    public Response getEntertainmentNews();

    public Response getBusinessNews();

    public Response getSportsNews();

    public Response getOpinionNews();

    public Response getResearchNews();
}
