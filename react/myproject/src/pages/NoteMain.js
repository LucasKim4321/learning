import TopUI from '../component/TopUI.js'
import Header from '../component/Header.js'
import NotePanel from '../component/NotePanel.js'
import Advertisement from '../component/Advertisement.js'


const NoteMain = ()=> {
    return (
        <div>   
            <Header/>
            <div className='mainContaier mx-4'>
                <TopUI/>
                <NotePanel/>
            </div>
            <Advertisement/>
        </div>
    )
}

export default NoteMain;