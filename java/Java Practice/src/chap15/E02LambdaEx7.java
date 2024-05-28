package chap15;

import java.util.function.BooleanSupplier;
import java.util.function.DoubleSupplier;
import java.util.function.IntSupplier;
import java.util.function.Supplier;

public class E02LambdaEx7 {

	public static void main(String[] args) {
		Supplier<String> s1 = ()-> {
			return "홍길동";
		};
		System.out.println(s1.get());
		
		s1 = () -> "이순신";
		System.out.println(s1.get());
		
		IntSupplier s2 = ()-> {
			int num = (int)(Math.random()*6)+1;
			return num;
		};
		System.out.println("주사위 : "+s2.getAsInt());
		
		DoubleSupplier s3 = ()-> Math.PI;
		System.out.println("PI : "+s3.getAsDouble());
		
		BooleanSupplier s4 = ()-> 3>2;
		System.out.println(s4.getAsBoolean());
	}

}
