/**
 * basic2.js
 */
const fruits = ['apple', 'banana', 'cherry'];//new Array();
fruits[3] = 'orange';

// 추가, 삭제
fruits.push('melon'); //마지막 인덱스에 추가되는 기능이 push임
fruits.unshift('mango'); //제일 앞쪽에 추가하는게 unshift
fruits.pop(); //마지막 끝 인덱스가 제거됨(melon 제거)
fruits.pop(); //마지막 끝 인덱스가 제거됨(orange 제거)
fruits.shift(); // 제일 첫 인덱스가 제거됨(mango제거.)
fruits.shift(); // 제일 첫 인덱스가 제거됨(apple제거.)

for(let fruit of fruits) {
	console.log(fruit);
}

const members = [{id:'user01', name:'Hong', point: 100}];
members.push({id: 'user02', name: 'Park', point: 120});
members.push({id: 'user03', name: 'Kim', point: 90});

for(let i = 0; i < members.length; i++) {
	if (members[i].point >= 100) 
	console.log(`id: ${members[i].id}, name: ${members[i].name}, point: ${members[i].point}`)	
}
// 화면에 배열의 갯수만큼 회원정보를 출력하는 함수.
function showList() {
	
// 반복문. forEach (배열이 가지고 있는 기본 메서드)
members.forEach((elem, idx, ary) => {
	let str = `<li>아이디: ${elem.id}, 이름: ${elem.name}, 포인트: ${elem.point} </li>`;
	// ul 요소.
	document.querySelector('#list').innerHTML += str;
});
}//end of showList().
showList();
// 이벤트.
document.querySelector('#addBtn').addEventListener('click', () => {
	let id = document.querySelector('#mid').value;
	let name = document.querySelector('#mname').value;
	let point = document.querySelector('#point').value;
	//필수값 않넣으면 함수 종료시키게 만드는 구문
	if(id == '' || name == '' || point == '') {
		console.log("빈값이다 값 너어라")
		return;
	}
	document.querySelector('#list').innerHTML = '';
	// 배열에 추가.
	members.push({id: id, name: name, point: point});
	showList();	
	// 입력값 초기화.
	document.querySelector('#mid').value = '';
	document.querySelector('#mname').value = '';
	document.querySelector('#point').value = '';
})









