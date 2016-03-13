define(['angular-ui-router'], function() {
    'use strict';
    angular.module('mod.states', ['ui.router']).config(['$stateProvider', '$urlRouterProvider', '$couchPotatoProvider', 
		function($stateProvider, $urlRouterProvider, $couchPotatoProvider) {
				
				$urlRouterProvider.otherwise('/first');


				$stateProvider

                    // LISTA DEGLI STATI
                    .state('firstPoint', {
                    url: '/first',
                    views : {
                        'firstView@' : {                        // questa vista può essere richiamata solo nello stato root
                            templateUrl: './firstPage.html'
                        }
                    },

                    resolve: {
                        dummy: $couchPotatoProvider.resolveDependencies([
                            'pages/firstPage'
                        ])}

                    })

                    .state('firstPoint.statoDelCazzo', {
                    url: '/statoDelCazzo',
                    views : {
                        'vistaDelCazzo@firstPoint' : {          // questa vista può essere richiamata nello stato firstPoint
                            templateUrl: './nuovostato.html'
                        }
                    }})






	}]);
})
