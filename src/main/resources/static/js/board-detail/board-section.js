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
    let allAddCardSection = $('.add-card-section');
    allAddCardSection.attr('hidden', true);
    console.log("h3");
})

function addCard(element){
    let openedList = element.getAttribute("listid");
    let textarea = element.parentNode.querySelector('.list-card-title');
    let cardtitle = textarea.value;
    console.log(cardtitle);
    $.ajax({
        url : '/card_detail/get_orderMax',
        type : 'get',
        data : {
            "list_id" : openedList
        }
    }).done(function (data){
        console.log(data + " is max number of order of cards from list " + openedList);
        let order = data;
        $.ajax({
            url : '/card_detail/addCardtoList',
            type : 'get',
            data : {
                "list_id" : openedList,
                "card_name" : cardtitle,
                "card_order" : order + 1
            }
        }).done(function (data){
            console.log("card is added to list " + openedList);
            location.reload();
        }).fail(function (xhr, status, error){
            console.log("error getting max order");
        })
    }).fail(function (xhr, status, error){
        console.log("error getting max order");
    })
}


$( function () {
    $('.list-container').sortable({
        cancel: ".not-sortable",
        update : function(event, ui){
            let movedListItem = ui.item.attr("listid");
            console.log(movedListItem + " is moved");
            let boardLists = ui.item.parent().children().map(function () {
                return $(this).attr("listid");
            }).get();
            console.log(boardLists);
            for (let i = 0; i < boardLists.length; i++) {
                $.ajax({
                    url : '/list_detail/reorderList',
                    type : 'get',
                    data : {
                        "list_id" : boardLists[i],
                        "order" : i + 1
                    }
                }).done(function (){
                    console.log(boardLists[i] + "'s new order = " + i);
                }).fail(function (xhr, status, error){
                    console.log("error reordering list");
                    console.log(error);
                })
            }
        }
    });
});

$( function () {
    $('.cards-section').sortable({
        connectWith : ".cards-section",
        update : function(event, ui){
            if (this === ui.item.parent()[0]) {
                let movedCardItem = ui.item.attr("cardid");
                let destinationList = ui.item.parent().parent().parent().parent().attr("listid");
                $.ajax({
                    url : '/card_detail/moveCard',
                    type : 'get',
                    data : {
                        "card_id" : movedCardItem,
                        "list_id" : destinationList
                    }
                }).done(function(){
                    let listItems = ui.item.parent().children().map(function () {
                        return $(this).attr("cardid");
                    }).get();
                    for(let i = 0; i < listItems.length; i++){
                        $.ajax({
                            url : '/card_detail/reorderCard',
                            type : 'get',
                            data : {
                                "card_id" : listItems[i],
                                "order" : i + 1
                            }
                        }).done(function(){
                            console.log(listItems[i] + " new order = " + i);
                        }).fail(function(xhr, status, error){
                            console.log("error reordering card");
                            console.log(error);
                        })
                    }

                }).fail(function(xhr, status, error){
                    console.log("error moving card");
                    console.log(error);
                });
            }

        }
    })
})

function addListToBoard(event, element) {
    let boardId = element.getAttribute("board_id");
    console.log(boardId + " is current board id");
    var formElement = event.target.closest('form');
    var textareaElement = formElement.querySelector('.list-textarea');
    var textareaValue = textareaElement.value;
    //listframe을 직접 추가하는 방식
    /*if (textareaValue !== "" && textareaValue !== null){
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
    }*/
    //페이지 새로고침으로 해결
    if (textareaValue !== "" && textareaValue !== null){
        $.ajax({
            url : '/list_detail/getMaxListOrder',
            type : 'get',
            data : {
                "board_id" : boardId
            }
        }).done(function (data) {
            console.log(data + " is max order of list in board " + boardId);
            let maxOrder = data;
            console.log(maxOrder + " order");
            $.ajax({
                url : '/list_detail/addList',
                type : 'get',
                data : {
                    "list_name" : textareaValue,
                    "board_id" : boardId,
                    "order" : maxOrder + 1
                }
            }).done(function () {
                location.reload();
            }).fail(function (xhr, status, error) {
                console.log("error adding list");
                console.log(error);
            })
        }).fail(function (xhr, status, error) {
            console.log("error getting order of lists");
            console.log(error);
        })
        /*$.ajax({
            url : '/list_detail/addList',
            type : 'get',
            data : {
                "list_name" : textareaValue,
                "board_id" : boardId
            }
        }).done(function (data) {
            location.reload();
        }).fail(function (xhr, status, error) {
            console.log("error adding list");
            console.log(error);
        })*/
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
    location.reload();
    /*modalBackground.style.display = "none";*/
});

