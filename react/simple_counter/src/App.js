import 'bootstrap/dist/css/bootstrap.css'

import './App.css';
import Viewer from './component/Viewer.js'
import Controller from './component/Controller.js'
import Even from './component/Even.js';

import { useState,useEffect,useRef } from 'react';

function App() {

  // 멤버 변수
  const [count,setCount] = useState(1000)
  const [text, setText] =useState("")
  // useRef : DOM 요소를 참조, 컴포넌트 변수
  const didMountRef = useRef(false);

  // 함수 선언
  const handleSetCount = (value) => {
    setCount(count+value)
  }
  const handleChangeText = (e) => {
    // console.log("값의 변화: ",e.target.value)
    setText(e.target.value);
  }

  // 리액트 컴포넌트의 라이프 사이클
  // Mount(처음 페이지 표시) -> Update(State,Props,부모컴포넌트 리렌더) -> Unmount(페이지에서 제거)
  // useEffect : 어떤 값이 변경될 때마다 특정 코드를 실행하는 리엑트 훅

  // useEffect(수행할 함수, 의존성배열(감지할 대상))
  // []안의 값이 바뀔때마다 useEffect실행
  // useEffect( ()=> {
  //   console.log("useState 객체 값 업데이트.\ncount: ",count,"\n text: ",text)
  // }, [count,text])

  // 두번째 인자 의존성 배열 생략시, 컴포넌트를 렌더링할 때마다 콜백함수 수행
  useEffect( ()=> {
    // useEffect에서 마운트 시점은 제외하고 업데이트 시점에만 콜백함수
    if (!didMountRef.current){
      didMountRef.current = true;
      return;
    } else {
      console.log('컴포넌트 업데이트!![의존성 배열 생략]')
    }
    console.log("useState 객체 값 업데이트.\ncount: ",count,"\n text: ",text)
  })

  // useEffect에서 빈 배열을 전달하면 마운트 시점에만 콜백함수 1번만 수행
  useEffect( ()=> {console.log('컴포넌트 마운트, 의존성 배열에 빈 배열 전달')},[])

  // 클린업(Cleanup)기능 : 특정 함수가 실행되고 종료된 후, 수행하고자 하는 내용이 있으면 처리
  useEffect( ()=> {
    const intervalID = setInterval(() => {
      console.log("1초마다 깜박!!!")
    }, 1000);
    return () => {
      console.log("클린업 기능 수행")
      clearInterval(intervalID);
    }
  })

  
  return (
    <div className="App">
      <div className="container">
        <div className='alert alert-danger title'>
          <h1>Simple Counter</h1>
        </div>
        <section>
          <input className='alert alert-danger' value={text} onChange={handleChangeText}/>
        </section>
        <section>
          <Viewer count2={count}/>
          {/* {조건식이 참이면 컴포넌트값으로 반환{} */}
          {count%2==0 && <Even/>}
        </section>
        <section>
          <Controller handleSetCount2={handleSetCount}/>
        </section>
      </div>
    </div>
  );
}

export default App;
