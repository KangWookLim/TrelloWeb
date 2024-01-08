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
