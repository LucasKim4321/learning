// import { useSearchParams } from "react-router-dom";
import {useState, useContext, useEffect} from 'react';
import {getMonthRangeByDate} from '../util';
import { DiaryStateContext } from '../App.js';


import './Home.css';

import Header from '../component/Header.js';  // 페이지 상단
import Button from "../component/Button.js";  // 버튼
import Editor from "../component/Editor.js";  // 페이지 본체
import DiaryList from "../component/DiaryList.js"


// const onSubmitSend = ()=> {
//     alert("작성완료 버튼 클릭")
// }



const Home = ()=> {

    // 쿼리스트링을 이용할 경우 : useSearchParams()
    // http://localhost:3000/?name=hong&age=30&addr=부산

    // const [searchParams, setSearchParams] = useSearchParams();
    // console.log("searchParams.get():", searchParams.get("name"))
    // console.log("searchParams.get():", searchParams.get("age"))
    // console.log("searchParams.get():", searchParams.get("addr"))
    // console.log("searchParams.get():", searchParams.get("sort"))


    // App 컴포넌트에 있는 데이터 공유하기
    const data = useContext(DiaryStateContext);
    const [pivotDate,setPivotDate] = useState(new Date());  // 날짜 초기화
    const [filteredDate, setFilteredDate] = useState([]);  // 필터링한 데이터

    // 날짜 형식
    const headerTitleDate = `${pivotDate.getFullYear()}년 ${pivotDate.getMonth()+1}월`;
    
    const onIncreaseMonth = ()=> {
        // console.log("1씩 증가")
        setPivotDate(new Date(pivotDate.getFullYear(), pivotDate.getMonth()+1))
    }
    const onDecreaseMonth = ()=> {
        // console.log("1씩 감소")
        setPivotDate(new Date(pivotDate.getFullYear(), pivotDate.getMonth()-1))
    }

    // 데이터 또는 날짜가 변동되면 처리하는 콜백함수(처음 실행시에도 실행)
    // **
    useEffect( ()=>{
        console.log("date useEffect")
        if (data.length >= 1) {  // 등록된 일기가 1개 이상 있을 때
            const {beginTimeStamp, endTimeStamp} = getMonthRangeByDate(pivotDate);  // 시작시간과 끝나는 시간

            setFilteredDate(
                // 조건에 부함된 데이터만 filteredData
                data.filter((it)=> beginTimeStamp <= it.date && it.date <= endTimeStamp)  // beginTimeStamp <= it.date <= endTimeStamp
            )
        } else {  // 등록된 일기가 없을 때
            setFilteredDate([])
        }
    },[data,pivotDate])

    return (
        <div>
            <Header
                title={`Home ${headerTitleDate}`}
                leftChild={
                    <Button
                        text={"<"}  
                        type={"danger"}
                        // onClick={()=>{alert("하이!!!")}}
                        onClick={onDecreaseMonth}
                    />
                }
                        
                rightChild={
                    <Button
                        text={">"}
                        onClick={onIncreaseMonth}
                    />
                }
            />
            <DiaryList data={filteredDate}/>
            {/* <Editor 
                initData= {
                    {date: new Date().getTime(), emotionId:1, content:"이전에 작성했던 일기"}
                }
                onSubmit= {
                    ()=>{alert("작성완료 버튼 클릭")}
                    // onSubmitSend()
                }
            /> */}
        </div>
    )
}
export default Home;