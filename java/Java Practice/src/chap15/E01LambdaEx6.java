package chap15;

import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.DoubleConsumer;
import java.util.function.ObjIntConsumer;

public class E01LambdaEx6 {

	public static void main(String[] args) {
		Consumer<String> c1 = name -> System.out.println("제 이름은 "+name+"입니다.");
		Consumer<String> c2 = name -> System.out.println("제 이름은 "+name+"입니다.");
		c1.andThen(c2).accept("다나카");
		
		BiConsumer<String, String> c3 = (lastname, firstname) -> {
			System.out.println("제 이름은 "+lastname + firstname+"입니다.");
		};
		c3.accept("김", "홍남");
		
		DoubleConsumer c4 = (score) -> System.out.println("제 점수는 "+score+"입니다.");
		c4.accept(95.5);
		
		ObjIntConsumer<String> c5 = (lecture, i) -> {
			System.out.println("제 "+lecture+" 점수는 "+i+"점 입니다.");
		};
		c5.accept("국어", 100);
	}

}
