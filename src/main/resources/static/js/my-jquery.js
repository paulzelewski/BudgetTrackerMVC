/**
 * Table filter
 
$(document).ready(function(){
	$("#sortTable").on("keyup", function(){
		let value = $(this).val().toLowerCase();
		$("#myTable tr").filter(function() {
			$(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
		});
	});
});
*/
function sortTable(inputId, tableId){
	$("#"+inputId).on("keyup", function(){
		let value = $(this).val().toLowerCase();
		$("#"+tableId+" tr").filter(function() {
			$(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
		});
	});
};