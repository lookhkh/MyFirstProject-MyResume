window.addEventListener('load',function(){

    const wrapperDemo  = document.querySelector('.demo-wrap')
    const wrapper = document.querySelector('.wrapper');
    const h1 = document.querySelector('.h1')
    const p = document.querySelector('.none')
    const action = document.querySelector('.action');
    const navLink = document.querySelector('.direction');
    const nav = navLink.querySelectorAll('a')
    let currentA = nav[0];
    const mailBtn = document.querySelector('.mail')
    currentA.classList.add('current')
    const btn = document.querySelector('.btn')
    
    mailBtn.addEventListener('click', function(){
        let clicke = new Event("click");
        btn.dispatchEvent(clicke);
    })

    window.addEventListener('scroll',function(e){
        let currentScrollY = window.scrollY;
        currentA.classList.remove('current')

        if(currentScrollY<600){
            currentA = nav[0];
        }
        if(currentScrollY>=600&&currentScrollY<1200){
                currentA = nav[1];
            }
        if(currentScrollY>1200){
            currentA = nav[2];
            console.log(currentA)
        }

        currentA.classList.add('current')
        })

    navLink.addEventListener('click',function(e){
        if(e.target.nodeName==="A"){
            if(e.target === currentA) return;
            e.target.classList.add('current')
            if(currentA){
                currentA.classList.remove('current')
            }
            currentA=e.target;
        }
    })



    h1.classList.remove('h1');
    

    
    function handler(){
        wrapperDemo.classList.add('hidden');    
    }


    const timeOut =setTimeout(()=>{p.classList.remove('none');
    setTimeout(() => {
       action.classList.remove('none'); 
    }, 1000);

}, 1000);





})