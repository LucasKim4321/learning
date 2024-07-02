// 부모 NoteMain 

import { useEffect, useState } from 'react'
import CreateNoteUI from '../../component/CreateNoteUI'

import './CreateNote.css'

const CreateNote = ({display,offCreateNote})=> {
    const [text, setText] = useState("");

    // const [opacity, setOpacity] = useState("opacity-100");
    
    // useEffect( ()=> {
    //     if(display=="d-block") {
    //         setOpacity("opacicy-100")
    //     } else {
    //         setOpacity("opacicy-0")
    //     }
    //   }, [display])

    const onChange = (e)=> {
        setText(e.target.value)
    }

    return (
        <div className={`createNote ${display}`}>
            <div 
            // className={`box ${opacity}`}
            >
                <CreateNoteUI offCreateNote={offCreateNote}/>
                <div className='textBox'><textarea value={text} onChange={onChange}></textarea></div>
            </div>
        </div>
    )
}

export default CreateNote