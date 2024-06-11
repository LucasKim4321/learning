package chap17;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class E10JTableTest extends JFrame{

	JTable table;
	Object[] columnNames = {"사번","이름","근무부서"};
	String[][] data = {
			{"220000","박길동","총무부"},
			{"220001","홍길동","관리부"},
			{"220002","동길동","영업부"},
			{"220003","동길이","관리부"},
			{"220004","홍길순","총무부"},
			{"220005","제임스","영업부"},
			{"220006","이길동","회계부"},
			{"220007","김갑돌","개발부"},
			{"220008","일갑돌","개발부"},
			{"220009","이갑돌","개발부"},
			{"220010","삼갑돌","개발부"},
			{"220011","사갑돌","개발부"},
			{"220012","오갑돌","개발부"},
			{"220013","육갑돌","개발부"},
	};
	
	public E10JTableTest() {
		table = new JTable(data,columnNames);  // 배열을 TableModal로 이용해서 JTable생성
		setTitle("사원 정보 테이블");
		add(new JScrollPane(table));  // 스크롤 객체 테이블을 추가
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
//		table.setAutoResizeMode(table.AUTO_RESIZE_ALL_COLUMNS);  // 컬럼 사이즈 조절시 양쪽 컬럼의 사이즈도 변경
//		table.setAutoResizeMode(table.AUTO_RESIZE_LAST_COLUMN);  // 컬럼 사이즈 조절시 마지막 컬럼의 크기만 변경
//		table.setAutoResizeMode(table.AUTO_RESIZE_NEXT_COLUMN);  // 컬럼 사이즈 조절시 다음 열의 크기만 변경
//		table.setAutoResizeMode(table.AUTO_RESIZE_OFF);  // 컬럼 사이즈를 자동으로 조절하지 않고, 스크롤바를 이용
		table.setAutoResizeMode(table.AUTO_RESIZE_SUBSEQUENT_COLUMNS);  // 테이블을 포함하는 화면 크기 조절시 모든 테이블의 열의 크기를 균등하게 유지: 기본속성
		
		pack();
		setVisible(true);
	}
	
	
	public static void main(String[] args) {
		// JTable : 데이터 목록
		// TableModal작성(테이블에 넣을 데이터) -> 스크롤 기능있는 테이블(JTable작성 -> JScrollPanel에 JTable추가) -> Container에 추가
		
//		new E10JTableTest();
		E10JTableTest table = new E10JTableTest();
		
	}

}
