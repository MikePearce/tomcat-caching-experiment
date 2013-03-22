function HeaderCtrl($scope, $http) {
    $http.get('/dynamic/navigation').success(function(data) {
        $scope.menuItemList = data;
    })
}

HeaderCtrl.$inject = ['$scope', '$http'];