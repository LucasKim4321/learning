import { useNavigate } from "react-router-dom";
import { getEmotionImgById } from "../util";

import "./DiaryItem.css"

import Button from "./Button.js"

const DiaryItem = ({id,emotionId,content,date})=> {
    const navigate = useNavigate();
    
    const goDetail = ()=> {
        navigate(`/dairy/${id}`);  //  "http://localhost:3000/diary/1"
    }

    const goEdit = ()=> {
        navigate(`/edit/${id}`);
    }
    
    

    return (
        <div className="diaryItem">
            {/* {new Date(parseInt(date)).toLocaleString()} - {content} */}
            <div onClick={goDetail}  // ["img_section", "btn"].join(" ") => "img_section btn"
                 className={["img_section", `img_section_${emotionId}`].join(" ")}>
                <img alt={`emotion${emotionId}`} src={getEmotionImgById(emotionId)}/>
            </div>

            <div className="info_section">

                <div className="date_wrapper">
                    {new Date(parseInt(date)).toLocaleDateString()}
                </div>
                <div className="content_wrapper">
                    {content.slice(0, 25)}
                </div>

            </div>

            <div className="">
                <Button onClick={goEdit} text={"수정하기"}/>
            </div>
        </div>
    );
}

export default DiaryItem;