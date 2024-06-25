const NoteList = ({notes})=> {

    return (
        <div className="noteList">
            {
                notes.map((it)=> {
                    <div className="note">
                        <div className="id">{it.id}</div>
                        <div className="title">{it.title}</div>
                        <div className="content">{it.content}</div>
                        <div className="date">{it.date}</div>
                    </div>
                })
            }
        </div>
    )
}

export default NoteList