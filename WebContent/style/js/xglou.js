$(function () {
	var yinfo = $('#xinfo').val();
	$('#xgl').on('click', function(event) {
		event.preventDefault();
		var id    = $('#llid').html();
		var name  = $('#lnm').html();
		var info  = $('#xinfo').val();
		
		if(info != yinfo){
			$.post('updateld', {
				lid: id,
				lname: name,
				linfo: info
				}, function(data) {
				$('#sslgl').html(data);
			});
		} else {
			$('#lxgalert').fadeIn(200);
		}
	});
});