(function() {
	'use strict';
	var questionApp = angular.module('questionApp', []);
	questionApp
			.controller(
					'questionController',
					function($scope, fileUploadService, viewService,
							addService) {

						$scope.relatedField = [];
						$scope.relatedFieldParams = null;
						$scope.init = function() {
							if ($scope.relatedFieldParams == null) {
								var uploadUrl = "http://localhost:8080/question/viewAllExam", promise = viewService
										.getRelatedFieldParams(uploadUrl);
								promise.then(function success(response) {
									$scope.relatedFieldParams = {
										"exams" : response.data
									};
								}, function error(response) {
									$scope.relatedField = [];
								})
							}
						};

						$scope.changeIcon = function(index) {
							$scope.input.image[index] = $scope.input.image[index] === "../images/right.png" ? "../images/down.png"
									: "../images/right.png";
						};

						$scope.makeQuestionPreview = function(index) {
							var input = $('#question' + index).val();
							$('#preview' + index).html(input);
							MathJax.Hub.Queue([ "Typeset", MathJax.Hub,
									"preview" + index ]);
							$('#qpreview' + index).html(input);
							MathJax.Hub.Queue([ "Typeset", MathJax.Hub,
									"qpreview" + index ]);
							/*var output = angular.element(document.querySelector("#previewhtml"+index));
							output["0"].innerHTML = input;*/
						};

						$scope.makeOptionPreview = function(index) {
							var length = $scope.questionModels[index].options.option.length;
							for (var i = 0; i < length; i++) {
								var input = $scope.questionModels[index].options.option[i];
								$(('#option' + i) + index).html(input);
								MathJax.Hub.Queue([ "Typeset", MathJax.Hub,
										("option" + i) + index ]);
								$(('#qoption' + i) + index).html(input);
								MathJax.Hub.Queue([ "Typeset", MathJax.Hub,
										("qoption" + i) + index ]);
							}
							for (var i = length; i < 4; i++) {
								$(('#option' + i) + index).html("");
								$(('#qoption' + i) + index).html("");
							}
							/*var output = angular.element(document.querySelector("#previewhtml"+index));
							output["0"].innerHTML = input;*/
						};

						$scope.uploadFile = function(x, y, file, id, option) {
							// var file = $scope.input.questionImage;
							var uploadUrl = "http://localhost:8080/question/uploadImage", promise = fileUploadService
									.uploadFileToUrl(file, id, option, uploadUrl);

							promise.then(function success(response) {
								
								$scope.getUploadedImage(response.data.path, x);
								
//								x.push(response.data.path);
								
							}, function error(response) {
								alert('An error has occurred');
							})
						};
						
						$scope.getUploadedImage = function(imagePath, imageArr) {
							var uploadUrl = window.location.origin + imagePath.substring(2), 
							promise = fileUploadService
							.getUploadedImage(uploadUrl);
							
							promise.then(function success(response) {
								imageArr.push(imagePath);
//								noty({text: 'Image uploaded successfully.', type: 'success'});
								
								$scope.showNotification("Image uploaded successfully.", "success")
							}, function error(response) {
								setTimeout(function() {
									$scope.getUploadedImage(imagePath, imageArr);
								}, 1000);
							})
						}
						
						$scope.showNotification = function(message, type) {
							var alertType = function() {
								if(type === "success") {
									return "Success!"
								} else if(type === "error") {
									return "Error!"
								}
							}();
							$('#alertType').html(alertType);
							$('#alertMsg').html(message);
							$('#notification').addClass('alert-' + type).css({display:'block'});
							setTimeout(function() {
								$('#notification').removeClass('alert-' + type).css({display:'none'});
							}, 5000);
						}
						
						$scope.types = [ "Previous Year", "Test Series",
								"Normal" ];
						$scope.marks = [ 1,2,3,4,5,6,7,8,9,10 ];
						$scope.years = [ 2000,2001,2002,2003,2015,2016,2017 ];
						$scope.tags = [ "Language", "Project", "General" ];
						$scope.searchCriteria = {
								exam : null,
								stream : null,
								subject : null,
								topic : null,
								subTopic : null,
								marks : null,
								type : null,
								fromYear : null,
								toYear : null
							};
						$scope.input = {
							image : [],
							language : "Select Language",
							project : "Select Project",
							other : "Select Others",
							newOptionVal : "",
							selectedExam : "Select Exam",
							selStream : "Select Stream",
							selSubject : "Select Subject",
							selTopic : "Select Topic",
							selSubTopic : "Select Sub-Topic",
							newPathVal : "",
							questionImage : null,
							optionImage : null,
							showSubmitPreviewButton : false,
							isImageAvailable : []
						};

						$scope.fileNameChanged = function(ele) {
							var files = ele.files;
							var l = files.length;
							var namesArr = [];

							for (var i = 0; i < l; i++) {
								namesArr.push(files[i].name);
							}
							$scope.namesString = namesArr.join(' ,');
							$scope.$apply();
							reader.readAsText(ele.files[0]);
							var reader = new FileReader();
							reader.onload = function() {
								$scope.fileContent = reader.result;
								$scope.$apply();
							}
						};

						$scope.addOption = function(newOptionVal, index, image) {
							if (newOptionVal && newOptionVal != "") {
								$scope.questionModels[index].options.option
										.push(newOptionVal);
								if (!image) {
									$scope.questionModels[index].options.imagePath
											.push("BLANK");
								}
								$scope.input.newOptionVal = "";
							}
							$scope.makeOptionPreview(index);
						};

						$scope.addImage = function(newPathVal, index) {
							if (newImageVal && newImageVal != "") {
								$scope.questionModels[index].images.paths
										.push(newPathVal);
								$scope.input.newPathVal = "";
							}
						};

						$scope.removeQuestion = function(questionModels, index) {
							if (questionModels.length == 1) {
								$scope.input.showSubmitPreviewButton = false;
							}
							questionModels.splice(index, 1);
						};

						$scope.removeOption = function(option, index, parentIndex) {
							option.splice(index, 1);
							$scope.makeOptionPreview(parentIndex);
						};

						$scope.questionModels = [];
						$scope.addQuestionModel = function(questionModels) {
							$scope.input.showSubmitPreviewButton = true;
							$scope.input.image.push("../images/right.png");
							$scope.input.isImageAvailable.push("false");
							questionModels.push({
								"id" : Math.random().toString().slice(2,12),
								"question" : "",
								"images" : {
									"paths" : []
								},
								"type" : "",
								"options" : {
									"type" : "Text",
									"option" : [],
									"imagePath" : []
								},
								"hints" : "",
								"marks" : "",
								"year" : "",
								"relatedTo" : {
									"exam" : [],
									"stream" : [],
									"subject" : [],
									"topic" : [],
									"subTopic" : [],
									"tags" : [],
								}
							});
						}

						$scope.addRelatedField = function(questionModel) {
							var relatedToField = questionModel.relatedTo;
							relatedToField.exam
									.push(($scope.input.selectedExam) ? $scope.input.selectedExam.exam
											: "BLANK");
							relatedToField.stream
									.push(($scope.input.selStream) ? $scope.input.selStream.stream
											: "BLANK");
							relatedToField.subject
									.push(($scope.input.selSubject) ? $scope.input.selSubject.subject
											: "BLANK");
							relatedToField.topic
									.push(($scope.input.selTopic) ? $scope.input.selTopic.topic
											: "BLANK");
							relatedToField.subTopic
									.push(($scope.input.selSubTopic) ? $scope.input.selSubTopic.subTopic
											: "BLANK");
						}

						$scope.removeRelatedField = function(questionModel,
								index) {
							var relatedToField = questionModel.relatedTo;
							relatedToField.exam.splice(index, 1);
							relatedToField.stream.splice(index, 1);
							relatedToField.subject.splice(index, 1);
							relatedToField.topic.splice(index, 1);
							relatedToField.subTopic.splice(index, 1);
							relatedToField.language.splice(index, 1);
							relatedToField.project.splice(index, 1);
							relatedToField.other.splice(index, 1);
						}

						$scope.submitQuestion = function(questions) {
							var url = "http://localhost:8080/question/insert", // Url
							// of
							// webservice/api/server
							promise = addService.addQuestions(
									questions, url);

							promise.then(function success(response) {
								debugger;
							}, function error(response) {
								debugger;
							});
						}

						$scope.viewQuestion = function() {
							var url = "http://localhost:8080/question/fetch", promise;
							var viewCriteriaModel = {
									"relatedTo" : {
										"exam" : [$scope.searchCriteria.exam["exam"]],
										"stream" : [$scope.searchCriteria.stream["stream"]],
										"subject" : [$scope.searchCriteria.subject["subject"]],
										"topic" : [$scope.searchCriteria.topic["topic"]],
										"subTopic" : [($scope.searchCriteria.subTopic != null) ? $scope.searchCriteria.subTopic["subTopic"] : null],
										"tags" : []
									},
									"type" : $scope.searchCriteria.type,
									"marks" : $scope.searchCriteria.marks,
									"fromYear" : $scope.searchCriteria.fromYear,
									"toYear" : $scope.searchCriteria.toYear
								};
							promise = viewService.viewQuestions(
									viewCriteriaModel, url);

							promise.then(function success(response) {
								$scope.questionModels = response.data;
							}, function error(response) {
								debugger;
							});
						}

					});

})();