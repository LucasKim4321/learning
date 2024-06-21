import "./Button.css";
// 공통 컴포넌트

const Button = ({text, type, onClick})=> {

    // type이 positive이거나 negative일 경우 동일값 출력 아니면 default
    const btnType = ["primary","danger","warning","secondary","success","info","light","dark","black","white"].includes(type) ? type : "success";

    return <button 
        // className="btn btn-warning btn-sm"
        className={ ["btn", `btn-${btnType}`, "btn-sm", "px-3", "btn_style"].join(" ") }
        onClick={onClick}>
            {text}</button>
};

export default Button;