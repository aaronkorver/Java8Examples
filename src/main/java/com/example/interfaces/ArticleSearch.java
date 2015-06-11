package com.example.interfaces;

import com.example.model.Article;

import java.util.List;
import java.util.Optional;

/**
 * Created by aaron.korver.
 */
public interface ArticleSearch {
    Optional<Article> getFirstJavaArticle(List<Article> articles);
}
