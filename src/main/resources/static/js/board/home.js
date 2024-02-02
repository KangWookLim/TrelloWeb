    const token = $("meta[name='_csrf']").attr("content");
    const header = $("meta[name='_csrf_header']").attr("content");

    $(document).ready(function(){
      $("#home-home-btn").addClass("home-active-btn")
      const activeTemplate = $("#home-home-btn").children("img");
      activeTemplate.attr("src", function(index, attr){
        return attr.replace("home", "homeA");
      });
    })

    $("#home-workspace-box").click(function() {
      console.log("check1");
      $("#ws-btn-ul").toggleClass("menuon");
      const arrowImage = $("#home-workspace-box").children("img");
      arrowImage.attr("src", function(index, attr){
        if (attr.match('up')) {
          return attr.replace("up", "down");
        }
        else {
          return attr.replace("down", "up");
        }
      });
    });


    $(".board-starred-icon").click(function(e) {
       e.preventDefault();
      const boardId = $(this).attr("value");
      console.log(boardId);
      $(this).attr("src", function(index, attr){
        if (attr.match('full')) {
          return attr.replace("full", "empty");
        }
        else {
          return attr.replace("empty", "full");
        }
      });
        $.ajax({
          type: "POST",
          url:"/board/star",
          data : {
            boardId : boardId
          },
          beforeSend: function(xhr){
                    xhr.setRequestHeader(header, token);
          },
          success: function(data){
                $(location).prop("href", location.href);
          },
          error : function(xhr, status, error){
            console.log(xhr.status);
          }
        })

    });
    $(".board-starred-icon").hover(function() {
      $(this).attr("src", function(index, attr){
        if (attr.match('full')) {
          return attr.replace("full", "empty");
        }
        else {
          return attr.replace("empty", "full");
        }
      });
    })
