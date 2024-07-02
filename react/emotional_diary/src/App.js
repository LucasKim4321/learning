import {Routes, Route} from "react-router-dom";
import React, { useReducer, useRef, useEffect, useState } from "react";

import './App.css';
import 'bootstrap/dist/css/bootstrap.min.css';

// 이미지 불러오기
import { getEmotionImgById } from './util';
import emotion5 from './img/emotion5.png';

// 라우팅 할 페이지 가져오기
import Home from "./pages/Home";
import New from "./pages/New";
import Diary from "./pages/Diary";
import Edit from './pages/Edit';


// 목 데이터(더미)
const mockData = [
  {
    id: "mock1",
    date: new Date().getTime()-100,  // 현재 시간에서 1000분의 1초를 뺀 값
    content: "Velit do nostrud ullamco amet officia proident dolor ipsum. Id eiusmod exercitation officia qui officia occaecat amet amet nulla mollit sit aute nisi incididunt. Duis consequat labore sit laboris anim. Mollit voluptate laborum do reprehenderit.",
    emotionId: 1
  },
  {
    id: "mock2",
    date: new Date().getTime()-200,
    content: "Qui nulla est dolore tempor ut nulla quis commodo sunt. Nostrud labore ad reprehenderit fugiat. Elit ut cupidatat officia exercitation velit reprehenderit laborum quis nisi proident labore ut. Eu consequat ex proident ullamco nisi laboris aute fugiat excepteur. Fugiat proident aliquip amet minim excepteur. Veniam do ullamco laborum proident do consectetur aliqua ipsum. Consectetur non nulla nisi sit.",
    emotionId: 2  
  },
  {
    id: "mock3",
    date: new Date().getTime()-300,
    content: "Do non excepteur ex esse dolor commodo dolore Lorem labore pariatur. Voluptate officia fugiat incididunt sit eiusmod qui labore exercitation sint velit laborum est. Sunt ut dolore anim reprehenderit exercitation aliqua reprehenderit elit.",
    emotionId: 3
  },
];

// Context객체 활용: 특정 범위내에서 전역 변수(함수) 역할 => Prop객체 사용하지 않음   //  java의 protect랑 비슷
export const DiaryStateContext = React.createContext();  // Context생성
export const DiaryDispatchContext = React.createContext();  // Context생성



// 일기 데이터를 관리하기 위한 State 생성: 외부 함수를 활용하여 State 데이터 관리
function reducer(state, action) {  // state==data  action.type="CREATE","UPDATE"  action.data{id,date,content,emotionId}
  console.log("외부함수 reducer: ",action.type, action.data)

  switch (action.type){
    case "CREATE": {
      return[action.data, ...state]  // 기존에 있는 data에 action.data추가(새로운 값을 기존 데이터와 병합)  // state(data) = action.data + state
    }
    case "UPDATE": {  // 기존의 data를 불러와서 데이터를 수정
      return state.map((it)=> String(it.id)=== String(action.data.id)?{...action.data}:it);  // id가 일치하면 action.data값들을 저장  아니면 그대로
      /*  맵핑방식(위에거랑 같음)
      if (String(action.id) === String(state.id)) {
        it(state).content = action.content
        it(state).emotionId = action.emotionId
        it(state).date = action.date
      }
      */
       
    }
    case "DELETE": {
      return state.filter((it)=> String(it.id) !== String(action.targetId))  // id가 일치하는 것들만 다시 저장.(일치하는건 빼고 만들어서 삭제효과)
    }

    case "INIT": {
      console.log(`App 마운트 시점에 ${action.count}회 수행함...`)
      return action.data;
    }

  }

}


