async function load () {
    const data = await fetch('ex11_sample.txt')  // await 데이터를 정상적으로 불러 온 후 대입
    const text = await data.text()
    // console.log(text)
    document.querySelector('#log').innerHTML = text
}

load()  //호출

//JSON형식 읽기
async function json_load() {
    const data = await fetch('ex11_sample.json')  // 비동기 방식
    const json_data = await data.json()
    console.log(json_data)
    console.log(JSON.stringify(json_data,null,' '))  // JSON.stringify(JSON객체, 수행할 함수,'대입할 문자열')
}
json_load()

//XML 읽기
async function xml_load() {
    const data = await fetch('ex11_sample.xml')
    const text = await data.text()  // 텍스트 형식
    // XML형식으로 해석
    const xml = new DOMParser().parseFromString(text, 'application/xml')
    console.log(text)
    // console.log(xml)
    document.querySelector('#log2').innerHTML = text
    
}
xml_load()

//img 읽기
async function img_load() {
    const data = await fetch('frog.webp')
    const blob = await data.blob()  // blob 형식
    // img 요소 생성
    const image = new Image()
    image.src = URL.createObjectURL(blob)
    console.log(blob)
    // console.log(image)
    document.querySelector('#log3').appendChild(image)
}
img_load()