modalContainer.addEventListener('click', () => {
    event.stopPropagation();
})

//modal 변수 및 함수 선언
//modal id는 언더바 사용
let card_name = document.getElementById("card_name");
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
let card_banner = $(".card-banner");
let card_list_id = $('#card_list_id');


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

const backgroundImages = [
    "url('https://trello-backgrounds.s3.amazonaws.com/SharedBackground/1358x1920/c4b12af65970ab36e306a792eb9b5b92/photo-1705154580249-55990fe3a8fb.jpg')",
    "url('https://trello-backgrounds.s3.amazonaws.com/SharedBackground/1281x1920/a42fd455c005dcfad21cd1ee5f892bc4/photo-1705336402584-b5deb3aa6cd2.jpg')",
    "url('https://trello-backgrounds.s3.amazonaws.com/SharedBackground/1280x1920/69663f756c39f078810be5fbe2a8c5af/photo-1705445826760-f020a78b4023.jpg')",
    "url('https://trello-backgrounds.s3.amazonaws.com/SharedBackground/1280x1920/ec75dd1c8e20f8ffcd64191ead8d26f1/photo-1705312409574-a2e2b0d11d61.jpg')"
]
$(document).ready(function(){
    for (let i = 0; i < backgroundImages.length; i++){
        console.log(backgroundImages[i]);
    }
    let backgroundUrl = $('.content-container').css('background-image');
    backgroundUrl = backgroundUrl.replace(/^url\(["']?/, '').replace(/["']?\)$/, '').trim();
    switch (backgroundUrl){
        case "https://images.unsplash.com/photo-1705154580249-55990fe3a8fb?crop=entropy&cs=tinysrgb&fit=max&fm=jpg&ixid=M3w3MDY2fDB8MXxjb2xsZWN0aW9ufDF8MzE3MDk5fHx8fHwyfHwxNzA1NjM1ODc1fA&ixlib=rb-4.0.3&q=80&w=400" :
            $('.content-container').css('background-image', backgroundImages[0]);
            break;
        case "https://images.unsplash.com/photo-1705336402584-b5deb3aa6cd2?crop=entropy&cs=tinysrgb&fit=max&fm=jpg&ixid=M3w3MDY2fDB8MXxjb2xsZWN0aW9ufDJ8MzE3MDk5fHx8fHwyfHwxNzA1NjM1ODc1fA&ixlib=rb-4.0.3&q=80&w=400" :
            $('.content-container').css('background-image', backgroundImages[1]);
            break;
        case "https://images.unsplash.com/photo-1705445826760-f020a78b4023?crop=entropy&cs=tinysrgb&fit=max&fm=jpg&ixid=M3w3MDY2fDB8MXxjb2xsZWN0aW9ufDN8MzE3MDk5fHx8fHwyfHwxNzA1NjM1ODc1fA&ixlib=rb-4.0.3&q=80&w=400" :
            $('.content-container').css('background-image', backgroundImages[2]);
            break;
        case "https://images.unsplash.com/photo-1705312409574-a2e2b0d11d61?crop=entropy&cs=tinysrgb&fit=max&fm=jpg&ixid=M3w3MDY2fDB8MXxjb2xsZWN0aW9ufDR8MzE3MDk5fHx8fHwyfHwxNzA1NjM1ODc1fA&ixlib=rb-4.0.3&q=80&w=400" :
            $('.content-container').css('background-image', backgroundImages[3]);
            break;
        default :
            console.log("no match");
    }
    $('.content-container').css('background-image')
    console.log(backgroundUrl);
});

function setDueDate(date) {
    if (date != null){
        card_due_date_container.show();
        card_due_date.innerText = formatDateString(date.toString());
    } else {
        card_due_date_container.hide();
    }
}

//
let openedCard;


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
        console.log(data.listname);
        card_list_id.text(data.listname);
        card_name.value = data.name;
        card_description.value = data.description;
        let coverColor = data.cover;
        console.log(coverColor);
        setCoverColor(coverColor);
        setDueDate(data.due_date);
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

function removeList(element){
    let listId = element.getAttribute("listId");
    console.log(listId);
    $.ajax({
        url : '/list_detail/removeList',
        type : 'get',
        data : {
            "listId": listId
        }
    }).done(function (){
        console.log("list " + listId+ "removed");
        let grandParent = element.parentNode.parentNode.parentNode;
        grandParent.parentNode.removeChild(grandParent);
    }).fail(function (xhr, status, error){
        console.log("error removing list")
    })
    event.stopPropagation();
}

function deleteCard(){
    $.ajax({
        type: "get",
        url : '/card_detail/deleteCard',
        data : {
            "cardId" : openedCard
        }
    }).done(function(data){
        console.log("successfully deleted task " + openedCard + " from list");
        location.reload();
    }).fail(function (xhr, status, error){
        console.log("error deleting task from card");
    })
}

function deleteTask(element){
    let taskId = element.dataset.task_id;
    console.log(taskId);
    $.ajax({
        type: "get",
        url : '/card_detail/deleteTask',
        data : {
            "taskId" : taskId
        }
    }).done(function(data){
        showTasks(openedCard);
        console.log("successfully deleted task " + taskId + " from card");
    }).fail(function (xhr, status, error){
        console.log("error deleting task from card");
    })
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
            console.log("no task for this card");
        } else {
            console.log("tasks detected");
            console.log(data.length + " is total tasks of card");
            let tasksNum = data.length;
            for (let i = 0; i < tasksNum; i++){
                console.log( "Attempt loading task" + data[i].task_id +" items");
                const taskData = data[i];
                // card_task_inner 생성
                const cardTaskInner = document.createElement("div");
                let task_id = data[i].task_id;
                cardTaskInner.id = "card_task_inner"+task_id;
                // card-description-header 생성
                const cardDescriptionHeader = document.createElement("div");
                cardDescriptionHeader.classList.add("card-description-header");
                // "Checklist" 대신 task의 title로 설정
                cardDescriptionHeader.innerHTML = `<span class="card-header-logo"><span data-testid="ChecklistIcon" aria-hidden="true" class="css-1aufzry" style="--icon-primary-color: inherit; --icon-secondary-color: inherit;"><svg width="24" height="24" role="presentation" focusable="false" viewBox="0 0 24 24" xmlns="http://www.w3.org/2000/svg"><path fill-rule="evenodd" clip-rule="evenodd" d="M6 4C4.89543 4 4 4.89543 4 6V18C4 19.1046 4.89543 20 6 20H18C19.1046 20 20 19.1046 20 18V13C20 12.4477 19.5523 12 19 12C18.4477 12 18 12.4477 18 13V18H6V6L16 6C16.5523 6 17 5.55228 17 5C17 4.44772 16.5523 4 16 4H6ZM8.73534 10.3223C8.36105 9.91618 7.72841 9.89038 7.3223 10.2647C6.91619 10.639 6.89039 11.2716 7.26467 11.6777L10.8768 15.597C11.4143 16.1231 12.2145 16.1231 12.7111 15.6264L13.0754 15.2683C13.3699 14.9785 13.6981 14.6556 14.0516 14.3075C15.0614 13.313 16.0713 12.3169 17.014 11.3848L17.0543 11.3449C18.7291 9.68869 20.0004 8.42365 20.712 7.70223C21.0998 7.30904 21.0954 6.67589 20.7022 6.28805C20.309 5.90022 19.6759 5.90457 19.2881 6.29777C18.5843 7.01131 17.3169 8.27244 15.648 9.92281L15.6077 9.96263C14.6662 10.8937 13.6572 11.8889 12.6483 12.8825L11.8329 13.6851L8.73534 10.3223Z" fill="currentColor"></path></svg></span></span><span style="width: 50px">${taskData.title}</span><div style="margin-left: 380px"><a href="#" class="due-button" onclick="deleteTask(this)" style="text-decoration: none" data-task_id="${task_id}" >Delete</a></div>`;
                //
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
    //get percentage value of items within task
    let tmppercentage;
    $.ajax({
        type : 'get',
        url : '/card_detail/task_items_percent',
        data : {
            "taskid" : taskId
        }
    }).done(function(data){
       tmppercentage = data;
       console.log(tmppercentage + "%");
        $.ajax({
            type : 'get',
            url : '/card_detail/task_items',
            data : {
                "taskid" : taskId
            }
        }).done(function (data){
            var parentDiv = $("#card_task_inner" + taskId);
            var addItemLink = '<div style="margin-left: 40px">'
                + '<textarea class="list-card-title" placeholder="Add an Item to Task"></textarea>'
                + '<a href="#" class="due-button" onclick="addItemtoTask(this,' + taskId + ')">Add an item</a>'
                + '</div>';
            if (data.length === 0){
                console.log("no items for this task");
                parentDiv.append(addItemLink);
            } else {
                console.log("items detected for taskid");
                console.log(data.length + " is total items of task with taskId " + taskId);
                // 부모 div를 찾아서 변수에 할당

                var checklistProgress = `
    <div class="checklist-progress">
        <span class="checklist-progress-percentage">${tmppercentage}%</span>
        <div class="checklist-progress-bar">
            <div id="checklist-progress-bar-current" style="width: ${tmppercentage}%"></div>
        </div>
    </div>`;
                parentDiv.append(checklistProgress);
                // checklist-items-list를 추가
                var checklistItemsList = '<div class="checklist-items-list"></div>';
                parentDiv.append(checklistItemsList);
                for (var i = 0; i < data.length; i++) {
                    var checkbox = '<div class="checklist-item-checkbox">' +
                        '<input type="checkbox" ' + (data[i].is_checked ? 'checked' : '') +
                        ' onclick="setTaskItem(this, ' + data[i].task_item_id + ')">' +
                        '</div>';
                    var detail = '<div class="checklist-item-detail" style = "display: flex;"><span style ="width: 50px;">' + data[i].title + '</span>'+'<div style = "margin-left: 350px"><a href="#" class="due-button" style="text-decoration: none; font-size: 10px;" onclick="deleteTaskItem('+data[i].task_item_id+')">Delete Item</a></div>'+'</div>';

                    // checklist-item을 생성하고 checklist-items-list에 추가
                    var checklistItem = '<div class="checklist-item">' + checkbox + detail + '</div>';
                    parentDiv.find('.checklist-items-list').append(checklistItem);
                }

// Add an item 링크 추가
                parentDiv.append(addItemLink);


// checklist-progress-bar 업데이트
                /*var percentage = tmppercentage; // 실제로 사용하는 퍼센티지로 변경 필요
                parentDiv.find('.checklist-progress-percentage').text(percentage + '%');
                parentDiv.find('#checklist-progress-bar-current').css('width', percentage + '%');*/



            }
        }).fail(function (xhr, status, error){
            console.log("error loading tasks for card");
            console.log(status);
        });
    }).fail(function (xhr, status, error){
        console.log("error loading task items percent");
        console.log(status);
    });
    //)

}

function deleteTaskItem(taskItemId){
    console.log(taskItemId);
    $.ajax({
        url : '/card_detail/deleteTaskItem',
        type : 'get',
        data : {
            "taskItemId" : taskItemId
        }
    }).done(function (){
        showTasks(openedCard);
    }).fail(function (xhr, status, error){
        console.log("error deleting task item");
        console.log(status);
    })

}

function setTaskItem(element, taskItemId){
    let checked = element.checked;
    console.log(checked);
    console.log(taskItemId);
    $.ajax({
        url : '/card_detail/setTaskItem',
        type : 'get',
        data : {
            "taskItemId" : taskItemId,
            "checked" : checked
        }
    }).done(function(){
        showTasks(openedCard);
    }).fail(function(xhr, status,error){
        console.log("error setting task item state");
        console.log(status);
    });
}
function addItemtoTask(element,taskId) {
    let text = element.previousElementSibling.value;
    if (text != null && text != "") {
        console.log(taskId + " : " + text);
        $.ajax({
            url : '/card_detail/addItemtoTask',
            type : 'get',
            data : {
                "taskid" : taskId,
                "text" : text
            }
        }).done(function(data){
            showTasks(openedCard);
        }).fail(function(xhr, status, error){
            console.log("error adding items to task");
            console.log(status);
        })
    }
    else {
        console.log("no text to add");
    }

}

function deleteComment(card_comment_id){
    console.log(card_comment_id);
    $.ajax({
        url : '/card_detail/deleteComment',
        type : 'get',
        data : {
            "card_comment_id" : card_comment_id
        }
    }).done(function(data){
        console.log("success deleting comment");
        showComments(openedCard);
    }).fail(function(xhr, status, error){
        console.log("error deleting comment");
        console.log(status);
    })
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
            <span style="margin-left: 250px; cursor: pointer;" onclick="deleteComment(${commentData.card_comment_id})">Delete comment</span>
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
                setDueDate(date.val());
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
            setDueDate(null);
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
            showTasks(openedCard);
        }
    }).fail(function (xhr, status, error){
        console.log("error adding checklist");
        console.log(status);
    });
})
//when card_name changes
$('#card_name').change(function () {
    let name = $('#card_name').val();
    console.log(name);
    if (name != ""){
        $.ajax({
            url : "/card_detail/name",
            type : 'get',
            data : {
                "name" : name,
                "card_id" : openedCard
            }
        }).done(function (data) {
            if (data === 1){
                console.log("insert name successful");
            }
        }).fail(function (xhr, status, error){
            console.log("error changing name");
            console.log(status);
        });
    }

});

