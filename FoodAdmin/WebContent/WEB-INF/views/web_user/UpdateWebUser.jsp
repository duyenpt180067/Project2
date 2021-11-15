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
					<h1>Update WebUser</h1>
				</div>
				<div class="col-sm-6">
					<ol class="breadcrumb float-sm-right">
						<li class="breadcrumb-item"><a href="#">Home</a></li>
						<li class="breadcrumb-item active">Update WebUser</li>
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
							<f:form action="updateWebUser.htm" modelAttribute="WebUserUp">
								<div class="card-body">
									<div class="form-group">
										<label for="userId">User Id</label>
										<f:input type="text" path="userId" readonly="true" class="form-control" placeholder="User Id"/>
									</div>
									<div class="form-group">
										<label for="userName">User Name</label>
										<f:input type="text" path="username" class="form-control" placeholder="User Name"/>
									</div>
									<div class="form-group">
										<label for="pass">Password</label>
										<f:input type="text" path="password" class="form-control" placeholder="Password"/>
									</div>
									<div class="form-group">
										<label for="phone">Phone</label>
										<f:input type="number" path="phone" class="form-control" placeholder="Phone"/>
									</div>
									<div class="form-group">
										<label for="addresses">Address</label>
										<f:input type="text" path="addresses" class="form-control" placeholder="Address"/>
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
									<button type="submit" class="btn btn-warning">Update</button>
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