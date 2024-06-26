import React, { useEffect, useReducer, useState } from 'react'
import {mockData} from "../MockData.js"

import './NoteMain.css'

import TopUI from '../component/TopUI.js'
import Header from '../component/Header.js'
import NotePanel from '../component/NotePanel.js'
import Advertisement from '../component/Advertisement.js'


export const NotesStateContext = React.createContext();  // Context생성

function reducer(state, action) {
    switch (action.type) {
        case "INIT": {
            return action.data
        }
    }
}

const NoteMain = ()=> {
    const [notes, dispatch] = useReducer(reducer, []);

    const [isDataLoaded, setIsdataLoaded] = useState(false);

    useEffect( ()=> { // 처음 실행시 한번 실행
        dispatch({
            type:"INIT",
            data: mockData,
        })
        setIsdataLoaded(true);
    },[]) // 처음 실행시 한번 실행


    if (!isDataLoaded) {  // 로딩 중일때
        console.log("로딩중...")
        return <div>데이터를 불러오는 중입니다...</div>
    
    } else {  // 초기값 로딩 완료 후 본문 실행]
        console.log("로딩 완료!")
        return (
            // notes데이터 전역 변수로 전달
            <NotesStateContext.Provider value={notes}>
                <div className='noteMain'>   
                    <Header/>
                    <div className='mainContaier mx-4'>
                        <TopUI/>
                        <NotePanel/>
                    </div>
                    <Advertisement/>
                </div>
            </NotesStateContext.Provider>
        )
    }
}
export default NoteMain;