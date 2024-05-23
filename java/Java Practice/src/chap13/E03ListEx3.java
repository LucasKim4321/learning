package chap13;

import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class E03ListEx3 {

	public static void main(String[] args) {
		
		List list = new ArrayList();
		// list 객체에 요소 추가
		list.add(new E03Circle(3.0));
		list.add(new E03Rectangle(3,4));
		list.add(new E03Circle(5));
		list.add(new E03Rectangle(5,6));
		
		System.out.println("전체 도형의 면적의 합"+sumArea(list));
		System.out.println("전체 도형의 둘레의 합"+sumLength(list));
		
	}

	private static double sumLength(List list) {
		double sumlength = 0;
		
		for (int i=0; i<list.size(); i++) {
			// list 객체 형변환
			E03Shape s = (E03Shape)list.get(i);
			sumlength += s.length();
		}
		return sumlength;
	}

	private static double sumArea(List list) {
		double sumarea = 0;
		
		for (int i=0; i<list.size(); i++) {
			// list 객체 형변환과 메서드 호출 동시에
			sumarea += ((E03Shape)list.get(i)).area(); 
		}
		return sumarea;
	}

}
