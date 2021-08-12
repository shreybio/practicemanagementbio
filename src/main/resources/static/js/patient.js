/**
 * 
 */

$('document').ready(function() {
	
	$('.table .btn-primary').on('click',function(event){		
		event.preventDefault();		
		var href= $(this).attr('href');		
		$.get(href, function(patient, status){
			$('#txtAddressEdit').val(patient.address);
			$('#txtCityEdit').val(patient.city);
			$('#ddlNationalityEdit').val(patient.countryid);			
			var dob = patient.dateOfBirth.substr(0,10);
			$('#txtDateOfBirthEdit').val(dob);
			$('#txtEmailEdit').val(patient.email);
			$('#txtFirstnameEdit').val(patient.firstname);
			$('#ddlGenderEdit').val(patient.gender);
			$('#txtIdEdit').val(patient.id);
			$('#txtInitialsEdit').val(patient.initials);
			$('#txtLastnameEdit').val(patient.lastname);
			$('#ddlMaritalStatusEdit').val(patient.maritalStatus);
			$('#txtMobileEdit').val(patient.mobile);
			$('#txtOthernameEdit').val(patient.othername);		
			$('#txtPhoneEdit').val(patient.phone);			
			$('#fupPhotoEdit').val(patient.photo);			
			$('#txtSSNEdit').val(patient.socialSecurityNumber);			
			$('#ddlStateEdit').val(patient.stateid);	
			$('#ddlTitleEdit').val(patient.title);			
			$('#ddlpatientTypeEdit').val(patient.patienttypeid);				
			var hireDate = patient.hireDate.substr(0,10);
			$('#txtHireDateEdit').val(hireDate);
			$('#ddlJobTitleEdit').val(patient.jobtitleid);			
		});			
		$('#editModal').modal();		
	});
	
	$('.table #detailsButton').on('click',function(event) {
		event.preventDefault();		
		var href= $(this).attr('href');		
		$.get(href, function(patient, status){
			$('#idDetails').val(patient.id);
			$('#descriptionDetails').val(patient.description);
			$('#detailsDetails').val(patient.details);
			$('#lastModifiedByDetails').val(patient.lastModifiedBy);
			$('#lastModifiedDateDetails').val(patient.lastModifiedDate.substr(0,19).replace("T", " "));
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
		   $('#photoModal #patientPhoto').attr('src', href);
		   $('#photoModal').modal();		
	});
	
});



