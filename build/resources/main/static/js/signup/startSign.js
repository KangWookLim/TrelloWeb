let isUserEmailChk = false;

function userEmailChk() {
    const Email = $('#email').val();
    isUserEmailChk = false;
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
        }
        else {
            console.log(data);
            alert('이미 등록된 이메일 입니다.');
            window.location.href = "/user/startSign";
        }
    }).fail(    function (xhr, status, error) {
        alert('시스템에 문제가 발생했습니다. 관리자에게 문의해주세요.');
        console.log(status);
    })
}



$(document).ready(function () {
    const urlParams = new URLSearchParams(window.location.search);
    const userEmail = urlParams.get('email');
    $('#email').val(userEmail);

})

