$(document).ready(function(){
    $("#profileImage").click(
        function (){
            alert("Please select");
        })
    /*$(".mandatory").blur(function (){
        alert("please fill in the required fields");
    })*/

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

document.addEventListener("DOMContentLoaded", function(){

    const mandatoryInputs = document.querySelectorAll('.mandatory');
    mandatoryInputs.forEach(function(input){
        input.addEventListener("blur",checkInputMandatory);
        input.addEventListener("click",restoreInput);
    });



    function checkInputMandatory(event){
        let input = event.target;
        let abcd = input.getAttribute("abcd");
        console.log(abcd);
        if (input.value === ""){
            input.style.border = "1px solid red";
        }

    }

    function restoreInput(event){
        let input = event.target;
        input.style.border = "1px solid lightgray";

    }

})
