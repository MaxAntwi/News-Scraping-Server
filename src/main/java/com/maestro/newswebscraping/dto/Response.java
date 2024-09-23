package com.maestro.newswebscraping.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@Builder
public class Response {
    private String message;
    private int status;
    private List<Article> articles;
}
