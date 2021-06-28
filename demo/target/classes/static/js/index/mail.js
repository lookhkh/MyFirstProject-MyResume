window.addEventListener('load',function(){
   const button = document.querySelector('button[value="Send message"]')
   const modal = document.querySelector('.modal-body');
   let modalInput = modal.querySelectorAll('input');
   let modalTextArea = modal.querySelector('textarea');
   let closeBtn = modal.querySelector('button[class="btn btn-secondary"]');
   button.addEventListener('click',function(){

        let mailVO = {};
        mailVO.who = modalInput[0].value;
        mailVO.contactInfo = modalInput[1].value;
        mailVO.title = modalInput[2].value;
        mailVO.content = modalTextArea.value;
        
        mailSend(mailVO);
    

});
    function mailSend(vo){
    const xhr = new XMLHttpRequest();
    const url = "http://localhost:8085/mail";

    xhr.open('post',url)
    xhr.setRequestHeader('Content-Type','application/json');

    vo=JSON.stringify(vo);

    xhr.send(vo);
    

    console.log(vo.title)

    xhr.onreadystatechange=()=>{
        if(xhr.status===200&&xhr.readyState===4){
        
            alert("요청이 성공적으로 전달되었습니다! 바쁜 시간 내어주셔서 감사드립니다")
            closeBtn.dispatchEvent(new Event('click'));
        };
        if(xhr.status===500&&xhr.readyState===4){
            alert("요청에 문제가 생겼습니다. 다시 시도해 주세요");
        }
        if(xhr.status===400&&xhr.readyState===4){
        	alert(xhr.responseText);
        	}
    };
}

})