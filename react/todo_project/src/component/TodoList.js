import './TodoList.css'
import TodoItem from './TodoItem.js';
import {useState} from 'react';

const TodoList = ({todo, onUpdate, onDelete})=> {
    console.log(todo)

    const [search, setSearch] = useState("");
    const onChangeSearch = (e) => {
        setSearch(e.target.value)

        console.log("search: ",search)
    }

    // 검색 필터 함수
    const getSearchResult = ()=> {
        return search === ""  // 비교문 ? 참인경우 : 참이 아닌 경우
                        ? todo  // 참인 경우
                        : todo.filter((it)=>it.content.toLowerCase().includes(search.toLowerCase()))
    }

    //  // 추가버튼 동작
    //  const onSubmit = ()=> {
    //     if (!content) {
    //         inputRef.current.focus();
    //         return;
    //     }
    //     onCreate(content);  // 아이템 추가
    //     setContent("");  // 입력란은 초기화
    // }
    // const onKeyDown = (e)=> {
    //     if (e.keyCode == 13) {
    //         onSubmit();
    //     }
    // }

    return (
        <div className="TodoList border border-danger-subtle p-2 rounded-2">
            <h5>Todo List!! 😆</h5>
            <div className='inputBox'>
                <input className="" 
                        type="search"
                        value={search}
                        onChange={onChangeSearch}
                        placeholder="검색어를 입력하세요"/>
                <button>search</button>
            </div>
            <div className='list_wrapper'>
                {/* {todo.map((it)=> <did>{it.content}</did>)} */}
                
                {/* todo 할 일 아이템 전체 list */}
                {/* {todo.map((it)=> <TodoItem key={it.id}{...it}/>)}   */}
                {/* 위에 거랑 같음 
                <TodoItem id={id}, isDone={isDone}, content={content}, createdDate={createdDate} />
                */}

                {getSearchResult().map((it)=> (<TodoItem key={it.id}{...it} onUpdate={onUpdate} onDelete={onDelete}/>))}
                {/* <TodoItem/>
                <TodoItem/> */}
            </div>
        </div>
    );
};

export default TodoList;