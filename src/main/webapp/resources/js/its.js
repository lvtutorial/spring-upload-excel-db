var hiddenValToForm = function (formId, mapVal, override){
	for (var key in mapVal) {
		var hiddenField =$('#'+formId+" > input:hidden[name="+key+"]");
		if(hiddenField.size() ==0){
			$('<input>').attr({
			    type: 'hidden',
			    name: key,
			    value:mapVal[key]
			}).appendTo('#'+formId);
		}
		else {
			hiddenField.val(mapVal[key]);
		}
	}
}
function submitAndSetHiddenVal (formId, mapVal, override){
	hiddenValToForm(formId, mapVal, override);
	$("#"+formId).submit();
}
function confirmMessage(msg,callback){
	/*bootbox.confirm({ 
	    size: 'medium',
	    message: "Your message here!", 
	    callback: function(result) { 
		    if (result) {
		    	entity = JSON.parse(entity);
		    	document.location.href = "${addAction}/remove/"+entity.id;
		    	console.log("1111" + entity.id);
			}
		    else {
		    	console.log("2222" + result);
			} 
		}
	})*/
//	/bootbox.setLocale(bmsLocale);
	return bootbox.confirm(msg, callback); 
}