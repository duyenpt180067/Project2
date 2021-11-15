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
					<h1>Create Blog</h1>
				</div>
				<div class="col-sm-6">
					<ol class="breadcrumb float-sm-right">
						<li class="breadcrumb-item"><a href="/FoodAdmin/AdminController/home">Home</a></li>
						<li class="breadcrumb-item active">Add Blog</li>
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
								<h3 class="card-title">Blog Form</h3>
							</div>
							<!-- /.card-header -->
							<!-- form start -->
							<f:form action="addBlog.htm" modelAttribute="BlogNew">
								<div class="card-body">
									<div class="form-group">
										<label for="title">Blog Name</label>
										<input name="blogName" class="form-control note-codable" placeholder="Blog Name"/>
									</div>
									<div class="form-group">
										<label for="title">Title</label>
										<textarea name="title" class="form-control note-codable" placeholder="Title"></textarea>
									</div>
									<div class="form-group">
										<label for="descriptions">Description</label>
										<textarea name="descriptions" class="form-control"
											placeholder="Description" class="note-codable" aria-multiline="true"></textarea>
									</div>
									<div class="form-group">
										<label for="created">Created</label>
										<input type="date" name="created" class="form-control"/>
									</div>
									<div class="form-group">
										<label for="userId">User Id</label>
										<f:select path="user.userId" class="form-control">
											<c:forEach items="${listWebUsers }" var="user">
												<f:option value="${user.userId }">${user.userId }</f:option>
											</c:forEach>
										</f:select>
									</div>
									<div class="form-group">
										<label for="imageURL">Image</label>
										<div class="row">
											<div class="col-3">
												<input type="file" id="imageURL"  class="form-control" style="padding: 0;height: 32px;"/>
												<input type="text" class="urlImage" name="imageURL" style="display: none" />
											</div>
											<div class="col-5">
												<button type="button" class="btn-upload">Upload</button>
											</div>
										</div>
										<img src="" class="imgShow" style="width:175px" />
									</div>
								</div>
								<!-- /.card-body -->

								<div class="card-footer" style="background-color: white;">
									<button type="submit" class="btn btn-primary">Add</button>
									<button class="btn btn-dark">
										<a href="/FoodAdmin/AdminController/blog/list.htm" style="color: white;">Back</a>
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