var myApp = angular.module('shop',[]);

myApp.controller('Controller',  function($scope,$http,$window,$interval) {
	$scope.parseInt = parseInt;	
	$scope.choice=
			[];
		$scope.choice=[];
		$scope.qty=[];
		$scope.user;
		$scope.names="";
		$scope.name=[];
		//$scope.user.snack= $scope.name.join(";");
		//$scope.user.snack= "dorito";
		 
		  $scope.$watchCollection( 'choice', function(newVal){
		        for( var i = 0; i < newVal.length; ++i ) {
		        	$scope.name[i]=newVal[i].name;
		        	//$scope.user.snack= $scope.name.toString();
		        	$scope.user.snack= $scope.name.toString();
		        	$scope.user.qty= $scope.qty.toString();
		        	$scope.quantity=$scope.qty.toString();
		        console.log(newVal[i]); 
		        console.log($scope.user.snack); 
		        console.log($scope.qty);
		        console.log($scope.quantity);
		        }$scope.showreq();
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
										console.log($scope.user.snack);
										
										})};
		$scope.showreq= function(){$http({
		  method:'GET',
			  url:'/api/request/all'})
			  .then(function(response)
			  {
			  	$scope.cart= response.data;
			  	console.log($scope.cart);
			  	
			  })};
			  $scope.chosen;
			  $scope.choice;
			 
			  $scope.add = function ()
			  {		$scope.user.qty= $scope.qty.toString();
			  		$scope.user.snack= $scope.name.toString();
			 		$scope.adds();
			  }
			  $scope.adds = function (){$http({
					method:'POST',
				    url:'/api/request/add',
				    
						data: $scope.user
					
							}).then(function(response)
									{	
										console.log($scope.user);
										
										})};
	
										$scope.Pass = true;
							            $scope.Fail = false;
							                // Login Usernames
							            var managerUsername= "topman";        

							                // Login Passwords
							             var managerPassword="topman";
							             

							            $scope.login = function()
							                        {
							                         
							                            if ($scope.username  == managerUsername && $scope.password  == managerPassword )
							                                {
							                                    return $scope.Pass = false;
							                                }
							                            else
							                                {
							                                    return $scope.Fail = true;
							                                } 
							                        }      

										
					
});
