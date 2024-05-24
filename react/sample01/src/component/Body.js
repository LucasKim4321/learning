// import React from "react"
// 스타일 시트 가져오기
import "./Body.css"

// childCom컴포넌트sms children프로퍼티로 전달
function Body({children}){
    console.log("children:",children)

// function Body({name,location,favorList}) {  // 여러개 받을때는 {}안에 넣어줘야함

// function Body(props) {
// 동작 : props props = {name:"홍길동", location:"부산"} 이런식으로 전달 받음
// console.log(props)
// console.log(props.name)
// 구조 분해 할당 : {변수1, 변수2} = {객체:속성1, 객체:속성2}
// const {name,location} = props;

    return (
        <div className="body">
            {/* <h1 style={{backgroundColor:"red",color:"blue"}}>body</h1> */}
            {/* <h1 className="content">이름: {props.name}, 거주지: {props.location}</h1> */}
            {/* <h1 className="content">이름: {name}, 거주지: {location}</h1><br/> */}
            {/* <span style={{color:"black"}}>{favorList[0]},{favorList[1]},{favorList[2]}</span><br/> */}
            {/* {favorList.length} 개의 음식을 좋아합니다.<br/><br/> */}
            <br/>
            <h3>ChildCom컴포넌트는 children프로퍼티로 전달</h3>
            <div>{children}</div>
        </div>
    )

}
// props 기본값 설정
Body.defaultProps = {
    favorList:[],
}
export default Body;

/*
import React from "react"
function Body () {
    const number = 1;
    const a = 10;
    const b = 20;
    const name = "홍길동"
    const age = 10
    const boolA = true;
    const boolB = false;
    const objA = {
        name : "길순이",
        age : 12,
        address : "부산"
    }
    const num10 = 19;
    const num20 = 201;

    if (num20%2 == 0) {
        return "<div>짝수</div>"
    }
    else {
        return (

        // <React.Fragment> 이거 대신 <> 해도 됨
        <>
            <h1>body</h1>
            <h2>number={number}</h2>
            <hr/>
            <h3>a={a},b={b}, a+b={a+b}</h3>
            <hr/>
            <div>
                <div>이름:{name}, 나이:{age}</div>
                <hr></hr>
                boolean
                <div>{String(boolA&&boolB)}, {String(5>2)} </div>
                <h3>{objA.name}{objA.age},{objA.address}</h3>
            </div>
            <div>
                <h3>
                    {num10}은(는) {num10 % 2 == 0 ? "짝수" : "홀수"}
                </h3>
            </div>
        </>
        // </React.Fragment>
    )}
}
export default Body;
*/