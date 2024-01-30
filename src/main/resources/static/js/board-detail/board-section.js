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
    $.ajax({
        type: 'get',
        url : '/card_detail',
        data : {
            "cardid" : cardId
        }
    }).done(function (data){
        console.log("success");
        console.log(data.description);
        card_name.value = data.name;
        card_description.value = data.description;
        if (data.due_date != null){
            card_due_date.innerText = data.due_date.toString();
        }
        console.log(data.due_date);
    }).fail(function (xhr, status, error) {
        alert('Unexpected error. Please contact System Administrator for ');
        console.log(status);

    });
    showMembers(cardId);
    showLabels(cardId);
    showAttachments(cardId);
    showTasks(cardId);
    modalBackground.style.display = "flex";
    event.stopPropagation();
}
//멤버 로딩
function showMembers(cardId) {
    $.ajax({
        type : 'get',
        url : '/card_detail/member',
        data : {
            "cardid" : cardId
        }
    }).done(function (data){
        if (data == null){
            console.log("no members for this card")
        } else {
            console.log("members detected");
            console.log(data.length + " is total members of card");
        }
    }).fail(function (xhr, status, error){
       console.log("error loading members for card");
       console.log(status);
    });
}

function showLabels(cardId) {
    $.ajax({
        type : 'get',
        url : '/card_detail/label',
        data : {
            "cardid" : cardId
        }
    }).done(function (data){
        if (data == null){
            console.log("no labels for this card")
        } else {
            console.log("labels detected");
            console.log(data.length + " is total labels of card");
        }
    }).fail(function (xhr, status, error){
        console.log("error loading labels for card");
        console.log(status);
    });
}

function showAttachments(cardId) {
    $.ajax({
        type : 'get',
        url : '/card_detail/attachment',
        data : {
            "cardid" : cardId
        }
    }).done(function (data){
        if (data == null){
            console.log("no attachments for this card")
        } else {
            console.log("attachments detected");
            console.log(data.length + " is total attachments of card");
        }
    }).fail(function (xhr, status, error){
        console.log("error loading attachments for card");
        console.log(status);
    });
}

function showTasks(cardId) {
    $.ajax({
        type : 'get',
        url : '/card_detail/task',
        data : {
            "cardid" : cardId
        }
    }).done(function (data){
        if (data == null){
            console.log("no task for this card")
        } else {
            console.log("tasks detected");
            console.log(data.length + " is total tasks of card");
            let tasksNum = data.length;
            for (let i = 0; i < tasksNum; i++){
                console.log( "Attempt loading task" + data[i].task_id +" items");
                showTaskItems(data[i].task_id);
            }

        }
    }).fail(function (xhr, status, error){
        console.log("error loading tasks for card");
        console.log(status);
    });
}

function showTaskItems(taskId) {
    $.ajax({
        type : 'get',
        url : '/card_detail/task_items',
        data : {
            "taskid" : taskId
        }
    }).done(function (data){
        if (data == null){
            console.log("no items for this task")
        } else {
            console.log("items detected for taskid");
            console.log(data.length + " is total tasks of card");
        }
    }).fail(function (xhr, status, error){
        console.log("error loading tasks for card");
        console.log(status);
    });
}