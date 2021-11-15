<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<!DOCTYPE html>

<%@include file="../home/header.jsp"%>
<%@include file="../home/aside.jsp"%>
<div class="content-wrapper">
	<section class="content-header">
		<div class="container-fluid">
			<div class="row mb-2">
				<div class="col-sm-6">
					<h1>Update Slider</h1>
				</div>
				<div class="col-sm-6">
					<ol class="breadcrumb float-sm-right">
						<li class="breadcrumb-item"><a href="#">Home</a></li>
						<li class="breadcrumb-item active">Update Slider</li>
					</ol>
				</div>
			</div>
		</div>
		<!-- /.container-fluid -->
	</section>

	<!-- Main content -->
	<section class="content">
		<div class="container-fluid">
			<div class="row">
				<div class="col-12">
					<div class="card">
						<div class="card card-primary">
							<div class="card-header">
								<h3 class="card-title">Slider Form</h3>
							</div>
							<!-- /.card-header -->
							<!-- form start -->
							<f:form action="updateSlider.htm" modelAttribute="SliderUp">
								<div class="card-body">
									<div class="form-group">
										<label for="slideId">Slide Id</label>
										<f:input type="text" path="sliderId" readonly="true" class="form-control" />
									</div>
									<div class="form-group">
										<label for="imageURL">Image</label>
										<div class="row">
											<div class="col-3">
												<input type="file" id="imageURL" value="${ FoodUp.imageURL}" class="form-control" style="padding: 0;height: 32px;"/>
												<f:input type="text" class="urlImage" path="imageURL" style="display: none" />
											</div>
											<div class="col-5">
												<button type="button" class="btn-upload">Upload</button>
											</div>
										</div>
										<img src= "${ SliderUp.imageURL}" class="imgShow" style="width:175px" />
									</div>
									<div class="form-group">
										<label for="sliderLink">Slider Link</label>
										<f:input type="text" path="sliderLink" class="form-control" />
									</div>
									<div class="form-group">
										<label for="sliderStatus">Slider Status</label>
										<f:select path="sliderStatus" class="form-control">
											<f:option value="true">Active</f:option>
											<f:option value="false">InActive</f:option>
										</f:select>
									</div>
									<div class="form-group">
										<label for="priority">Priority</label> 
										<f:input type="number" path="priorities" class="form-control"  />
									</div>
								</div>
								<!-- /.card-body -->

								<div class="card-footer" style="background-color: white;">
									<button type="submit" class="btn btn-warning">Update</button>
									<button class="btn btn-dark">
										<a href="/FoodAdmin/AdminController/slider/list.htm" style="color: white;">Back</a>
									</button>
								</div>
							</f:form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
</div>
<%@include file="../home/footer.jsp"%>

<script>
	$(function() {
		$(".btn-upload").click(function(){
			var frmData = new FormData();
			frmData.append("file", $('#imageURL')[0].files[0]);
			$.ajax({
				type: "POST",
				url: "http://localhost:8080/api/v1/file/uploads",
				data: frmData,
				processData: false,  // tell jQuery not to process the data
			    contentType: false,
				success: function(res) {
					$('.urlImage').val(res.fileDownloadUri);
					$('.imgShow').attr('src', res.fileDownloadUri);
					console.log(res);
				}
			})
		})
	})
</script>