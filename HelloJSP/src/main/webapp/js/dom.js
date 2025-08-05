/**
 * dom.js
 * <ul id='target'>
     <li>apple</li>
     <li>banana</li>
   </ul>
 */
let ul = document.createElement('ul'); //<ul />
ul.setAttribute('id', 'target');

let li = document.createElement('li'); // <li />
li.innerText = 'apple';
ul.appendChild(li); //ul의 child요소로 삽입하는 기능

//banana 추가
li = document.createElement('li'); // <li />
li.innerText = 'banana';
ul.appendChild(li); //ul의 child요소로 삽입하는 기능

console.log(ul); // <ul id='target'><li>apple</li></ul>

document.querySelector('#show').appendChild(ul);