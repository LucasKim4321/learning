import './NotePanel.css'

import NoteList from './NoteList.js'

const NotePanel =  ()=> {
    return (
        <div className="notePanel">
            <div className="nP_box border">
                <NoteList/>
                <p className='btn_left'>◀</p>
                <p className='btn_right'>▶</p>
            </div>
        </div>
    )
}

export default NotePanel