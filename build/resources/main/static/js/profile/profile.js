
const modalOpenButton = document.getElementById('changePassword');
const modalCloseButton = document.getElementById('modalClose');
const modal = document.getElementById('modalContainer');
const proceedToChange = document.getElementById('proceedToChange');
const modal2 = document.getElementById('modalContainer2');
const modalCloseButton2 = document.getElementById('modal2Close')

modalOpenButton.addEventListener('click', () => {
    modal.style.display = "flex";
});

modalCloseButton.addEventListener('click', () => {
    modal.style.display = "none";
})

modal.addEventListener('click', () => {
    modal.style.display = "none";
});
proceedToChange.addEventListener('click', () => {
    modal.style.display = "none";
    modal2.style.display = "flex";
})
modal2.addEventListener('click', () => {
    modal2.style.display = "none";
})
modalCloseButton2.addEventListener('click', () => {
    modal2.style.display = "none";
})



