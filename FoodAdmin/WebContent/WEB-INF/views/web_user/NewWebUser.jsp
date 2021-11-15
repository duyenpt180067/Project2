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
					<h1>Add WebUser</h1>
				</div>
				<div class="col-sm-6">
					<ol class="breadcrumb float-sm-right">
						<li class="breadcrumb-item"><a href="#">Home</a></li>
						<li class="breadcrumb-item active">Add WebUser</li>
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
								<h3 class="card-title">WebUser Form</h3>
							</div>
							<!-- /.card-header -->
							<!-- form start -->
							<f:form action="addWebUser.htm" modelAttribute="WebUserNew">
								<div class="card-body">
									<div class="form-group">
										<label for="userName">User Name</label>
										<input type="text" id="username" name="username" class="form-control" placeholder="User Name"/>
									</div>
									<p class="user-message"></p>
									<div class="form-group">
										<label for="pass">Password</label>
										<input type="text" id="password" name="password" class="form-control" placeholder="Password"/>
									</div>
									<div class="form-group">
										<label for="phone">Phone</label>
										<input type="number" id="phone" name="phone" class="form-control" placeholder="Phone"/>
									</div>
									<div class="form-group">
										<label for="addresses">Address</label>
										<input type="text" id="address" name="addresses" class="form-control" placeholder="Address"/>
									</div>
									<div class="form-group">
										<label for="permission">Permission</label>
										<f:select path="permission" class="form-control">
											<f:option value="true">Yes</f:option>
											<f:option value="false">No</f:option>
										</f:select>
									</div>
									<div class="form-group">
										<label for="userStatus">User Status</label>
										<f:select path="userStatus" class="form-control">
											<c:forEach items="${listStatus }" var="status">
												<f:option value="${status }">${status }</f:option>
											</c:forEach>
										</f:select>
									</div>
									<div class="form-group">
										<label for="isadmin">Is Admin?</label>
										<f:select path="isadmin" class="form-control">
											<f:option value="true">Yes</f:option>
											<f:option value="false">No</f:option>
										</f:select>
									</div>
								</div>
								<!-- /.card-body -->

								<div class="card-footer" style="background-color: white;">
									<button type="submit" class="btn btn-primary">Add</button>
									<button class="btn btn-dark">
										<a href="/FoodAdmin/AdminController/web_user/list.htm" style="color: white;">Back</a>
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
$(document).ready(function() {
	$('#username').blur(function() {
		$.ajax({
			url : "http://localhost:8080/api/v1/webUser/findWebUserByName/"+$('#username').val(),
            type: 'GET',
			
			success : function(response) {
               if (response)
            	   alert("This username is already");
			}
		});
	});
});
</script>