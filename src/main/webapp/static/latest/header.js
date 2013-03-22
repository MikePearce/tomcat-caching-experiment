function HeaderCtrl($scope, $http) {
    $http.get('/rest/navigation').success(function(data) {
        $scope.menuItemList = data;
    })
}

HeaderCtrl.$inject = ['$scope', '$http'];