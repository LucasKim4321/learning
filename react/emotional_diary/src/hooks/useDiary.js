import { useContext, useEffect, useState } from "react";
import {useNavigate} from "react-router-dom";
import {  DiaryStateContext } from "../App";

// DiaryStateContext.Provider value={data}    data: mockData
// 목 데이터(더미)
/* 
const mockData = [
    {
      id: "mock1",
      date: new Date().getTime()-100,  // 현재 시간에서 1000분의 1초를 뺀 값
      content: "mock1",
      emotionId: 1
    },
    {
      id: "mock2",
      date: new Date().getTime()-200,
      content: "mock2",
      emotionId: 2  
    },
    {
      id: "mock3",
      date: new Date().getTime()-300,
      content: "mock3",
      emotionId: 3
    },
  ];
*/

const useDiary = (id)=> {
    // App 컴포넌트에서 생성 공통 객체를 사용
    const data = useContext(DiaryStateContext);
    const [diary, setDiary] = useState();
    const navigate = useNavigate();

    useEffect( ()=> {
        const matchDiary = data.find( (it)=> String(it.id) == String(id) )  // id가 일치하면
        if (matchDiary) {  // 찾고자 하는 데이터가 있으면 State객체 보관
            setDiary(matchDiary)  // 일치하는 값 셋팅
        } else {
            alert("일기가 존재하지 않습니다.")
            navigate("/",{replace:true})  // 두번째 인자 브라우저의 되돌아가기 비활성

        }
    },[id,data])  // id,data 값이 바뀌면 함수 실행

    return diary;
}

export default useDiary;
/*
커스텀 훅: 개발자가 직접 만들어 사용
: 여러 컴포넌트에서 동일하게 사용하는 기능을 별도의 파일로 만듬
*/