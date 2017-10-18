(function () {
    'use strict';
    var questionApp = angular.module('questionApp');
    questionApp.service('fileUploadService', function ($http, $q) {

        this.uploadFileToUrl = function (file, questionid, option, uploadUrl) {
            //FormData, object of key/value pair for form fields and values
            var fileFormData = new FormData();
            		
            fileFormData.append('file', file);
            fileFormData.append('questionid', questionid);
            fileFormData.append('option', option);
            		
    		var request = $http({
		            	method: "POST",
		            	url: uploadUrl,
		            	data: fileFormData,
		            	headers: {
		            		"Content-Type": undefined
		            	},
		            	 transformRequest: angular.identity
		            });

            return request;
        }
        
        this.getUploadedImage = function (url) {
            //FormData, object of key/value pair for form fields and values
            		
    		var request = $http({
		            	method: "GET",
		            	url: url,
		            	data: null,
		            });

            return request;
        }
    });
    
    questionApp.service('viewService', function ($http, $q) {

        this.getRelatedFieldParams = function (getRelatedFieldParamsUrl) {
                        		
    		var request = $http({
		            	method: "GET",
		            	url: getRelatedFieldParamsUrl
		            });

            return request;
        }
        
        this.viewQuestions = function (viewCriteriaModel, viewQuestionUrl) {
    		
    		var request = $http({
		            	method: "POST",
		            	url: viewQuestionUrl,
		            	data: JSON.stringify(viewCriteriaModel),
		            	headers: {
		            		"Content-Type": "application/json"
		            	},
		            });

            return request;
        }
    });
    
    questionApp.service('addService', function ($http, $q) {

        this.addQuestions = function (data, url) {
            //FormData, object of key/value pair for form fields and values
            		
    		var request = $http({
		            	method: "POST",
		            	url: url,
		            	data: JSON.stringify(data),
		            	headers: {
		            		"Content-Type": "application/json"
		            	},
//		            	 transformRequest: angular.identity
		            });

            return request;;
        }
        
        this.addRelatedTo = function (data, url) {
            //FormData, object of key/value pair for form fields and values
            		
    		var request = $http({
		            	method: "POST",
		            	url: url,
		            	data: JSON.stringify(data),
		            	headers: {
		            		"Content-Type": "application/json"
		            	},
//		            	 transformRequest: angular.identity
		            });

            return request;;
        }
    });
    
})();