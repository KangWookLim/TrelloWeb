var headerElements = [ "Features", "Solution", "Plans", "Resources" ];
//헤더 상세창 열기
function OpenFeatures(ID) {
    for (let i = 0; i < headerElements.length; i++) {
        var tmp = headerElements[i];

        if (tmp != ID) {
            document.getElementById(tmp).classList.add("dn");
        }
    }
    var drop = document.getElementById(ID);
    if (drop.classList.contains("dn")) {
        drop.classList.remove("dn");
    } else {
        drop.classList.add("dn");
    }
    const body = document.getElementsByTagName('body')[0];
    if (drop.classList.contains("dn")) {
        document.getElementById("HeaderBack").classList.add("dn");
        body.classList.remove('scrollLock');

    } else {
        document.getElementById("HeaderBack").classList.remove("dn");
        body.classList.add('scrollLock');

    }

}
//헤더 상세창 밖 클릭 시
function removeHeaderBack() {
    for (let i = 0; i < headerElements.length; i++) {
        var tmp = headerElements[i];
        document.getElementById(tmp).classList.add("dn");
    }
    document.getElementById("HeaderBack").classList.add("dn");
    const body = document.getElementsByTagName('body')[0];
    body.classList.remove('scrollLock');
}