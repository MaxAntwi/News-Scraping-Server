# News Scraping Server

## Overview

This is a News Scraping Server built with Spring Boot that fetches news articles from my https://www.myjoyonline.com/. The server provides several endpoints to retrieve articles from different sectors such as news, entertainment, business, sports, opinion, research, and election news.

## Features

- Scrapes articles from a specified news website.
- Provides structured responses in JSON format.
- Supports multiple news categories.

## Endpoints

### 1. Get News Articles

**Endpoint:** `GET /news`

**Description:** Fetches the latest news articles.

**Response Example:**
```json
{
  "message": "Latest News",
  "status": 200,
  "articles": [
    {
      "title": "Example News Title",
      "source": "Source Name",
      "imageUrl": "https://example.com/image.jpg",
      "url": "https://example.com/news/article"
    }
  ]
}
```

### 2. Get entertainment Articles

**Endpoint:** `GET /entertainment`

**Description:** Fetches the latest entertainment news articles.

### 3. Get Sports News

**Endpoint:** `GET /sports`

**Description:** Fetches the latest sports news articles.

### 4. Get Opinion News

**Endpoint:** `GET /opinion`

**Description:** Fetches the latest opinion articles.

### 5. Get Research News

**Endpoint:** `GET /research`

**Description:** Fetches the latest research articles.

### 6. Get Business News

**Endpoint:** `GET /business`

**Description:** Fetches the latest business news articles.

### 7. Get Election News

**Endpoint:** `GET /business`

**Description:** Fetches the latest articles related to elections in Ghana.

