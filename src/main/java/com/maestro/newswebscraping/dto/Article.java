package com.maestro.newswebscraping.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Article {
    private String title;
    private String source;
    private String imageUrl;
    private String url;
}
