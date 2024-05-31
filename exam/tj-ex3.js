// Taejin

    const btnL = document.querySelector('#btnL')
    const btnR = document.querySelector('#btnR')
    const imgs_box1 = document.querySelector('#imgs_box1')
    const img_boxes = document.querySelectorAll('.img_box')
    const img_box = document.querySelector('.img_box')
    const img_slider1 = document.querySelector('#img_slider1')
    const header = document.querySelector('#header')


    let left = 0, left2 = 0
    headcolor()
    console.log(img_slider1.offsetWidth)
    btnL.addEventListener('click', (e)=> {
        if(left<0) {
            left += img_slider1.offsetWidth
            left2++
            imgs_box1.style.left = left+'px'
            console.log('left',left,typeof(left))
            console.log(imgs_box1.style.width)
            headcolor()
        }
    })
    btnR.addEventListener('click', ()=> {
        if(left>((img_boxes.length-1)*(-img_slider1.offsetWidth))) {
            left -= img_slider1.offsetWidth
            left2--
            imgs_box1.style.left = left+'px'
            console.log('left',left,typeof(left))
            headcolor()
        }
    })

    img_boxes.forEach((x)=>{x.style.flex = `0 0 ${img_slider1.offsetWidth}px`})
    window.addEventListener('resize', (e)=> {
        imgs_box1.style.transition = 'none'
        img_boxes.forEach((x)=>{x.style.flex = `0 0 ${img_slider1.offsetWidth}px`})
        left = img_slider1.offsetWidth*left2
        imgs_box1.style.left = left+'px'
        console.log(img_slider1.offsetWidth)
        imgs_box1.style.transition = 'all 1s'
    })

    
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

    

    function headcolor() {
        // header.style.transition = 'all 1s'
        if(left2==0) {
            header.style.backgroundColor = 'lightsalmon'
        }
        if(left2==1) {
            header.style.backgroundColor = 'lightblue'
        }
        if(left2==2) {
            header.style.backgroundColor = 'lightslategray'
        }
    }