import "./TopUI.css"
import MenuUI from '../component/MenuUI.js'

const TopUI = ()=> {
    return (
        <div className="top_ui d-flex">
            
            <div className="">폴더메뉴</div>
            <div className="">기본폴더</div>
            <div className="ms-auto d-flex">
                <div><input type="search"/></div>
                <div><button>검색</button></div>
                <div><button>메모추가</button></div>
                <div><button>불러오기</button></div>
                <div><button>선택</button></div>
                <div><button>전체선택</button></div>
                <div><button>이동</button></div>
                <div><button>삭제</button></div>
            </div>
            <div className="ms-auto">로그인</div>
            <div className="">회원가입</div>
            <MenuUI/>
        </div>
    )
}

export default TopUI;