/**
 * array3.js
 */






let studentsAry = [
	{name:"홍길동", score: 80},
	{name:"김민규", score: 85},
	{name:"박흥부", score: 88},
	{name:"고길동", score: 76}
]
//80점 이상



let result2 = studentsAry.reduce((acc, elem) => {
	let tr = document.createElement('tr');
	for(let prop in elem) {
		let td = document.createElement('td');
		td.innerText = elem[prop];
		tr.appendChild(td);
	}
	acc.appendChild(tr);
	
	return acc;
}, document.querySelector('#item tbody'));
//console.log(`최고점자는 ${result2.name}, 점수는 ${result2.score}점입니다.`);


let numAry = [10, 15, 34, 77, 20, 25, 30];
let result = numAry.reduce((acc, elem, idx, ary) => {
	console.log(`${acc}, ${elem}`);
	if(elem %2 == 0) {
		acc.push(elem);
	}
	return acc; //[10]
}, []);
console.log(result);