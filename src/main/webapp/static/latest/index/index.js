function ContentCtrl($scope, $http) {
    $http.get('/rest/${version}/content').success(function(data) {
        $scope.content = data;
    })
}

ContentCtrl.$inject = ['$scope', '$http'];