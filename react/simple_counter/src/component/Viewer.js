const Viewer = ({count2}) => {
    return (
        <div className="counter">
            <div>현재 카운트:</div>
            <hr/>
            <h1>{count2}</h1>
        </div>
    );
}

export default Viewer;