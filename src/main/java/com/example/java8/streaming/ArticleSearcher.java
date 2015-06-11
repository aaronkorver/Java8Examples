package com.example.java8.streaming;

import com.example.model.Article;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;


public class ArticleSearcher {

    public Optional<Article> getFirstJavaArticle(List<Article> articles) {
        return articles.stream()
                .filter(new Predicate<Article>() {
                    @Override
                    public boolean test(Article article) {
                        return article.getTags().contains("Java");
                    }
                })
                .findFirst();
    }

    public List<Article> getAllJavaArticles(List<Article> articles) {
        return articles.stream()
                .filter(article -> article.getTags().contains("Java"))
                .collect(Collectors.toList());
    }

    public Map<String, List<Article>> groupByAuthor(List<Article> articles) {
        return articles.stream()                    //Article::getAuthor
                .collect(Collectors.groupingBy(new Function<Article, String>() {
                    @Override
                    public String apply(Article t) {
                        return t.getAuthor();
                    }
                }));
    }
}
