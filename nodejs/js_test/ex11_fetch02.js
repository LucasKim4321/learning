// 1.
// fetch('https://jsonplaceholder.typicode.com/posts/1').then((resp)=>resp.json()).then((data)=>console.log(data))

// 2.
// const getData = async function(){}  // 이렇게 해도됨
const getData = async()=>{
    try{  // 에러 발생 판별 할 문장
        // REST API방식으로 Data 요청
        const resp = await fetch('https://jsonplaceholder.typicode.com/users')
        console.log('resp',resp) // Object
        const data = await resp.json()  // json구조로 전환
        console.log(data)
        data.forEach((item)=> {
            // for (변수 of 배열), for (키 in json객체)
            console.log('----------')
            for(let key in item) {
                // console.log(`${key} => ${item[key]}`)  // itme.key == item[key]
                let item2 = item[key]
                console.log(`${key} => ${item[key]}`)
                if (typeof item[key] == 'object') {  // 객체 판별
                    console.log(`<--- ${key} is a object --->`)
                    for (let key2 in item2) {
                        console.log(`${key}:${key2} => ${item2[key2]}`)
                        if (typeof item2[key2] == 'object') {  // 한번더 객체 판별 geo객체에만 해당
                            let item3 = item2[key2]
                            console.log(`<--- ${key2} is a object --->`)
                            for (let key3  in item3) {
                                console.log(`${key2}:${key3} => ${item3[key3]}`)
                            }
                        }
                    }
                }
            }
        })
    }
    catch(e) {  // 에러발생 시 출력 후 정상 작동
        console.log(`error: ${e}`)
    }
}
getData()