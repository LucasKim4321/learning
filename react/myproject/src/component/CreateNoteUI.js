const CreateNoteUI = ({offCreateNote})=> {
    
    return (
        <div className="createNoteUI">
            <div className="d-flex UIbox">
                <button><i class="fa-solid fa-check"></i></button>
                <button><i class="fa-solid fa-pen"></i></button>
                <button><i class="fa-solid fa-outdent"></i></button>
                <button><i class="fa-solid fa-t"></i>c</button>
                <button><i class="fa-solid fa-t"></i>bc</button>
                <button><i class="fa-solid fa-t"></i>s</button>
                <button><i class="fa-solid fa-fill-drip"></i></button>
                <button><i class="fa-solid fa-reply"></i></button>
                <button><i class="fa-solid fa-reply scaleX-R"></i></button>
                <button className="ms-auto" onClick={offCreateNote}><i class="fa-solid fa-xmark"></i></button>
            </div>
        </div>
    )
}

export default CreateNoteUI