const board_style_btn = $('.content-header-board-style-icon');
const board_style_list = $('.board-style-section');
board_style_btn.click(function () {
    if(board_style_list.css('display') === 'none'){
        board_style_list.css('display','flex');
    }else{
        board_style_list.css('display','none');
    }
})



const style_board = $("#style-board");
const style_calender = $("#style-calender");
const style_timeline = $("#style-timeline");
style_board.click(function (){
    if(style_board.prop('checked')===true){
        style_board.prop('checked',true);
        style_calender.prop('checked',false);
        style_timeline.prop('checked',false);
    }else{
        style_board.prop('checked',true);
    }
});
style_calender.click(function (){
    if(style_calender.prop('checked')===true){
        style_calender.prop('checked',true);
        style_board.prop('checked',false);
        style_timeline.prop('checked',false);
    }else{
        style_calender.prop('checked',true);
    }
})
style_timeline.click(function (){
    if(style_timeline.prop('checked')===true){
        style_timeline.prop('checked',true);
        style_calender.prop('checked',false);
        style_board.prop('checked',false);
    }else{
        style_timeline.prop('checked',true);
    }
})


//focus 걸기
/*const style_form = $('.list-add-container-form');
const focusme = $('#focusme')
style_form.click(function (){
    focusme.focus();
})*/
const list_add_btn = $('.list-add-btn');
const list_add_container = $('.list-add-container');
const content_container  = $('.content-container');
const list_add_card_button = $('.list-add-card-button');
let allAddCardSections = $('.add-card-section');
list_add_btn.click(function (){
    list_add_btn.hide();
    list_add_container.show();
    event.stopPropagation();
    console.log("h2");
})

list_add_container.click(function () {
    event.stopPropagation();
    }
)
content_container.click(function () {
    list_add_container.hide();
    list_add_btn.show();
    /*add-card-section 클래스 히든 걸기*/
    /*if (allAddCardSections.length > 0) {
        allAddCardSections.setAttribute('hidden', 'true');
    }*/
    console.log("h3");
})

$( function () {
    $('.list-container').sortable({
        cancel: ".not-sortable"
    });
});

$( function () {
    $('.cards-section').sortable({
        connectWith : ".cards-section"
    })
})

function addListToBoard(event) {
    var formElement = event.target.closest('form');
    var textareaElement = formElement.querySelector('.list-textarea');
    var textareaValue = textareaElement.value;
    if (textareaValue !== "" && textareaValue !== null){
        var listFrame = document.getElementById("listFrame");
        var clone = listFrame.content.cloneNode(true);
        clone.querySelector('.list-textarea').value = textareaValue;
        document.querySelector(".list-container").appendChild(clone);
        document.querySelector(".list-container").style.padding = "12px 12px 0";
        $('.cards-section').sortable({
            connectWith : ".cards-section"
        })
        list_add_container.hide();
        list_add_btn.show();
    }
}

function showAddCard(event) {
    var listAddCard = event.target.closest('.list-add-card');
    console.log(listAddCard);
    var list = listAddCard.closest('.list-detail');
    console.log(list)
    var addCardSection = list.querySelector('.add-card-section');
    addCardSection.removeAttribute('hidden');
    event.stopPropagation();

}

const modalBackground = document.getElementById("card-background");
const modalContainer = document.getElementById("card-container");

modalBackground.addEventListener('click', () => {
    modalBackground.style.display = "none";
});

modalContainer.addEventListener('click', () => {
    event.stopPropagation();
})

//modal 변수 및 함수 선언
//modal id는 언더바 사용
let card_name = document.getElementById("card_name");
let card_list_id = document.getElementById("card_list_id");
let card_description = document.getElementById("card_description");
let card_due_date = document.getElementById("card_due_date");



function setAndShowModal (element){
    let cardId = element.getAttribute("cardid");
    console.log(cardId);
    let CardDetailVo = null;
    /*$.ajax({
        type: 'get',
        url : '/card_detail',
        data : {
            "cardid" : cardId
        }
    }).done(function (data){
        CardDetailVo = data;
    }).fail(function (xhr, status, error) {
        alert('Unexpected error. Please contact System Administrator for ');
        console.log(status);
    });*/
    if (CardDetailVo == null){
        console.log("vo is null")
    }
    else {
        console.log("vo is not null")
    }
    modalBackground.style.display = "flex";
    event.stopPropagation();
}

/*
// Assuming cardVo is the received object from AJAX
var cardVo = receivedData.cardVo;

// Assuming you have a container div to hold all comments
var commentsContainer = $("#commentsContainer");

// Function to add a single comment to the container
function addCommentToContainer(commentVo) {
    var commentDiv = $("<div>").addClass("phenom-comment");
    var button = $("<button>").addClass("card-member-detail").text("b1").css("margin-left", "-40px");
    var descDiv = $("<div>").addClass("phenom-desc");

    // Assuming commentVo has properties like 'author', 'timestamp', and 'detail'
    var authorSpan = $("<span>").text(commentVo.author);
    var timestampSpan = $("<span>").text(commentVo.timestamp).css({"font-size": "12px", "color": "#9fadbc"});

    var commentDivInner = $("<div>").addClass("comment");
    var currentCommentDiv = $("<div>").addClass("current-comment");
    var commentParagraph = $("<p>").text(commentVo.detail).css("margin", "0");

    currentCommentDiv.append(commentParagraph);
    commentDivInner.append(currentCommentDiv);

    descDiv.append(authorSpan, $("<span>").addClass("inline-spacer"), timestampSpan, commentDivInner);

    commentDiv.append(button, descDiv, $("<div>").addClass("phenom-reactions"));

    // Append the comment div to the container
    commentsContainer.append(commentDiv);
}

// Loop through card_commentVoList and add each comment to the container
cardVo.card_commentVoList.forEach(function(commentVo) {
    addCommentToContainer(commentVo);
});
*/
