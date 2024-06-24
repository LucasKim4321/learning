import "./MenuUI.css"

const MenuUI = ()=> {
    return (
        <div className="menu_ui">
            <div id="menu" className="mymenu">
                <ul>
                    <li><a href="#">메뉴</a>
                        <ul>
                            <li><a href="#">설정</a></li>
                            <li><a href="#">테마</a></li>
                            <li><a href="#">마켓플레이스</a></li>
                            <li><a href="#">휴지통</a></li>
                            <li><a href="#">광고 제거</a></li>
                            <li><a href="#">후원</a></li>
                            <li><a href="#">프로그램 다운</a></li>
                            <li><a href="#">듀토리얼</a></li>
                        </ul>
                    </li>
                </ul>
            </div>
        </div>
    )
}

export default MenuUI;