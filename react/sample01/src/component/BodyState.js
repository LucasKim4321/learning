// state 상태 관리
// 
// 컴포넌트 : 값이 변하지 않는 상태
//           값이 변하는 상태(동적)
// 
// useState 이용 생성
// const [상태변수,set함수] = useState(초기값)

import {useState} from "react"; // 상태관리 컴포넌트

function BodyState() {
    const name = "길순이"
    const [count, setCount] = useState(0)  // setCount 통해 count값을 +1 시킨후 count에 대입
    
    const onIncrease = () => {
        setCount(count+1);
    }

    // function onIncrease() {
    //     console.log("1씩 증가")
    // }

    // input 요소 변경
    const [text, setText] = useState("")  // useState() 초기값
    const inputOnChange = (e) => {
        // console.log(e.target.value)
        setText(e.target.value)
    }

    // 날짜 변경
    const [date, setDate] = useState("")  // setDate를 통해 value값을 전달받아 date에 대입
    const dateOnChange = (e) =>{
        setDate(e.target.value)
    }

    // select
    const [option, setoption] = useState("")
    const selectOnChange = (e) =>{
        setoption(e.target.value)
    }

    // textarea
    const [text2, setText2] = useState("")
    const textareaOnChange = (e) => {
        setText2(e.target.value)
    }

    return(
        <div>
            <h2>이름: {name}</h2>
            <hr/>
            <h1>useState로 관리하는 count변수</h1>
            <h3>{count}</h3>
            <button onClick={onIncrease}>1씩 증가</button>
            <hr/>
            <input onChange={inputOnChange}/>
            <div>{text}</div>
            <hr/>
            <input type="date" value={date} onChange={dateOnChange}/> {/*value={date}하면 기본값이랑 같음*/}
            <hr/>
            <select onChange={selectOnChange}>
                <option key="1번">1번</option>
                <option key="2번">2번</option>
                <option key="3번">3번</option>
            </select>
            <div>{option}</div>
            <hr/>
            <textarea onChange={textareaOnChange}></textarea>
            <div>{text2}</div>
        </div>
    )
}

export default BodyState;