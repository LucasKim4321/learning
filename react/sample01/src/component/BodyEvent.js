function BodyEvent() {

    function handleOnClick(){
        alert("버튼을 클릭하셨군요!!")
    }

    return(
        <div>
            <button onClick={handleOnClick}>Event</button>
        </div>
    )
}

export default BodyEvent;