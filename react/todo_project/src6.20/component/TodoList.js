import './TodoList.css'
import TodoItem from './TodoItem.js';
import {useState,useMemo, useContext} from 'react';

// const TodoList = ({todo, onUpdate, onDelete})=> {  // pros를 통해 값을 전달
const TodoList = () => {
    console.log(todo)  // todo todoitem들이 배열로 저장되어있음
    
    const {todo, onUpdate, onDelete} = useContext(TodoContext);   

    const [search, setSearch] = useState("");
    const onChangeSearch = (e) => {
        setSearch(e.target.value)

        console.log("search: ",search)  // 바뀌기전 값이 보이지만 setSearch 정상 작동했음
    }

    // 검색 필터 함수
    const getSearchResult = ()=> {
        return search === ""  // 비교문 ? 참인경우 : 참이 아닌 경우
                        ? todo  // 참인 경우
                        : todo.filter((e)=>e.content.toLowerCase().includes(search.toLowerCase()))  // includes  s주의
    }

    // Todo 통계
    // 고차 컴포넌트 : 인수로 전달된 컴포넌트를 새로운 컴포넌트로 반환하는 함수
    // 횡단 관심사(크로스커팅관심사): 프로그래밍에서 비즈니스 로직(핵심기능)과 구분되는 공통 기능을 지칭 (예 공통으로 체크할 사항)
    // useMemo: 불필요한 기능은 다시 호출 하지 않도록 설정
    // const 변수 = useMemo(콜백함수, 의존성 배열)

    const analyzeTodo = useMemo( () => {  // analyze분석하다
        console.log("analyzeTodo 함수 호출")

        const totalCount = todo.length;
        const doneCount = todo.filter( (e) => e.isDone).length;
        const notDoneCount = totalCount - doneCount;

        return {
            totalCount,
            doneCount,
            notDoneCount
        }

    },  // 첫번째 인자: 콜백 함수
    [todo] // 두번째 인자: 의존성 배열: 값(todo)이 변할때만 콜백 함수 호출  
    )

    // const { totalCount, doneCount, notDoneCount} = analyzeTodo();  // useMemo 사용 전
    const { totalCount, doneCount, notDoneCount} = analyzeTodo;


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
            <hr/>
            <div>
                <div>총 개수: {totalCount}</div>
                <div>완료된 할 일: {doneCount}</div>
                <div>아직 완료하지 못한 할 일: {notDoneCount}</div>
            </div>
            <hr/>
            <div className='inputBox'>
                <input className="" 
                        type="search"
                        value={search}
                        onChange={onChangeSearch}
                        placeholder="검색어를 입력하세요"/>
                <button>search</button>
            </div>
            {/* 
            할 일 아이템추가 -> App컴포넌트 todo업데이트 -> App컴포넌트 리렌더 -> TodoItem에 전달되는 Pros도 변경되어 리렌더 
            
            불필요한 함수 재생성 방지 : useCallback   (props가 있어도 재생성방지)
            const memorizedFunc = useCallback(콜백함수,의존성배열)
            의존성 배열에 값이 변경되면 콜백함수 수행
            의존성 배열을 빈배열로 전달 => 콜백함수를 수행하지 않음

            *****
            ****
              const onUpdate = useCallback ((targetId) => {},[]);

            */}

            <div className='list_wrapper'>
                {/* {todo.map((e)=> <did>{e.content}</did>)} */}
                
                {/* todo 할 일 아이템 전체 list */}
                {/* {todo.map((e)=> <TodoItem key={e.id}{...e}/>)}   */}
                {/* 위에 거랑 같음 
                <TodoItem id={id}, isDone={isDone}, content={content}, createdDate={createdDate} />
                */}

                {getSearchResult().map((e)=> (<TodoItem 
                                                key={e.id}{...e} 
                                                onUpdate={onUpdate} 
                                                onDelete={onDelete}
                                                />))}
                {/* <TodoItem/>
                <TodoItem/> */}
            </div>
        </div>
    );
};

export default TodoList;