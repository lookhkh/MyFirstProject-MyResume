

window.addEventListener('load',function(){

	 const buttons = document.querySelector('tbody');
     const modalBtn = document.querySelectorAll('button')[1]
     const title = document.querySelector('.modal-title')
     const titleRel = document.querySelector('.modal-title.relation')
     const titleReg = document.querySelector('.modal-title.registerDate')
          const titleHead = document.querySelector('.modal-title.title')

    const modalBody = document.querySelector('.modal-body').firstElementChild;
    console.log(modalBody)

     buttons.onclick= (e)=>{
        const currentTar = e.target;
        const targetNumber = currentTar.parentNode.firstElementChild.textContent;
        if(currentTar.nodeName!=="TD") return;

        ajaxGet(targetNumber);
    }


function ajaxGet(val){
    const xhr = new XMLHttpRequest();
    const url = "http://localhost:8085/ref/detail?bno="+val;
    const board = document.querySelector('.modal-content');
   
    xhr.open('GET',url);
    xhr.send();

    xhr.onreadystatechange = ()=>{
        if(xhr.status===200&&xhr.readyState===xhr.DONE){
            const result = JSON.parse(xhr.response);
			const edit = document.queryselector('.')

            
            let date = result.registerDate;
            date = date.substr(0,10);
            console.log(date);
            titleHead.innerHTML= result.title;
            titleRel.innerHTML=result.relationship;
            titleReg.innerHTML=date;
            modalBody.innerHTML=result.content
            
            
            
            let click = new Event('click');
            modalBtn.dispatchEvent(click);

        }
    }
}





});
