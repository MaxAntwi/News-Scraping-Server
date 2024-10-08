package com.maestro.newswebscraping.service;

import com.maestro.newswebscraping.dto.Article;
import com.maestro.newswebscraping.dto.Response;
import lombok.extern.slf4j.Slf4j;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
@Slf4j
public class ScrapingServiceImpl implements ScrapingService{

    @Override
    public Response getNews() {
        String url = "https://www.myjoyonline.com/news";
        log.info("Getting News from: {}", url);
        List<Article> newsArticles = getArticles(url);
        return Response
                .builder()
                .status(HttpStatus.OK.value())
                .message("News Articles")
                .articles(newsArticles)
                .build();
    }

    @Override
    public Response getEntertainmentNews() {
        String url = "https://www.myjoyonline.com/entertainment";
        log.info("Getting News from: {}", url);
        List<Article> newsArticles = getArticles(url);
        return Response
                .builder()
                .status(HttpStatus.OK.value())
                .message("Entertainment News")
                .articles(newsArticles)
                .build();
    }

    @Override
    public Response getBusinessNews() {
        String url = "https://www.myjoyonline.com/business";
        log.info("Getting News from: {}", url);
        List<Article> newsArticles = getArticles(url);
        return Response
                .builder()
                .status(HttpStatus.OK.value())
                .message("Business News")
                .articles(newsArticles)
                .build();
    }

    @Override
    public Response getSportsNews() {
        String url = "https://www.myjoyonline.com/sports";
        log.info("Getting News from: {}", url);
        List<Article> newsArticles = getArticles(url);
        return Response
                .builder()
                .status(HttpStatus.OK.value())
                .message("Sports News")
                .articles(newsArticles)
                .build();
    }

    @Override
    public Response getOpinionNews() {
        String url = "https://www.myjoyonline.com/opinion";
        log.info("Getting News from: {}", url);
        List<Article> newsArticles = getArticles(url);
        return Response
                .builder()
                .status(HttpStatus.OK.value())
                .message("Opinions")
                .articles(newsArticles)
                .build();
    }

    @Override
    public Response getResearchNews() {
        String url = "https://www.myjoyonline.com/research";
        log.info("Getting News from: {}", url);
        List<Article> newsArticles = getArticles(url);
        return Response
                .builder()
                .status(HttpStatus.OK.value())
                .message("Research Articles")
                .articles(newsArticles)
                .build();
    }

    @Override
    public Response getElectionsNews() {
        String url = "https://www.myjoyonline.com/ghana-election/?election=1";
        log.info("Getting News from: {}", url);
        List<Article> newsArticles = getArticles(url);
        return Response
                .builder()
                .status(HttpStatus.OK.value())
                .message("Election Articles")
                .articles(newsArticles)
                .build();
    }


    private List<Article> getArticles(String url) {
        List<Article> newsArticles = new ArrayList<>();
        try {
            Document document = Jsoup.connect(url).get();
            Elements articles = document.select("div.col-lg-3.col-md-6.col-sm-6.col-xs-6.mb-4");
            for (Element article : articles) {
                String articleUrl = article.select("a.bgposition").attr("href");

                // Extract the title
                String title = article.select("h4").text();

                // Extract the image URL
                String imageUrl = article.select("img").attr("data-src");
                if (imageUrl.isEmpty()) {
                    imageUrl = article.select("img").attr("src"); // Fallback to src if data-src is not found
                }
                Article articleDto = Article
                        .builder()
                        .title(title)
                        .imageUrl(imageUrl)
                        .source("My Joy Online")
                        .url(articleUrl)
                        .build();
                newsArticles.add(articleDto);
            }
            return newsArticles;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
