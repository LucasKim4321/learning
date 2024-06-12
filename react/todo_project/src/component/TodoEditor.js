import './TodoEditor.css';

const TodoEditor = ()=> {
    return(
        <div className="TodoEditor border border-danger-subtle p-2 rounded-2">
            <h4 className="m-0">새로운 Todo 작성하기!! 💕</h4>
            <div className="edit_wrapper">
                <input placeholder="새로운 Todo..."/>
                <button>추가</button>
            </div>
        </div>
    );
};

export default TodoEditor;