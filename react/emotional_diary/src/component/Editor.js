import { useState, useEffect } from "react";
import { getFormattedDate, emotionList } from "../util";
import Button from "./Button";  // default 설정된건 이렇게 불러와야함
// import {Button} from "./Button";  // 이렇게는 안됨

// 브라우저의 뒤로가기 - 이전 페이지 이동
import {useNavigate} from "react-router-dom";
import EmotionItem from "../component/EmotionItem.js"

import "./Editor.css"


const Editor = ({initData, onSubmit})=> {
    const navigate = useNavigate();

    // 변수 (값이 변하는)
    const [state,setState] = useState({
        date: getFormattedDate(new Date()),  // 현재 날짜를 전달
        emotionId:3,
        content:""
    })

    // 의존성 배열 값이 변경될 때마다 콜백함수 수행
    // new Date(parseInt(initData.date)) : 타임스템프형식을 Date객체로 변환
    // useEffect(콜백함수, 의존성배열)
    useEffect(()=>{
        if(initData) {
            setState({
                ...initData,
                date: getFormattedDate(new Date(parseInt(initData.date)))
            })
        }
    },[initData])

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

    const handleChangeEmotion = (emotionId)=> {
        setState ({
            ...state,
            emotionId
        })
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
                {/* {state.date} */}
            </div>
        </div>
        <div>
            <h4>오늘의 감정</h4>
            <div className="input_wrapper">
                <div className="emotion_list_wrapper">
                    {
                        emotionList.map ((e)=>
                            // <img key={e.id} alt={`emotion${e.id}`} src={e.img}/>
                            <EmotionItem
                                key={e.id}
                                {...e}  // e.id, e.img, e.name 전달
                                onClick={handleChangeEmotion}
                                isSelected={state.emotionId === e.id}
                            />
                        )
                    }
                    {/* {
                        emotionList.map((e)=>(<img key={e.id} alt={`emotion ${e.name}`} src={e.img}/>))
                    } */}
                </div>
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
        <div className="d-flex justify-content-between align-items-center">
            <Button text={"취소하기"} type={"danger"} onClick={handleOnGoBack}/>
            <Button text={"작성완료"} type={"success"} onClick={handleSubmit}/>
        </div>
    </div>
)
}

export default Editor;