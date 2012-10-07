/* JS Custom */
$(document).ready(function(){
	// Search
	$inputsearch = $('#search input[type="text"]');
	$inputsearch.addClass('unfocus');
	$inputsearch.focus(function() {
		$(this).removeClass('unfocus').addClass('focus');
		if (this.value == this.defaultValue){ 
			this.value = '';
		}
		if(this.value != this.defaultValue){
			this.select();
		}
	});
	$inputsearch.blur(function() {
		$(this).removeClass('unfocus').addClass('focus');
		if ($.trim(this.value) == ''){
			this.value = (this.defaultValue ? this.defaultValue : '');
			$(this).removeClass('focus').addClass('unfocus');
		}
	});
	
	// button 01 ON
	$('.button01').hover(
		function() {
			$(this).addClass('btn01On');
			return false;
		},function(){
			$(this).removeClass('btn01On');
			return false;
	});
	
	
	// GNB
	var $gnb = $('.gnb');
	var $gnb_item = $gnb.children('li');
	//var $gnb_item_act = $gnb_item.index('.active');	
	$gnb_item.hover(
		function() {
			$gnb_item.removeClass('active');
			$(this).addClass('active').find('ul:first').slideDown();
			return false;
		},function(){
			$(this).removeClass('active').find('ul').slideUp();
			//$gnb_item.eq($gnb_item_act).addClass('active');
			return false;
	});
	
	
	// LNB
	var $lnb = $('.lnb');
	var $lnbLi = $lnb.children('li');
	var $lnbLink = $lnbLi.children('a');
	$lnbLink.bind('click', function(event) {
			
		
	});
	
	
	// Use idTabs
	$('.title .tabs, .tabsdetail').idTabs();	
	
	
	// Add dashed in commList and show .toolstip
	var $commList = $('.commList, .samePrdList');
	var $commList_item = $commList.children('li');
	var $commList_info = $commList_item.find('.info');
	$commList_item.hover(
		function() {
			$commList.find('.wrap').removeClass('dashed');
			$(this).find('.wrap').addClass('dashed');
			//$(this).find('.toolstip').show();
			return false;
		},function(){
			$commList.find('.wrap').removeClass('dashed');
			//$(this).find('.toolstip').hide();
			return false;
	});
	$commList_info.hover(
		function() {
			$(this).next('.toolstip').show();
			return false;
		},function(){
			$(this).next('.toolstip').hide();
			return false;
	});
	
	// Banner Slide
	$('#preFeature2').siteFeature2({
		pauseBtnLocation: 'right',
		pauseOnHover: true,
		menuLocation: 'right',
		menuDirection: 'horizontal',
		menuStatus: 'open',
		showHideMenu: 'hide',
		imgAnimationDirection: 'fade',
		autoPlayInterval: 2500
	});
	
	
	// Hotline in bottom
	$('.hotline .ctrl').bind('click', function() {
		if($(this).is('.min')){
			$(this).removeClass('min').addClass('max');
			$('.hotline .cont').hide();
		}
		else if($(this).is('.max')){
			$(this).removeClass('max').addClass('min');
			$('.hotline .cont').show();
		}
		else if ($(this).is('.close')) {
			$('.hotline').hide();
		}
		return false;
	});
	
	// Go on top
	$('#wrapper').append('<div id="gotop" title="Go to top">Go to top</div>');
	$(window).scroll(function(){
		if($(window).scrollTop() != 0){
			$('#gotop').facdeIn();
		}else{
			$('#gotop').fadeOut();
		}
	});
	$('#gotop').click(function(){
		$('html, body').animate({scrollTop:0},500);
	});
	
});