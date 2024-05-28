import {useState} from "react";

function BodyState2() {

    // const [name, setName] = useState("")
    // const [gender, setGender] = useState("")
    // const [birth, setBirth] = useState("")
    // const [bio, setBio] = useState("")

    const [state, setState] = useState({  // 객체 구조
        name: "name",
        gender: "",
        birth: "",
        bio: ""
    })

    console.log("------")
    console.log(state.name, state["name"])

    // 이벤트 핸들러 선언
    // function onChangeName(e) { setName(e.target.value) }
    // const onChangeGender = (e) => { setGender(e.target.value); console.log(e.target.value)}
    // const onChangeBirth = (e) => { setBirth(e.target.value) }
    // const onChangeBio = (e) => { setBio(e.target.value) }
    const handleOnChange = (e) => {
        // 상태 객체에 값을 수정하는 메서드
        // setState({
        //     ...state,  // 가변인자
        //     [e.target.name]: e.target.value,  // ["name"]: e.target.value
        //     [e.target.gender]: e.target.value,  // target의 value값을 name에 대입
        //     [e.target.birth]: e.target.value,
        //     [e.target.bio]: e.target.value
        // })
        setState( (s)=> {
            return {
                ...state,
                [e.target.name]: e.target.value,  // ["name"]: e.target.value
                [e.target.gender]: e.target.value,  // target의 value값을 name에 대입
                [e.target.birth]: e.target.value,
                [e.target.bio]: e.target.value
            }
        })
        console.log(state)
    }
    
    return (
        <div>
            <div>
                <input name="name" value={state.name} onChange={handleOnChange} placeholder="이름"/>
            </div>
            <div>
                <select name="gender" value={state.gender} onChange={handleOnChange}>
                    <option key={""}></option>
                    <option key={"남성"}>남성</option>
                    <option key={"여성"}>여성</option>
                </select>
            </div>
            <div>
                <input type="date" name="birth" value={state.birth} onChange={handleOnChange}/>
            </div>
            <div>
                <textarea name="bio" value={state.bio} onChange={handleOnChange}></textarea>
            </div>
            <div>{state.name}{state.gender}{state.birth}{state.bio}</div>
        </div>
    )

}

export default BodyState2