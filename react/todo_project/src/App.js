import './App.css';
import {useCallback, useState, useRef, useReducer} from 'react';
import React from 'react';
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

// State관리 값의 변수를 줄 함수를 외부 함수로 정의
function reducer (state, action) {  // state = todo
  switch (action.type) {
    case "CREATE":  // action.type의 값이 CREATE 일 때
      return [action.newItem, ...state]  // newItem + ...todo

    case "UPDATE":  // action.type의 값이 UPDATE 일 때
      return state.map((e)=> e.id === action.targetId ? {...e, isDone: !e.isDone} : e)

    case "DELETE":  // action.type의 값이 DELETE 일 때
      return state.filter( (e) => e.id !== action.targetId)

    default:
      break;
  }

}

// const MyContext = react.createContext(defaultValue);

function App() {
  // 변수(상태)
  const [todo, dispatch] = useReducer (reducer, mockTodo);  // useReducer(실행할 함수, 기본값)

  // const [todo, setTodo] = useState(mockTodo);
  const idRef = useRef(3);  // 변수 역할  todo 추가시 id: 3부터 해서 추가

  // 함수(기능) : useReducer를 이용할 경우 함수형 업데이트 기능을 사용하지 않아도 된다.
  const onCreate = (content)=> {

    /*  useReducer로 대체
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
  */

    dispatch({
      type:"CREATE",
      newItem: {
        id: idRef.current,   // 변수 역할
        content,  // 전달 받은(입력한) 내용
        isDone: false,
        createdDate: new Date().getTime()
      }
    });
    idRef.current += 1;;

  }

  // 기존 함수에 useCallback(함수,[]) 추가
  const onUpdate = useCallback ((targetId) => {
    /* useReducer로 대체
    setTodo(
      todo.map((e)=> e.id === targetId ? {...e, isDone: !e.isDone} : e )
    );
    */

    dispatch({
      type: "UPDATE",
      targetId
    })
  },[]);

  const onDelete = useCallback ((targetId) => {
    /* useReducer로 대체
    setTodo(
      todo.filter( (e) => e.id !== targetId)  // 조건을 만족하는 값 반환
    );
    */
    dispatch({
      type: "DELETE",
      targetId
    })
  },[]);

  return (
    <div className='container'>
      <div className='contents alert alert-warning'>
        <div>
        <TestReducerComp/>
        </div>
        <Header/>
        <TodoEditor onCreate={onCreate}/>
        {/* {} 왼쪽의 값(변수)을 통해 {}안의 값을 전달해줌 */}
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
