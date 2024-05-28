package chap12;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

public class E09MethodReference {

	public static void main(String[] args) {
//		메서드 참조 : (Object name)::(Method name) => System.out::println
//		- static 메서드 참조
//		- 특정 개체의 인스턴스 메서드 참조
//		- 특정 타입의 임의 개체에 대한 인스턴스 메서드 참조
//		- 생성자 참조
		
//		1. static 메서드 참조
		List<Integer> list = Arrays.asList(1,2,3,4,5);
		list.forEach( x -> System.out.println(x));
		
		System.out.println("-- Method reference");
		list.forEach(Write::doWrite);  // 메서드가 매개변수를 추론하여 알아서 메서드로 넘겨서 처리
		
		Function<String, String> helloLambda = (name) -> HelloTo.hello("홍길동");
		Function<String, String> helloStatic = HelloTo::hello;

		System.out.println(helloLambda.apply("홍길동"));
		System.out.println(helloStatic.apply("동순이"));
		
		// 2. 특정 객체 인스턴스 메서드 참조
		String greeting = "Hello";  // String greeting = new String("Hello")
		Consumer<String> c = System.out::println;
		c.accept(greeting);
		
		System.out.println("-- 인스턴스(개체) 참조");
		writeString(greeting::toString);  // greeting.toString()
		
		// 3. 특정 타입의 임의 개체에 대한 인스턴스 메서드 참조
		var person = Arrays.asList(
				new Person(1, "홍길동"),
				new Person(2, "동순이"),
				new Person(3, "김홍남"),
				new Person(4, "다나카")
				);
		
		person.forEach( x -> x.toObjString());
		System.out.println("--");
		person.forEach(Person::toObjString);
		
		// 4. 생성자 참조 : (Object name)::new
		System.out.println("-- 생성자 참조");
		Supplier<Person> s = ()-> new Person();  // Person s = new Person()
		System.out.println(s.get());
		
		Supplier<Name> s2 = Name::new;  // Name s2 = new Name()
		Name n = s2.get();
		System.out.println(n.getName());
		System.out.println(s2.get().getName());
		
		
	}
	public static void writeString(Supplier<String> s) {
		System.out.println( s.get());
	}

}
class Write {
	public static void doWrite(Object msg) {  // 싱글톤
		System.out.println(msg);
	}
}

class HelloTo {
	public static String hello(String name) {
		return "Hello~~~"+name;
	}
}

@Getter@Setter@AllArgsConstructor
class Person {
	private Integer no;
	private String name;
	
	public void toObjString() {
		System.out.println("person[no="+no+",name="+name+"]");
	}
	// 생성자
	public Person() {
		this.name = "김길동";
		this.no = 1000;
	}
	@Override
	public String toString() {
		return "Object::constructor";
	}
}

@Getter
class Name {
	private String name;
	public Name() {
		this.name = "홍길동";
	}
}