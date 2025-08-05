/**
 * todo1.js
 */
const students = [];
students.push({sname: "홍길동", score: 90});

function showList() {
// 반복문. forEach (배열이 가지고 있는 기본 메서드)
students.forEach((elem, idx, ary) => {		
	let str = `<tr>  <td>${elem.sname}</td><td>${elem.score}</td>  </tr> `;
	// ul 요소.
	document.querySelector('#tlist').innerHTML += str;
});
}//end of showList().

showList();

// 이벤트.
document.querySelector('#addList').addEventListener('click', () => {	
	let sname = document.querySelector('#std_name').value;
	let score = document.querySelector('#std_score').value;
	//필수값 않넣으면 함수 종료시키게 만드는 구문
	if(sname == '' || score == '') {
		console.log("빈값이다 값 너어라")
		return;
	}
	document.querySelector('#tlist').innerHTML = '';
	// 배열에 추가.
	students.push({sname: sname, score: score});
	showList();	
	// 입력값 초기화.	
	document.querySelector('#std_name').value = '';
	document.querySelector('#std_score').value = '';
})