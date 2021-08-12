/**
 * 
 */

$('document').ready(function() {
	
	$('.table .btn-primary').on('click',function(event){		
		event.preventDefault();		
		var href= $(this).attr('href');		
		$.get(href, function(practice, status){
			$('#txtAddressEdit').val(practice.address);
			$('#txtCityEdit').val(practice.city);
			$('#ddlNationalityEdit').val(practice.countryid);			
			var dob = practice.dateOfBirth.substr(0,10);
			$('#txtDateOfBirthEdit').val(dob);
			$('#txtEmailEdit').val(practice.email);
			$('#txtFirstnameEdit').val(practice.firstname);
			$('#ddlGenderEdit').val(practice.gender);
			$('#txtIdEdit').val(practice.id);
			$('#txtInitialsEdit').val(practice.initials);
			$('#txtLastnameEdit').val(practice.lastname);
			$('#ddlMaritalStatusEdit').val(practice.maritalStatus);
			$('#txtMobileEdit').val(practice.mobile);
			$('#txtOthernameEdit').val(practice.othername);		
			$('#txtPhoneEdit').val(practice.phone);			
			$('#fupPhotoEdit').val(practice.photo);			
			$('#txtSSNEdit').val(practice.socialSecurityNumber);			
			$('#ddlStateEdit').val(practice.stateid);	
			$('#ddlTitleEdit').val(practice.title);			
			$('#ddlpracticeTypeEdit').val(practice.practicetypeid);				
			var hireDate = practice.hireDate.substr(0,10);
			$('#txtHireDateEdit').val(hireDate);
			$('#ddlJobTitleEdit').val(practice.jobtitleid);			
		});			
		$('#editModal').modal();		
	});
	
	$('.table #detailsButton').on('click',function(event) {
		event.preventDefault();		
		var href= $(this).attr('href');		
		$.get(href, function(practice, status){
			$('#idDetails').val(practice.id);
			$('#descriptionDetails').val(practice.description);
			$('#detailsDetails').val(practice.details);
			$('#lastModifiedByDetails').val(practice.lastModifiedBy);
			$('#lastModifiedDateDetails').val(practice.lastModifiedDate.substr(0,19).replace("T", " "));
		});			
		$('#detailsModal').modal();		
	});	
	
	$('.table #deleteButton').on('click',function(event) {
		event.preventDefault();
		var href = $(this).attr('href');
		$('#deleteModal #confirmDelete').attr('href', href);
		$('#deleteModal').modal();		
	});	
	
	$('.table #photoButton').on('click',function(event) {
		   event.preventDefault();
		   var href = $(this).attr('href');
		   $('#photoModal #practicePhoto').attr('src', href);
		   $('#photoModal').modal();		
	});
	
});



