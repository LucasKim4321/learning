/* 
문서 객체를 선택

1개 선택
document.getElementById(아이디)  아이디만
document.getSelector(선택자)  아이디 클래스 태그 다 찾아짐

여러 개 선택
document.getElementByClassName(클래스)
document.getElementByName(태그이름)
document.getElementByAll(선택자)
*/


// font-size => fontSize  background-color =>backgroundColor  width => width

// var header= document.getElementById('header')  //태그 선택자를 변수로 지정
// var header= document.querySelector('#header2')
// var header= document.querySelector('h1')  // 첫번째 h1만 지정

document.getElementById('header').innerHTML = '태그 선택자입니다.'
document.getElementById('header').style.color = 'skyblue'
document.getElementById('header').style.backgroundColor = 'black' // 변수로 대신해서 간단해짐


header3.style.backgroundColor = 'lightgray'  //HTML id 바로 불러와짐?

/*
// 태그요소 선택시 여러개일 경우는 배열구조형식으로 전환 됨.
// 외부에서 여러개의 데이터를 받으면 배열구조로 저장
var header= document.querySelectorAll("h1")  //집합(배열구조)로 header값 저장 후 불러옴
// header[0], header[1] ...
for (i=0; i<header.length; i++) {
    header[i].style.backgroundColor = 'lightgray' 
    header[i].style.color = 'skyblue'
    header[i].innerHTML = '태그 선택자입니다.'
}
*/