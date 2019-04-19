var myApp = angular.module('shop',['service']);

/*myApp.service('allReqs', function ($http) {
	  
	  this.get = (callback) => 
	  {
		  return $http.get('/api/request/all').then(callback)
	  };
	  


});*/
myApp.factory('cartItems',function(){
    return {
    	
    orders: [],
    add: function(item) {
    	item.total = item.price* item.qtys;
    	
    	
      this.orders.push(item)
    }
    }
    //return this.orders;
});

myApp.controller('snackController', ['$scope','allSnacks','cartItems', function($scope,allSnacks,cartItems) {
	// console.log(allSnacks.list());
	allSnacks.get((response)=>{
			$scope.snacks=response.data;
			console.log($scope.snacks);
	});
				$scope.addItem = function(item) {
			        cartItems.add(item);
			        console.log(cartItems.orders)
      };
			
	        
	                   
	  
}]);


myApp.controller('RequestController', ['$scope','allReqs', function($scope,allReqs) {
	// console.log(allSnacks.list());
	  allReqs.get((response)=>{
			$scope.cart=response.data;
			console.log($scope.cart);
	} 
			);
	        
	          
	        
	  
}]);
myApp.controller('Loginctrl', ['$scope', function($scope) {
	// console.log(allSnacks.list());
	$scope.Pass = true;
    $scope.Fail = false;
        // Login Usernames
    var managerUsername= "topman";        

        // Login Passwords
     var managerPassword="topman";
     console.log("check if true");

    $scope.login = function()
                {
                 
                    if ($scope.username  == managerUsername && $scope.password  == managerPassword )
                        {
                            return $scope.Pass = false;
                            console.log("check if true");
                        }
                    else
                        {
                            return $scope.Fail = true;
                            console.log("check if false");
                        } 
                }      

	

	          
	        
	  
}]);
myApp.controller('cartController', ['$scope','cartItems','$http', function($scope,cartItems,$http) {
	// console.log(allSnacks.list());
	$scope.cartItems = cartItems.orders;
	/*$scope.lname;
	$scope.fnum;*/
	
	$scope.lname;
	
		 
$scope.user= {};

$scope.location;
$scope.Names;
$scope.stu_ID;
	console.log($scope.lname);
	$scope.name=[];
	$scope.quantity=[];
	$scope.tots=[];
	 console.log("run");
	  console.log($scope.Names);
	  console.log("name is" ); 
	$scope.adds = function()
	{	 console.log("add startn");
		for( var i = 0; i < $scope.cartItems.length; ++i ) {
			 console.log("add fin");
			 console.log( $scope.cartItems[i].name);
			 console.log("add fina");
			 $scope.tots[i]= $scope.cartItems[i].total;
			 console.log( $scope.tots);
				$scope.name[i]=$scope.cartItems[i].name; console.log("add finc");
		     	$scope.quantity[i]=$scope.cartItems[i].qtys;
		     	 console.log("add find");
		     	//$scope.user.snack= $scope.name.toString();
		     	
		     	$scope.user.snack= $scope.name.toString(); console.log("add fi");
		     	$scope.user.qty= $scope.quantity.toString(); console.log("add fa");
		     	$scope.user.total= $scope.tots.toString(); 
		     	
		     
		     console.log($scope.user); 
		    
		     console.log($scope.Location);
		     
		}
	}
	$scope.addreq = function (){$http({
		method:'POST',
	    url:'/api/request/add',
	    
			data: $scope.user
		
				}).then(function(response)
						{	console.log($scope.user);
							console.log($scope.user.snack);
							console.log($scope.user);
							})};
}]);