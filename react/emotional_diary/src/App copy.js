import {Routes, Route} from "react-router-dom";
import React, {useReducer, useRef, useEffect, useState} from "react";


// import './App.css';
import 'bootstrap/dist/css/bootstrap.min.css';
// 리소스 임포트 방식
// import { getEnmotionImgById} from "./util";
// import emotion5 from "./img/emotion5.png";

// 라우팅 할 페이지 가져오기
import Home from  "./pages/Home";
import New  from  "./pages/New";
import Edit from  "./pages/Edit";
import Diary from "./pages/Diary";  

// 목 데이터(더미)
 const mockData = [
  {
    id: "mock1",
    date: new Date().getTime() - 1,
    content: "mock1",
    emotionId: 1,
  },
  {
    id: "mock2",
    date: new Date().getTime() - 1,
    content: "mock2",
    emotionId: 2,
  },
  {
    id: "mock3",
    date: new Date().getTime() - 1,
    content: "mock3",
    emotionId: 3,
  },
 ];

 // Context객체 활용: 특정범위내에서 전역변수(함수) 역할 => Prop객체 사용하지 않음
 export const DiaryStateContext = React.createContext();

// 일기 데이터 관리하기 위한 State 생성: 외부함수을 활용하여 State 데이터 관리
function reducer(state, action){// action.type,  action.data
  console.log("외부함수 reducer: ", action.type, action.data)

  switch (action.type){
    case "CREATE": 
      return [action.data, ...state] // 기존에 있는 data에 action.data추가
    case "UPDATE":
      // 기존에 data을 불러와서 데이터를 수정하여 저장
      return state.map( (it) => String(it.id) === String(action.data.id) ? {...action.data} : it);
      /* 맵핑방식
        if (String(state.id ) === String(action.data.id) ){}
          it(state).content = action.data.content
          it(state).emotionId = action.data.emotionId
          it(state).date = action.data.date
        }
      */
    case "DELETE":
        return state.filter( (it) => String(it.id) !== String(action.targetId))
    case "INIT":{
        console.log("INIT(useEffect(콜백함수,[])): App 마운트 시점에 1회수행함....")
        return action.data;
      }

    
    }// end switch()

}


function App() {
  const [data, dispatch] = useReducer(reducer, []);
  const idRef = useRef(0);// idRef객체 변수에 0을초기화

  // 데이터 로딩 상태알려주는 State 생성
  const [isDataLoaded, setIsDataLoaded] = useState(false);

  //useEffect()이용: App컴포넌트를 마운트할 때 일기 State값을 목 데이터로 업데이트
  // java에 생성자 역할
  useEffect( ()=> {
    dispatch({
      type:"INIT",
      data: mockData,
    });

    // dispatch()정상처리한 후 로딩상태 체크 전환(false -> true)
    setIsDataLoaded(true);
    
  }, [])

  // 생성
  const onCreate = (date, content, emotionId) =>{
    dispatch ({
      type:"CREATE",
      data:{ 
        id: idRef.current,// 0,1,2,3,....
        date: new Date(date).getTime(),
        content,
        emotionId
      }
    });// dispatch()호출 -> reducer()함수 호출하여 실행
    
    idRef.current += 1;

  }
  // 수정
  const onUpdate = (targetId, date, content, emotionId) => {
    dispatch({
      type: "UPDATE" ,
      data: {
        id: targetId,
        date: new Date(date).getTime(),
        content,
        emotionId
      }
    });
  }
  // 삭제
  const onDelete = (targetId) => {
    dispatch({
      type: "DELETE",
      targetId,
    });
  }

  if (!isDataLoaded) {
    console.log("로딩중...")
    return <div>데이터를 불러오는 중입니다...</div>

  } else {

    return (
      <DiaryStateContext.Provider value={data} >
      <div className="App container d-flex justify-content-center">
        <div className="w-75 border  border-4 my-3 p-4 myfont ">
            
            {/* 이미지 리소스
            <div>
              <img src={emotion5} />
              <img src={getEnmotionImgById(1)} />
              <img src={getEnmotionImgById(2)} />
            </div> */}
            
            <Routes >
              <Route path="/"     element={<Home />} />
              <Route path="/new"  element={<New />} />
              {/* 동적 경로 설정 */}
              <Route path="/diary/:id" element={<Diary />} />
              <Route path="/edit" element={<Edit />} />
            </Routes>


        </div> 
      </div>
      </DiaryStateContext.Provider>
    );
  }// end if
}

export default App;