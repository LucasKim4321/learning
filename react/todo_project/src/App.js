
import './App.css';
import { useMemo, useCallback, useState, useRef , useReducer} from "react";
import React from 'react';

import Header from './component/header.js';
import TodoEditor from './component/TodoEditor.js';
import TodoList from './component/TodoList.js';

// import TestReducerComp from './component/TestReducercomp.js';

// 목데이터 설정
const mockTodo = [
  { 
    id:0, 
    isDone: false, 
    content: "React 공부하기", 
    createdDate: new Date().getTime(),
  },
  { 
    id:1, 
    isDone: false, 
    content: "Java 공부하기", 
    createdDate: new Date().getTime(),
  },
];



// State관리 값의 변수를 줄 함수를 외부 함수로 정의
function reducer(state, action){
  switch (action.type) {
    case "CREATE":
      return [action.newItem, ...state]
    case "UPDATE":
      return state.map( (it) =>  it.id === action.targetId ? {...it, isDone: !it.isDone}  : it);
    case "DELETE":
      return state.filter( (it) => it.id !== action.targetId)
    default:
      break;
  }

}


// Context객체 생성
// export const TodoContext = React.createContext();
export const TodoStateContext    = React.createContext();
export const TodoDispatchContext = React.createContext();


function App() {
  
  // 변수(상태)
  const [todo, dispatch] = useReducer(reducer, mockTodo)
  //const [todo, setTodo] = useState(mockTodo);
  const idRef = useRef(2); //변수 역할

  // 함수(기능): useReducer을 이용할 경우 함수형 업데이트 기능을 사용하지 않아된다.
  const onCreate =  (content) => {
    /*
    // 새 할 일 아이템 객체
    const newItem = {
      id: idRef.current,
      content,
      isDone: false,
      createdDate: new Date().getTime()
    }
    //새롭게 추가된 아이템은 항상 배열의 0번 요소
    setTodo([newItem, ...todo ])
    idRef.current += 1;
    */

    dispatch({
      type:"CREATE",
      newItem: {
        id: idRef.current, // 변수 역할
        content,
        isDone: false,
        createdDate: new Date().getTime()
      }
    }); 
    idRef.current += 1;
    

  };


  const onUpdate = useCallback ( (targetId) => {
    /*
    setTodo(
      todo.map( (it) => it.id === targetId ? {...it, isDone: !it.isDone}  : it)
    );
    */

    dispatch({
      type: "UPDATE",
      targetId
    });
  }, []);

  const onDelete = useCallback( (targetId) => {
    /*
    setTodo(
      todo.filter( (it) => it.id !== targetId)
    );
    */
   dispatch({
    type:"DELETE",
    targetId,
   });
  }, []);

  // useMemo를 이용해 함수 onCreate, onUpdate, onDelete를 묶은 객체를
  // App컴포넌트가 리렌더되어도 다시 생성하지 않도록 설정
  const memorizedDispatches = useMemo( ()=> { 
    return {onCreate, onUpdate, onDelete}
  }, []);

  return (
    <div className="container">
      <div className="contents">
        {/* <div>
          <TestReducerComp />
        </div> */}

        <Header/>
        {/* <TodoEditor onCreate={onCreate} />
        <TodoList todo={todo} onUpdate={onUpdate} onDelete={onDelete} /> */}
        {/* <TodoContext.Provider value={ {todo, onCreate, onUpdate, onDelete}} > */}

        <TodoStateContext.Provider value={ todo } >
        {/* <TodoDispatchContext.Provider value={ {onCreate, onUpdate, onDelete}} > */}
        <TodoDispatchContext.Provider value={ memorizedDispatches } >

          <TodoEditor  />
          <TodoList    />

        </TodoDispatchContext.Provider>
        </TodoStateContext.Provider>
      </div>  
    </div>  
  );
}

export default App;

// cd./todo_project

/*
기능 구현

App     : 할 일 데이터 관리
header  : 오늘의 날짜 표시
TodoEditor: 새로운 할 일 아이템 생성
TodoList : 검색에 따라 필터링된 할 일 아이템 렌더링
TodoItem : 할 일 아이템의 수정 및 삭제

Create: 생성
Read : 읽기
Update : 수정
Delete : 삭제



최정화와 메모이제이션(Memoization)
메모이제이션(Memoization):
  특정 입력에 대한 결과를 계산해 메모리 어딘가에 
  저장했다가, 동일한 요청이 들어오면 저장한 결과값을 제공해 빠르게 
  응답하는 기술

useMemo 객체

-------
Context 객체: 컴포넌트 트리전역에 데이터를 공할 수 있어 Prop Drilling문제를 해결
------


App() -> header(), Body()
                   Body() -> List1(), List2(), List3()
                             List1() -> Cal(), Result()
import React from 'react';
const MyContext = React.createContext();

App(){
  const data = '1000'
  <header />
  <MyContext.Provider value={data} >
    <Body > // Props과정 생략 
  </MyContext>
}

Body( ) { // Props과정 생략 -> useContext()반환값으로 전달 받음
  const data = useContext(MyContext);
}

Result() {
 const data = useContext(MyContext);
}

// 문제가 발생
React.memo가 리팩토링 이후 정상적으로 동작하지 않음
 : dispatch관련 함수들이 하나의 객체로 묶여 동일한 Context에 Prorops로 전달되기 때문에

TodoStateContext: 
  todo가 업데이트되면 영향을 받는 컴포턴트을 위한 Context

TodoDispatchContext: 
  dispatch함수(onCreate, onUpdate, onDelete)가 업데이트되면 영향을 받는 컴포턴트을 위한 Context
*/