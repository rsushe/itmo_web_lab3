let board;

function test(data) {
    console.log(data);
}

function set_timezone() {
    $('input[id="form:timezone"]').val(new Date().getTimezoneOffset());
}

$(document).ready(function () {
    set_timezone();
    board = JXG.JSXGraph.initBoard('jxgbox', {boundingbox: [-6, 6, 6, -6], axis: true, showCopyright: false});

    let rInput = $('input[name="r"]');

    let pointsById = {};
    rInput.each(function () {
        pointsById[$(this).val()] = [];
    });

    let drawnObjects = []
    $('.r_buttons input[type="button"]').click(function () {
        let pressedButton = $(this);
        $('.r_buttons input[type="button"]').each(function () {
            let currentButton = $(this);
            if (currentButton.val() !== pressedButton.val() && currentButton.hasClass("pressed")) {
                currentButton.removeClass("pressed");
            }
        });

        clearFigures(board, drawnObjects);
        if (pressedButton.hasClass("pressed")) {
            $('.r_buttons input[type="hidden"]').val("");
            pressedButton.removeClass("pressed");

            drawnObjects = []
        } else {
            const r = parseFloat(pressedButton.val());

            $('.r_buttons input[type="hidden"]').val(r);
            pressedButton.addClass("pressed");

            let rectangle = createRectangle(board, r);
            let triangle = createTriangle(board, r);
            let circle = createCircle(board, r);
            drawnObjects = [rectangle, triangle, circle];
        }
    });

    setCurrentDateTime();
    setInterval(setCurrentDateTime, DELAY);
});