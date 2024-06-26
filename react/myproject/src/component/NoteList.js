import {useContext} from 'react';
import {NotesStateContext} from '../pages/NoteMain.js'

import './NoteList.css'

const NoteList = ()=> {

    const notes = useContext(NotesStateContext);
    console.log(notes)

    const notesView = 10;  // 표시할 노트 수 5 / 10(기본값) / 20

    return (
        <div className="noteList">
            {
                notes.map((it,idx)=> {if(idx<notesView){return(
                    <div className="note">
                        <div className="id">넘버: {it.id}</div>
                        <div className="date">날짜: {it.date}</div>
                        <div className="title">제목: {it.title}</div>
                        <div className="content">내용: {it.content}</div>
                    </div>
                    )}}
                )
            }
        </div>
    )
}

export default NoteList