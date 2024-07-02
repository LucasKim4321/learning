import {useNavigate, useParams, useSearchParams} from "react-router-dom";
import { getFormattedDate } from "../util";

import useDiary from "../hooks/useDiary"

import Header from "../component/Header"
import Button from "../component/Button"
import Viewer from "../component/Viewer"


const Diary = ()=> {
    // const params = useParams();
    // console.log("Dairy 컴포넌트 URL 파라미터 값 가져오기:",params)

    // http://localhost:3000/diary/100?name=Kim&age=20

    // -------------------------------------------
    // const {id} = useParams();  // url path에 설정된 id값을 가져옴
    // const [searchParams, setSearchParams] = useSearchParams();

    // const name = searchParams.get("name");
    // const age = searchParams.get("age");
    // const message = searchParams.get("message");

    // console.log("Dairy 컴포넌트 URL 파라미터 값 가져오기:",id)
    // console.log("쿼리 스트링 값 추출하기: ", searchParams.get("name"))
    // console.log("쿼리 스트링 값 추출하기: ", searchParams.get("age"))
    //--------------------------------------------

    const {id} = useParams();  // url path에 설정된 id값을 가져옴
    const data = useDiary(id);  // 설정된 id를 검색
    console.log("찾고자하는 일기 데이터:",data);
    
    // const {date, emotionId,content} = data;  // 여기서 바로 불러오면 데이터가 없어서 에러걸림
    // const title = `${getFormattedDate(new Date(Number(date)))}`;

    const navigate = useNavigate();
    const goBack = ()=> {
        navigate(-1)
    }
    // 수정작업 처리한 컴포넌트 링크
    const goEdit = ()=> {
        navigate(`/edit/${id}`)
    }
    
    if(!data)  {  // 데이터가 존재하지 않으면
        return <div>일기를 불러오고 있습니다.</div>

    } else {  // 데이터가 존재하면
        const {date, emotionId, content} = data;  // 일기를 불러온 후 데이터를 불러와야 에러 안걸림
        const title = `${getFormattedDate(new Date(Number(date)))} 기록`;

        return (
            <div>
                <Header 
                    title={title}
                    leftChild={<Button onClick={goBack} text={"뒤로 가기"}/>}
                    rightChild={<Button onClick={goEdit} text={"수정하기"}/>}
                />
                <Viewer content={content} emotionId={emotionId}/>
                {/* <div>{id}번 일기</div>
                <div>{name}님, {age}세</div>
                <div>Diray 페이지입니다.</div>
                <div>Message: {message}</div> */}
            </div>
        )
    }
}

export default Diary;