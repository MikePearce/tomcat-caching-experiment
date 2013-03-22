function ContentCtrl($scope, $http) {
    $http.get('/dynamic/content').success(function(data) {
        $scope.content = data;
    })
}

ContentCtrl.$inject = ['$scope', '$http'];