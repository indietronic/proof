define(['Application'], function(Application){


	Application.controller('myController', function($scope, $timeout){
		$scope.pippo = 'cane';
		$timeout(function(){
			$scope.pippo = 'cane morto';
		}, 1000);


	});


});