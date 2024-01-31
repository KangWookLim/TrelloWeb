const token = $("meta[name='_csrf']").attr("content");
const header = $("meta[name='_csrf_header']").attr("content");
function ajaxcheck(){
    $.ajax({
        type: "POST",
        url: "/user/check",
        data: {
            name : '조성연',
            age : 25
        },
        beforeSend: function(xhr){
            xhr.setRequestHeader(header, token);
        },
        success(){
            alert("성공")
        }
    })
}