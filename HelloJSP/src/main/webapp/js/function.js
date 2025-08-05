/**
 * function.js
 */
// 함수선언식.
//function sum(num1, num2) {
//	let result = num1 + num2;
//	return result;
//}
//내부적으로 표현되는 방식은... 아래와 같다
//let sum = function(num1, num2) {
//	let result = num1 + num2;
//	return result;
//}

//화살표 함수. 실행하는 코드가 하나일경우 중괄호도 생략 가능 리턴도 생략가능
let sum = (num1, num2) => num1 + num2;	

sum(10, 12);
// 함수표현식.
let showInfo = (result) => console.log(result);

showInfo('Hello, World');