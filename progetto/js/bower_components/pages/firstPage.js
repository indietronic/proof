define(['app'], function(Application){


	Application.controller('myController', ['$scope', '$timeout', function($scope, $timeout){
		$scope.pippo = 'cane';
		$timeout(function(){
			$scope.pippo = 'cane morto';
		}, 1000);


	}]);


});