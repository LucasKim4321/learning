// import { useSearchParams } from "react-router-dom";
import { useState, useContext, useEffect } from "react";

import {getMonthRangeByDate} from "../util";  // 날자범위 함수 임포트
import { DiaryStateContext } from "../App";   // Constext객체 임포트

import Button from "../component/Button"; // 버튼
import Header from "../component/Header"; // 페이지 상단
// import Editor from "../component/Editor"; // 페이지 본체
import DiaryList from "../component/DiaryList"; // 리스트


// 쿼리스트링을 이용할 경우: useSearchParams()
// http://localhost:3000/?name=hong&age=30&addr=부산
const Home = () => {
  // const [searchParams, setSearchParams] = useSearchParams();
  // console.log("searchParams.get():", searchParams.get("name"))
  // console.log("searchParams.get():", searchParams.get("age"))
  // console.log("searchParams.get():", searchParams.get("addr"))
  //   const  onSubmitSend = () => {
  //     alert("작성완료 버튼 클릭")
  //   } 

  //App 컴포넌트에 있는 데이터 공유하기
  const data = useContext(DiaryStateContext);

  const [pivotDate,     setPivotDate] = useState(new Date()); // 날짜 초기화
  const [filteredDate,  setFilteredData] = useState([]); // 필터링한 데이터

  //  날짜형식
  const headerTitle = `${pivotDate.getFullYear()}년 ${pivotDate.getMonth()+1} 월`;
  const onIncreaseMonth = () => { //console.log("1씩 증가");
    setPivotDate(new Date(pivotDate.getFullYear(), pivotDate.getMonth()+1));
  }
  const onDecreaseMonth = () => {  //console.log("1씩 감소");
    setPivotDate(new Date(pivotDate.getFullYear(), pivotDate.getMonth()-1));
  }

  // 데이터 또는 날짜가 변동되는 처리하는 콜백함수
  useEffect(()=>{
    if (data.length >=1 ) {// 등록된 일기가 1개 이상이면(존재하면)
      const { beginTimeStamp, endTimeStamp} = getMonthRangeByDate(pivotDate);
     
      setFilteredData(
         // 조건에 부함된 데이터만 filteredData
        data.filter( (it) =>  it.date >= beginTimeStamp  && it.date <= endTimeStamp )
      );
    } else {// 등록된 일기 없음을 의미
      setFilteredData([])
    }
  }, [data, pivotDate]);


  return (
      <div >
        
        <Header 
            title={headerTitle}
            leftChild={
                <Button 
                text={"<"}
                onClick={ onDecreaseMonth } />
            }
            rightChild={
                <Button 
                text={">"}
                onClick={ onIncreaseMonth  } />
            }
            

            // <Button 
            //     text={"warning"}
            //     type={"warning"}
            //     onClick={ () => { alert("warning!!!!"); } } />
            // <Button 
            //     text={"danger"}
            //     type={"danger"}
            //     onClick={ () => { alert("danger!!!!"); } } />
            // <Button 
            //     text={"primary"}
            //     type={"primary"}
            //     onClick={ () => { alert("primary!!!!"); } } />   
        />                     

        <DiaryList data={filteredDate} />
       {/* <Editor initData={
                    {data:new Date().getTime(), emotionId:1, content:"이전에 작성했던 일기"}
                }
                onSubmit={ 
                            () => { alert("작성완료 버튼 클릭")} 
                            // onSubmitSend
                        }/> */}
      
      </div>
    );
}
export default Home;