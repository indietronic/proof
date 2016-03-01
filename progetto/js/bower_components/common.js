requirejs.config({
	baseUrl : "js/bower_components" ,		// percorso in cui si trova il common js
	paths : {
		'angular': 'angular/angular.min',
		'jquery': "jquery/dist/jquery.min",
		'bootstrap' : "bootstrap/dist/js/bootstrap.min",
		'app' : "angular-app",
		'domReady' : "domReady/domReady"		

	},
	shim: {
        'app': {
            deps: ['bootstrap', 'jquery', 'angular']
        },
        'angular': {
            deps: ['jquery']
        },
        'bootstrap': {
            deps: ['jquery']
        }
    },
    priority: [
        'jquery',
        'bootstrap',
        'angular'
    ]
});

// require the main angular app and bootstrap angular itself
define(function () {
	require(['app'], function() {
	    require(['domReady'], function(domReady) {
	        domReady(function() {
	            if (!window.angularBooted) {
	                window.angularBooted = true;
	                angular.bootstrap(document, ['myApp']);
	            }
	        });
	    });
	});
});

