function setDate(date) {
    let day = date.getDate();
    let month = date.getMonth() + 1;
    let year = date.getFullYear();

    day = (day < 10) ? '0' + day : day;
    month = (month < 10) ? '0' + month : month;

    $('span[id="date"]').html(`${day}.${month}.${year}`);
}

function setTime(date) {
    let hours = date.getHours();
    let minutes = date.getMinutes();
    let seconds = date.getSeconds();

    hours = (hours < 10) ? '0' + hours : hours;
    minutes = (minutes < 10) ? '0' + minutes : minutes;
    seconds = (seconds < 10) ? '0' + seconds : seconds;

    $('span[id="time"]').html(`${hours}:${minutes}:${seconds}`);
}

function setCurrentDateTime() {
    let date = new Date();
    setDate(date);
    setTime(date);
}

$(document).ready(function () {
    const DELAY = 10000;
    setCurrentDateTime();
    setInterval(setCurrentDateTime, DELAY);
});