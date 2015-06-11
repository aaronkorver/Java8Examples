package com.example.streaming;

import com.example.model.Article;
import org.junit.Test;

import java.util.List;
import java.util.Map;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by aaron.korver.
 */
public class TestArticleGroupBy{

    @Test
    public void testJava7GroupBy()
    {
        com.example.java7.streaming.ArticleSearcher searcher = new com.example.java7.streaming.ArticleSearcher();
        Map<String,List<Article>> groupByAuthorMap = searcher.groupByAuthor(ArticleFixture.createArticles());
        assertThat(groupByAuthorMap.keySet().size(),is(5));
        List<Article> bobbyJuneArticles = groupByAuthorMap.get("Bobby June");
        assertThat(bobbyJuneArticles.size(),is(2));
    }


    @Test
    public void testJava8GroupBy()
    {
        com.example.java8.streaming.ArticleSearcher searcher = new com.example.java8.streaming.ArticleSearcher();
        Map<String,List<Article>> groupByAuthorMap = searcher.groupByAuthor(ArticleFixture.createArticles());
        assertThat(groupByAuthorMap.keySet().size(),is(5));
        List<Article> bobbyJuneArticles = groupByAuthorMap.get("Bobby June");
        assertThat(bobbyJuneArticles.size(),is(2));
    }

}
