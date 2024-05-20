package chap07;

public class Ex04_ParamEx2 {

	public static void main(String[] args) {
		Param p = new Param();
//		p.add(10.5, 5.5);  //  에러
		p.add((int)10.5, (int)5.5);  // 타입 설정하면 강제로 바뀌면서 인식됨
		p.add2(10.5, 5.5);
	}

}
