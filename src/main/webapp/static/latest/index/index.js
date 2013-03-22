function ContentCtrl($scope, $http) {
    $http.get('/rest/content').success(function(data) {
        $scope.content = data;
    })
}

ContentCtrl.$inject = ['$scope', '$http'];