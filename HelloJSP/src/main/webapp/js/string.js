/**
 * string.js
 * 문자열 메소드(indexOf, substring, slice, split, toUpperCase, toLowerCase
 * trim, replace, includes, charAt)
 */

//1번)
let strAry = [" Hello, Java          "//
	, " Html, Css, javaScript   "//
	, "     Java is complier     "//
	, "         Java and Javascript        "];
let filterWord = "java";
//const tLower = [];
//const replaAll = [];
//const ttrim = [];
//const tUpper = [];
//strAry.forEach(elem=>tLower.push(elem.toLowerCase()));
//tLower.forEach(elem=>replaAll.push(elem.replaceAll(filterWord, "****")));
//replaAll.forEach(elem=>ttrim.push(elem.trim()));
//ttrim.forEach(elem=>tUpper.push(elem.toUpperCase()));
//tUpper.forEach(elem=>console.log(elem));

/// java/g 요게 글로벌 표현?
strAry.forEach(elem=>console.log(elem.toLowerCase()
                                     .replaceAll(filterWord, "****")
									 .trim()
								     .toUpperCase()
								 ));


//결과=> "HELLO, ****"
//      "HTML, CSS, ****SCRIPT"
//	  "**** IS COMPILER"
//	  "**** AND **** SCRIPT
	  
//2번)
let noAry = ["920304-1213421", "990508 2928123", "030702-4323123"];
//결과=> "920304-1213421"은 남자입니다
//      "990508-2928123"은 여자입니다
//	    "030702-4323123"은 여자입니다.
noAry.forEach(elem => {
	let gen = elem.slice(-7)[0];
	let gender = gen==1 || gen==3 ?	console.log(`${elem}은 남자입니다`) :
                 gen==2 || gen==4 ?	console.log(`${elem}은 여자입니다`) : gender
});

let idx = "Hello, World".indexOf('W');
console.log(idx);  //찾는 값이 없을 경우 => -1 값을 반환.
idx = "Hello, World".indexOf("Nice");
if(idx == -1) {
	console.log("찾는 문자열이 없습니다");
}
console.log(idx);

const names = ['홍길동', '홍길순', '김길동', '김민수', '박길동'];
// '길동' 이름이 총 몇명인지를 반환하는 함수를 생성.
function getKildong() {
	let cnt = 0;
	names.forEach(elem => elem.indexOf('길동')!=-1 ? cnt++ : cnt);
	console.log(`인덱스는 총${cnt}입니다`);	
};
getKildong();


const obj = {
	name: '홍길동', // obj.name
	age: 20,
	info: function() {
		return `이름은 ${this.name}, 나이는 ${this.age}`
	}
}
console.log(obj.name);

Array.prototype.sum = function(num1) {
	this.push(num1);
}

const numbers = [1,2];
numbers.push(3);
numbers.sum(4);

console.log(numbers);


