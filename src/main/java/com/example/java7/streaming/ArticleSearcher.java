package com.example.java7.streaming;

import com.example.model.Article;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class ArticleSearcher{

    public Article getFirstJavaArticle(List<Article> articles) {

        for (Article article : articles) {
            if (article.getTags().contains("Java")) {
                return article;
            }
        }

        return null;
    }

    public List<Article> getAllJavaArticles(List<Article> articles) {

        List<Article> result = new ArrayList<>();

        for (Article article : articles) {
            if (article.getTags().contains("Java")) {
                result.add(article);
            }
        }

        return result;
    }

    public Map<String, List<Article>> groupByAuthor(List<Article> articles) {

        Map<String, List<Article>> result = new HashMap<>();

        for (Article article : articles) {
            if (result.containsKey(article.getAuthor())) {
                result.get(article.getAuthor()).add(article);
            } else {
                ArrayList<Article> groupedArticles = new ArrayList<>();
                groupedArticles.add(article);
                result.put(article.getAuthor(), groupedArticles);
            }
        }

        return result;
    }
}
