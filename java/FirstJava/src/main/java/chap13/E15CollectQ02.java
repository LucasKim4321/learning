package chap13;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.List;

public class E15CollectQ02 {

	public static void main(String[] args) {
		// 2. 현재 수중에 500,000원을 갖고 있습니다. <보기>에 나오는 항목으로 장을 봤습니다.
		//    수중에 남는 돈은 얼마인지 reduce().메서드를 활용하여 코드 구현
		/* 보기
		 * 
		 * 빵	20,000
		 * 우유	5,000
		 * 라면 10,000
		 * 옷 200,000
		 * 신발 100,000
		 * 삼겹살 50,000
		 * 소주 10,000
		 * 삼장 2,000
		 * 상추 3,500
		 * 쌀 50,000
		 * ----
		 * 남은 돈 : 49,500
		*/
		
		List<Integer> goods = Arrays.asList(20000,5000,10000,200000,100000,50000,10000,2000,3500,50000);
		System.out.println("goods : "+goods);
		
		System.out.println("--------");
		int myMoney = 500000;
//		reduce() 초기값 ((x,y)x+y)
		myMoney = goods.stream().peek(x->System.out.println("item price : "+x)).reduce(myMoney, (a,b)-> {System.out.println("myMoney:"+a+" - item:"+b+" = "+(a-b)+"\n-------"); return a-b;});
//		myMoney = goods.stream().reduce(myMoney, (a,b)->a-b);
		System.out.println("myMoney : "+myMoney);  // 결과 49500

		System.out.println("--------");
		DecimalFormat df = new DecimalFormat("#,##0원");
		System.out.println("남은 돈 : "+df.format(myMoney));
		
		
	}

}
