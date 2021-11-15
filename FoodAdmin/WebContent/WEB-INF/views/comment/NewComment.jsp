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
					<h1>Create Comment</h1>
				</div>
				<div class="col-sm-6">
					<ol class="breadcrumb float-sm-right">
						<li class="breadcrumb-item"><a href="#">Home</a></li>
						<li class="breadcrumb-item active">Add Comment</li>
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
								<h3 class="card-title">Comment Form</h3>
							</div>
							<!-- /.card-header -->
							<!-- form start -->
							<f:form action="addComment.htm" modelAttribute="CommentNew">
								<div class="card-body">
									<div class="form-group">
										<label for="userId">User Id</label>
										<f:select path="user.userId" class="form-control">
											<c:forEach items="${listWebUsers }" var="user">
												<f:option value="${user.userId }">${user.userId }</f:option>
											</c:forEach>
										</f:select>
									</div>
									<div class="form-group">
										<label for="foodId">Food Id</label>
										<f:select path="food.foodId" class="form-control">
											<c:forEach items="${listFoods }" var="food">
												<f:option value="${food.foodId }">${food.foodId }</f:option>
											</c:forEach>
										</f:select>
									</div>
									<div class="form-group">
										<label for="content">Content</label>
										<textarea name="content" class="form-control"
											placeholder="Content" class="note-codable" aria-multiline="true"></textarea>
									</div>
									<div class="form-group">
										<label for="status">Status</label>
										<f:select path="commentStatus" class="form-control">
											<f:option value="true">Active</f:option>
											<f:option value="false">InActive</f:option>
										</f:select>
									</div>
									<div class="form-group">
										<label for="created">Created</label>
										<input type="date" name="created" value="2020-09-04" class="form-control"/>
									</div>
									<div class="form-group">
										<label for="parentId">Parent Id</label>
										<f:select path="parentId" class="form-control">
											<c:forEach items="${listParentId }" var="parentId">
												<f:option value="${parentId }">${parentId }</f:option>
											</c:forEach>
										</f:select>
									</div>
									<div class="form-group">
										<label for="rating">Rating</label>
										<f:select path="rating" class="form-control">
											<c:forEach items="${listRating }" var="rating">
												<f:option value="${rating }">${rating }</f:option>
											</c:forEach>
										</f:select>
									</div>
								</div>
								<!-- /.card-body -->

								<div class="card-footer" style="background-color: white;">
									<button type="submit" class="btn btn-primary">Add</button>
									<button class="btn btn-dark">
										<a href="/FoodAdmin/AdminController/comment/list.htm" style="color: white;">Back</a>
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