//when description changes
$('#card_description').change(function () {
    let description = $('#card_description').val();
    console.log(description);
    if (description != ""){
        $.ajax({
            url : "/card_detail/description",
            type : 'get',
            data : {
                "description" : description,
                "card_id" : openedCard
            }
        }).done(function (data) {
            if (data === 1){
                console.log("insert description successful");
            }
        }).fail(function (xhr, status, error){
            console.log("error changing description");
            console.log(status);
        });
    }
});


//open and close sidebar modals
$('.card-sidebar-button').click(function (){

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
    else if (linkText === "cover") {
        openCoverModal();
    }
    else {
        console.log("yet no functions available")
    }
})

function openMembersModal(){

    $('#card-sidebar-button-members').toggle();

}
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
            showMembers(openedCard);
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
        showMembers(openedCard);
    }).fail(function (xhr, status, error) {
        alert('add user failed');
        console.log(status);
    });
}

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
    $('#card-sidebar-button-cover').toggle();
}

    $(".color-picker").click(function(){
        let background = $(this).css('background-color');
        console.log(background);
        $.ajax({
            type: 'get',
            url : '/card_detail',
            data : {
                "cardid" : openedCard
            }
        }).done(function (data){
            if (data.cover === background) {
                console.log(data.cover);
                $.ajax({
                    url : "/card_detail/removeCover",
                    type : 'get',
                    data : {
                        "card_id" : openedCard
                    }
                }).done(function(data){
                    console.log("Removed cover");
                    setCoverColor(null);
                }).fail(function (xhr, status, error) {
                    alert('Error removing cover color to card');
                    console.log(status);
                });
            }
            else {
                $.ajax({
                    url : "/card_detail/addCover",
                    type : 'get',
                    data : {
                        "cover" : background,
                        "card_id" : openedCard
                    }
                }).done(function(data){
                    console.log("Added cover")
                    setCoverColor(background);
                }).fail(function (xhr, status, error) {
                    alert('Error adding cover color to card');
                    console.log(status);
                });
            }

        }).fail(function (xhr, status, error) {
            alert('Unexpected error. Please contact System Administrator for ');
            console.log(status);

        });


    })

function setCoverColor(coverColor){
    if (coverColor === null){
        console.log("cover color not included");
        card_banner.css('height', 0);
    } else {
        card_banner.css('height', 116);
        card_banner.css('backgroundColor', coverColor);
    }
}


function setComment() {
    let comment = $('#comment-textarea').val();
    if (comment === ""){
        console.log("comment not included 1");

    }
    else {
        console.log(comment);
        $.ajax({
            url : '/card_detail/addComment',
            type : 'get',
            data : {
                "card_id" : openedCard,
                "comment" : comment
            }
        }).done(function (){
            console.log("comment added successfully");
            $('#comment-textarea').val('');
            showComments(openedCard);
        }).fail(function (xhr, status, error) {
            console.log("comment insertion failed");
        });

    }
}

$('.list-title-area').on('input', function(){
    let modifyId = $(this).attr("listId");
    let newListTitle = $(this).val();
    console.log(newListTitle);
    console.log(modifyId);
    if (newListTitle.length > 0){
        $.ajax({
            url : '/list_detail/editListTitle',
            type : 'get',
            data : {
                "Title" : newListTitle,
                "listId" : modifyId
            }
        }).done(function (){

        }).fail(function (xhr,status,error){
            console.log("error editing title for list")
        })
    }
});