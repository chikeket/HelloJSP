/**
 * openapi.js
 */

let url = `https://api.odcloud.kr/api/15077586/v1/centers?page=1&perPage=284&serviceKey=JM8XtDAtSldZOaB2pLP2Pyg4ON%2F8TL6ZxLE%2BhmsJQnil92XKZ90aIIfR9EmafelMT5Gnv1y5SUn9TZ1OCcG4Xw%3D%3D`;

document.querySelector('#search').addEventListener('change', function(e) {
	let sido = e.target.value;
	searchCenterList(sido);
});

// 검색목록 생성.
fetch(url)
	.then(resolve => resolve.json())
	.then(result => {
		const search = document.getElementById('search');
		result.data.reduce((acc, elem) => {
			if (acc.indexOf(elem.sido) == -1) {
				acc.push(elem.sido); // ['서울특별시', '제주자치도']
			}
			return acc; // 다음순번의 acc값으로 활용.
		}, [])
			.forEach(elem => {
				//<option value="서울특별시">서울특별시</option>
				let opt = document.createElement('option');
				opt.value = elem;
				opt.innerHTML = elem;
				search.appendChild(opt);
			})
	})
	.catch(err => console.error(err));



console.log("왜안됨?");
searchCenterList('서울특별시');
function searchCenterList(sido) {

	fetch(url)
		.then(resolve => resolve.json())
		.then(result => {
			//결과 목록을 활용해서 페이지 작성.

			//if(elem.sido == sido) {}
			// 결과값을 활용해서 반복문(forEach)활용해서 목록생성   
			document.querySelector('#list').innerHTML='';
			result.data.forEach(elem => {
				if (elem.sido == sido) {
					console.log(elem);

					let tr = document.createElement('tr');
					tr.addEventListener('click', function(e) {
						window.open('daum.jsp?lat='+elem.lat+'&lng='+elem.lng+'&str='+elem.centerName.substring(6));
					});
					//tr 생성하기.
					['id', 'centerName', 'phoneNumber'].forEach(prop => {
						let td = document.createElement('td');
						td.innerText = elem[prop];
						tr.appendChild(td);
					})
					// 생성한 tr을 tbody에 하위요소로 등록.
					document.getElementById('list').appendChild(tr);
				}
			});
		})
		.catch(err => console.error(err));
}// end of searchCenterList();
