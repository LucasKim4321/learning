import { useReducer } from "react";

// useReducer 컴포넌트 밖에서 사용 가능
// action = {type:"DECREASE", data: 1}
// dispath({type:"INCREASE", data: 1})
function reducer(state, action) {
    switch (action.type) {
        case "INCREASE":
            return state + action.data;
        case "DECREASE":
            return state - action.data;
    }
}

const TestReducerComp = ()=> {
    // useState 반드시 컴포넌트 안에서만 사용
    // const [count, setCount] = useState(100)
    
    // 상태변화 코드 : State값을 변경하는 코드
    // const onIncrease = () => {setCount(count+1)}
    // const onDecrease = () => {setCount(count-1)}

    const [count, dispatch] = useReducer(reducer, 100);  // 상태 변화 촉발 함수  useReducer(불러올 함수, 초기값)

    return (
        <div>
            <h3>UseReducer 컴포넌트 테스트</h3>
            <div><h2>{count}</h2></div>
            <div>
                <button className="btn btn-outline-danger opacity-75 me-3"
                        // onClick={onIncrease}
                        onClick={()=> dispatch({type:"INCREASE", data: 1})}
                        >1씩 증가</button>
                <button className="btn btn-outline-danger opacity-75"
                        // onClick={onDecrease}
                        onClick={()=> dispatch({type:"DECREASE", data: 1})}
                        >1씩 감소</button>
            </div>
        </div>
    );
}

// function TestReducerComp () {
//     return (
//         <div></div>
//     )
// }

export default TestReducerComp;