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

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@Service
@Slf4j
public class ScrapingServiceImpl implements ScrapingService{
    @Override
    public void scrape(String url) {
        url = "https://www.myjoyonline.com/news";
        log.info("Scraping url: {}", url);
        try {
            Document document = Jsoup.connect(url).get();

            Element menu = document.select("ul#menu-top-menu.menu").first();

            assert menu != null;
            Elements menuItems = menu.select("li.menu-item");

            for (Element menuItem : menuItems) {
                Element link = menuItem.selectFirst("a");
                assert link != null;
                String menuText = link.text();
                String menuLink = link.attr("href");
                log.info("Scraping {} for {}",menuLink, menuText);
                System.out.println("Menu: " + menuText + " | Link: " + menuLink);
                if (!menuLink.isEmpty() && !menuLink.equals("/")) {
                    Document newDocument = Jsoup.connect(menuLink).get();
                    Elements articles = newDocument.select("div.col-lg-3.col-md-6.col-sm-6.col-xs-6.mb-4");
                    for (Element article : articles) {
                        String articleUrl = article.select("a.bgposition").attr("href");

                        // Extract the title
                        String title = article.select("h4").text();

                        // Extract the image URL
                        String imageUrl = article.select("img").attr("data-src");
                        if (imageUrl.isEmpty()) {
                            imageUrl = article.select("img").attr("src"); // Fallback to src if data-src is not found
                        }

                        System.out.println("title: " + title + " | imageUrl: " + imageUrl);
                    }
                }
            }

        } catch (Exception e) {
            log.error("An exception occurred {}", e.getMessage());
            throw new RuntimeException(e);
        }
    }

    @Override
    public Response getNews() {
        String url = "https://www.myjoyonline.com/news";
        log.info("Getting News from: {}", url);
        try {
            Document document = Jsoup.connect(url).get();
            Elements articles = document.select("div.col-lg-3.col-md-6.col-sm-6.col-xs-6.mb-4");
            List<Article> newsArticles = new ArrayList<>();
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
            return Response
                    .builder()
                    .status(HttpStatus.OK.value())
                    .message("News Articles")
                    .articles(newsArticles)
                    .build();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
