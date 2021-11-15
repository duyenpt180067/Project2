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
					<h1>Create Order Detail</h1>
				</div>
				<div class="col-sm-6">
					<ol class="breadcrumb float-sm-right">
						<li class="breadcrumb-item"><a href="#">Home</a></li>
						<li class="breadcrumb-item active">Add Order Detail</li>
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
								<h3 class="card-title">Order Detail Form</h3>
							</div>
							<!-- /.card-header -->
							<!-- form start -->
							<f:form action="addOrderDetail.htm" modelAttribute="OrderDetailNew">
								<div class="card-body">
									<div class="form-group">
										<label for="OrderId">Order Id</label>
										<input class="form-control" value="${order.orderId }" name ="order.orderId" readonly="readonly">
									</div>
									<div class="form-group">
										<label for="sizeId">Food Name</label>
										<f:select path="foodDetail.fdId" class="form-control">
											
											<c:forEach items="${listFoodDetail }" var="fd">
												<f:option value="${fd.fdId }">${fd.food.foodName } - size: ${fd.size.sizeName}</f:option>
											</c:forEach>
										</f:select>
									</div>
									<div class="form-group">
										<label for="OrderName">Quantity</label>
										<input type="text" name="quantity" class="form-control" placeholder="Quantity"/>
									</div>
									<!--<div class="form-group">
										<label for="OrderName">Price</label>
										<input type="text" name="price"  class="form-control" placeholder="Price"/>
									</div>-->
								</div>
								<!-- /.card-body -->

								<div class="card-footer" style="background-color: white;">
									<button type="submit" class="btn btn-primary">Add</button>
									<button class="btn btn-dark">
										<a href="/FoodAdmin/AdminController/Orders/detailOrder.htm?orderId=${OrderDetailNew.order.orderId }" style="color: white;">Back</a>
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
