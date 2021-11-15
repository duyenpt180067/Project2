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
					<h1>Create Orders</h1>
				</div>
				<div class="col-sm-6">
					<ol class="breadcrumb float-sm-right">
						<li class="breadcrumb-item"><a href="#">Home</a></li>
						<li class="breadcrumb-item active">Add Orders</li>
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
								<h3 class="card-title">Orders Form</h3>
							</div>
							<!-- /.card-header -->
							<!-- form start -->
							<f:form action="addOrders.htm" modelAttribute="OrdersNew">
								<div class="card-body">
									<!--<div class="form-group">
										<label for="orderId">Order Id</label>
										<input type="text" name="orderId" class="form-control" placeholder="OrderId"/>
									</div>-->
									<div class="form-group">
										<label for="userId">User Name</label>
										<f:select path="user.userId" class="form-control">
											<c:forEach items="${listWebUsers }" var="user">
												<f:option value="${user.userId }">${user.username }</f:option>
											</c:forEach>
										</f:select>
									</div>
									<div class="form-group">
										<label for="created">Created</label>
										<input type="date" name="created" class="form-control"/>
									</div>
									<div class="form-group">
										<label for="orderId">Receiver's Name</label>
										<input type="text" name="nameReceiver" class="form-control" placeholder="Phone"/>
									</div>
									<div class="form-group">
										<label for="orderId">Address</label>
										<input type="text" name="addresses" class="form-control"/>
									</div>
									<div class="form-group">
										<label for="orderId">Receiver's Phone</label>
										<input type="number" name="phone" class="form-control" placeholder="Phone"/>
									</div>
									<div class="form-group">
										<label for="orderStatus">Order Status</label>
										<f:select path="orderStatus" class="form-control">
											<f:option value="cho xu ly">cho xu ly</f:option>
											<f:option value="dang van chuyen">dang van chuyen</f:option>
											<f:option value="da thanh toan">da thanh toan</f:option>
										</f:select>
									</div>
								</div>
								<!-- /.card-body -->

								<div class="card-footer" style="background-color: white;">
									<button type="submit" class="btn btn-primary">Add</button>
									<button class="btn btn-dark">
										<a href="/FoodAdmin/AdminController/orders/list.htm" style="color: white;">Back</a>
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