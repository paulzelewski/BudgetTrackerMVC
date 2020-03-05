/**
 * 
 */
function post(path, radio_name, checkbox_name){
	
	const form = document.createElement('form');
	form.method = 'post';
	form.action = path;
	var radiovalue = getRadioValue(radio_name);
	var checkboxesvalue = getChceckboxesValues(checkbox_name);
	var params = {'budgetId':radiovalue, 'transactionIds': checkboxesvalue};
	
	for(const key in params){
		if(params.hasOwnProperty(key)) {
			const hiddenField = document.createElement('input');
			hiddenField.type = 'hidden';
			hiddenField.name = key;
			hiddenField.value = params[key];
			
			form.appendChild(hiddenField);
		}
	}
	
	document.body.appendChild(form);
	form.submit();	
	
}

function getChceckboxesValues(name){
	
	var checkboxes = document.getElementsByName(name);
	var vals = "";
	for (var i=0, n=checkboxes.length;i<n;i++){
		if(checkboxes[i].checked){
			
			vals += ","+checkboxes[i].value;
		}
	}
	if(vals) vals = vals.substring(1);
	return vals;
}

function getRadioValue(name){
	
	var radios = document.getElementsByName(name);
	
	for(var i=0, n=radios.length; i<n; i++){
		if(radios[i].checked){
			return radios[i].value;
		}
	}
}