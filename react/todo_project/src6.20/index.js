import React from 'react';
import ReactDOM from 'react-dom/client';
import './index.css';
import 'bootstrap/dist/css/bootstrap.min.css';
import App from './App';

const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(
  <React.StrictMode>
    <App />
  </React.StrictMode>
);

/*
Todo : 할 일 관리 앱 구현

1. 오늘 날짜를 요일, 월, 일 연도 순으로 표시
2. 할 일(Todo)작성하는 폼, 추가버튼 클릭시 할 일 아이템 생성
3. 생성된 할 일 아이템은 페이지 하단에 리스트로 표시, 키워드 검색으로 원하는 할일 추출
4. 리스트로 표시하는 할 일 아이템은 일을 마쳤는지 여부를 표시 체크박스, 이름, 날짜, 삭제 버튼으로 구성

[할 일 관리]앱의 UI요소 컴포넌트 단위로 분류
- Header: 오늘의 날짜를 표시 형식에 맞게 표시
- TodoEditor: 새로운 할 일 아이템을 등록
- TodoLists: 검색어에 맞게 필터링된 할 일 리스트를 렌더링
- TodoItem: 할 일 아이템의 기본 정보(체크박스, 삭제버튼 등등)
*/