function App() {

  const [data, dispatch]  = useReducer(reducer, []);
  const idRef = useRef(0)  // idRef객체 변수에 0을 초기화  식별자,변수 용도  // idRef = useRef(초기값)


  // useEffect(초기화면의 값)의 데이터 로딩 상태를 알려주는 State
  const [isDataLoaded, setIsDataLoaded] = useState(false);


  const useEffectCount = useRef(0);  // 값을 불러올때 useEffectCount.current
  // idRef객체 변수에 0을 초기화  식별자,변수 용도  // idRef = useRef(초기값)
  // useEffect()이용: App컴포넌트를 마운트할 때 일기 State값을 목 데이터로 업데이트  // useEffect( 함수, [의존성배열(배열을 감지해서 함수실행,비워두면 갑지안하는데 처음 실행시 한번 실행)])
  // java에서의 생성자 역할
  useEffect( ()=> {
    useEffectCount.current+=1;
    dispatch({
      type:"INIT",
      data: mockData,
      count: useEffectCount.current
    })

    // dispatch()정상처리한 후 로딩상태 체크 전환(false -> true)
    setIsDataLoaded(true);

  }, [])  // 의존성배열(배열을 감지,비워두면 감지안하는데 처음 실행시 한번 실행)

  // 생성
  const onCreate = (date,content,emotionId)=> {  // 새로운 data 생성
    dispatch({
      type:"CREATE",
      data:{
        id: idRef.current,  // idRef.current  idRef의 현재값(초기값0)  // onCreate함수가 실행 될때 마다 id가 1, 2, 3 ... 이런식으로 됨
        date: new Date(date).getTime(),  // 현재 시간을 추가
        content,
        emotionId
      }
    })  // dispatch()호출 -> reducer()함수 호출하여 실행

    idRef.current += 1;  // onCreate 함수를 실행할 때마다 idRef값 1증가

  }
  

  // 수정
  const onUpdate = (targetId,date,content,emotionId)=> {  // onUpdate함수에서 인자 4개를 받아서 data값 수정
    dispatch({
      type:"UPDATE",
      data:{
        id: targetId,
        date: new Date(date).getTime(),  // 현재 시간을 추가
        content,
        emotionId
      }
    });
  }

  // 삭제
  const onDelete = (targetId)=> {
    dispatch({
      type: "DELETE",
      targetId
      // targetId:targetId
    })
  }

  
  if (!isDataLoaded) {  // 로딩 중일때
    console.log("로딩중...")
    return <div>데이터를 불러오는 중입니다...</div>

  } else {  // 초기값 로딩 완료 후 본문 실행
    return (
      // Context 전역 변수 및 함수 data, onCreate, onUpdate, onDelete
      <DiaryStateContext.Provider value={data}>
        <DiaryDispatchContext.Provider value={{onCreate, onUpdate, onDelete}}>
          <div className="App myStyle">
            <div className="container border border-warning rounded-4 mt-5">
              <div className="contents">
                <h3 className='title border border-warning-subtle rounded-4 text-center my-5 p-3'>감정일기장 프로젝트</h3>
                <div>
                  <img src={emotion5}/>
                  <img src={getEmotionImgById(1)}/>
                  <img src={getEmotionImgById(2)}/>
                </div>
                {/* path 설정 */}
                <Routes>
                  <Route path="/" element= {<Home/>} />
                  <Route path="/new/" element= {<New/>} />
                  {/* 동적 경로 설정 */}
                  {/* :id 하면 해당 자리에 다른 값이 입력되면 해당 페이지에서 읽음 */}
                  <Route path="/diary/:id" element= {<Diary/>} />
                  <Route path="/edit/:id" element= {<Edit/>} />
                </Routes>
              </div>
            </div>
          </div>
        </DiaryDispatchContext.Provider>
      </DiaryStateContext.Provider>
    );
  }  // end  if(!isDataLoaded)else
}  // end App

export default App;


//  cd./emotional_diary


// <header className="App-header">
// <h3 className='title border border-warning-subtle rounded-4 text-center my-5 p-3'>감정일기장 프로젝트</h3>
// <div>
// {/* <img alt="감정1" src={emotion2}/> */}
// <hr/>
//   <img alt="감정1" src={getEmotionImgById(1)}/>
//   <img alt="감정2" src={getEmotionImgById(2)}/>
//   <img alt="감정3" src={getEmotionImgById(3)}/>
//   <img alt="감정4" src={getEmotionImgById(4)}/>
//   <img alt="감정5" src={getEmotionImgById(5)}/>
// </div>
// </header>