function count() {
    var num = $('.star-holder>.i-rate-hover-click').length;
    $('.star-value').attr("value", num);
}

$(function () {
	for (i = 0; i < 5; i++) {
		before();
		change(i);
		after(i);
	}
    function change(i) {
        $('.star-holder>.i-rate:eq(' + i + ')').mouseover(function () {
            $('.star-holder>a:lt(' + (i + 1) + ').i-rate').attr("class", "i-rate-hover");
        });
    }

    function after(i) {
        $('.star-holder>a:eq(' + i + ')').click(function () {
            $('.star-holder>a:lt(' + (i + 1) + ')').attr("class", "i-rate-hover-click");
            $('.star-holder>a:gt(' + i + ')').attr("class", "i-rate");
            count();
            return false;
        });
    }

    function before() {
        $('.star-holder').mouseout(function () {
            $('.star-holder >.i-rate-hover').attr("class", "i-rate");
        });
    }
});
