
const modalOpenButton = document.getElementById('modalOpenButton');
const modalCloseButton = document.getElementById('modalCloseButton');
const modal = document.getElementById('modalContainer');
const TrelloVideoModal = document.getElementById('TrelloVideo');
modalOpenButton.addEventListener('click', () => {
    modal.style.display = "flex";
    TrelloVideoModal.src = "https://www.youtube.com/embed/AyfupeWS0yY?si=5cOBsj8XjN0KRjWq";

});
modal.addEventListener('click', () => {
    modal.style.display = "none";
    TrelloVideoModal.src = '';
});

var swiper = new Swiper(".mySwiper", {
    slidesPerView: 3,
    spaceBetween: 30,

    navigation: {
        nextEl: ".swiper-button-next",
        prevEl: ".swiper-button-prev",
    },
});

const swiper1 = new Swiper('.swiper-container-1', {
    // Optional parameters
    direction: 'horizontal',
    loop: false,

    // If we need pagination
    pagination: {
        el: '.external-pagination',
        clickable: true,
    },
    navigation: {
        nextEl: "#ext-but4",
        prevEl: "#ext-but3"
    }

});

var swiper2 = new Swiper('.swiper2', {
    slidesPerView: 1,
    spaceBetween: 10,
    loop: false, // Loop 비활성화
    navigation: {
        nextEl: '.swiper-button-next',
        prevEl: '.swiper-button-prev',
    },
});

document.getElementById('ext-but2').addEventListener('click', function() {
    let lastIndex = swiper.slides.length - 1;

    swiper.slideTo(lastIndex);

});
document.getElementById('ext-but1').addEventListener('click', function() {

    swiper.slideTo(0);
});
document.getElementById('ext-butBoards').addEventListener('click', function() {

    swiper2.slideTo(0);
});
document.getElementById('ext-butLists').addEventListener('click', function() {

    swiper2.slideTo(1);
});
document.getElementById('ext-butCards').addEventListener('click', function() {

    swiper2.slideTo(2);
});

function toggleButtonClick(button) {
    document.querySelectorAll('.list_button_clicked').forEach(function(btn) {
        btn.classList.add('list_button');
        btn.classList.remove('list_button_clicked');
    });
    button.classList.remove('list_button');
    button.classList.add('list_button_clicked');
}
