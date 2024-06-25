import {useContext} from 'react';
import {NotesStateContext} from '../pages/NoteMain.js'

import './NoteList.css'

const NoteList = ()=> {

    const notes = useContext(NotesStateContext);
    console.log(notes)

    return (
        <div className="noteList">
            {
                notes.map((it)=> (
                    <div className="note">
                        <div className="id">넘버: {it.id}</div>
                        <div className="date">날짜: {it.date}</div>
                        <div className="title">제목: {it.title}</div>
                        <div className="content">내용: {it.content}</div>
                    </div>
                ))
            }
        </div>
    )
}

export default NoteList