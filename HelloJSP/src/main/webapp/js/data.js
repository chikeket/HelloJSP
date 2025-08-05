/**
 * data.js
 */
const str = `[{"id":1,"first_name":"Isadore","last_name":"Lawey","email":"ilawey0@4shared.com","gender":"Male","salary":6053},
{"id":2,"first_name":"Kyrstin","last_name":"Benard","email":"kbenard1@sitemeter.com","gender":"Female","salary":6549},
{"id":3,"first_name":"Isidora","last_name":"Ayshford","email":"iayshford2@fema.gov","gender":"Female","salary":6051},
{"id":4,"first_name":"Judas","last_name":"Skypp","email":"jskypp3@buzzfeed.com","gender":"Male","salary":6060},
{"id":5,"first_name":"Corbie","last_name":"Strute","email":"cstrute4@ted.com","gender":"Male","salary":9877},
{"id":6,"first_name":"Kellie","last_name":"Acreman","email":"kacreman5@globo.com","gender":"Female","salary":7614},
{"id":7,"first_name":"Pauletta","last_name":"Patey","email":"ppatey6@microsoft.com","gender":"Female","salary":9348},
{"id":8,"first_name":"Ursala","last_name":"Figures","email":"ufigures7@pcworld.com","gender":"Female","salary":9120},
{"id":9,"first_name":"Yoshiko","last_name":"Shailer","email":"yshailer8@chicagotribune.com","gender":"Female","salary":8849},
{"id":10,"first_name":"Noelani","last_name":"Gent","email":"ngent9@reddit.com","gender":"Female","salary":5520},
{"id":11,"first_name":"Gracie","last_name":"Pashby","email":"gpashbya@addthis.com","gender":"Female","salary":6285},
{"id":12,"first_name":"Harlan","last_name":"Behagg","email":"hbehaggb@slashdot.org","gender":"Male","salary":6405},
{"id":13,"first_name":"Brandon","last_name":"Oboy","email":"boboyc@flickr.com","gender":"Male","salary":5581},
{"id":14,"first_name":"Gloria","last_name":"Glenfield","email":"gglenfieldd@xing.com","gender":"Female","salary":9028},
{"id":15,"first_name":"Morris","last_name":"Rosenqvist","email":"mrosenqviste@answers.com","gender":"Male","salary":6314}]`;

//json문자열(객체) -> 객체.
let members = JSON.parse(str);
//console.log(str);
//console.log(members[0].first_name);

let students = [{ name: "Hong", age: 20}, { name: "Choi", age: 21}];
	//객체 -> JSON.stringify() -> json문자열.
let json = JSON.stringify(students);
//console.log(json);	

// 반복문(forEach) => 성별:Female 급여 6000 이상인 사람을 출력.
//members.forEach(elem=>elem.salary>=6000 && elem.gender=="Female"?console.log(`last_name: ${elem.last_name}\t gender: ${elem.gender}\t salary: ${elem.salary}`):false);
