import React from 'react';
import ReactDOM from 'react-dom/client';
import './index.css';
import App from './App';
import reportWebVitals from './reportWebVitals';

// root.render(컴포넌트)
const root = ReactDOM.createRoot(document.getElementById('root'));  // virtual(가상) DOM에만 업데이트 하다가 한번에 업데이트 해줌
root.render(  // render(대상)  대상(리엑트프로그램)을 html 태그로 만듬
  // <React.StrictMode>  // 호환성 관련 (없어도됨)
  // 컴포넌트 호출 =>  "<컴포넌트이름 />"
    <App />  // App컴포넌트를 가져옴
  // </React.StrictMode>
);

// If you want to start measuring performance in your app, pass a function
// to log results (for example: reportWebVitals(console.log))
// or send to an analytics endpoint. Learn more: https://bit.ly/CRA-vitals
reportWebVitals();

// 리엑트 컴포넌트 => 자바스크립트 함수를 만들어 HTML값을 반환
// JSX(자바스크립트 + XML) : 자바스크립트 + HTML태그 섞어서 사용하는 문법