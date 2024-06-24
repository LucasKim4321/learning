import "./TopUI.css"
import Dropdown from 'react-bootstrap/Dropdown';
import DropdownButton from 'react-bootstrap/DropdownButton';

const TopUI = ()=> {
    return (
        <div>
            <div className="d-flex">
                <div className="ms-auto">로그인</div>
                <div>테마</div>
                <div>설정</div>
                <div>
                    <DropdownButton id="dropdown-basic-button" title="dd">
                    <Dropdown.Item href="#/action-1">광고 제거</Dropdown.Item>
                    <Dropdown.Item href="#/action-2">후원</Dropdown.Item>
                    <Dropdown.Item href="#/action-3">듀토리얼</Dropdown.Item>
                    <Dropdown.Item href="#/action-4">프로그램</Dropdown.Item>
                    </DropdownButton>
                </div>
                
            </div>
        </div>
    )
}

export default TopUI;