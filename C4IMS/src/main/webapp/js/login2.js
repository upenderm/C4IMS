$(document).ready(function() {
	$('.form').find('input, textarea').on('keyup blur focus', function(e) {
		//       console.log("1111111");
		var $this = $(this), label = $this.prev('label');

		if (e.type === 'keyup') {
			//       console.log("222222");
			if ($this.val() === '') {
				//       console.log("33333333");
				label.removeClass('active highlight');
			} else {
				//       console.log("44444");
				label.addClass('active highlight');
			}
		} else if (e.type === 'blur') {
			//       console.log("55555");
			if ($this.val() === '') {
				//       console.log("666666");
				label.removeClass('active highlight');
			} else {
				label.removeClass('highlight');
			}
		} else if (e.type === 'focus') {
			//       console.log("777777777");
			if ($this.val() === '') {
				label.removeClass('highlight');
			} else if ($this.val() !== '') {
				label.addClass('highlight');
			}
		}

	});

	$('.tab a').on('click', function(e) {
		//       console.log("clicked on tabs..");
		e.preventDefault();

		$(this).parent().addClass('active');
		$(this).parent().siblings().removeClass('active');

		target = $(this).attr('href');

		$('.tab-content > div').not(target).hide();

		$(target).fadeIn(600);

	});

	$(document).ready(function() {
		//       console.log("page loaded..");
		var kk = $('#temp1');
		//       console.log("kk value is ::" + kk);
		if (kk) {
			//       console.log("page loaded first object.." + kk[0].value);
			if (kk[0].value) {
				$('#signinli a').trigger("click");
			}
		}

	});

});