package com.example.java8.streaming;

import com.example.model.Article;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Created by aaron.korver.
 */
public class ArticleSearcherPredicate {

    public Optional<Article> getFirstArticle(List<Article> articles,Predicate<Article> predicate) {
        return articles.stream()
                .filter(predicate)
                .findFirst();
    }

    public List<Article> getAllArticles(List<Article> articles,Predicate<Article> predicate) {
        return articles.stream()
                .filter(predicate)
                .collect(Collectors.toList());
    }

    public Map<String, List<Article>> groupByAuthor(List<Article> articles,Function<Article,String> function) {
        return articles.stream()                    //Article::getAuthor
                .collect(Collectors.groupingBy(function));
    }
}
