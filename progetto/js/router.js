define(['angular-ui-router'], function() {
    'use strict';
    angular.module('mod.states', ['ui.router']).config(['$stateProvider', '$urlRouterProvider', '$couchPotatoProvider', 
		function($stateProvider, $urlRouterProvider, $couchPotatoProvider) {
				
				$urlRouterProvider.otherwise('/first');


				$stateProvider

				// LISTA DEGLI STATI
				.state('firstPoint', {
                url: '/first',
                templateUrl: 'firstPage.html',
                resolve: {
                    dummy: $couchPotatoProvider.resolveDependencies([
                        'js/pages/firstPage'
                    ])}

				});






	}]);
})
