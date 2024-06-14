package chap19.common;

import javax.swing.table.AbstractTableModel;

import chap19.member.controller.MemberController;

public class RentTableModel extends AbstractTableModel{

	Object[][] data;
	String[] columnNames;
	boolean[] columnEditables = new boolean[] {false, true, true, true, true, true};
	
	//생성자
	public RentTableModel(Object[][] data, String[] columnNames) {
		this.data = data;
		this.columnNames = columnNames;
	}
	
	@Override
	public int getRowCount() {
		// 테이블의 행의 수를 지정
		// 1차원 배열: 열의 개수 => 행, 2차원 배열: 행(1차원)의 개수 => 면, 3차원 배열: 면(2차원)의 개수 => 블럭, 4차원 배열: 블럭(3차원)의 개수 => 블럭 집합  5차원: 블럭 집합(4차원)의 집합 n차원 배열: n-1차원의 집합
		return data.length;
	}

	@Override
	public int getColumnCount() {
		// 테이블의 컬럼 수
		return columnNames.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// 각 셀의 값(테이블의 값)
		return data[rowIndex][columnIndex];
	}

	// 테이블의 컬럼이름
	public String getColumnName(int column) {
		return columnNames[column];
	}
	
	// 테이블에 있는 특정 위치에 있는 셀을 편집
	public boolean isCellEditable(int row, int column) {
		return columnEditables[column];	
	}
	
	// 테이블의 특정 위치에 있는 값을 수정(변경, 설정)
	public void setValueAt(Object value, int row, int column) {
		data[row][column] = value;
		// 모든 리스너에게 셀 데이터 변경 통보
		fireTableCellUpdated(row, column);
	}
	
}
