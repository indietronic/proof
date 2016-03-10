requirejs.config({
  baseUrl : "js" ,   // percorso in cui si trova il common js
  paths : {

    // external libs downloaded using bower
    'angular': 'lib/bower_components/angular/angular.min',
    'jquery': 'lib/bower_components/jquery/dist/jquery.min',
    'bootstrap' : 'lib/bower_components/bootstrap/dist/js/bootstrap.min',
    'domReady' : 'lib/bower_components/domReady/domReady', 
    'angular-couch-potato': 'lib/bower_components/angular-couch-potato/dist/angular-couch-potato',
    'oc-lazy-load' : 'lib/bower_components/oclazyload/dist/ocLazyLoad.min',
    'angular-ui-router': 'lib/bower_components/angular-ui-router/release/angular-ui-router.min',
    //'ui-router-extras': 'lib/bower_components/ui-router-extras/release/ct-ui-router-extras',

    'state-routing' : 'router',  // configuration file for routing
    'app' : 'angular-app' // principal app module


  },
  shim: {
        'app': {
            deps: ['bootstrap', 'jquery', 'angular', 'oc-lazy-load']
        },
        'angular': {
            deps: ['jquery']
        },
        'bootstrap': {
            deps: ['jquery']
        },
        'oc-lazy-load': {
            deps: ['angular']
        },
        'angular-ui-router': {
            deps: ['angular']
        },
        'angular-couch-potato': {
            deps: ['angular']
        },
        // 'ui-router-extras': {
        //     deps: ['angular']
        // }
    },
    priority: [
        'jquery',
        'bootstrap',
        'angular'
    ]
});

// require the main angular app and bootstrap angular itself (equivalente all' ng-app)
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
