package chap17;

import javax.swing.table.AbstractTableModel;

public class E11UserTableModel extends AbstractTableModel {
	// 사용자 정의 TableModel
	
	String[] columnNames = {"사번","이름","근무부서"};
	Object[][] data = {{" "," "," "}};

	boolean[] columnEditables = new boolean[] {false,true,true};
	
	
	// 생성자
	public E11UserTableModel(Object[][] data) {
		this.data = data;
	}

	// 오버라이딩
	@Override
	public int getRowCount() {
		// 테이블 행의 수를 지정
		return data.length;
	}

	@Override
	public int getColumnCount() {
		// 테이블의 컬럼 수
		return columnNames.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// 각 셀의 값
		return data[rowIndex][columnIndex];
	}
	
	// 각 컬럼명
	public String getColumnName(int rowIndex) {
		return columnNames[rowIndex];
	}
	// 각 셀의 편집 기능 여부 지정
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return columnEditables[columnIndex];
	}
	// 셀의 데이터 수정시 수정돈 데이터를 반영
	public void setValueAT(Object value, int rowIndex, int columnIndex) {
		data[rowIndex][columnIndex] = value;
		fireTableCellUpdated(rowIndex, columnIndex);  // 모든 리스너에게 셀 데이터 변경 통보
	}

}
