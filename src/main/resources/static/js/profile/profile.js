const modalPwModOpenButton = document.getElementById('pw_mod');
const modalIdModOpenButton = document.getElementById('id_mod');
const modalNickModOpenButton = document.getElementById('nick_mod');
const modalCloseButton = document.getElementById('modalClose');
const modal = document.getElementById('modalContainer');
const proceedToChange = document.getElementById('proceedToChange');
const modal2 = document.getElementById('modalContainer2');
const modalCloseButton2 = document.getElementById('modal2Close')
const modal1_title = document.getElementById('modal1-title')
const modaltitle = document.getElementById('modalTitle');
const modalDetail = document.getElementById('modalDetail');
const modal_input_option = document.getElementById('modal-input-option');
const modal_input_btn = document.getElementById('modal-input-btn')
const modal_input_form = document.getElementById('modal-input-form');
const usersPrivate = $("#usersPrivate");
modalPwModOpenButton.addEventListener('click', () => {
    modal1_title.innerText = 'Really change your password?';
    proceedToChange.innerText = 'I understand, let\'s change my password';
    modaltitle.childNodes.item(1).innerText = 'Enter a new password';
    modal_input_option.innerText = 'Please enter a new password.';
    modal_input_btn.innerText = 'Change my password';
    usersPrivate.attr('type','password');
    modal_input_form.setAttribute("data-type",'pass');
    modal.style.display = "flex";
});
modalIdModOpenButton.addEventListener('click', () => {
    modal1_title.innerText = 'Really change your id?';
    proceedToChange.innerText = 'I understand, let\'s change my id';
    modaltitle.childNodes.item(1).innerText = 'Enter a new id';
    modal_input_option.innerText = 'Please enter a new id';
    modal_input_btn.innerText = 'Change my id';
    modal_input_form.setAttribute("data-type",'id');
    usersPrivate.attr('type','text');
    modal.style.display = "flex";
});
modalNickModOpenButton.addEventListener('click', () => {
    modal1_title.innerText = 'Really change your nickname?';
    proceedToChange.innerText = 'I understand, let\'s change my nickname';
    modaltitle.childNodes.item(1).innerText = 'Enter a new nickname';
    modal_input_option.innerText = 'Please enter a new nickname';
    modal_input_btn.innerText = 'Change my nickname';
    modal_input_form.setAttribute("data-type",'nickname');
    usersPrivate.attr('type','text');
    modal.style.display = "flex";
});

modalCloseButton.addEventListener('click', () =>{
    usersPrivate.val("");
    $('#oldpass').val("");
    proceedToChange.disabled = true;
    modal.style.display = "none";
})

modal.addEventListener('click', () => {
    usersPrivate.val("");
    $('#oldpass').val("");
    proceedToChange.disabled = true;
    modal.style.display = "none";
});
proceedToChange.addEventListener('click', () => {
    usersPrivate.val("");
    $('#oldpass').val("");
    proceedToChange.disabled = true;
    modal.style.display = "none";
    modal2.style.display = "flex";
})
modal2.addEventListener('click', () => {
    usersPrivate.val("");
    $('#oldpass').val("");
    proceedToChange.disabled = true;
    modal2.style.display = "none";
})
modalCloseButton2.addEventListener('click', () => {
    usersPrivate.val("");
    $('#oldpass').val("");
    proceedToChange.disabled = true;
    modal2.style.display = "none";
})

const token = $("meta[name='_csrf']").attr("content");
const header = $("meta[name='_csrf_header']").attr("content");

function public_profile_submit(){
    const profile_form_data = $("#profile-form").serializeArray();
    const data_map = new Map();
    $.each(profile_form_data, function(index, field){
        data_map.set(field.name,field.value);
    });
    const confirmval = confirm("Are you sure you want to update your profile?");
    if(confirmval){
        $.ajax({
            url: '/user/profile/update',
            method: 'put',
            data: JSON.stringify(Object.fromEntries(data_map)), // Map을 일반 객체로 변환하고 JSON으로 변환하여 전달
            contentType: "application/json",
            beforeSend: function(xhr){
                console.log(token,header)
                xhr.setRequestHeader(header, token);
            },
            success:function(data){
                alert('profile updated successfully')
            },
        })
    }
}

function confirmpw(){
    $.ajax({
        url: '/user/passcheck',
        method: 'post',
        data: {
            password : $('#oldpass').val()
        },
        beforeSend: function(xhr){
            console.log(token,header)
            xhr.setRequestHeader(header, token);
        },
        success:function (data){
            if(data){
                proceedToChange.disabled = false;
            }else{
                proceedToChange.disabled = true;
                alert("check your password again")
            }
        }
    })
}

function modUsersPrivate(){
    const changePrivateType  = modal_input_form.getAttribute("data-type");
    const privateData = usersPrivate.val();
    $.ajax({
        url: "/user/change/"+changePrivateType,
        method: "post",
        data:{
            PrivateData : privateData
        },
        beforeSend: function(xhr){
            console.log(token,header)
            xhr.setRequestHeader(header, token);
        },
        success: function (data){
            console.log(data);
        }
    })
}

function deleteAjax(){
    const confirmval = confirm("Are you sure you want to update your profile?");
    const privateData = $("#useruid").val();
    console.log(privateData);
    if(confirmval) {
        $.ajax({
            url: "/user/delete",
            method: "delete",
            data: {
                PrivateData: privateData
            },
            beforeSend: function (xhr) {
                console.log(token, header)
                xhr.setRequestHeader(header, token);
            },
            success: function (data) {
                console.log(data);
            }
        })
    }
}

