// 다중 for

for (i=1; i<=25; i++) {
    // console.log(i)
    document.write(i," ")
}

document.write("<br><br><hr><br>")

var cnt= 0
for (i=1; i<=5; i++) {
    for(j=1; j<=5; j++) {
        cnt++
        document.write(cnt," ")
    }
    document.write("<br>")
}

document.write("<br><hr><br>")

for (i=1; i<=5; i++) {
    for(j=1; j<=5; j++) {
        document.write("*")
    }
    document.write("<br>")
}

document.write("<br><hr><br>")

for (i=1; i<=5; i++) {
    for(j=1; j<=i; j++) {
        document.write("*")
    }
    document.write("<br>")
}

document.write("<br><hr><br>")

var n = 0
for (i=1; i<=5; i++) {
    for(j=1; j<=i; j++) {
        n++
        document.write(n," ")
    }
    document.write("<br>")
}

document.write("<br><hr><br>")

var a = prompt("횟수 입력",1)
var n2 = 0
ss(a)
function ss(b) {
    for (i=1; i<=b; i++) {
        for(j=1; j<=i; j++) {
            n2++
            document.write(n2," ")
        }
        document.write("<br>")
    }
}

document.write("<br><hr><br>")

var c = prompt("횟수 입력",1)
var n3 = 0
ss2(c)
function ss2(d) {
    for (i=d; i>=1; i--) {
        for(j=1; j<=i; j++) {
            n3++
            document.write(n3," ")
        }
        document.write("<br>")
    }
}