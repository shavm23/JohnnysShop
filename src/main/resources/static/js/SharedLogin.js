angular.module('service',[])

/*myApp.factory("allSnacks", function($http) { 
    return {
        getData: function () {
            return $http.get("/api/Snack/all'").then(function (response) {
              return response.data; 
            });console.log(getData);
        }
    }
});*/
	
.service('allReqs', function ($http) {
	  
			  this.get = (callback) => 
			  {
				  return $http.get('/api/request/all').then(callback)
			  };
			  
          
    
})
.service('allSnacks', function ($http,$window) {
	  
	
	  this.get = (callback) => 
	  {
		  return $http.get('/api/Snack/all').then(callback)
	  };
	


});
