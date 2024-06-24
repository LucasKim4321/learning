import "./Button.css";
// 공통 컴포넌트

const Button = ({text, type, onClick})=> {

    // 삼항연산자 => (조건식) ? true : false
    // type이 positive이거나 negative일 경우 동일값 출력 아니면 default
    const btnType = ["primary","danger","warning","secondary","success","info","light","dark","black","white"].includes(type) ? type : "success";

    return <button 
        // className="btn btn-warning btn-sm"
        className={ ["btn", `btn-${btnType}`, "btn-sm", "px-3", "btn_style"].join(" ") }
        // onClick={()=>{alert("하이!!!")}}
        onClick={onClick}>
            {text}</button>
            
    // "btn-"+변수 => `btn-${변수}`
    //return <button classNaME="btn btn-success" onClick={수행할 함수본체 or 수행할 함수명}>버튼</button>
};

export default Button;