package chap08;

import java.util.Arrays;
import java.util.Comparator;

// 추상 클래스 : 하나이상의 추상메서드가 포함된
public abstract class E07Data {
	Integer[] data;  // Integer WrapperClass
	
	public void setData(Integer...data) {  // 가변인자 입력받은 데이터들은 배열구조
		this.data = data;
	}
	@Override
	public String toString() {
		return Arrays.toString(data);  // 배열 내용 상태 표시
	}
	
	// 추상 메서드: 본체가 없는 메서드
	public abstract void sort();
}

class AscData extends E07Data {

	@Override
	public void sort() {
		Arrays.sort(data);  // 오름차순으로 정렬   // Arrays클래스의 sort()라는 메소드를 사용
	}
	
}

class DescData extends E07Data {

	@Override
	public void sort() {
		Arrays.sort(data, Comparator.reverseOrder());  // 내림차순  Comparator클래스의 reverseOrder()라는 메소드를 사용. 
	}
	
}

