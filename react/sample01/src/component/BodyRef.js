import {useState, useRef} from "react";


// 리액트 훅 : useState, useRef ...
// 함수로 만든 리액트 컴포넌트에서 클래스로 만든 리액트 컴포넌트의 기능을 이용하도록 도와주는 함수
function BodyRef() {

    const [text, setText] = useState("")
    const textRef = useRef();  // Ref객체 생성

    const handleOnClick = (e) => {
        alert(text)
        // 현재 참조하고 있는 돔(DOM) 요소의 value값을 공백 처리
        // textRef = document.querySelector('#text')와 유사 방식
        textRef.current.value = ""
    }
    const handleOnChange = (e) => {
        setText(e.target.value)
    }

    return (
        <div>
            <input ref={textRef} value={text} onChange={handleOnChange}/>
            <button onClick={handleOnClick}>작성 완료</button>
        </div>
    )
}

export default BodyRef;