import { useNavigate } from 'react-router-dom';
import { useContext } from 'react';
import { DiaryDispatchContext } from '../App.js';

import Header from '../component/Header.js';
import Button from "../component/Button.js";
import Editor from '../component/Editor.js';



const New = ()=> {

    const {onCreate} = useContext(DiaryDispatchContext)
    const navigate = useNavigate();
    const goBack = ()=> {
        navigate(-1)
    }

    const onSubmit = (data)=> {
        const {date, content, emotionId} = data;
        // 데이터 추가하는 함수
        onCreate(date, content, emotionId);
        navigate("/",{replace: true});
    }

    return (
    <div>
        <Header
            title={"새 일기 쓰기"}
            leftChild={
                <Button
                    text={"뒤로가기"}
                    // onClick={()=>{alert("뒤로가기!!!")}}/>
                    onClick={goBack}/>
                }
            rightChild={
                <Button
                    text={"삭제하기"}
                    type={"danger"}
                    onClick={()=>{alert("삭제하기!!!")}}/>
                }
        />
        <Editor onSubmit={onSubmit} />
    </div>
    )
}

export default New;
