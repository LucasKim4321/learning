import {emotionList} from "../util"

import './Viewer.css'

const Viewer = ({content,emotionId})=>{

    // console.log("Viewer Prop: ",content+","+emotionId)
    const emotionItem = emotionList.find((it)=> it.id === emotionId)

    console.log(emotionItem)
    return (
        <div className="viewer">
            <section>
                <h4>오늘의 감정</h4>
                <div className={["emotion_img_wrapper",`emotion_img_wrapper_${emotionId}`].join(" ")}>
                    <div>
                        <img src={emotionItem.img} alt={emotionItem.name}/>
                        <div>{emotionItem.name}</div>
                    </div>
                </div>
            </section>
            <section>
                <h4>오늘의 일기</h4>
                <div>
                    <p className="diaryContent">{content}</p>
                </div>
            </section>
        </div>
    )
}
export default Viewer