const DiaryItem = ({id,emotionId,content,date})=> {
    return (
        <div className="diaryItem">
            {new Date(parseInt(date)).toLocaleString()} - {content}
        </div>
    );
}

export default DiaryItem;