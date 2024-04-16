let id1 = "hong1234"
let pwd1 = "112233"
let id2 = "min123"
let pwd2 = "1234"


let user_id = prompt("아이디를 입력해주세요","")
let user_pwd = prompt("비밀번호를 입력해주세요","")

if (id1==user_id)
if(pwd1==user_pwd)
    document.write(`${user_id}님 반값습니다.`)
    else {
    alert("비밀번호가 일치하지 않습니다.")
    location.reload()
}
else if (id2==user_id)
if(pwd2==user_pwd)
    document.write(`${user_id}님 반값습니다.`)
    else {
    alert("비밀번호가 일치하지 않습니다.")
    location.reload()
}
else{
alert("아이디가 일치하지 않습니다!")
location.reload();
}