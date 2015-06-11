package com.example.streaming;

import com.example.model.Article;
import org.junit.Test;

import java.util.List;
import java.util.function.Predicate;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertNotNull;

/**
 * Created by aaron.korver.
 */
public class TestArticleFindAll{

    @Test
    public void testJava7FindAll()
    {
        com.example.java7.streaming.ArticleSearcher searcher = new com.example.java7.streaming.ArticleSearcher();
        List<Article> foundArticles = searcher.getAllJavaArticles(ArticleFixture.createArticles());
        assertNotNull(foundArticles);
        assertThat(foundArticles.size(),is(3));

        assertThat(foundArticles.get(0).getAuthor(),is("Bobby May"));
        assertThat(foundArticles.get(1).getAuthor(),is("Bobby June"));
        assertThat(foundArticles.get(2).getAuthor(),is("George Henry"));
    }

    @Test
    public void testJava8FindAll()
    {
        com.example.java8.streaming.ArticleSearcher searcher = new com.example.java8.streaming.ArticleSearcher();
        List<Article> foundArticles = searcher.getAllJavaArticles(ArticleFixture.createArticles());
        assertNotNull(foundArticles);
        assertThat(foundArticles.size(),is(3));

        assertThat(foundArticles.get(0).getAuthor(),is("Bobby May"));
        assertThat(foundArticles.get(1).getAuthor(),is("Bobby June"));
        assertThat(foundArticles.get(2).getAuthor(),is("George Henry"));
    }

    @Test
    public void testPredicateFindAllContainsJava()
    {
        com.example.java8.streaming.ArticleSearcherPredicate searcher = new com.example.java8.streaming.ArticleSearcherPredicate();
        Predicate<Article> filter = (Article a) -> {return a.getTags().contains("Java");};
        List<Article> foundArticles = searcher.getAllArticles(ArticleFixture.createArticles(), filter);
        assertNotNull(foundArticles);
        assertThat(foundArticles.size(),is(3));

        assertThat(foundArticles.get(0).getAuthor(),is("Bobby May"));
        assertThat(foundArticles.get(1).getAuthor(),is("Bobby June"));
        assertThat(foundArticles.get(2).getAuthor(),is("George Henry"));
    }

    @Test
    public void testPredicateFindAllIsPublished()
    {
        com.example.java8.streaming.ArticleSearcherPredicate searcher = new com.example.java8.streaming.ArticleSearcherPredicate();
        List<Article> foundArticles = searcher.getAllArticles(ArticleFixture.createArticles(),Article::isPublished);
        assertNotNull(foundArticles);
        assertThat(foundArticles.size(),is(4));
    }
}
