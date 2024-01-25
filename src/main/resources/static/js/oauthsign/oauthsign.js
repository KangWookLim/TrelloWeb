let isNickNameDuplicate = true;
let isUserIdChk = true;
$(document).ready(function() {
    submitablecheck();
})

function userIdChk(){
    const ID = $('#ID').val();
    if ($.trim(ID).length === 0) {
        alert('아이디를 입력하십시오.');
        return false;
    }else if(ID.indexOf(" ") >= 0){
        alert('공백을 입력할 수 없습니다.')
        return
    }

    $.ajax({
        url : '/user/chkID',
        type : 'get',
        data :{
            id : ID
        }
    }).done(function (data){
        if (data === 0) {
            alert('사용가능한 아이디 입니다');
            isUserIdChk = false;
            submitablecheck()
        }
        else {
            alert('이미 등록된 아이디 입니다.');
        }
    })
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

const inputbox = $('.InputBox')

inputbox.click(function (){
    inputbox.each(function (index ,element){
        if(element.value !== "") {
            if (element.value.length < 3 || element.value.length > 20) {
                element.style.border = '2px solid palevioletred'
            } else if (element.value.indexOf(" ") >= 0) {
                element.style.border = '2px solid palevioletred'
                element.value = "";
                element.placeholder = "공백이 포함 되어있습니다"
            } else {
                element.style.border = '2px solid rgba(223,225,230,255)'
            }
        }else {
            element.style.border = '2px solid rgba(223,225,230,255)'
        }
    })
})
inputbox.blur(function (){
    inputbox.each(function (index ,element){
        if(element.value !== "") {
            if (element.value.length < 3 || element.value.length > 20) {
                element.style.border = '2px solid palevioletred'
            } else if (element.value.indexOf(" ") >= 0) {
                element.style.border = '2px solid palevioletred'
                element.value = "";
                element.placeholder = "공백이 포함 되어있습니다"
            } else {
                element.style.border = '2px solid rgba(223,225,230,255)'
            }
        }else{
            element.style.border = '2px solid rgba(223,225,230,255)'
        }
    })
})

const signup_btn = $('#signup-btn');
function submitablecheck(){
    if(isNickNameDuplicate){
        signup_btn.prop('disabled', true)
        signup_btn.css('background-color', 'gray')
    }else{
        signup_btn.prop('disabled', false)
        signup_btn.css('background-color', 'blue')
    }
}