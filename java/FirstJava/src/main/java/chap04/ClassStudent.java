package chap04;

import chap04.vo.VO4;

public class ClassStudent {

	public static void main(String[] args) {
		VO4 student = new VO4();
//		student.hakbun = 1;  // 접근 불가
		student.setHakbun(10);
		System.out.println("학번:"+student.getHakbun());
		
		student.setKor(95);
		System.out.println("한국어:"+student.getKor());
		
		student.setEng(85);
		System.out.println("영어:"+student.getEng());
		
		student.setMat(75);
		System.out.println("수학:"+student.getMat());
		
		System.out.println("총점:"+student.getTot());
		
		System.out.println("평균:"+student.getAvg());
		//ㄴㄴ
		
	}

}
