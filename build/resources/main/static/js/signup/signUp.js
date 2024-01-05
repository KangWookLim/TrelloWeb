$(document).ready(function () {
        const urlParams = new URLSearchParams(window.location.search);
        const token = urlParams.get('token');
        console.log(token);
        if ($.trim(token).length === 0) {
            alert('Token Required');
            window.location.href = "/"

        }

        $.ajax({
            url : '/signup/chkToken',
            type : 'post',
            dataType : 'json',
            data : 'json',
            data : {
                token : token
            }
        }).done(function(data) {
            if (data === 0){
                console.log(data);
                alert ('The token is not valid');
                window.location.href = "/";
            }
            else {
                console.log(data);
            }
        }).fail(function (xhr, status, error) {
            alert('시스템에 문제가 발생했습니다. 관리자에게 문의해주세요.');
            console.log(status);
            console.log(error);
        })
    }
)

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

}