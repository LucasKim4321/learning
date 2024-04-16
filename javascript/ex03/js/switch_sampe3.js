var name=prompt("가위, 바위, 보!","가위")

switch(name){
    case "가위":
        num=1
        break
    case "바위":
        num=2
        break
    case "보":
        num=3
        break
    default:
        alert("잘못입력했습니다. 다시 해주세요!")
        location.reload()
}
var com=Math.ceil(Math.random()*3)
document.write(com)

switch(com){
    case (num==com):
        document.write("비겼습니다.")
        break
    case (num>com):
        document.write("이겼습니다.")
    case (num==com):

}