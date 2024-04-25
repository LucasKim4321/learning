const input1 = document.querySelector('#input1')
const input2 = document.querySelector('#input2')
const cf1 = document.querySelector('#cf1')
const cf2 = document.querySelector('#cf2')
const change = document.querySelector('#change')
const title = document.querySelector('.title')

var a = 0
change.addEventListener('click', ()=> {
    a++
    if (a == 2) {a=0}
    console.log(a)
    if (a==1) {
        console.log('섭씨 화씨')
        cf1.innerHTML = 'C'
        cf2.innerHTML = 'F'
        title.innerHTML = '섭씨 ↔ 화씨 온도 변환기'
        input1.addEventListener('keyup', (e)=> {
            // console.log(e.key)
            // console.log(e.keyCode)
            var f = (input1.value*1.8)+32
            if (e.keyCode == 13) {
                // console.log(f)
                input2.value = f.toFixed(1)
            }
        })
        input2.addEventListener('keyup', (e)=> {
            var c = (input2.value-32)/1.8
            if (e.keyCode == 13) {
                // console.log(c)
                input1.value = c.toFixed(1)
            }
        })
    }
    else{
        console.log('화씨 섭씨')
        cf1.innerHTML = 'F'
        cf2.innerHTML = 'C'
        title.innerHTML = '화씨 ↔ 섭씨 온도 변환기'
        input2.addEventListener('keyup', (e)=> {
            var f = (input2.value*1.8)+32
            if (e.keyCode == 13) {
                input1.value = f.toFixed(1)
            }
        })
        input1.addEventListener('keyup', (e)=> {
            var c = (input1.value-32)/1.8
            if (e.keyCode == 13) {
                input2.value = c.toFixed(1)
            }
        })
    }
})
change.click()

const input3 = document.querySelector('#input3')
const input4 = document.querySelector('#input4')

input3.addEventListener('keyup', (e)=> {
    var c = (input3.value-32)/1.8
    if (e.keyCode == 13) {
        input4.value = c.toFixed(1)
    }
})
input4.addEventListener('keyup', (e)=> {
    var f = (input4.value*1.8)+32
    if (e.keyCode == 13) {
        input3.value = f.toFixed(1)
    }
})


const input5 = document.querySelector('#input5')
const input6 = document.querySelector('#input6')
const input7 = document.querySelector('#input7')

// input5.addEventListener('keyup', (e)=> {
//     var inch = input5.value/2.54
//     if (e.keyCode == 13) {
//         input4.value = c.toFixed(1)
//     }
// })
// input6.addEventListener('keyup', (e)=> {
//     var f =
//     if (e.keyCode == 13) {
//         input3.value = f.toFixed(1)
//     }
// })
// input6.addEventListener('keyup', (e)=> {
//     var f =
//     if (e.keyCode == 13) {
//         input3.value = f.toFixed(1)
//     }
// })