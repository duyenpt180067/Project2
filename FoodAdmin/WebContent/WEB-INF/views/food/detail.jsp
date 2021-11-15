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
					<h1>Food Detail</h1>
				</div>
				<div class="col-sm-6">
					<ol class="breadcrumb float-sm-right">
						<li class="breadcrumb-item"><a
							href="/FoodAdmin/AdminController/home">Home</a></li>
						<li class="breadcrumb-item active">Food Detail</li>
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
							<h3 class="card-title">${foodDetail.foodName } Detail</h3>
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
										<h4 class="card-title"><b>Catalog Name: </b><i>${foodDetail.catalog.caName }</i></h4><br>
										<div class="container">
											<div class="row">
												<div class="col-6">
													<h4 class="card-title"><b>Food Id: </b><i>${foodDetail.foodId }</i></h4><br>
													<h4 class="card-title"><b>Food Name: </b><i>${foodDetail.foodName }</i></h4><br>
													<h4 class="card-title"><b>Food Status: </b><i>${foodDetail.foodStatus }</i></h4><br>
													<h4 class="card-title"><b>Created: </b><i>${foodDetail.created }</i></h4><br>
													<h4 class="card-title"><b>Title: </b><i>${foodDetail.title }</i></h4><br>
													<h4 class="card-title"><b>Description:</b> <i>${foodDetail.descriptions }</i></h4><br>
													<div class="row">
														<div class="col-6">
															<h4 class="card-title"><b>Discount: </b><i>${foodDetail.discount } %  </i></h4><br>
														</div>
														<div class="col-6">
															<h4 class="card-title"><b>Views: </b><i>${foodDetail.foodView }</i></h4>
														</div>
													</div>
												</div>
												<div class="col-6">
												<h4 class="card-title"><b>Image: </b></h4>
													<img alt="" style="width: 50%" src=${foodDetail.imageURL }>
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
														aria-label="Engine version: activate to sort column ascending">Food Detail
														Id</th>
													<th class="sorting" tabindex="0" aria-controls="example2"
														rowspan="1" colspan="1"
														aria-label="Engine version: activate to sort column ascending">Size
														Name</th>
													<th class="sorting" tabindex="0" aria-controls="example2"
														rowspan="1" colspan="1"
														aria-label="Engine version: activate to sort column ascending">Price
														</th>
													<th class="sorting" tabindex="0" aria-controls="example2"
														rowspan="1" colspan="1"
														aria-label="Engine version: activate to sort column ascending">Food
														Status</th>
													<th class="sorting" tabindex="0" aria-controls="example2"
														rowspan="1" colspan="1"
														aria-label="Engine version: activate to sort column ascending">Action</th>
												</tr>
											</thead>
											<tbody>
												<c:forEach items="${listFoodDetail }" var="food">
													<tr role="row" class="odd">
														<td class="dtr-control sorting_1">${food.fdId }</td>
														<td>${food.size.sizeName }</td>
														<td>${food.price }</td>
														<td>${food.fdStatus }</td>
														<td><a
															href="initUpdateFoodDetail.htm?fdId=${food.fdId }"><button
																	class="btn btn-warning">Update</button></a> <a
															href="deleteFoodDetail.htm?fdId=${food.fdId }"><button
																	class="btn btn-danger">Delete</button></a></td>
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
				<a href="initAddFoodDetail.htm?foodId=${foodDetail.foodId }"><button class="btn btn-info">Add Food Detail</button></a>
				<button class="btn btn-dark">
					<a href="/FoodAdmin/AdminController/food/list.htm"
						style="color: white;">Back</a>
				</button>
			</div>
		</div>
	</section>
</div>

<%@include file="../home/footer.jsp"%>
