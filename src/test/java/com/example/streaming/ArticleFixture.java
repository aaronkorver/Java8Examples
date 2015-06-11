package com.example.streaming;

import com.example.model.Article;

import java.util.Arrays;
import java.util.List;

/**
 * Created by aaron.korver.
 */
public class ArticleFixture {

    static List<Article> createArticles() {
        Article article1 = new Article("My first article", "Bobby April", Arrays.asList("Groovy", "Database", "Gradle"),true);
        Article article2 = new Article("My second article", "Bobby May", Arrays.asList("Java", "Database", "Maven"),false);
        Article article3 = new Article("My third article", "Bobby June", Arrays.asList("Java", "Kafka"),false);
        Article article4 = new Article("My fourth article", "Bobby July", Arrays.asList("Scala", "Akka"),true);
        Article article5 = new Article("My fifth article", "Bobby June", Arrays.asList("Ruby", "Rails", "Rake"),true);
        Article article6 = new Article("My sixth article", "George Henry", Arrays.asList("Java", "Spring", "REST"),true);
        return Arrays.asList(article1, article2, article3, article4, article5,article6);
    }
}
