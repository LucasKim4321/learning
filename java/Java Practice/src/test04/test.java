package test04;

public class test {

	public static void main(String[] args) {
		int colorPen = 5*12;
		int studentCount = 27;
		int divColorPen = colorPen/27;
		System.out.println("각각 나눠줄 수 있는 색연필수 "+divColorPen);
		int remainColorPen = colorPen%27;
		System.out.println("남은 색연필수 "+remainColorPen);
		
		
		int age=16;
		int height=120;
		boolean parent = true; 
		boolean heartDisease = false;
		String pass = heartDisease ? "탑승 불가능" : (age>=6&&height>=120||height>=120&&parent==true ? "탑승 가능" : "탑승 불가능") ;
		System.out.println(pass);
		
		
		int year = 2024;
		boolean leapYear = (year%4==0&&year%100!=0)||year%400==0;
		System.out.println("윤년 "+leapYear);
		
		
		int price = 187000;
		int oman = price/50000;
		int ilman = (price%50000)/10000;
		int ochun = ((price%50000)%10000)/5000;
		int ilchun = (((price%50000)%10000)%5000)/1000;
		System.out.println("oman "+oman+", ilman "+ilman+", ochun "+ochun+", ilchun "+ilchun);
		
		
		int number = 5555;
		int result = number-(number%100);
		System.out.println(result);
	}

}
