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
					<h1>Create Food</h1>
				</div>
				<div class="col-sm-6">
					<ol class="breadcrumb float-sm-right">
						<li class="breadcrumb-item"><a href="#">Home</a></li>
						<li class="breadcrumb-item active">Add Food</li>
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
								<h3 class="card-title">Food Form</h3>
							</div>
							<!-- /.card-header -->
							<!-- form start -->
							<f:form action="addFood.htm" modelAttribute="FoodNew">
								<div class="card-body">
									<div class="form-group">
										<label for="caId">Catalog Id</label>
										<f:select path="catalog.caId" class="form-control">
											<c:forEach items="${listCategoriess }" var="catalog">
												<f:option value="${catalog.caId }">${catalog.caId }</f:option>
											</c:forEach>
										</f:select>
									</div>
									<div class="form-group">
										<label for="foodId">Food Id</label>
										<input type="text" name="foodId" class="form-control" placeholder="Food Id"/>
									</div>
									<div class="form-group">
										<label for="foodName">Food Name</label>
										<input type="text" name="foodName" class="form-control" placeholder="Food Name"/>
									</div>
									<div class="form-group">
										<label for="descriptions">Description</label>
										<textarea name="descriptions" class="form-control"
											placeholder="Description" class="note-codable" value="Although the legendary Double Burger really needs no introduction, please allow us... Tucked in between three soft buns are two all-beef patties, cheddar cheese, ketchup, onion, pickles and iceberg lettuce. Hesburger's own paprika and cucumber mayonnaise add the crowning touch. Oh baby!" aria-multiline="true"></textarea>
									</div>
									<div class="form-group">
										<label for="descriptions">Title</label>
										<input type="text" name="title" value="Dr. Praeger's Black Bean Burger, Focaccia bun, Balsamic Vinaigrette, Pesto, Tomato, Swiss Cheese" class="form-control" placeholder="Title"/>
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
									<div class="form-group">
										<label for="status">Status</label>
										<f:select path="foodStatus" class="form-control">
											<f:option value="true">Active</f:option>
											<f:option value="false">InActive</f:option>
										</f:select>
									</div>
									<div class="form-group">
										<label for="created">Created</label>
										<input type="date" value="2019-01-01" name="created" class="form-control"/>
									</div>
									<div class="form-group">
										<label for="created">Release Date</label>
										<input type="date" name="releaseDate" value="2020-01-01" class="form-control"/>
									</div>
									<div class="form-group">
										<label for="discount">Discount</label>
										<input type="number" name="discount" class="form-control" placeholder="Discount"/>
									</div>
									<div class="form-group">
										<label for="foodView">Views</label>
										<input type="number" name="foodView" class="form-control" placeholder="Views"/>
									</div>
								</div>
								<!-- /.card-body -->

								<div class="card-footer" style="background-color: white;">
									<button type="submit" class="btn btn-primary">Add</button>
									<button class="btn btn-dark">
										<a href="/FoodAdmin/AdminController/food/list.htm" style="color: white;">Back</a>
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