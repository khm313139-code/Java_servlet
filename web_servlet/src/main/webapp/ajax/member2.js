//동기화 통신으로 적용된 스크립트

function gopage(){ //회원 가입 시 적용되는 함수
	if(frm.userid.value ==""){
		alert("아이디를 입력하세요: ");
		return false;
	}
	else if(frm.userpw.value==""){
		alert("패스워드를 입력하세요: ");
		return false;		
	}
	else if(frm.companynm.value==""){
		alert("회사명을 입력하세요: ");
		return false;		
	}
	else if(frm.ceonm.value==""){
		alert("대표자명을 입력하세요: ");
		return false;		
	}
	else if(frm.corpno.value==""){
		alert("사업자 번호를 입력하세요: ");
		return false;		
	}
	else{
		//아이디 중복체크 버튼을 확인하지 않을 경우
		if(frm.userid.readOnly==false){
			alert("아이디 중복체크를 하셔야만 회원가입이 진행 됩니다.");
			return false;
		}
		else{
			return true;
		}
		
	}
	
}

function ajax_data(){ //아이디 중복체크
	if(frm.userid.value==""){
		alert("아이디를 입력해 주세요!!")
		frm.userid.focus();
	}
	else{
		/* 동기화 통신 */
		var check = ajax_get(frm.userid.value,"1");
		if(check=="ok"){ //equals 없음 연산기호 사용해야함
			alert("사용 가능한 아이디 입니다.");
			frm.userid.readOnly=true;
		}
		else{
			alert("해당 아이디는 사용할 수 없습니다.");
			frm.userid.value ="";
		}
	
	}
	
} 
	

function ajax_data2(){ //사업자 번호 중복체크
	if(frm.corpno.value==""){
		alert("사업자 번호를 입력해 주세요");
		frm.corpno.focus();
	}
	else{
		ajax_get(frm.corpno.value,"2");
	}
}





/*
readystate: 숫자를 적용
0(UNSENT): 객체 생성
1(OPENED): open(GET,PIST,PUT... 정상적으로 실행)
2(HEADERS_RECEIVED): 서버쪽에서 응답 결과만 체크
3(LOADING): 요청에 대한 처리 결과 (데이터 처리하고 있는 상황을 확인할 떄)
4(DONE): 요청된 데이터를 보낸 후 결과에 대한 값을 return
*/
//GET 전송에 대한 값을 어떻게 전송할 것인지 적용하는 변수
//back-end와 get 통신

function ajax_get(infodata,part){
	var pm="";
	if(part=="1"){ //아이디
		pm="?data="+infodata+"&part="+part;
	}
	else if(part=="2"){ //사업자 번호
		pm="?data="+infodata+"&part="+part;
	}
	
	
	
	
	
	var data; //결과값을 받는 변수 및 return 형태
	var ajaxs = new XMLHttpRequest();
	ajaxs.onreadystatechange = function(){
		if(ajaxs.readyState == 4 && ajaxs.status==200){
			data = this.response; //Backend에서 처리된 결과값을 받아서 변수에 이관
			
		}
	}
	
	//동기화를 사용한 이유는 back-end에 데이터 전송 후 return 결과를 받기 전에 javascript가 먼저 return을 시켜버림
	//결과값이 없다는 undefined가 무조건 출력될 수 밖에 없음 왜?? 통신 전송에는 딜레이가 발생함 그래서 뜨게 되는 것임.
	ajaxs.open("GET","../web_ajax/usercheck.jsp"+pm,false); //동기화 통신을 사용함.(딜레이 상황으로 인하여)
	//동기화는 순서대로 처리를 하니까 값이 올때까지 return을 안시킨다 false 때리면 동기화임
	//but 비동기화는 무작위 처리니까 값이 오기전에 return을 바로 찍어버린다. console에다가
	//return을 받으려면 무조건 동기화로 설정을 해야한다.
	ajaxs.send();
	return data; //결과값을 return 시킴
	
	
	
	
	//아래 settimer 설정하는 것은 동기화로 설정하지 않고 비동기화로 설정했을 때 해줘야 하는 경우
	//data를 100으로 설정하면 console에 100이 찍히는데 이거는 이유가 send하고 콜백을 받기전에 return data를 찍어버려서 100이 찍히는거임
	//그래서 settimer로 딜레이를 설정을 해야한다. 최대 5초 정도?

}

