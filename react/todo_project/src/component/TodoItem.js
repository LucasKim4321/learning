import './TodoItem.css';

const TodoItem = ()=> {
    return (
        <div className="TodoItem">
            <div className="checkbox_col">
                <div className="form-check form-switch">
                    <input className="form-check-input" type="checkbox" role="switch" id="flexSwitchCheckDefault"/>
                    <label className="form-check-label" for="flexSwitchCheckDefault">Default switch checkbox input</label>
                </div>
            </div>
            <div className="title_col">
                할 일
            </div>
            <div className="date_col">
                {new Date().toLocaleDateString()}
            </div>
            <div className="btn_col">
                <button className="btn btn-danger btn-sm">삭제</button>
            </div>
        </div>

        
    )
}

export default TodoItem;