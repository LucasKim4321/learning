import { useEffect, useState } from "react"
import { useNavigate } from "react-router-dom"

import "./DiaryList.css"

import Button from "./Button.js"
import DiaryItem from "./DiaryItem.js"


const sortOptionList = [
    { value: "lastest", name: "최신순"},
    { value: "oldest", name: "오래된순"}
]

const DiaryList = ({data})=> {
    
    const navigate = useNavigate();  // url요청시 이동
    const [sortType, setSortType] = useState("lastest");  // 정렬 타입
    const [sortedData, setSortedData] = useState([]);  // 정렬 결과 저장

    // data, dataType이 변경될 때마다 콜백함수(정렬처리) 수행
    useEffect(()=> { // 수행할 콜백 함수
        const compare = (a,b)=> {  // compare=(a,b) 정렬
            if(sortType ==="lastest") {
                return Number(b.date) - Number(a.date)  // 내림차순
            } else {
                return Number(a.date) - Number(b.date);  // 오름차순
            }
        }
        const copyList = JSON.parse(JSON.stringify(data));  // 배열복사
        copyList.sort(compare);  // 복사한 배열을 정렬
        setSortedData(copyList);  // 정렬된 배열을 저장
        
    },[data,sortType])  // 의존성 배열  data,sortType이 변동될때


    // 쓰기
    const onClickNew = ()=> {
        navigate("/new");
    }

    // seelct객체 값 변경 시
    const onChangeSortType = (e)=> {
        setSortType(e.target.value)  // 선택시 sortType변경
    }

    return (
        <div className="DiaryList">
            리스트
            <div className="menu_wrapper">
                <div className="left">
                    <select value={sortType} onChange={onChangeSortType} className="d-flex align-items-center text-center">
                        {
                        sortOptionList.map((it,idx) => (<option key={idx} value={it.value}>{it.name}</option>))
                        }
                    </select>
                </div>
                <div className="right">
                    <Button type="success" text={"새 일기 쓰기"} onClick={onClickNew}/>
                </div>
            </div>
            <div className="list_wrapper">
                {
                    sortedData.map((it)=> (<DiaryItem key={it.id}{...it}/>))
                }
                리스트
            </div>
        </div>
    );
}

export default DiaryList;