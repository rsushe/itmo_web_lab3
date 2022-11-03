let board;
let points = [];
let serverPoints = [];

function test(data) {
    console.log(data);
}

function set_timezone() {
    $('input[id="form:timezone"]').val(new Date().getTimezoneOffset());
}

$(document).ready(function () {
    $('[id="form:x_value"]').val(-2);
    set_timezone();
    board = JXG.JSXGraph.initBoard('jxgbox', {boundingbox: [-6, 6, 6, -6], axis: true, showCopyright: false});

    board.on("down", function (event) {
        if (event.button === 2 || event.target.className === 'JXG_navigation_button') {
            return;
        }
        if (check_r()) {
            let coords = board.getUsrCoordsOfMouse(event);
            console.log(coords[0] + " " + coords[1]);
            let x = $('[id="form:x_value"]').val(), y = $('[id="form:y_value"]').val();
            $('[id="form:x_value"]').val(coords[0].toFixed(2));
            $('[id="form:y_value"]').val(coords[1].toFixed(2));
            $('[id="form:r_value"]').val($('.r_buttons input.pressed').val());
            console.log($('[id="form:x_value"]').val() + " " + $('[id="form:y_value"]').val() + " " + $('[id="form:r_value"]').val())
            $('#form input[type="submit"]').click();
            $('[id="form:x_value"]').val(x);
            $('[id="form:y_value"]').val(y);
        }
        event.preventDefault();
    });

    $('[id="form:selector"]').on("click", function () {
        $('[id="form:x_value"]').val($(this).val());
    });

    let drawnObjects = []
    $('.r_buttons input[type="button"]').click(function () {
        clearPoints();
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

            updatePoints();
        }
    });
});