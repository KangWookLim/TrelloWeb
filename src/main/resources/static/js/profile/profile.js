
const modalOpenButton = document.getElementById('changePassword');
//const modalCloseButton = document.getElementById('modalCloseButton');
const modal = document.getElementById('modalContainer');

modalOpenButton.addEventListener('click', () => {
    modal.style.display = "flex";
});
modal.addEventListener('click', () => {
    modal.style.display = "none";
});
$(document).ready(function(){
    $("#profileImage").click(
        function (){
            alert("Please select");
        })
    $("#ID").val("hi");
    $("#password").val("123456");
    $("#email").val("eg@example.com");
    $("#firstName").val("Nakyeon");
    $("#lastName").val("Choi");
    $("#nickName").val("naknak99");
    $("#date").val("2000-01-01");
    $("#male").prop("checked",true);
    $("#bio").val("im fine thankyou");
    $("#social1").val("www.facebook.com");

})