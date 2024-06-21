
import "./TodoEditor.css";
import React, { useContext,useState, useRef } from "react";
// import {TodoContext} from "../App"
import {TodoDispatchContext} from "../App";

// const TodoEditor = ({onCreate}) => {
const TodoEditor = () => {
//   const {onCreate} = useContext(TodoContext)
  const {onCreate} = useContext(TodoDispatchContext)

  const [content, setContent] = useState("")
  const inputRef = useRef();

  const onChangeContent = (e) => {
    setContent(e.target.value)
    
    //console.log(content)
  }
  const onSubmit = () => {
    if (!content) {
      inputRef.current.focus();
      return;
    }
    
    onCreate(content); // 아이템 추가
    setContent("");; // 입력란은 초기화

  }
  const onKeyDown = (e) => {
    if (e.keyCode == 13){
      onSubmit();
    }
  }
  return(
    <div className="TodoEditor border border-danger-subtle p-2 rounded-2">
        <h4 className="m-0">새로운 Todo 작성하기!! 💕</h4>
        <div className="edit_wrapper">
            <input 
            type="search"
            placeholder="새로운 Todo..."
            value={content}
            onChange={onChangeContent}
            onKeyDown={onKeyDown}
            ref={inputRef}
            />
            <button onClick={onSubmit}>추가</button>
        </div>
    </div>
    );
};

export default TodoEditor;