import './NotePanel.css'

import NoteList from './NoteList.js'

const NotePanel =  ()=> {
    return (
        <div className="notePanel">
            <div className="nP_box border">
                <NoteList/>
            </div>
        </div>
    )
}

export default NotePanel