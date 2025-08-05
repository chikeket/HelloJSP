/**
 * array2.js
 * filter 배열 메소드.
 * 요소의 값 -> true일 때 그 요소를 새로운 배열에 생성.
 */

function makeRow(member) {
	//tr>td*7 기능.
	let tr = document.createElement('tr');	
	// for.. in ..
	for (let prop in member) {		
		let td = document.createElement('td');
		td.innerText = member[prop]; // <td>Messi</td>
		tr.appendChild(td);
	}//end of for in..
	// 삭제버튼. <td><button>삭제</button></td>
	let td = document.createElement('td');
	let btn = document.createElement('button');
	// 이벤트&이벤트핸들러.
	btn.addEventListener('click', (e) => {		
		let parent = e.target.parentElement.parentElement;		
		let fn = parent.children[1].innerText;
		let ln = parent.children[2].innerText;
		//confirm메소드는 반환값이 true/false로 반환된다
		if (confirm(`${fn} ${ln}을 삭제하겠습니까?`)) {
			e.target.parentElement.parentElement.remove();
		}
	})
	btn.innerText = '삭제';
	td.appendChild(btn);

	tr.appendChild(td);
	return tr;
}//end of makeRow

// 급여가 7000 이상인 사람들을 목록으로 출력.
// map 메소드도 새로운 배열을 생성해주기에 뒤에 forEach쓰는게 가능함
members//
    .filter(elem => elem.salary > 7000 //
		         && elem.gender == 'Female')//
	.map(elem => {
		let {id, first_name, last_name, salary} = elem; //{id,fn,ln,email,gender,salary}		
		let obj = {id, first_name:first_name, last_name, salary}//속성:변수값이 같을때 생략해서 하나로 적을 수 있다
		return obj;
	})	
    .forEach(elem => document.querySelector('#show tbody')//
        .appendChild(makeRow(elem)));



let result = [10, 20, 30, 40, 50].filter((elem, idx, ary) => {
	if (elem >= 30) {
		return true;
	}
});

console.log(result);