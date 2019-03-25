/*
///<reference path="angular.min.js" />
var myApp = angular
    .module("shop", [])
    .controller("requestController", function ($scope) {
       scope.message="it worked";
    });*/
    /*
var myApp = angular
.module("shop", [])
   /* .factory('helperFactory', function()
    {
         return{
             filterFieldArayByDone : function(thisArray,thisField,thisValue)
             {
                var arrayToReturn = [];
                for (var i =0;i < thisArray.length; i++)
                    {
                        if (thisArray[i].avl == thisValue)
                        {
                            arrayToReturn.push(thisArray[i][thisField]);
                        }
                    }
                return arrayToReturn;
             }
         }
    })
    .controller("requestController", function($scope)
        { scope.message="it worked";
           var snacks = 
                {
                    name: 'cheetos'};
                //,i:"1",price:"50",QTY:"10",AVL:"" }, 
                /*{name= "Dorito",id="2",price="50",QTY="10",AVL="" }, 
                {name= "Cheeses",id="3",price="50",QTY="10",AVL="" }, 
                {name= "bun",id="4",price="50",QTY="10",AVL="" } 

                
            ;
            $scope.snacks = snacks;
        }
   */    
    var myApp = angular
    .module("shop", [])
    
    .controller("Controller",['$scope', function ($scope) {
        $scope.loginUser = function(user){
            if(user.username == 'demo' && user.password == 'demo'){
               var path = "afterLogin.html";
            window.location.href = path;

            }
            else{
                alert('Wrong credentials')
            }
        }
       var snacks = [
                {
                    name: 'cheetos',qty:'10',price:'50'},
              {  name: 'cheeto', qty:'11',price:'60'}
       ]
              //  {name= "bun",id="4",price="50",QTY="10",AVL="" } 

                
            ;
            $scope.id='';
            $scope.name='';
            $scope.snacks = snacks;
            $scope.request = [];
            $scope.req={
                id:'',name:'',qty:'',location:'',snack:{  name: '', qty:'',price:''}
            }

      $scope.update = function(req) {
        

          $scope.req.snack
        $scope.request.push(angular.copy(req)) ;
         console.log($scope.req.snack.price);
         //console.log(request);
      };


            /*$scope.request={};
            $scope.add= function()
        {
           $scope.request= angular.copy(req);
            console.log("it worked");
        };*/
            
        }
        
        
     ] );
























        
    
    
   // );

    

        /*
         $scope.insert = function()
        {   var thisData= "stu_ID="+ scope.stud_id + "&Name="+ scope.stud_name+ "&Location=" + scope.Location + "&Snack="+ scope.snack;
          
            $http({
                method : 'POST',
                url : urlInsert,
                data : thisData,
                headers : {'Content-Type' : 'application/x-www-form-urlencoded'}*/
    