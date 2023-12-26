let isUserEmailChk = false;

function userEmailChk() {
    const Email = $('#email').val();
    isUserEmailChk = false;
    if ($.trim(Email).length === 0) {
        alert('이메일을 입력하십시오.');
        return false;
    }

    $.ajax({
        url : '/user/chkEmail',
        type : 'post',
        dataType : 'json',
        data : 'json',
        data :{
            Email : Email
        }
    }).done(function (data){
        if (data === 0) {
            console.log(data);
            alert('사용가능한 이메일 입니다');
            window.location.href = "/emailSent?email=" + encodeURIComponent($('#email').val());
        }
        else {
            console.log(data);
            alert('이미 등록된 이메일 입니다.');
            window.location.href = "/login";
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

