var myApp = angular.module('shop',[]);

myApp.controller('Controller',  function($scope,$http,$window,$interval) {
		$scope.choice=
			[];
		$scope.chosen;
		$scope.user;
		$scope.names="";
		$scope.name=[];
		//$scope.user.snack= $scope.name.join(";");
		//$scope.user.snack= "dorito";
		 
		  $scope.$watchCollection( 'choice', function(newVal){
		        for( var i = 0; i < newVal.length; ++i ) {
		        	$scope.name[i]=newVal[i].name;
		        console.log(newVal[i]); 
		        console.log($scope.name); 
		        }
		    });
		
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
		$scope.showreq= function(){$http({
		  method:'GET',
			  url:'/api/request/all'})
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