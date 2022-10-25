$(function() {

  'use strict';

  $('.js-menu-toggle').click(function(e) {

  	var $this = $(this);

  	

  	if ( $('body').hasClass('show-sidebar') ) {
  		$('body').removeClass('show-sidebar');
  		$this.removeClass('active');
  	} else {
  		$('body').addClass('show-sidebar');	
  		$this.addClass('active');
  	}

  	e.preventDefault();

  });

  // click outisde offcanvas
	$(document).mouseup(function(e) {
    var container = $(".sidebar");
    if (!container.is(e.target) && container.has(e.target).length === 0) {
      if ( $('body').hasClass('show-sidebar') ) {
				$('body').removeClass('show-sidebar');
				$('body').find('.js-menu-toggle').removeClass('active');
			}
    }
	}); 

    

});

function searchProduct() {
	let input = document.getElementById("searchBar").value.toLowerCase();
	console.log(input);
	let products = document.getElementsByClassName('product');
	for (let i = 0; i < products.length; i++) {
		if (!products[i].getElementsByClassName("card-title")[0].innerHTML.toLowerCase().includes(input)) {
			products[i].classList.add("noSearch");
			products[i].style.visibility = "hidden";
		}
		else {
			products[i].classList.remove("noSearch");
			products[i].style.visibility = "visible";
		}
	}
}