function HeaderCtrl($scope, $http) {
    $http.get('/rest/${version}/navigation').success(function(data) {
        $scope.menuItemList = data;
    })
}

HeaderCtrl.$inject = ['$scope', '$http'];