import { useState } from "react";

// 자식 컴포넌트  부모 컴포넌트가 업데이트되면 모든 자식 컴포넌트도 같이 업데이트
function Viewer({number}) {
    return <div>
        {number % 2 == 0 ? <h3>짝수</h3> : <h3>홀수</h3>}
    </div>
}
function Viewer2() {
    console.log("View component update!!!!")
    return <div>
        Viewer
    </div>
}

// 부모 컴포넌트
function BodyStateProp() {
    // 상태변수
    const [number, setNumber] = useState(0);

    // 이벤트 핸들러
    const onDecrease = () => {
        // setNumber()함수로 number값 변경
        setNumber(number-1)  // number= number-1
    }
    const onIncrease = () => {
        // setNumber()함수로 number값 변경
        setNumber(number+1)  // number= number+1
    }
    return (
        <div>
            <h1>BodyStateProp</h1>
            <div>
                <h3>number:{number}</h3>
            </div>
            {/* 자식 컴포넌트 */}
            <Viewer number={number} />
            <Viewer2 />
            <hr/>
            <div>
                <button onClick={onDecrease}>감소</button>
                <button onClick={onIncrease}>증가</button>
            </div>
        </div>
    )
}
export default BodyStateProp;
