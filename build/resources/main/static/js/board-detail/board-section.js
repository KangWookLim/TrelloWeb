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
let card_due_date_container = $("#card_due_date_container");
let card_due_date = document.getElementById("card_due_date");
let card_member_container = $("#card_member_container");
let card_members = $("#card_members");
let card_label_container = $("#card_label_container");
let card_labels = $("#card_labels");
let trello_attachments_container = $("#trello_attachments_container");
let board_attachment_container = $("#board_attachment_container");
let comments_container = $("#comments_container");
let cardTaskContainer = $("#card_task_container");


//db time format
function formatDateString(inputDateString) {
    // Create a Date object from the input string
    const dateObject = new Date(inputDateString);

    // Format the date to a string with the desired format
    const formattedDateString = dateObject.toLocaleString('en-US', {
        month: 'short',
        day: 'numeric',
        hour: 'numeric',
        minute: 'numeric',
        hour12: true,
    });

    return formattedDateString;
}
//
<<<<<<< HEAD
let openedCard;
=======

>>>>>>> main

function setAndShowModal (element){
    let cardId = element.getAttribute("cardid");
    openedCard = element.getAttribute("cardid").toString();
    console.log("Card " + openedCard + " is opened");
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
            card_due_date_container.show();
            card_due_date.innerText = formatDateString(data.due_date.toString());
        } else {
            card_due_date_container.hide();
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
    showComments(cardId);
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
        card_members.empty();
        if (data.length === 0){
            card_member_container.hide();
            console.log("no members for this card")
        } else {
            card_member_container.show();
            console.log("members detected");
            console.log(data.length + " is total members of card");

            for (var i = 0; i < data.length; i++) {
                var button = document.createElement("button");
                button.className = "card-member-detail";
                button.textContent = data[i].nickname;
                card_members.append(button);
            }

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
        card_labels.empty();
        if (data.length === 0){
            console.log("no labels for this card");
            card_label_container.hide();
        } else {
            card_label_container.show();
            console.log("labels detected");
            console.log(data.length + " is total labels of card");
            for (let i = 0; i < data.length; i++) {
                var span = document.createElement("span");
                span.className = "card-label";
                span.style.backgroundColor = data[i].color;
                span.textContent = data[i].title;
                card_labels.append(span);
            }
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
        if (data.length === 0){
            trello_attachments_container.hide();
            console.log("no attachments for this card")
        } else {
            trello_attachments_container.show();
            board_attachment_container.empty();
            console.log("attachments detected");
            console.log(data.length + " is total attachments of card");
            for(let i = 0; i < data.length; i++){
                const boardDiv = document.createElement('div');
                boardDiv.classList.add('canonical-board');

                const boardLink = document.createElement('a');
                boardLink.href = '#';
                boardLink.classList.add('canonical-board-link');

                const boardDetail = document.createElement('div');
                boardDetail.classList.add('canonical-board-detail');

                const h1 = document.createElement('h1');
                h1.innerText = data[i].board_name;

                const miniList = document.createElement('div');
                miniList.classList.add('mini-list');

                // Insert three mini-cards
                for (let j = 0; j < 3; j++) {
                    const miniCard = document.createElement('div');
                    miniCard.classList.add('mini-card');
                    miniList.appendChild(miniCard);
                }

                // Set background image for boardDetail
                boardDetail.style.backgroundImage = `linear-gradient(0deg, rgba(56, 66, 80, 0.7) 50%, rgba(56, 66, 80, 0.7) 0%), url(${data[i].image_url})`;

                // Append elements to the container
                boardDetail.appendChild(h1);
                boardDetail.appendChild(miniList);
                boardLink.appendChild(boardDetail);
                boardDiv.appendChild(boardLink);

                // Append the constructed boardDiv to the container with id board_attachment_container
                document.getElementById('board_attachment_container').appendChild(boardDiv);
            }
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
        cardTaskContainer.empty();
        if (data.length === 0){
            console.log("no task for this card")
        } else {
            console.log("tasks detected");
            console.log(data.length + " is total tasks of card");
            let tasksNum = data.length;
            for (let i = 0; i < tasksNum; i++){
                console.log( "Attempt loading task" + data[i].task_id +" items");
                const taskData = data[i];
                // card_task_inner 생성
                const cardTaskInner = document.createElement("div");
                cardTaskInner.id = "card_task_inner"+data[i].task_id;
                // card-description-header 생성
                const cardDescriptionHeader = document.createElement("div");
                cardDescriptionHeader.classList.add("card-description-header");
                // "Checklist" 대신 task의 title로 설정
                cardDescriptionHeader.innerHTML = `<span class="card-header-logo"><span data-testid="ChecklistIcon" aria-hidden="true" class="css-1aufzry" style="--icon-primary-color: inherit; --icon-secondary-color: inherit;"><svg width="24" height="24" role="presentation" focusable="false" viewBox="0 0 24 24" xmlns="http://www.w3.org/2000/svg"><path fill-rule="evenodd" clip-rule="evenodd" d="M6 4C4.89543 4 4 4.89543 4 6V18C4 19.1046 4.89543 20 6 20H18C19.1046 20 20 19.1046 20 18V13C20 12.4477 19.5523 12 19 12C18.4477 12 18 12.4477 18 13V18H6V6L16 6C16.5523 6 17 5.55228 17 5C17 4.44772 16.5523 4 16 4H6ZM8.73534 10.3223C8.36105 9.91618 7.72841 9.89038 7.3223 10.2647C6.91619 10.639 6.89039 11.2716 7.26467 11.6777L10.8768 15.597C11.4143 16.1231 12.2145 16.1231 12.7111 15.6264L13.0754 15.2683C13.3699 14.9785 13.6981 14.6556 14.0516 14.3075C15.0614 13.313 16.0713 12.3169 17.014 11.3848L17.0543 11.3449C18.7291 9.68869 20.0004 8.42365 20.712 7.70223C21.0998 7.30904 21.0954 6.67589 20.7022 6.28805C20.309 5.90022 19.6759 5.90457 19.2881 6.29777C18.5843 7.01131 17.3169 8.27244 15.648 9.92281L15.6077 9.96263C14.6662 10.8937 13.6572 11.8889 12.6483 12.8825L11.8329 13.6851L8.73534 10.3223Z" fill="currentColor"></path></svg></span></span>${taskData.title}<div style="margin-left: 380px"><a href="#" class="due-button" style="text-decoration: none">Delete</a></div>`;
                // card_task_inner에 card-description-header, checklist-progress 추가
                cardTaskInner.append(cardDescriptionHeader);
                // card_task_container에 card_task_inner 추가
                cardTaskContainer.append(cardTaskInner);
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
        var parentDiv = $("#card_task_inner" + taskId);
        var addItemLink = '<div style="margin-left: 40px"><a href="#" class="due-button">Add an item</a></div>';

        if (data.length === 0){
            console.log("no items for this task");
            parentDiv.append(addItemLink);
        } else {
            console.log("items detected for taskid");
            console.log(data.length + " is total items of task with taskId " + taskId);
            // 부모 div를 찾아서 변수에 할당

            var checklistProgress = `
    <div class="checklist-progress">
        <span class="checklist-progress-percentage">0%</span>
        <div class="checklist-progress-bar">
            <div id="checklist-progress-bar-current" style="width: 0%"></div>
        </div>
    </div>`;
            parentDiv.append(checklistProgress);
            // checklist-items-list를 추가
            var checklistItemsList = '<div class="checklist-items-list"></div>';
            parentDiv.append(checklistItemsList);
            for (var i = 0; i < data.length; i++) {
                var checkbox = '<div class="checklist-item-checkbox"><input type="checkbox" ' + (data[i].is_checked ? 'checked' : '') + '></div>';
                var detail = '<div class="checklist-item-detail">' + data[i].title + '</div>';

                // checklist-item을 생성하고 checklist-items-list에 추가
                var checklistItem = '<div class="checklist-item">' + checkbox + detail + '</div>';
                parentDiv.find('.checklist-items-list').append(checklistItem);
            }

// Add an item 링크 추가
            var addItemLink = '<div style="margin-left: 40px"><a href="#" class="due-button">Add an item</a></div>';
            parentDiv.append(addItemLink);


// checklist-progress-bar 업데이트
            var percentage = 60; // 실제로 사용하는 퍼센티지로 변경 필요
            parentDiv.find('.checklist-progress-percentage').text(percentage + '%');
            parentDiv.find('#checklist-progress-bar-current').css('width', percentage + '%');



        }
    }).fail(function (xhr, status, error){
        console.log("error loading tasks for card");
        console.log(status);
    });
}

function createCommentElement(commentData) {
    var formattedDate = formatDateString(commentData.created_date);
    return `
    <div class="phenom-comment">
        <button class="card-member-detail" style="margin-left: -40px">${commentData.nickname}</button>
        <div class="phenom-desc">
            <span>${commentData.nickname}</span>
            <span class="inline-spacer"></span>
            <span style="font-size: 12px; color: #9fadbc;">${formattedDate}</span>
            <div class="comment">
                <div class="current-comment">
                    <p style="margin: 0;">${commentData.comment}</p>
                </div>
            </div>
        </div>
        <div class="phenom-reactions"></div>
    </div>
  `;
}
function showComments(cardId) {
    $.ajax({
        type : 'get',
        url : '/card_detail/comment',
        data : {
            "cardid" : cardId
        }
    }).done(function (data){
        comments_container.empty();
        if (data.length === 0){
            console.log("no comments");
        } else {
            console.log("comments found");
            for (let i = 0; i < data.length; i++) {
                var commentElement = createCommentElement(data[i]);
                comments_container.append(commentElement);
            }
        }
    }).fail(function (xhr, status, error){
        console.log("error loading labels for card");
        console.log(status);
    });
}



<<<<<<< HEAD
 //due-date value out check
let date = $("#due-date");
$('#due-date-save').click(function () {
    if (date.val().length === 0){
        alert("Please enter a due date");
    } else {
        $.ajax({
            type : 'get',
            url : "/card_detail/updateDueDate",
            data : {
                "card_id" : openedCard,
                "due_date" : date.val()
            }
        }).done(function (data) {
            if (data === 1){
                console.log("update successful");
            }
        }).fail(function (xhr, status, error){
            console.log("error updating due date");
            console.log(status);
        });
    }
})

$('#due-date-remove').click(function(){
    $.ajax({
        type : 'get',
        url : "/card_detail/removeDueDate",
        data : {
            "card_id" : openedCard
        }
    }).done(function (data) {
        if (data === 1){
            console.log("update successful");
        }
    }).fail(function (xhr, status, error){
        console.log("error updating due date");
        console.log(status);
    });
})
$('#insertChecklist').click(function(){
    let checklistValue = $('#checklist-value').val();
    $.ajax({
        type : 'get',
        url : "/card_detail/insertChecklist",
        data : {
            "card_id" : openedCard,
            "checklist_value" : checklistValue
        }
    }).done(function (data) {
        if (data === 1){
            console.log("insert successful");
        }
    }).fail(function (xhr, status, error){
        console.log("error adding checklist");
        console.log(status);
    });
})

//open and close sidebar modals
$('.card-sidebar-button').click(function (){
=======
/* //due-date value out check
let date = $("#due-date");
function checkdatetime(){
    console.log(date.val());
}*/

//open and close sidebar modals
$('.card-sidebar-button').click(function (event){
    event.preventDefault();
>>>>>>> main

    var linkText = $(this).text().toLowerCase();
    console.log(linkText);
    if (linkText === "members"){
        openMembersModal();
    }
    else if (linkText === "labels") {
        openLabelsModal();
    }
    else if (linkText === "checklist") {
        openChecklistModal();
    }
    else if (linkText === "dates") {
        openDatesModal();
    }
    else if (linkText === "attachment") {
        openAttachmentModal();
    }
    /*else if (linkText === "cover") {
        console.log("labels clicked");
    }*/
    else {
        console.log("yet no functions available")
    }
})

function openMembersModal(){

    $('#card-sidebar-button-members').toggle();
}
<<<<<<< HEAD
function removeMemberFromCard(element){
    let memberid = element.getAttribute("user_uid");
    console.log(memberid);
    $.ajax({
        type : 'get',
        url : "/card_detail/removeMember",
        data : {
            "user_uid" : memberid,
            "cardid" : openedCard
        }
    }).done(function (data) {
        if (data === 1){
            console.log("deletion successful");
        }
        else if (data === 0){
            console.log("member not found");
            addMemberToCard(memberid, openedCard);
        }
    }).fail(function (XHR, Status, error) {
        console.log("deletion failed");
        console.log(error);
    })
    console.log(openedCard + " is current card number");
}

function addMemberToCard(user_uid, card_id){

    console.log("user_uid : "+user_uid);
    console.log("card_id : "+card_id);
    console.log("lets add member");
    $.ajax({
        url : '/card_detail/addMember',
        type : 'get',
        data : {
            "user_uid" : user_uid,
            "card_id" : card_id
        }
    }).done(function (data){
        console.log("add user completed");
    }).fail(function (xhr, status, error) {
        alert('add user failed');
        console.log(status);
    });
}

=======
>>>>>>> main
function openLabelsModal() {
    $('#card-sidebar-button-labels').toggle();
}
function openChecklistModal() {
    $('#card-sidebar-button-Checklist').toggle();
}
function openDatesModal() {
    $('#card-sidebar-button-dates').toggle();
}
function openAttachmentModal() {
    $('#card-sidebar-button-attachment').toggle();
}

function openCoverModal() {
    $('#card-sidebar-button-members').toggle();
}