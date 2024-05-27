import {useState} from "react";

function BodyState2() {

    // const [name, setName] = useState("")
    // const [gender, setGender] = useState("")
    // const [birth, setBirth] = useState("")
    // const [bio, setBio] = useState("")

    const [state, setState] = useState({
        name: "",
        gender: "",
        birth: "",
        bio: ""
    })

    // 이벤트 핸들러 선언
    // function onChangeName(e) { setName(e.target.value) }
    // const onChangeGender = (e) => { setGender(e.target.value); console.log(e.target.value)}
    // const onChangeBirth = (e) => { setBirth(e.target.value) }
    // const onChangeBio = (e) => { setBio(e.target.value) }
    const handleOnChange = (e) => {
        setState({
            ...state,
            [e.target.name]: e.target.value,
            [e.target.gender]: e.target.value,
            [e.target.birth]: e.target.value,
            [e.target.bio]: e.target.value
        })
    }
    
    return (
        <div>
            <div>
                <input value={state.name} onChange={handleOnChange} placeholder="이름"/>
            </div>
            <div>
                <select value={state.gender} onChange={handleOnChange}>
                    <option key={""}></option>
                    <option key={"남성"}>남성</option>
                    <option key={"여성"}>여성</option>
                </select>
            </div>
            <div>
                <input type="date" value={state.birth} onChange={handleOnChange}/>
            </div>
            <div>
                <textarea value={state.bio} onChange={handleOnChange}></textarea>
            </div>
            <div>{state.name}{state.gender}{state.birth}{state.bio}</div>
        </div>
    )

}

export default BodyState2