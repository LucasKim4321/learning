package com.spring.MyProject.blog.dto;

import com.spring.MyProject.blog.domain.Article;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class AddArticleRequest {  // dto를 entity로 맵핑하는 역할

    private String title;
    private String content;

    // dto -> entity
    public Article dtoToEntity() {
        return Article.builder()
                .title(title)
                .content(content)
                .build();

    }
}
