package chap12;

import java.util.function.Function;
import java.util.function.UnaryOperator;

public class E07UnaryOperatorInterface {

	public static void main(String[] args) {
		// UnaryOperator : 매개변수와 동일한 자료형을 반환
		
		Function<String, String> sourceFile = p -> p+".java";
		UnaryOperator<String> classFile = (String p) -> p+".class";
		System.out.println(sourceFile.apply("Sample01"));
		System.out.println(classFile.apply("Sample02"));

	}

}
