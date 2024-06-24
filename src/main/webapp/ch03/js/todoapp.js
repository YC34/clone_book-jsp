function addItem(){
    // 입력값을 읽어와서 저장
    let todo = document.getElementById("item");
    let list = document.getElementById("todolist");

    // 새로운 <li>요소를 생성하여 listitem 변수에 저장
    let listitem = document.createElement("li");

    // 새로운 목록에 디자인 추가
    listitem.className
        = "d-flex list-group-item list-group-item-action list-group-item-warning";

    // 입력값을 <li> 태그 보디에 추가
    listitem.innerText = todo.value;

    // list에 추가
    list.appendChild(listitem);

    // 입력칸 빈칸 만들기 및 포커스 이동 . (초기화)
    todo.value="";
    todo.focus();

    // <li>요소에 들어갈 닫기 버튼 생성
    let xbtn = document.createElement("button");
    // 버튼에 부트스트랩 클래스 적용
    xbtn.className = "btn-close ms-auto";

    // <li>에 버튼 추가
    listitem.append(xbtn);


    // close 버튼에 이벤트 처리
    xbtn.onclick = function (e) {
        let pnode = e.target.parentNode;
        list.removeChild(listitem);
    }


}