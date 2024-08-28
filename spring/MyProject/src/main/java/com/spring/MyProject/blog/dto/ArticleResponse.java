package com.spring.MyProject.blog.dto;

import com.spring.MyProject.blog.domain.Article;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ArticleResponse {
    private final String title;
    private final String content;

    // entity -> dto
    public ArticleResponse(Article article) {
        this.title = article.getTitle();
        this.content = article.getContent();
    }

}
