$(document).ready(function(){
    $("#profileImage").click(
        function (){
            alert("Please select");
        })
})

let date = document.querySelector("#date");

// 문자열, 하이픈을 막기 위해 input event 사용
date.addEventListener("input", () => {

    // 사용자 입력값은 모두 숫자만 받는다.(나머지는 ""처리)
    let val = date.value.replace(/\D/g, "");
    let leng = val.length;

    // 출력할 결과 변수
    let result = '';

    // 5개일때 - 20221 : 바로 출력
    if(leng < 6) result = val;
    // 6~7일 때 - 202210 : 2022-101으로 출력
    else if(leng < 8){
        result += val.substring(0,4);
        result += "-";
        result += val.substring(4);
        // 8개 일 때 - 2022-1010 : 2022-10-10으로 출력
    } else{
        result += val.substring(0,4);
        result += "-";
        result += val.substring(4,6);
        result += "-";
        result += val.substring(6);
    }
    result = result.substring(0,10);
    date.value = result;

})