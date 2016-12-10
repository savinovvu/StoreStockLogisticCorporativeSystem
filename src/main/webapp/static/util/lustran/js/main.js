$(document).ready(function(){

	//Удалить заказ
	$('.new-order').on('click','[data-toggle=remove-row]',function(){
		$(this).parents('.new-order-form-row').remove();
	})

	//Добавить заказ
	$('.new-order').on('click','[data-toggle=add-row]',function(){
		var row = $(this).parents('.new-order-form-row').html();
		$(this).removeClass('add');
		$(this).addClass('remove');
		$(this).attr('data-toggle','remove-row');
		$(this).html('<i class="fa fa-times-circle" aria-hidden="true"></i>&nbspУдалить товар');
		$(this).parents('.new-order-form-row').after('<div class="new-order-form-row row">'+row+'</div>');
		$('[data-input=number]').inputmask({mask:'9{*}',greedy: false});
		$('[data-input=date]').inputmask('dd/mm/yyyy',{ "placeholder": "дд/мм/гггг" });
	})

	// Валидация инпутов
	$('[data-input=time]').inputmask('hh:mm',{ "placeholder": "чч.мм" });
	$('[data-input=date]').inputmask('dd/mm/yyyy',{ "placeholder": "дд/мм/гггг" });
	$('[data-input=phone]').inputmask('+7 (999) 999-99-99');
	$('[data-input=number]').inputmask({mask:'9{*}',greedy: false});

	//Отмена стандартного действия ссылок
	$('body').delegate('a[href*="#"]','click',function(e){
		e.preventDefault();
	})


	//Изменить статус заказа
	$('body').delegate('.order-list-item:not(.status-removed) .order-status:not(.status-null) .order-status-edit','click',function(){
		var offsetTop = $(this).offset().top + $(this).height();
		var offsetLeft = $(this).offset().left - 150 + $(this).width()/2;
		$('.layout-dark').height($('body').height());
		$('.layout-dark').show();
		$('.action').addClass('show');
		$('.action').css({'top':offsetTop, 'left':offsetLeft});
	})

	//Изменить статус заказа
	$('body').delegate('.order-list-item:not(.status-removed) .order-status:not(.status-null) .status-bottom .edit','click',function(){
		var offsetTop = $(this).offset().top + $(this).height() + 20;
		var offsetLeft = $(this).offset().left - 150 + $(this).width()/2;
		$('.layout-dark').height($('body').height());
		$('.layout-dark').show();
		$('.action').addClass('show');
		$('.action').css({'top':offsetTop, 'left':offsetLeft});
	})

	//Закрыть Action
	$('body').on('click','[data-toggle=close-action]',function(){
		$('.layout-dark').hide();
		$('.modal-layout').hide();
		$('.action').removeClass('show');
	})

	//Отмена Action
	$('body').on('click','[data-toggle=cancel-action]',function(){
		$('.layout-dark').hide();
		$('.action').removeClass('show');
	})

	//Сохранить Action
	$('body').on('click','[data-toggle=save-action]',function(){
		$('.layout-dark').hide();
		$('.action').removeClass('show');
	})

	//Удалить заказ из списка
	$('body').on('click','[data-toggle=remove-order]',function(){
		$(this).parents('.order-list-item').toggleClass('status-removed')
	})

	//Открыть историю действий
	$('body').on('click','[data-toggle=open-log]',function(){
		$('.modal-layout').show();
	})

	//Сохранить Log
	$('body').on('click','[data-toggle=save-log]',function(){
		$('.modal-layout').hide();
	})

	//Отмена log
	$('body').on('click','[data-toggle=cancel-log]',function(){
		$('.modal-layout').hide();
	})

	$('.modal-layout').perfectScrollbar();
	$('.modal-log-body').perfectScrollbar();
})