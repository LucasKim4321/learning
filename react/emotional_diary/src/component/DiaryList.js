import { useEffect, useState } from "react"

import "./DiaryList.css"

import Button from "./Button.js"


const sortOptionList = [
    { value: "lastest", name: "최신순"},
    { value: "oldest", name: "오래된순"}
]

const DiaryList = ({filteredDate})=> {
    
    const [sortType, setSortType] = useState("lastest");
    const [sortedData, setSortedData] = useState([]);

    useEffect(()=> { // 수행할 콜백 함수
        const compare = (a,b)=> {
            if(sortType ==="lastest") {
                return Number(b.date) - Number(a.date)  // 내림차순
            } else {
                return Number(a.date) - Number(b.date);
            }
        }
    },[data,sortType])  // data,sortType이 변동될때

    const copyList = JSON.parse(JSON.stringify(data));
    copyList.sort(compare);  // 정렬
    setSortedData(copyList);

    return (
        <div className="DiaryList">
            리스트
            <div className="menu_wrapper">
                <div className="left d-flex justify-content-center align-items-center">
                    <selected>
                        {
                            sortOptionList.map((it,idx)=>{<option key={idx} value={it.value}>{it.name}</option>});
                            <option value="10">최신글1</option>
                        }
                    </selected>
                </div>
                <div className="right">
                    <Button type="success" text={"새 일기 쓰기"}/>
                </div>
            </div>
            <div className="list_wrapper">
                리스트
            </div>
        </div>
    );
}

export default DiaryList;