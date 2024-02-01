    const token = $("meta[name='_csrf']").attr("content");
    const header = $("meta[name='_csrf_header']").attr("content");
    function toBoard () {
    }
    $(document).ready(function(){
      $("#home-board-btn").addClass("home-active-btn")
      const activeTrello = $("#home-board-btn").children("img");
      activeTrello.attr("src", function(index, attr){
        return attr.replace("trello", "trelloA");
      });

      if($('.starred-board-section-list-item').length < 1) {
        let star = document.getElementById("starred-boards");
        star.style.display = "none"
      }
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
