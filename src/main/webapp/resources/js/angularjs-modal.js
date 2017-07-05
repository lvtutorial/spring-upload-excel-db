angular.module('ui.bootstrap.modal.app', ['ngAnimate', 'ui.bootstrap']);
angular.module('ui.bootstrap.modal.app').controller('ModalDemoCtrl', function ($scope, $uibModal, $log) {

  //$scope.items = ['item1', 'item2', 'item3'];

  $scope.animationsEnabled = true;

  $scope.open = function (size) { 
	//when click then initial items
	$scope.items = ['item1'];

    var modalInstance = $uibModal.open({
      animation: $scope.animationsEnabled,
      templateUrl: 'idModalContent',
      controller: 'ModalInstanceCtrl',
      size: size,
      resolve: {
        items: function () {
          return $scope.items;
        }
      }
    });

    modalInstance.result.then(function (selectedItem) {
      $scope.selected = selectedItem;
    }, function () {
      $log.info('Modal dismissed at: ' + new Date());
    });
  };

  $scope.toggleAnimation = function () {
    $scope.animationsEnabled = !$scope.animationsEnabled;
  };
  
 
  $scope.remove = function(entity, link) {
	  //$scope.items = eval('(' + entity + ')'); //syntax for object class
	  //$scope.items = JSON.parse(entity); //the same eval('(' + entity + ')');
	  $scope.items = entity;
	  console.log($scope.items);	  
	  /*for (var i in roles) {		  
		  console.log(roles[i].code);
	  }
	  */

	    var modalInstance = $uibModal.open({
	      animation: $scope.animationsEnabled,
	      templateUrl: 'idModalContent',
	      controller: 'ModalInstanceCtrl',
	      size: 0,
	      resolve: {
	        items: function () {
	          return $scope.items;
	        }
	      }
	    });

	    modalInstance.result.then(function (selectedItem) {
	      $scope.selected = selectedItem; //do not need
	      //var data = $scope.items;
	      //$scope.items = data;
	      //console.log(data.id);
	      window.location = link; //apply link, redirect to new link
	      //document.location.href
	            

	    }, function () {
	      $log.info('Modal dismissed at: ' + new Date());
	    });
  };

});

// Please note that $uibModalInstance represents a modal window (instance) dependency.
// It is not the same as the $uibModal service used above.

angular.module('ui.bootstrap.modal.app').controller('ModalInstanceCtrl', function ($scope, $uibModalInstance, items) {

  $scope.items = items;
  $scope.selected = {
    //item: $scope.items[0]
	item: $scope.items
  };

  $scope.ok = function () {
    $uibModalInstance.close($scope.selected.item);
  };

  $scope.cancel = function () {
    $uibModalInstance.dismiss('cancel');
  };
});