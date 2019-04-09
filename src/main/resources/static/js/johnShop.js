var myApp = angular.module('shop',[]);

myApp.controller('Controller',  function($scope,$http,$window,$interval) {
 
	
	$window.onload = function () {$http({
		  method:'GET',
			  url:'/api/Snack/all'})
			  .then(function(response)
			  {
			  	$scope.snacks= response.data;
			  	console.log($scope.snacks);
			  	 
			  })};
});