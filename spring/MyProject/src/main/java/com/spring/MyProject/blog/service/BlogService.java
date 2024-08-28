package com.spring.MyProject.blog.service;

import com.spring.MyProject.blog.domain.Article;
import com.spring.MyProject.blog.dto.AddArticleRequest;
import com.spring.MyProject.blog.dto.UpdateArticleRequest;
import com.spring.MyProject.blog.repository.BlogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BlogService {

    private final BlogRepository blogRepository;

    // 1. 등록
    public Article save(AddArticleRequest request) {
        // dto -> entity -> save
        return blogRepository.save(request.dtoToEntity());

    }

    // 2. 목록
    public List<Article> findAll() {
        // entity -> 전체 읽기
        return blogRepository.findAll();

    }

    // 3. 조회
    public Article findById(Long id) {
        return blogRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("not found: "+id));
    }

    // 4. 삭제
    public void delete(Long id) {
        blogRepository.deleteById(id);
    }

    // 5. 수정
    @Transactional
    public Article update(Long id, UpdateArticleRequest request) {

        // 수정할 data 불러오기
        Article article = blogRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("not found: "+id));

        // data 변경
        article.update(request.getTitle(), request.getContent());

        // 변경된 entity 반환
        return article;
    }

} // end class
