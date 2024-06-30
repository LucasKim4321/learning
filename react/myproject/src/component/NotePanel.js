// 부모 NoteMain

import './NotePanel.css'

import NoteList from './NoteList.js'

const NotePanel =  ({checked, checkbox, onCheckBox})=> {
    return (
        <div className="notePanel">
            <div className="nP_box border">
                <NoteList checked={checked} checkbox={checkbox} onCheckBox={onCheckBox}/>
                <p className='btn_left'>◀</p>
                <p className='btn_right'>▶</p>
            </div>
        </div>
    )
}

export default NotePanel