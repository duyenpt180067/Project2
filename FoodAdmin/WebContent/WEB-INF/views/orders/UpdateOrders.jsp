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
					<h1>Update Order</h1>
				</div>
				<div class="col-sm-6">
					<ol class="breadcrumb float-sm-right">
						<li class="breadcrumb-item"><a href="#">Home</a></li>
						<li class="breadcrumb-item active">Update Orders</li>
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
							<f:form action="updateOrders.htm" modelAttribute="OrdersUp">
								<div class="card-body">
									<div class="form-group">
										<label for="orderId">Order Id</label>
										<f:input type="text" path="orderId" class="form-control" readonly="true"/>
									</div>
									<div class="form-group">
										<label for="userId">User Id</label>
										<%-- <f:select path="user.userId" class="form-control" readonly="true">
											<c:forEach items="${listWebUsers }" var="user">
												<f:option value="${user.userId }">${user.userId }</f:option>
											</c:forEach>
										</f:select> 
										value="${OrdersUp.user.username }"--%>
										<f:input class="form-control" type= "text" path="user.userId" readonly="true"/>
									</div>
									<div class="form-group">
										<label for="created">Created</label>
										<input type="date" name="created" value="${OrdersUp.created }" class="form-control" readonly="true"/>
									</div>
									<div class="form-group">
										<label for="orderId">Receiver's Name</label>
										<f:input type="text" path="nameReceiver" class="form-control" readonly="true"/>
									</div>
									<div class="form-group">
										<label for="orderId">Address</label>
										<f:input type="text" path="addresses" class="form-control" readonly="true"/>
									</div>
									<div class="form-group">
										<label for="orderId">Receiver's Phone</label>
										<f:input type="number" path="phone" class="form-control" readonly="true"/>
									</div>
									<div class="form-group">
										<label for="orderStatus">Order Status</label>
										<f:select path="orderStatus" class="form-control status" id="statusOrder">
											<f:option value="cho xu ly">cho xu ly</f:option>
											<f:option value="dang van chuyen">dang van chuyen</f:option>
											<f:option value="da thanh toan">da thanh toan</f:option>
										</f:select>
										<input class="form-control" style="visibility: hidden" id="statusOrders" value="da thanh toan"/>
									</div>
								</div>
								<!-- /.card-body -->

								<div class="card-footer" style="background-color: white;">
									<button type="submit" class="btn btn-warning btn-update">Update</button>
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

<script>
	$(function() {
		//$(".btn-upload").click(function(){
		var e = document.getElementById("statusOrder");
		var status = e.options[e.selectedIndex].text;
		if(status=="da thanh toan"){
			document.getElementById("statusOrders").style.visibility = "visible";
			document.getElementById("statusOrders").setAttribute("readonly", true);
			e.style.visibility = "hidden";
		}
			/* var length = e.options.length;
			for (i = length-2; i >= 0; i--) {
			  //if(e.options[i] != "da thanh toan"){
				  e.remove(i);
			  //}
			} */
			//$("statusOrder").append('<option value="da thanh toan">da thanh toan</option>');
			/* e.setAttribute("disabled", true);
			$('#animal-select')
	        .attr('disabled', false)
	    	.attr('name', 'animal'); */
			/* $(".btn-update").click(function(){
				$("statusOrder").append('<option value="da thanh toan">da thanh toan</option>');
				e.setAttribute("disabled", false);
			}) */
		//}
	})
</script>