import './TodoList.css'
import TodoItem from './TodoItem.js';

const TodoList = ()=> {
    return (
        <div className="TodoList border border-danger-subtle p-2 rounded-2">
            <h5>Todo List!! 😆</h5>
            <div className='inputBox'>
                <input className="" type="search" placeholder="검색어를 입력하세요"/>
                <button>search</button>
            </div>
            <div className='list_wrapper'>
                <TodoItem/>
                <TodoItem/>
                <TodoItem/>
                <TodoItem/>
                <TodoItem/>
            </div>
        </div>
    );
};

export default TodoList;