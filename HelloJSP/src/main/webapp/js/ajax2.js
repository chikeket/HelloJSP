/**
 * ajax2.js 
 * JSON.parse(json문자열) -> 자바스크립트 객체.
 */
//서버에 요청한 매개값
fetch('js/MOCK_DATA.json') //Promise 객체(성공하면...)
.then(function(result) {
	console.log(result); //응답정보(body) 이진 데이터로 저장되어있음
	return  result.json(); //Promise 객체 반환
})
.then(function(data) {
	console.log(data);
	data.forEach(elem => {
		let tr = document.createElement('tr');
		['id', 'first_name', 'last_name', 'salary'].forEach(field => {
			let td = document.createElement('td');
			console.log(elem[field]);
			td.innerText = elem[field];
			tr.appendChild(td);
		})
		// 삭제버튼. <td><button>삭제</button></td>
		let td = document.createElement('td');
		let btn = document.createElement('button');
		btn.innerText = '삭제';
		td.appendChild(btn);
		tr.appendChild(td);
		document.querySelector('#show tbody').appendChild(tr);
	})
})
.catch(function(err){
	console.log(err);
})