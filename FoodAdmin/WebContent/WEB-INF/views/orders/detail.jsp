<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>

<%@include file="../home/header.jsp"%>
<%@include file="../home/aside.jsp"%>
<div class="content-wrapper">
	<section class="content-header">
		<div class="container-fluid">
			<div class="row mb-2">
				<div class="col-sm-6">
					<h1>Order Detail</h1>
				</div>
				<div class="col-sm-6">
					<ol class="breadcrumb float-sm-right">
						<li class="breadcrumb-item"><a
							href="/FoodAdmin/AdminController/home">Home</a></li>
						<li class="breadcrumb-item active">Order Detail</li>
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
						<div class="card-header">
							<h3 class="card-title">${orderDetail.orderId } Detail</h3>
						</div>
						<!-- /.card-header -->
						<div class="card-body">
							<div id="example2_wrapper"
								class="dataTables_wrapper dt-bootstrap4">
								<div class="row">
									<div class="col-sm-12 col-md-6"></div>
									<div class="col-sm-12 col-md-6"></div>
								</div>
								<div class="row">
									<div class="col-sm-12">
										<h4 class="card-title"><b>Order Id: </b><i>${orderDetail.orderId }</i></h4><br>
										<h4 class="card-title"><b>Created: </b><i>${orderDetail.created }</i></h4><br>
										<h4 class="card-title"><b>Receive Address: </b><i>${orderDetail.addresses }</i></h4><br>
										<h4 class="card-title"><b>User Info: </b></h4><br>
										<div class="container">
											<div class="row">
												<div class="col-12">
													<h4 class="card-title"><b>User Name: </b><i>${orderDetail.user.username }</i></h4><br>
													<h4 class="card-title"><b>User's Phone: </b><i>${orderDetail.user.phone }</i></h4><br>
													<h4 class="card-title"><b>User's Status: </b><i>${orderDetail.user.userStatus }</i></h4><br>
													<h4 class="card-title"><b>User's Address: </b><i>${orderDetail.user.addresses }</i></h4><br>
													
												</div>
											</div>
										</div>
										<h4 class="card-title"><b>List Detail:</b></h4><br>
										<table id="example2"
											class="table table-bordered table-hover dataTable dtr-inline"
											role="grid" aria-describedby="example2_info">
											<thead>
												<tr role="row">
													<th class="sorting" tabindex="0" aria-controls="example2"
														rowspan="1" colspan="1"
														aria-label="Engine version: activate to sort column ascending">Order Detail
														Id</th>
													<th class="sorting" tabindex="0" aria-controls="example2"
														rowspan="1" colspan="1"
														aria-label="Engine version: activate to sort column ascending">Food
														Name</th>
													<th class="sorting" tabindex="0" aria-controls="example2"
														rowspan="1" colspan="1"
														aria-label="Engine version: activate to sort column ascending">Food
														Size</th>
													<th class="sorting" tabindex="0" aria-controls="example2"
														rowspan="1" colspan="1"
														aria-label="Engine version: activate to sort column ascending">Quantity</th>
													<th class="sorting" tabindex="0" aria-controls="example2"
														rowspan="1" colspan="1"
														aria-label="Engine version: activate to sort column ascending">Price</th>
													
													<th class="sorting" tabindex="0" aria-controls="example2"
														rowspan="1" colspan="1"
														aria-label="Engine version: activate to sort column ascending">Image</th>
												</tr>
											</thead>
											<tbody>
												<c:forEach items="${listOrderDetail }" var="order">
													<tr role="row" class="odd">
														<td class="dtr-control sorting_1">${order.odId }</td>
														<td>${order.foodDetail.food.foodName }</td>
														<td>${order.foodDetail.size.sizeName }</td>
														<td>${order.quantity }</td>
														<td>${order.price }</td>
														<%-- <td><a
															href="initUpdateOrderDetail.htm?odId=${order.odId }"><button
																	class="btn btn-warning">Update</button></a> <a
															href="deleteOrderDetail.htm?odId=${order.odId }"><button
																	class="btn btn-danger">Delete</button></a></td> --%>
														<td>
															<img alt="" src="${order.foodDetail.food.imageURL }" style="width: 150px">
														</td>
													</tr>
												</c:forEach>
											</tbody>
										</table>
									</div>
								</div>
							</div>
						</div>
						<!-- /.card-body -->
					</div>
				</div>
			</div>
			<div class="card-footer" style="background-color: white;">
				<%-- <a href="initAddOrderDetail.htm?orderId=${orderDetail.orderId }"><button class="btn btn-info">Add Order Detail</button></a> --%>
				<button class="btn btn-dark">
					<a href="/FoodAdmin/AdminController/orders/list.htm"
						style="color: white;">Back</a>
				</button>
			</div>
		</div>
	</section>
</div>

<%@include file="../home/footer.jsp"%>
