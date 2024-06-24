import "./TopUI.css"

const TopUI = ()=> {
    return (
        <div>
            <div className="d-flex">
                <div className="ms-auto">로그인</div>
                <div>테마</div>
                <div>설정</div>
                <div>
                    <ul>
                        <li><a href="#">광고 제거</a>
                        </li>
                        <li><a href="#">후원</a>
                        </li>
                        <li><a href="#">듀토리얼</a>
                        </li>
                        <li><a href="#">듀토리얼</a>
                        </li>
                    </ul>
                </div>
            </div>
        </div>
    )
}

export default TopUI;