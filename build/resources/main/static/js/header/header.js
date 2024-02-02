
        function dp_create() {
            let click = document.getElementById("drop-header-create")
            let click2 = document.getElementById("drop-create-board");
            click2.style.display = "none";
            if(click.style.display === "none") {
                click.style.display = "block";
            }else{
                click.style.display = "none";
            }
        }

        function dp_profile() {
            let click = document.getElementById("header-user-profile-dropdown");
            if(click.style.display === "none") {
                click.style.display = "block";
            }else{
                click.style.display = "none";
            }
        }
        function create_board() {
            let click = document.getElementById("drop-create-board");
            if($('option[name=WS_ID]').length === 0){
                alert("워크스페이스를 생성하세요");
                return 0;
            }
            dp_create();
            if(click.style.display === "none") {
                click.style.display = "block";
            }else{
                click.style.display = "none";
            }
        }

        function close_dropdown_board() {
            let click = document.getElementById("drop-header-create")
            let click2 = document.getElementById("drop-create-board");
            click.style.display = "none";
            click2.style.display = "none";
        }

        $('.background-picker-button').click(function(){
            $('.background-picker-button').removeClass("button-clicked");
            $('.background-picker-button').empty();
            $('#board_background_hidden').val("")
            $(this).addClass("button-clicked");
            $(this).append('<span class=create-board-check-icon> <svg width="24" height="24" color="#1d2125" role="presentation" focusable="false" viewBox="0 0 24 24" xmlns="http://www.w3.org/2000/svg"><path d="M6.73534 12.3223C6.36105 11.9162 5.72841 11.8904 5.3223 12.2647C4.91619 12.639 4.89039 13.2716 5.26467 13.6777L8.87678 17.597C9.41431 18.1231 10.2145 18.1231 10.7111 17.6264C10.7724 17.5662 10.7724 17.5662 11.0754 17.2683C11.3699 16.9785 11.6981 16.6556 12.0516 16.3075C13.0614 15.313 14.0713 14.3169 15.014 13.3848L15.0543 13.3449C16.7291 11.6887 18.0004 10.4236 18.712 9.70223C19.0998 9.30904 19.0954 8.67589 18.7022 8.28805C18.309 7.90022 17.6759 7.90457 17.2881 8.29777C16.5843 9.01131 15.3169 10.2724 13.648 11.9228L13.6077 11.9626C12.6662 12.8937 11.6572 13.8889 10.6483 14.8825C10.3578 15.1685 10.0845 15.4375 9.83288 15.6851L6.73534 12.3223Z" fill="currentColor"></path></svg> </span>');
            var getting = $(this).css("background-image").replace(/^url\(['"](.+)['"]\)/, '$1');
            $('#board_background_hidden').val(getting);
            $('#drop-create-ex-background').css("background-image", "url(" + getting +")");
        })

        $('.ws-picker-button').click(function(){
            $('.ws-picker-button').removeClass("button-clicked");
            $('.ws-picker-button').empty();
            $('#board_background_hidden').val("")
            $(this).addClass("button-clicked");
            $(this).append('<span class=create-board-check-icon> <svg width="24" height="24" color="#1d2125" role="presentation" focusable="false" viewBox="0 0 24 24" xmlns="http://www.w3.org/2000/svg"><path d="M6.73534 12.3223C6.36105 11.9162 5.72841 11.8904 5.3223 12.2647C4.91619 12.639 4.89039 13.2716 5.26467 13.6777L8.87678 17.597C9.41431 18.1231 10.2145 18.1231 10.7111 17.6264C10.7724 17.5662 10.7724 17.5662 11.0754 17.2683C11.3699 16.9785 11.6981 16.6556 12.0516 16.3075C13.0614 15.313 14.0713 14.3169 15.014 13.3848L15.0543 13.3449C16.7291 11.6887 18.0004 10.4236 18.712 9.70223C19.0998 9.30904 19.0954 8.67589 18.7022 8.28805C18.309 7.90022 17.6759 7.90457 17.2881 8.29777C16.5843 9.01131 15.3169 10.2724 13.648 11.9228L13.6077 11.9626C12.6662 12.8937 11.6572 13.8889 10.6483 14.8825C10.3578 15.1685 10.0845 15.4375 9.83288 15.6851L6.73534 12.3223Z" fill="currentColor"></path></svg> </span>');
            var getting = $(this).css("background-image").replace(/^url\(['"](.+)['"]\)/, '$1');
            $('#ws_background_hidden').val(getting);
        })

        function create_ws() {
            let click = document.getElementById("drop-create-ws");
            dp_create();
            if(click.style.display === "none") {
                click.style.display = "flex";
            }else{
                click.style.display = "none";
            }
        }

        const csrfToken = $("meta[name='csrfToken']").attr('content');
        const csrfParameter = $("meta[name='csrfParameter']").attr('content')

        $(".ws-create-close").click(function(){
            let click = document.getElementById("drop-create-ws");
            click.style.display = "none";
        })

        $(".header-flexible-btn").click(function(){
//            $(".header-flexible-btn").removeClass("header-active-button")
            $except = $(this);
            $(".header-flexible-btn").not($except).removeClass("header-active-button");
            $except.toggleClass("header-active-button")
            checkStarredDp();
            checkWsDp();
        })

        function checkStarredDp() {
            if($('#starred_dp').hasClass('header-active-button')){
                $('#starred-header-box').addClass('displayNone');
            }else{
                $('#starred-header-box').removeClass('displayNone');
            }
        }
        function checkWsDp() {
            if($('#ws_dp').hasClass('header-active-button')){
                $('#ws-header-box').addClass('displayNone');
            }else{
                $('#ws-header-box').removeClass('displayNone');
            }
        }

        $(".starred-board-icon").hover(function() {
          $(this).attr("src", function(index, attr){
            if (attr.match('full')) {
              return attr.replace("full", "empty");
            }
            else {
              return attr.replace("empty", "full");
            }
          });
        })