import { useContext } from "react";
import { DiaryDispatchContext } from "../App";
import { useNavigate, useParams} from "react-router-dom";

import useDiary from "../hooks/useDiary";
import Button from "../component/Button";
import Editor from "../component/Editor";
import Header from "../component/Header";

const Edit = ()=> {
    const {onDelete, onUpdate} = useContext(DiaryDispatchContext);
    const {id} = useParams();  // 파라미터에서 id를 읽어옴
    const data = useDiary(id);  // 읽은 id를 채크
    const navigate = useNavigate();

    const goBack = ()=> {navigate(-1)}
    const onClickDelete = ()=> {
        if (window.confirm("일기를 정말 삭제 할 까요? 다시 복구되지 않습니다!!")) {
            onDelete(id);
            navigate("/",{replace:true})
        }
    }
    const onSubmit = (data)=> {
        if (window.confirm("일기를 수정 할 까요?")) {
            const {date, content, emotionId} = data;  // 받은 데이터 값들을 불러올 때 이렇게
            onUpdate(id,date,content,emotionId);
            navigate("/",{replace:true})
        }
    }


    return (
    <div className="Editor">
        <Header
            title={"일기 수정하기"}
            leftChild={<Button text={"뒤로가기"} onClick={goBack} />}
            rightChild={<Button text={"삭제하기"} type={"danger"} onClick={onClickDelete}/>}
        />
        <Editor initData={data} 
        onSubmit={onSubmit}
        />
    </div>
)
}

export default Edit;