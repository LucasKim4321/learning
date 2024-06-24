import { useState } from "react";
import { getFormattedDate } from "../util";
import Button from "./Button";  // default 설정된건 이렇게 불러와야함
// import {Button} from "./Button";  // 이렇게는 안됨

// 브라우저의 뒤로가기 - 이전 페이지 이동
import {useNavigate} from "react-router-dom";

import "./Editor.css"


const Editor = ({initData, onSubmit})=> {
    const navigate = useNavigate();

    // 변수 (값이 변하는)
    const [state,setState] = useState({
        date: getFormattedDate(new Date()),  // 현재 날짜를 전달
        emotionId:3,
        content:""
    })

    // 함수 (기능 수행)
    const handleChangeDate = (e)=> {
        setState ({
            ...state,
            //input에서 변경한 날짜를 state.date값으로 설정
            date: e.target.value
        })
    }

     // 뒤로 가기(이전 페이지 이동) 함수
     const handleOnGoBack = ()=> {
        navigate(-1)
    }


    const handleChangeContent = (e)=> {
        setState ({
            ...state,
            content: e.target.value
        })
    }

    const handleSubmit = ()=> {
        onSubmit(state)
    }

    return (
    <div className="Editor">
        <div>
            <h4>오늘의 날짜</h4>
            <div className="input_wrapper">
                <input type="date"
                value={state.date}
                onChange={handleChangeDate}
                />
                {state.date}
            </div>
        </div>
        <div>
            <h4>오늘의 감정</h4>
            <div className="input_wrapper">
                <textarea
                placeholder="오늘은 어땠나요? :b"
                value={state.content}
                onChange={handleChangeContent}
                ></textarea>
            </div>
        </div>
        <div>
            <h4>오늘의 일기</h4>
        </div>
        <div className="d-flex justify-content-center align-items-center">
            <Button text={"취소하기"} type={"danger"} onClick={handleOnGoBack}/>
            <Button text={"작성완료"} type={"success"} onClick={handleSubmit}/>
        </div>
    </div>
)
}

export default Editor;