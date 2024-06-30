import React, { useEffect, useReducer, useState, useRef } from 'react'
import {mockData} from "../MockData.js"

import './NoteMain.css'

import TopUI from '../component/TopUI.js'
import Header from '../component/Header.js'
import NotePanel from '../component/NotePanel.js'
import Advertisement from '../component/Advertisement.js'
import CreateNote from './funcPages/CreateNote.js'


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

    
    const [display, setDisplay] = useState("d-none")
    const onCreateNote = ()=> {
        setDisplay("d-block")
    }
    
    const offCreateNote = ()=> {
        setDisplay("d-none")
    }

    const onClickLogIn = ()=> {
        console.log("로그인 클릭")
    }

    const onClickSignUp = ()=> {
        console.log("회원가입 클릭")
    }


    const [checkbox, setCheckbox] = useState("d-none");
    const [checked, setChecked] = useState(false);

    const onCheck = ()=> {
        if(checkbox=="d-none") {
            setCheckbox("d-block");

        } else if (checkbox=="d-block") {
            setCheckbox("d-none");
            setChecked(false)
        }
    }
    const onAllCheck = (e)=> {
        if (checkbox=="d-block") {
            if (checked=="") {
                setChecked(true)
            } else {
                setChecked(false)
            }
        }
    }

    const onCheckBox = (e)=> {
    }



    if (!isDataLoaded) {  // 로딩 중일때
        console.log("로딩중...")
        return <div>데이터를 불러오는 중입니다...</div>
    
    } else {  // 초기값 로딩 완료 후 본문 실행]
        console.log("로딩 완료!")
        return (
            // notes데이터 전역 변수로 전달
            <NotesStateContext.Provider value={notes}>   {/* NoteList */}
                <div className='noteMain'>
                    <Header/>
                    <div className='mainContaier mx-4'>
                        <TopUI onCreateNote={onCreateNote} onCheck={onCheck} onAllCheck={onAllCheck} onClickLogIn={onClickLogIn} onClickSignUp={onClickSignUp}/>
                        <NotePanel checked={checked} checkbox={checkbox} onCheckBox={onCheckBox}/>
                    </div>
                    <Advertisement/>
                    <CreateNote display={display} offCreateNote={offCreateNote}/>
                </div>
            </NotesStateContext.Provider>
        )
    }
}
export default NoteMain;