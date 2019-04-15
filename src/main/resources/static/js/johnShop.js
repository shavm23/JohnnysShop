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
	$scope.user=
		{	pic:'',
			snack:'',
			qty:''
		};
	$scope.name=[];
	$scope.quantity=[];
	 console.log("run");
	  console.log($scope.cartItems);
	$scope.adds = function()
	{	 console.log("add startn");
		for( var i = 0; i < $scope.cartItems.length; ++i ) {
			 console.log( $scope.cartItems[i].name);
				$scope.name[i]=$scope.cartItems[i].name;
		     	$scope.quantity[i]=$scope.cartItems[i].qtys;
		     	//$scope.user.snack= $scope.name.toString();
		     	
		     	$scope.user.snack= $scope.name.toString();
		     	$scope.user.qty= $scope.quantity.toString();
		     	
		     
		     console.log($scope.user.snack); 
		    
		     console.log($scope.user.qty);
		     
		}
	}
	$scope.addreq = function (){$http({
		method:'POST',
	    url:'/api/request/add',
	    
			data: $scope.user
		
				}).then(function(response)
						{	
							console.log($scope.user.snack);
							
							})};
}]);/*
myApp.controller('dbcontrolerr', ['$scope','cartItems','cartController', function($scope,cartItems,cartController) {
	console.log($scope.cartItems);
	/*console.log($scope.cartItems[0].name);*/
	/*$scope.name=[];
	$scope.quantity=[];
	//$scope.cartItems = cartItems.orders;
	$scope.add = function(){ for( var i = 0; i < cartItems.orders; ++i ) {
     
     };
 
	
	  
	  
}]);*/
/*
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
		/*$scope.showreq= function(){$http({
		  method:'GET',
			  url:'/api/request/all'})
			  .then(function(response)
			  {
			  	$scope.cart= response.data;
			  	console.log($scope.cart);
			  	
			  })};*
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
*/