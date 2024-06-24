document.getElementById("result").style.display = "none"; // 같은화면에 있는 div 영역을 숨김


function signUp(){
    alert("정말로 가입하시겠습니까?")
    document.getElementById("regform").style.display = "none";
    document.getElementById("rname").innerHTML = document.form1.name.value;
    document.getElementById("remail").innerHTML = document.form1.email.value;
    document.getElementById("result").setAttribute("style", "display: block; " +
                                                                                           "background-color:KhaKi;")
}