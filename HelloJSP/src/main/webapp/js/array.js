/**
 * array.js (forEach, map, filter, reduce)
 * document.querySelectorAll() 결과에 사용.
 */

members.forEach((elem, idx, ary) => {
	if(idx==ary.length - 1) {
	console.log(elem);		
	}
	if(idx==0) {
	console.log(elem);		
	}
});

let sum = 0;


var evenSum = (elem, idx, ary) => {
	if(elem%2 ==0){
		sum += elem;
	}
	if(idx == ary.length -1) {
		console.log(`홀수합계${sum}`);
	}	
}

var totalSum = (elem, idx, ary) => {	
		sum += elem;	
	if(idx == ary.length -1) {
		console.log(`전체합계${sum}`);
	}	
}

[12, 34, 83, 22, 59, 77].forEach(evenSum);
[12, 34, 83, 22, 59, 77].forEach(totalSum);
