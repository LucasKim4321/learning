// 부모 NoteMain

// import {onClickCreateMemo} from '../util.js'

import "./TopUI.css"

import MenuUI from '../component/MenuUI.js'



const TopUI = ({onCreateNote,onCheck,onAllCheck,onClickLogIn,onClickSignUp})=> {


    return (
        <div className="top_ui d-flex">
            
            <div className=""><button className="btn"><i class="fa-regular fa-folder"></i></button></div>
            <div className=""><button className="btn">기본폴더</button></div>
            <div className="ms-auto d-flex">
                <div className="searchBox d-flex">
                    <div><input type="search" className="searchBar"/></div>
                    <div><button className="searchBtn">검색</button></div>
                </div>
                <div><button className="btn" onClick={onCreateNote}>메모추가</button></div>
                <div><button className="btn">불러오기</button></div>
                <div><button className="btn" onClick={onCheck}>선택</button></div>
                <div><button className="btn" onClick={onAllCheck}>전체선택</button></div>
                <div><button className="btn">이동</button></div>
                <div><button className="btn">삭제</button></div>
            </div>
            <div className="ms-auto"><button className="btn" onClick={onClickLogIn}>로그인</button></div>
            <div className=""><button className="btn" onClick={onClickSignUp}>회원가입</button></div>
            <MenuUI/>
        </div>
    )
}

export default TopUI;