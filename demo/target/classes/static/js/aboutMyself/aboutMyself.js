 window.addEventListener('load',function(){

        
        let modalBtn = document.querySelector('.btn.btn-primary');
        modalBtn.style.display='none';

        ajaxAllList();

        const timeout = setTimeout(() => {

            const intro = document.querySelector('.intro');
            intro.classList.add('hidden')
            const wrapper = document.querySelector('.wrapper');
            
            let boxes = document.querySelectorAll('.box');
            wrapper.classList.remove('hidden')
            
            setTimeout(() => {
                boxes.forEach((a)=>{
                a.classList.add('active')
            })
            }, 300);
           
        }, 2000);

        const boxList = document.querySelector('.wrapper');
        console.log(boxList);

        boxList.addEventListener('click',function(e){
            if(e.target.classList[0]==='front'||e.target.classList[0]==='back'){
                let targetNodeNum = e.target.parentNode.dataset.value;
                ajaxGet(targetNodeNum);
                
            }
        })



        function ajaxGet(val){
            const xhr = new XMLHttpRequest();
            const url = `http://localhost:8085/about/${val}`;
            const board = document.querySelector('.modal-content');
            let head = board.querySelector('.modal-title');
            let content = board.querySelector('span');
            let img = board.querySelector('img');
            xhr.open('GET',url);
            xhr.send();

            xhr.onreadystatechange = ()=>{
                if(xhr.status===200&&xhr.readyState===xhr.DONE){
                    const result = JSON.parse(xhr.response);
                    head.innerHTML=result.title;
                    content.innerHTML=result.content;
                    img.src=result.imgpath;

                    let click = new Event('click');
                    modalBtn.dispatchEvent(click);

                }
            }
        }

        function ajaxAllList(){
            const xhr = new XMLHttpRequest();
            const url = 'http://localhost:8085/about/list;'
            xhr.open('GET',url);
            xhr.send();

            xhr.onreadystatechange=()=>{
                if(xhr.status===200&&xhr.readyState===xhr.DONE){

                    const wrapper = document.querySelector('.wrapper');
                    let result = JSON.parse(xhr.response);
                    

                    for(let i=0; i<result.length; i++){
                        wrapper.appendChild(makeList(result[i]));
                        console.log(makeList(result[i]));
                    }
                    
                }



            }

        }

        function makeList(json){
            /* <div class="box">
                <div class="front">근성</div>
                <div class="back"><img src="KakaoTalk_20210620_002820397.jpg"></div>
            </div>
            */

            const divBox = document.createElement('div');
            const divFront = document.createElement('div');
            const divBack = document.createElement('div');
            const imgTag = document.createElement('img');
            divBox.classList.add('box');
            divFront.classList.add('front');
            divBack.classList.add('back');

            divBox.dataset.value = json.bno;
            divBox.appendChild(divFront);
            divBox.appendChild(divBack);
            divBack.appendChild(imgTag);

            divFront.innerHTML=json.title;
			imgTag.src=json.imgpath;

            return divBox;
        }




    });