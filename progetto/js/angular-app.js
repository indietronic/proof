define(function () {
	
	var Application = angular.module('myApp', [])

	.config(function ($controllerProvider){

		Application.controller = $controllerProvider.register;


	});

	return Application;

});


