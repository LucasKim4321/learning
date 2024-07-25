package com.spring.MyProject.repository;

import com.querydsl.core.BooleanBuilder;
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
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.TestPropertySource;
import org.thymeleaf.util.StringUtils;

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
        // 5. JPA queryDSL error => "Attempt to recreate a file" 도메인 중복 발생
        // IntelliJ -> Gradle 변환 or
        // Gradle -> IntelliJ 변환

        // 상품 등록 현재 메서드만 실행시(테스트 전체를 수행하면 필요없음 or MariaDB에서 테이블 데이터 생성 후 update로 설정하면 필요없음)
        this.insertItemTest();

        // 위에 선언함
        // @PersistenceContext
        // EntityManager em;
        
        JPAQueryFactory queryFactory = new JPAQueryFactory(em);
        QItem qItem = QItem.item;

        // 동적 query문 작성
        JPAQuery<Item> query = queryFactory
                .selectFrom(qItem)
                .where(qItem.itemSellStatus.eq(ItemSellStatus.SELL))
                .where(qItem.itemDetail.like("%"+"상품 상세 설명"+"%"))
                .orderBy(qItem.price.desc());

        // 1. List<T> fetch() => query문 실행 (조회한 결과를 반환를 List로 반환)
        List<Item> itemList = query.fetch();
        log.info("==> item list: .fetch() 메서드 결과");
        itemList.stream().forEach( item-> log.info("=> Qitem: " +item.getId()+", "+item.getItemDetail()));

        // fetchFirst() 하나만 반환
        Item itemOne = query.fetchFirst();
        log.info("==> itemOne: .fetchFirst() 메서드 결과");
        log.info("=> Qitem: " +itemOne.getId()+", "+itemOne.getItemDetail());

        // fetchCount() 검색된 값 카운트
        Long total = query.fetchCount();
        log.info("==> total: .fetchCount() 메서드 결과");
        log.info("=> total: " +total);

        // 단일 결과 처리  select * from qItem where id=5
        JPAQuery<Item> query2 = queryFactory.selectFrom(qItem).where(qItem.id.eq(5L));  // eq(equal) : 같은
        Item itemOne2 = query2.fetchOne();
        log.info("==> .fetchOne() 조회결과: ");
        log.info("==> id: "+itemOne2.getId()+", 아이템이름: "+itemOne2.getItemNm());

    }

    // ------------------------------------- //
    // Spring Q도메인 클래스 적용 : QuerydslPredicateExecutor 테스트
    // ------------------------------------- //

    @Test
    @DisplayName("QueryDSL: 조회기능 테스트2")
    public void queryDSLTest2() {
        // 상품 등록 현재 메서드만 실행시(테스트 전체를 수행하면 필요없음 or MariaDB에서 테이블 데이터 생성 후 update로 설정하면 필요없음)
        this.insertItemTest();

        BooleanBuilder booleanBuilder = new BooleanBuilder(); // dsl 조건식 담당
        QItem item = QItem.item;

        // 조건을 검색 할 대상의 초기값을 설정
        String itemDetail = "테스트 상품 상세 설명";
        int price = 10003;
        String searchItemState = "SELL";

        // query에 필요한 조건 설정
        booleanBuilder.and(item.itemDetail.like("%"+itemDetail+"%"));
        booleanBuilder.and(item.price.gt(price));  // gt(greater) : 보다 큰

        // 판매 상태에 대한 검색 키워드가 있으면 판매 상태 조건문 추가
        if(StringUtils.equals(searchItemState, ItemSellStatus.SELL)) {  // StringUtils thymeleaf에 있는 기능 사용
            booleanBuilder.and(item.itemSellStatus.eq(ItemSellStatus.SELL));  // where ItemSellStatus = 'SELL';
        }

        // 페이징
        Pageable pageable = PageRequest.of(0,5);  // 페이지번호, 페이지당 데이터 개수
//        List<Item> resultItemList =

    }
}


/*
 * JPAQuery 데이터 변환 메서드
 * List<T> fetch() : 조회한 결과를 List로 반환
 * T fetchOne() : 조회 대상이 1건인 경우 제네릭으로 지정한 타입 반환
 * T fetchFirst() : 조회 대상 중 1건만 반환
 * Long fetchCount() : 조회 대상 개수 반환
 *  =>  fetchCount() 메서드 대신 : .fetch().size() 형식으로  변경
 * QueryResult<T> fetchResults() : 조회한 리스트와 전체 개수를 포함한 QueryResult반환
 * 
 * QuerydslPredicateExecutor 적용하여 상품 조회 기능 구현
 * Predicate : 조건이 맞는지 판별
 * Repository에서는 Predicate를 파라미터로 전달하가 위해 QuerydslPredicateExecutor 인터페이스를 상속
 *
 */