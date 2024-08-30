package com.spring.MyProject.blog.controller;

import com.google.gson.Gson;
import com.spring.MyProject.blog.domain.Article;
import com.spring.MyProject.blog.dto.AddArticleRequest;
import com.spring.MyProject.blog.dto.UpdateArticleRequest;
import com.spring.MyProject.blog.repository.BlogRepository;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

// 테스트용 애플리케이션 컨텍스트 생성
@SpringBootTest
@Log4j2
@AutoConfigureMockMvc  // 테스트용
//@ExtendWith(MockitoExtension.class)
//@TestPropertySource(locations="classpath:application-test.properties")  // 환경설정파일 따로 지정
class BlogControllerTest {

    @Autowired
    protected MockMvc mockMvc;
    @Autowired
    private WebApplicationContext context;
    @Autowired
    private BlogRepository blogRepository;
    @Autowired
    private Gson gson;

    // 각각의 테스트 케이스 실행 전에 수행되는 메서드
    @BeforeEach
    public void mockMvcSetup() {
        this.mockMvc =
                MockMvcBuilders
                        .webAppContextSetup(context).build();
    }

    @DisplayName("addArticle: 블로그 글 추가 테스트")
    @Test@Transactional(readOnly = false)@Commit
    void addArticle() throws Exception {
        // given
        final String url        ="/api/articles";  // url 틀리면 404 에러남
        final String title      = "title000";
        final String content    = "content";
        // dto 객체 생성
        final AddArticleRequest userRequest = new AddArticleRequest(title, content);

        // java 객체 DTO -> JSON 구조형식을 가진 문자열로 전환
        final String requestBody = gson.toJson(userRequest);
        /*
        {
            "title" : "title",
            "content" : "content"
        }
        */

        // when
        ResultActions result = mockMvc.perform(MockMvcRequestBuilders
                .post(url)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(requestBody));

        // then
        result.andExpect(status().isCreated());

        List<Article> articles = blogRepository.findAll();

        // DB 반영 전 data와 반영 후 data
        assertThat(articles.size()).isEqualTo(1);
        assertThat(articles.get(0).getTitle()).isEqualTo(title);  // title 값이 일치하는지
        assertThat(articles.get(0).getContent()).isEqualTo(content);  // content 값이 일치하는지

    } // end test

    @DisplayName("findAllArticles: 블로그 글 목록 조회 테스트")
    @Test
    void findAllArticles() throws Exception {
        final String url ="/api/articles";  // url 틀리면 404 에러남
        final String title = "title";
        final String content = "content";

        blogRepository.save(Article.builder()
                .title(title)
                .content(content)
                .build());

        // when
        final ResultActions resultActions = mockMvc.perform(MockMvcRequestBuilders
                .get(url)
                .accept(MediaType.APPLICATION_JSON));

        // then
        resultActions.andExpect(status().isOk())  // 응답코드가 OK인지 확인
                .andExpect(jsonPath("$[0].content").value(content))  // content 값이 일치하는지
                .andExpect(jsonPath("$[0].title").value(title));  // title 값이 일치하는지

    } // end test

    @DisplayName("findArticle: 블로그 글 조회 테스트")
    @Test
    void findArticle() throws Exception {
        final String url ="/api/articles/{id}";  // url 틀리면 404 에러남
        final String title = "title";
        final String content = "content";

        // 테스트용 Entity를 생성하여 DB에 저장
        Article savedArticle = blogRepository.save(
                Article.builder()
                    .title(title)
                    .content(content)
                .build());

        // when
        final ResultActions resultActions = mockMvc.perform(MockMvcRequestBuilders
                .get(url, savedArticle.getId())
                .accept(MediaType.APPLICATION_JSON)).andDo(print());

        // then
        resultActions.andExpect(status().isOk())  // 응답코드가 OK인지 확인
                .andExpect(jsonPath("$.content").value(content))  // content 값이 일치하는지
                .andExpect(jsonPath("$.title").value(title)).andDo(print());  // title 값이 일치하는지

    } // end test

    // 글 삭제 테스트
    @DisplayName("deleteArticle: 블로그 글 삭제 테스트")
    @Test
    public void deleteArticle() throws Exception {
        // give
        final String url ="/api/articles/{id}";  // url 틀리면 404 에러남
        final String title = "title";
        final String content = "content";

        // 테스트용 Entity를 생성하여 DB에 저장
        Article savedArticle = blogRepository.save(
                Article.builder()
                        .title(title)
                        .content(content)
                        .build());

        // when
        mockMvc.perform( MockMvcRequestBuilders.delete(url, savedArticle.getId()) )
                .andExpect(status().isOk())
                .andDo(print());

        // then
        List<Article> articles = blogRepository.findAll();

        assertThat(articles).isEmpty();  // 데이터가 없는지 확인
//        assertThat(articles).isNotEmpty();  // 데이터가 있는지 (지웠으니 에러)

    } // end test

    // 글 수정 테스트
    @DisplayName("updateArticle: 블로그 글 수정 테스트")
    @Test
    public void updateArticle() throws Exception {
        // give
        final String url ="/api/articles/{id}";  // url 틀리면 404 에러남
        final String title = "title";
        final String content = "content";

        // 테스트용 Entity를 생성하여 DB에 저장
        Article savedArticle = blogRepository.save(
                Article.builder()
                        .title(title)
                        .content(content)
                        .build());

        final String newTitle = "new Title";
        final String newContent = "new Content";

        UpdateArticleRequest request = new UpdateArticleRequest(newTitle, newContent);
        String updateData = gson.toJson(request);
        /*
        {
            "title" : "new Title",
            "content" : "new Content"
        }
        */

        // when
        ResultActions resultActions = mockMvc.perform(MockMvcRequestBuilders.put(url, savedArticle.getId())
                .accept(MediaType.APPLICATION_JSON)
                .content(updateData)
                .contentType(MediaType.APPLICATION_JSON_VALUE));

        resultActions.andExpect(status().isOk()).andDo(print());

        Article article = blogRepository.findById(savedArticle.getId()).get();

        assertThat(article.getTitle()).isEqualTo(newTitle);
        assertThat(article.getContent()).isEqualTo(newContent);

    }


} // end class