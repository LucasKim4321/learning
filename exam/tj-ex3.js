// Taejin

    const imgs_box1 = document.querySelector('#imgs_box1')
    const firstImg = imgs_box1.firstElementChild.outerHTML
    const lastImg = imgs_box1.lastElementChild.outerHTML
    imgs_box1.innerHTML += firstImg+lastImg
    imgs_box1.firstElementChild.before(imgs_box1.lastElementChild)

    const btnL = document.querySelector('#btnL')
    const btnR = document.querySelector('#btnR')
    const img_boxes = document.querySelectorAll('.img_box')
    const img_box = document.querySelector('.img_box')
    const img_slider1 = document.querySelector('#img_slider1')
    const header = document.querySelector('#header')


    // 초기 위치 설정
    img_boxes.forEach((x)=>{x.style.flex = `0 0 ${img_slider1.offsetWidth}px`})
    let left = -img_slider1.offsetWidth, left2 = 0
    imgs_box1.style.left = left+'px'

    // 왼쪽 버튼
    headcolor()
    console.log(img_slider1.offsetWidth)
    btnL.addEventListener('click', (e)=> {
        if(left<0) {
            imgs_box1.style.transition = 'all 1s'
            left += img_slider1.offsetWidth
            left2++
            imgs_box1.style.left = left+'px'
            console.log('left',left,typeof(left))
            headcolor()
            if(left2==1){
                setTimeout(() => {
                    left2=-2
                    imgs_box1.style.transition = 'none'
                    left = img_slider1.offsetWidth*left2-img_slider1.offsetWidth
                    imgs_box1.style.left = left+'px'
                },1000)
            }
        }
    })

    // 오른쪽 버튼
    btnR.addEventListener('click', ()=> {
        if(left>((img_boxes.length-1)*(-img_slider1.offsetWidth))) {
            imgs_box1.style.transition = 'all 1s'
            left -= img_slider1.offsetWidth
            left2--
            imgs_box1.style.left = left+'px'
            console.log('left',left,typeof(left))
            headcolor()
            if(left2==-imgs_box1.childElementCount+2){
                setTimeout(() => {
                    left2=0
                    imgs_box1.style.transition = 'none'
                    left = -img_slider1.offsetWidth
                    imgs_box1.style.left = left+'px'
                },1000)
            }
        }
    })

    // 리사이징시 슬라이드 자동 맞춤
    window.addEventListener('resize', (e)=> {
        imgs_box1.style.transition = 'none'
        img_boxes.forEach((x)=>{x.style.flex = `0 0 ${img_slider1.offsetWidth}px`})
        left = img_slider1.offsetWidth*left2-img_slider1.offsetWidth
        imgs_box1.style.left = left+'px'
        console.log(img_slider1.offsetWidth)
        imgs_box1.style.transition = 'all 1s'
    })

    // 링크
    const instagram = document.querySelector('.fa-instagram')
    const facebook = document.querySelector('.fa-facebook-official')
    const twitter = document.querySelector('.fa-twitter')

    instagram.addEventListener('click', ()=>{
        location.href= "https://www.instagram.com/"
    })
    facebook.addEventListener('click', ()=>{
        location.href= "https://www.facebook.com/"
    })
    twitter.addEventListener('click', ()=>{
        location.href= "https://www.x.com/"
    })

    // 해드 컬러 변환
    function headcolor() {
        header.style.transition = 'all 1s'
        if(left2==1) {
            header.style.backgroundColor = 'lightgrey'
        }
        if(left2==0) {
            header.style.backgroundColor = 'lightsalmon'
        }
        if(left2==-1) {
            header.style.backgroundColor = 'lightblue'
        }
        if(left2==-2) {
            header.style.backgroundColor = 'lightgrey'
        }
        if(left2==-3) {
            header.style.backgroundColor = 'lightsalmon'
        }
    }