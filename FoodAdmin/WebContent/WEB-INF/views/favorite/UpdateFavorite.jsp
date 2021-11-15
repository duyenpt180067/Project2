<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>

<%@include file="../home/header.jsp"%>
<%@include file="../home/aside.jsp"%>
<div class="content-wrapper">
	<section class="content-header">
		<div class="container-fluid">
			<div class="row mb-2">
				<div class="col-sm-6">
					<h1>Update Favorite</h1>
				</div>
				<div class="col-sm-6">
					<ol class="breadcrumb float-sm-right">
						<li class="breadcrumb-item"><a href="#">Home</a></li>
						<li class="breadcrumb-item active">Update Favorite</li>
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
								<h3 class="card-title">Favorite Form</h3>
							</div>
							<!-- /.card-header -->
							<!-- form start -->
							<f:form action="updateFavorite.htm" modelAttribute="FavoriteUp">
								<div class="card-body">
									<div class="form-group">
										<label for="favoriteId">Favorite Id</label>
										<f:input type="text" path="favoriteId" readonly="true" class="form-control" />
									</div>
									<!--<div class="form-group">
										<label for="qId">User Id</label>
										<f:select path="user.userId" class="form-control">
											<c:forEach items="${listWebUsers }" var="user">
												<f:option value="${user.userId }">${user.userId }</f:option>
											</c:forEach>
										</f:select>
									</div>-->
									<div class="form-group">
										<label for="qId">Food Id</label>
										<f:select path="food.foodId" class="form-control">
											<c:forEach items="${listFoods }" var="food">
												<f:option value="${food.foodId }">${food.foodId }</f:option>
											</c:forEach>
										</f:select>
									</div>
									<div class="form-group">
										<label for="likes">Likes</label>
										<f:input type="number" path="likes" class="form-control" />
									</div>
								</div>
								<!-- /.card-body -->

								<div class="card-footer" style="background-color: white;">
									<button type="submit" class="btn btn-warning">Update</button>
									<button class="btn btn-dark">
										<a href="/FoodAdmin/AdminController/favorite/list.htm" style="color: white;">Back</a>
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
