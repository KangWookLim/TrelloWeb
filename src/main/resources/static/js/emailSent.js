$(document).ready(function () {
    const urlParams = new URLSearchParams(window.location.search);
    const userEmail = urlParams.get('email');
    $('#email').text(userEmail);
    $.ajax({
        url: '/mail', // 이메일 전송을 처리하는 서버 엔드포인트
        method: 'POST',
        contentType: 'text/plain', // 데이터 타입을 텍스트로 설정
        data: userEmail,
        success: function () {
            console.log('이메일 전송 성공');
        },
        error: function () {
            console.error('이메일 전송에 실패했습니다.');
        }
    });



})