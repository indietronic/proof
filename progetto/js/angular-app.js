// Require angularAMD, ui-router, and ui-router-extras
define(['angular-couch-potato',
    'angular-ui-router',
   // 'ui-router-extras',
    'state-routing',
    'oc-lazy-load'
], function (couchPotato) { // Only need to inject angularAMD for app config

	var Application = angular.module('myApp', [
		'oc.lazyLoad'
        ,'scs.couch-potato'
		//,'ct.ui.router.extras'
		,'ui.router'
		,'mod.states'
		])

	.config(function ($controllerProvider, $compileProvider, $filterProvider, $provide, $ocLazyLoadProvider){

				/**
                 * configure the ocLazyLoader to use requireJS as the loader
                 */
                $ocLazyLoadProvider.config({
                        debug: true,
                        asyncLoader: require
                });


                // Let's keep the older references.
                Application._controller = Application.controller;
                Application._service = Application.service;
                Application._factory = Application.factory;
                Application._filter = Application.filter;
                Application._directive = Application.directive;

                /**
                 * override angular default module api for creating components
                 * @type {Function|register|register|register}
                 */
                Application.controller = $controllerProvider.register;
                Application.service = $provide.service;
                Application.factory = $provide.factory;
                Application.filter = $filterProvider.register;
                Application.directive = $compileProvider.directive;
	}    )
    .run(['$couchPotato', '$rootScope', '$state', function ($couchPotato, $rootScope, $state) {
        Application.lazy = $couchPotato;
    }]);




	couchPotato.configureApp(Application);
	return Application;

});


