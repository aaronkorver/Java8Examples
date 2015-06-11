package com.example.streaming;

import com.example.model.Article;
import org.junit.Test;

import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertNotNull;

/**
 * Created by aaron.korver.
 */
public class TestArticleFindFirst{
    @Test
    public void testJava7FindFirst()
    {
        com.example.java7.streaming.ArticleSearcher searcher = new com.example.java7.streaming.ArticleSearcher();
        Article foundArticle = searcher.getFirstJavaArticle(ArticleFixture.createArticles());
        assertNotNull(foundArticle);
        assertThat(foundArticle.getAuthor(),is("Bobby May"));

    }

    @Test
    public void testJava8FindFirst()
    {
        com.example.java8.streaming.ArticleSearcher searcher = new com.example.java8.streaming.ArticleSearcher();
        Optional<Article> foundArticle = searcher.getFirstJavaArticle(ArticleFixture.createArticles());
        Article article = foundArticle.get();
        assertThat(article.getAuthor(),is("Bobby May"));

    }

    @Test
    public void testPredicateFindFirst()
    {
        com.example.java8.streaming.ArticleSearcherPredicate searcher = new com.example.java8.streaming.ArticleSearcherPredicate();
        Optional<Article> foundArticle = searcher.getFirstArticle(ArticleFixture.createArticles(), (a) -> {return a.getTags().contains("Scala");});
        Optional<Article> foundArticleTagSize = searcher.getFirstArticle(ArticleFixture.createArticles(),a -> a.getTags().size() > 2);

        Article article = foundArticle.get();
        assertThat(article.getAuthor(),is("Bobby July"));

        Article secondArticle = foundArticleTagSize.get();
        assertThat(secondArticle.getAuthor(),is("Bobby April"));

    }


}
