var myApp = angular.module('shop',[]);

myApp.controller('Controller',  function($scope,$http,$window,$interval) {
 $scope.req;
 $scope.add = function() {
	 $http.post('/api/request/add', $scope.req).then(function(response) {});
	 console.log($scope.req);
 }
// to show all option
	
});