const arr = [2,1,3,10]
const arr2 = arr.concat()  // 복사
const arr3 = [2,5,1]

// // 숫자일 경우
arr.sort(function(a,b) {
    return a - b  // 오름 차순
})
console.log(arr)
console.log(arr[0],arr[1],arr[2],arr[3])

arr2.sort(function(a,b) {
    return b - a  // 내림 차순
})
console.log(arr2)
console.log(arr2[0],arr2[1],arr2[2],arr2[3])

arr3.sort()  // 오름차순
console.log(arr3)
console.log(arr3[0],arr3[1],arr3[2])

arr3.reverse()  // 내림차순
console.log(arr3)
console.log(arr3[0],arr3[1],arr3[2])


// 문자일 경우 : 오름차순, 내림차순
const arr_str = ['김길순', '홍길동', '여우']
// 오름 차순
// arr_str.sort()
// console.log (arr_str)

// 내림차순
arr_str.sort(function (a,b) {
    if (a>b) return -1
    if (a<b) return 1
    if (a==b) return 0
})
console.log (arr_str)

//데이터
const userDataList = [
    {id:2, name:'곰'},
    {id:10, name:'여우'},
    {id:4, name:'사자'},
    {id:29, name:'기린'},
    {id:101, name:'호랑이'}
]

// 데이터 표시
function updataList() {
    let ul_html = ''
    for ( const data of userDataList) {
        console.log(data)
        ul_html += `<li>${data.id} : ${data.name}</li>`
    }  // end for
    document.querySelector('.result').innerHTML = ul_html
}

// 오름차순 정렬
function sortByAsc() {
    userDataList.sort ( (a,b)=> a.id - b.id)
    // for ( const data of userDataList) {
        // console.log(data)
    // }
    updataList()
}

// 내림차순 정렬
function sortByDesc() {
    userDataList.sort ( (a,b)=> b.id - a.id)
    // for ( const data of userDataList) {
    //     console.log(data)
    // }
    updataList()
}

// 정렬 버튼 이벤트 등록
document.querySelector('.asc').addEventListener('click', ()=> {
    sortByAsc()
})
document.querySelector('.desc').addEventListener('click', ()=> {
    sortByDesc()
})


console.log('--sort(), resverse() : 유니코드 기준으로 정렬')
const sort_test = [10,9,20,1]

sort_test.sort()  // 유니코드 기준으로 정렬해서 숫자는 이걸로 정렬안됨
console.log(sort_test)
console.log(sort_test[0],sort_test[1],sort_test[2],sort_test[3])

sort_test.sort(function(a,b) {  // 정렬하는 과정을 대신해주는 식
    return a-b // 오름차순
})
console.log(sort_test)
console.log(sort_test[0],sort_test[1],sort_test[2],sort_test[3])
