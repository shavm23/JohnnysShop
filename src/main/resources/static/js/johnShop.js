var myApp = angular.module('shop',[]);

myApp.controller('Controller',  function($scope,$http,$window,$interval) {
		$scope.choice=
			{
				Name:''
			};
		$scope.chosen;
		$scope.user=
			{	stu_ID:'',
				Name: '',
				Location:'',
				snack:''
			};
		
		$scope.tr = $scope.choice.name;
		 
		
		
	$window.onload = function () {$http({
		  method:'GET',
			  url:'/api/Snack/all'})
			  .then(function(response)
			  {
			  	$scope.snacks= response.data;
			  	console.log($scope.snacks);
			  	
			  })};
			  $scope.chosen;
			  $scope.choice;
	
			  $scope.add = function (){$http({
					method:'POST',
				    url:'/api/request/add',
				    
						data: $scope.user
					
							}).then(function(response)
									{	
										console.log($scope.user);
										
										})};
});