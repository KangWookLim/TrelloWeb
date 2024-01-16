let isNickNameDuplicate = true;
let  isUserEmailChk = true;
function getCSRFToken() {
    const metaTag = document.querySelector('meta[name="_csrf"]');
    return metaTag ? metaTag.getAttribute('content') : '';
}
$(document).ready(function() {
    submitablecheck();
})

const alphabetInputs = document.querySelectorAll('.alphabetOnly');
alphabetInputs.forEach(function(input) {
    input.addEventListener("input", () => {
        let val = input.value.replace(/[^a-zA-Z]/g,"");
        input.value = val;
    })

});

let nickNameInput = document.querySelector("#nickname");

nickNameInput.addEventListener("input", () => {
    let val = nickNameInput.value.replace(/[^a-zA-Z0-9]/g,"");
    nickNameInput.value = val;
})
function userIDCheck() {
    const id = $('#id').val();
    if(id.trim()===""){
        alert("아이디를 입력해주세요")
        return
    }else if(id.indexOf(" ")>=0){
        alert("공백이 포함될 수 없습니다")
        return
    }
    $.ajax({
        url : '/user/idcheck',
        type : 'get',
        data : {
            id : id
        }
    }).done(function (data){
        if(data === 0) {
            alert('사용 가능합니다');
            isIDDuplicate = false;
            submitablecheck()

        }else {
            alert('중복된 아이디입니다.');
        }
    }).fail(function (xhr, status, error) {
        alert('Unexpected error. Please contact System Administrator for ');
        console.log(status);
    });
}

function userNickCheck(){
    const nick = $('#nickname').val();
    if(nick.trim()===""){
        alert("닉네임을 입력해주세요")
        return
    }else if(nick.indexOf(" ")>=0){
        alert("공백이 포함될 수 없습니다")
        return
    }
    $.ajax({
        url : '/user/nickcheck',
        type : 'get',
        data : {
            nick : nick
        }
    }).done(function (data){
        if(data === 0) {
            alert('사용 가능합니다');
            isNickNameDuplicate = false;
            submitablecheck()
        }else {
            alert('중복된 닉네임입니다.');
        }
    }).fail(function (xhr, status, error) {
        alert('Unexpected error. Please contact System Administrator for ');
        console.log(status);
    });
}

function userPhoneCheck(){
    const phone = $('#phone').val();
    if(phone.trim()===""){
        alert("닉네임을 입력해주세요")
        return
    }else if(phone.indexOf(" ")>=0){
        alert("공백이 포함될 수 없습니다")
        return
    }
    $.ajax({
        url : '/user/phonecheck',
        type : 'get',
        data : {
            phone : phone
        }
    }).done(function (data){
        if(data === 0) {
            alert('사용 가능합니다');
            isPhoneNumberDuplicate = false;
            submitablecheck()
        }else {
            alert('중복된 연락처입니다.');
        }
    }).fail(function (xhr, status, error) {
        alert('Unexpected error. Please contact System Administrator for ');
        console.log(status);
    });
}

const inputbox = $('.InputBox')

inputbox.click(function (){
    inputbox.each(function (index ,element){
        if(element.value.trim() === ""|| (element.value.length < 3 || element.value.length > 20)){
            element.style.border = '2px solid palevioletred'
        }else if(element.value.indexOf(" ") >= 0){
            element.style.border = '2px solid palevioletred'
            element.value = "";
            element.placeholder = "공백이 포함 되어있습니다"
        }else{
            element.style.border = '2px solid rgba(223,225,230,255)'
        }
    })
})

function userEmailChk() {
    const Email = $('#EMAIL').val();
    if ($.trim(Email).length === 0) {
        alert('이메일을 입력하십시오.');
        return false;
    }else if(Email.indexOf(" ") >= 0){
        alert('공백을 입력할 수 없습니다.')
        return
    }

    $.ajax({
        url : '/user/chkEmail',
        type : 'get',
        data :{
            email : Email
        }
    }).done(function (data){
        if (data === 0) {
            alert('사용가능한 이메일 입니다');
            isUserEmailChk = false;
            submitablecheck()
        }
        else {
            alert('이미 등록된 이메일 입니다.');
        }
    })
}
const signup_btn = $('#signup-btn');
function submitablecheck(){
    if(isNickNameDuplicate||isIDDuplicate||isPhoneNumberDuplicate||isUserEmailChk){
        signup_btn.prop('disabled', true)
        signup_btn.css('background-color', 'gray')
    }else{
        signup_btn.prop('disabled', false)
        signup_btn.css('background-color', 'blue')
    }
}


// $(document).ready(function () {
//         const urlParams = new URLSearchParams(window.location.search);
//         const token = urlParams.get('token');
//         console.log(token);
//         if ($.trim(token).length === 0) {
//             alert('Token Required');
//             window.location.href = "/"
//
//         }
//
//         $.ajax({
//             url : '/signup/chkToken',
//             type : 'post',
//             dataType : 'json',
//             data : 'json',
//             data : {
//                 token : token
//             }
//         }).done(function(data) {
//             if (data === 0){
//                 console.log(data);
//                 alert ('The token is not valid');
//                 window.location.href = "/";
//             }
//             else {
//                 console.log(data);
//             }
//         }).fail(function (xhr, status, error) {
//             alert('시스템에 문제가 발생했습니다. 관리자에게 문의해주세요.');
//             console.log(status);
//             console.log(error);
//         })
//     }
// )