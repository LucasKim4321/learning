import './App.css';
import {useState, useRef} from 'react';

import Header from './component/header.js';
import TodoEditor from './component/TodoEditor.js';
import TodoList from './component/TodoList.js';
import TestReducerComp from './component/TestReducercomp.js';

// 함수 밖에 선언 전역 변수
// 목데이터 설정
const mockTodo = [
  {id:0, isDone: false, content:"React 공부하기", createdDate: new Date().getTime()},
  {id:1, isDone: false, content:"Java 공부하기", createdDate: new Date().getTime()}
];

function App() {
  // 변수(상태)
  const [todo, setTodo] = useState(mockTodo);
  const idRef = useRef(3);  // 변수 역할

  // 함수(기능)
  const onCreate = (content)=> {
    // 새 할 일 아이템 객체
    const newItem = {
      id: idRef.current,
      content,
      isDone: false,
      createdDate: new Date().getTime()
    }

    // 새롭게 추가된 아이템은 항상 배열의 0번 요소
    setTodo([newItem, ...todo])  // 입력된값이 병합이 됨
    idRef.current += 1;
  }
  
  const onUpdate = (targetId) => {
    setTodo(
      todo.map((it)=> it.id === targetId ? {...it, isDone: !it.isDone} : it )
    );
  }

  const onDelete = (targetId) => {
    setTodo(
      todo.filter( (it) => it.id !== targetId)  // 조건을 만족하는 값 반환
    );
  }

  return (
    <div className='container'>
      <div className='contents alert alert-warning'>
        <div>
        <TestReducerComp/>
        </div>
        <Header/>
        <TodoEditor onCreate={onCreate}/>
        <TodoList todo={todo} onUpdate={onUpdate} onDelete={onDelete}/>
      </div>
    </div>
  );
}

export default App;

/*
기능 구현
App : 할 일 데이터 관리
Header : 오늘의 날짜 표시
TodoEditor : 새로운 할 일 아이템 생성
TodoList : 검색에 따라 필터링된 할 일 아이템 렌더링
TodoItem : 할 일 아이템의 수정 및 삭제

Create : 생성
Read : 읽기
Update : 수정
Delete : 삭제
 */
