function gopage(){ //회원 가입 시 적용되는 함수
	return false;
}
var check; //비동기화 통신으로 인하여 전역변수로 빼버림 print_result() 함수에 사용하기 위해서

function ajax_data(){ //아이디 중복체크
	if(frm.userid.value==""){
		alert("아이디를 입력해 주세요")
		frm.userid.focus();
	}
	else{
		/* 비동기화 통신 */
		ajax_get(frm.userid.value,"3");
		
		
		//back-end에서 결과값을 가져올 때 딜레이 상황이 발생하므로 시간 함수를 이용하여 적용함
		setTimeout(function(){	
			console.log(this.check);
		},2500);
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
			print_result(data); //비동기 통신 딜레이 적용하기 위해 사용
		}
	}

	/*
	비동기 통신을 사용할 경우 (아래 코드)
	*/
	
	ajaxs.open("GET","../web_ajax/usercheck.jsp"+pm,true);
	ajaxs.send();
	//아래 settimer 설정하는 것은 동기화로 설정하지 않고 비동기화로 설정했을 때 해줘야 하는 경우
	//data를 100으로 설정하면 console에 100이 찍히는데 이거는 이유가 send하고 콜백을 받기전에 return data를 찍어버려서 100이 찍히는거임
	//그래서 settimer로 딜레이를 설정을 해야한다. 최대 5초 정도?

}

function print_result(data){
	this.check = data; //전역변수로 값을 이관
}