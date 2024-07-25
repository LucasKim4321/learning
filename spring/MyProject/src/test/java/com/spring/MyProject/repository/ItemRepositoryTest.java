package com.spring.MyProject.repository;

import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.spring.MyProject.constant.ItemSellStatus;
import com.spring.MyProject.entity.Item;
import com.spring.MyProject.entity.QItem;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Log4j2
@TestPropertySource(locations="classpath:application-test.properties")  // 환경설정파일 따로 지정
class ItemRepositoryTest {
    /* H2 기본속성 인듯 ?
    spring.jpa.hibernate.ddl-auto=create */


    @Autowired
    private ItemRepository itemRepository;

    @PersistenceContext
    EntityManager em;

    @Test
    @DisplayName("상품명 등록 테스트")
    public void insertItemTest() {
        IntStream.rangeClosed(1, 10).forEach(i -> {
            Item item = Item.builder()
                    .itemNm("테스트 상품" + i)
                    .price(10000 + i)
                    .itemDetail("테스트 상품 상세 설명" + i)
                    .itemSellStatus(ItemSellStatus.SELL)
                    .stockNumber(100)
                    .regTime(LocalDate.now())
                    .updateTime(LocalDateTime.now())
                    .build();
            Item savedItem = itemRepository.save(item);  // 저장 후 저장된 값 리턴
        });

    }

    @Test
    @DisplayName("상품명 조회 테스트")
    public void findByItemNmTest() {

        // 상품 등록 현재 메서드만 실행시(테스트 전체를 수행하면 필요없음)
        this.insertItemTest();

        // 상품 조회
        List<Item> itemList = itemRepository.findByItemNm("테스트 상품1");  // 검색할 때 엔티티에 선언된 테이블 상의 이름을 기준으로 검색

        // stream().forEach()이용해서 결과 로그 출력
        itemList.stream().forEach(item -> {
            log.info("==> item: " + item);
        });
    }

    @Test
    @DisplayName("상품명과 상품상세설명 동시(OR) 조회 테스트")
    public void findByItemNmOrItemDetailTest() {

        // 상품 등록 현재 메서드만 실행시(테스트 전체를 수행하면 필요없음)
        this.insertItemTest();

        // 상품 조회
        List<Item> itemList = itemRepository.findByItemNmOrItemDetail("테스트 상품1", "테스트 상품 상세 설명5");

        // 확장for를 이용해서 결과 로그 출력
        for (Item item : itemList) {
            log.info("==> item: " + item);
        }
    }


    @Test
    @DisplayName("해당 가격보다 적은(LessThen) 테스트")
    public void findByPriceLessThenTest() {

        // 상품 등록 현재 메서드만 실행시(테스트 전체를 수행하면 필요없음)
        this.insertItemTest();

        // 상품 조회
        List<Item> itemList = itemRepository.findByPriceLessThan(10005);  // 10005보다 적은 가격을 찾음

        // 결과 로그 출력
        itemList.stream().forEach(item -> {
            log.info("==> Less Than: " + item);
        });
    }

    @Test
    @DisplayName("가격 내림차순 and LessThan 테스트 ")
    public void findPriceLessThanOrderByPriceDescTest() {

        // 상품 등록 현재 메서드만 실행시(테스트 전체를 수행하면 필요없음)
        this.insertItemTest();

        // 상품 조회
        List<Item> itemList = itemRepository.findByPriceLessThanOrderByPriceDesc(10005);  // 10005보다 적은 가격을 찾음

        itemList.stream().forEach(item -> log.info("==> Price Less Than Order Desc: " + item));

    }

    // ------------------------------------- //
    // Spring DATA JPA @Query 어노테이션 테스트
    // ------------------------------------- //

    @Test
    @DisplayName("상품명, 상품상세설명 or 테스트")
    public void findByItemDetailTest() {
        // 상품 등록 현재 메서드만 실행시(테스트 전체를 수행하면 필요없음 or MariaDB에서 테이블 데이터 생성 후 update로 설정하면 필요없음)
        this.insertItemTest();

        List<Item> itemList = itemRepository.findByItemDetail("테스트 상품 상세 설명5");
        itemList.stream().forEach(item-> {
            log.info("==> item list: "+item);
        });
    }

    @Test
    @DisplayName("상품명, 상품상세설명 or 테스트")
    public void findByItemDetailByNativeTest() {
        // 상품 등록 현재 메서드만 실행시(테스트 전체를 수행하면 필요없음 or MariaDB에서 테이블 데이터 생성 후 update로 설정하면 필요없음)
        this.insertItemTest();

        List<Item> itemList = itemRepository.findByItemDetailByNative("테스트 상품 상세 설명");
        itemList.stream().forEach(item-> {
            log.info("==> item list: "+item);
        });
    }

    // ------------------------------------- //
    // Spring Q도메인 클래스 적용
    // ------------------------------------- //

    @Test
    @DisplayName("QueryDSL을 적용해서 조회 기능 테스트")
    public void queryDSLTest() {

        // 상품 등록 현재 메서드만 실행시(테스트 전체를 수행하면 필요없음 or MariaDB에서 테이블 데이터 생성 후 update로 설정하면 필요없음)
        this.insertItemTest();

        // 위에 선언함
        // @PersistenceContext
        // EntityManager em;
        
        JPAQueryFactory queryFactory = new JPAQueryFactory(em);
        QItem qItem = QItem.item;

        JPAQuery<Item> query = queryFactory
                .selectFrom(qItem)
                .where(qItem.itemSellStatus.eq(ItemSellStatus.SELL))
                .where(qItem.itemDetail.like("%"+"상품 상세 설명"+"%"))
                .orderBy(qItem.price.desc());

        // 1. List<T> fetch() => 조회한 결과를 반환
        List<Item> itemList = query.fetch();
    }
}