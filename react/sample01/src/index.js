import React from 'react';
import ReactDOM from 'react-dom/client';
import './index.css';
import App from './App';
import reportWebVitals from './reportWebVitals';

// root.render(컴포넌트)
const root = ReactDOM.createRoot(document.getElementById('root'));  // virtual(가상) DOM에만 업데이트 하다가 한번에 업데이트 해줌
root.render(
  // <React.StrictMode>  // 호환성 관련 (없어도됨)
    <App />
  // </React.StrictMode>
);

// If you want to start measuring performance in your app, pass a function
// to log results (for example: reportWebVitals(console.log))
// or send to an analytics endpoint. Learn more: https://bit.ly/CRA-vitals
reportWebVitals();
