$("#side-earase-btn").click(function(){
    $(".sidebar-container").removeClass("sidebar-show");
    $(".boardsidebar").css("width", 16);
    $(".sidebar-show-btn span").css("display", "flex");
    $(".sidebar-collapse-container").addClass("sidebar-show");
})
$(".sidebar-show-btn").click(function() {
    $(".sidebar-collapse-container").removeClass("sidebar-show");
    $(".boardsidebar").css("width", 260);
    $(".sidebar-show-btn span").css("display", "none");
    $(".sidebar-container").addClass("sidebar-show");
})
const wrk_sec = $(".workspace-setting-options-sec");
$(".sidebar-wrkset-btn").click(function (){
    if(wrk_sec.css("display") === "none"){
        console.log(wrk_sec.css("display"));
        wrk_sec.css("display", "flex");
    }
    else if(wrk_sec.css("display")==="flex"){
        wrk_sec.css("display", "none");
    }
})