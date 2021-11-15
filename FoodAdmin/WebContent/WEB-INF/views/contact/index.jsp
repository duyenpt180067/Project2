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
					<h1>Question Tables</h1>
				</div>
				<div class="col-sm-6">
					<ol class="breadcrumb float-sm-right">
						<li class="breadcrumb-item"><a
							href="/FoodAdmin/AdminController/home">Home</a></li>
						<li class="breadcrumb-item active">Question Tables</li>
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
							<a href="initAddQuestion.htm" class="add"><button
									class="btn btn-info">
									Add Question <i class="fas fa-plus"></i>
								</button></a>
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
										<table id="example2"
											class="table table-bordered table-hover dataTable dtr-inline"
											role="grid" aria-describedby="example2_info">
											<thead>
												<tr role="row">
													<th class="sorting_asc" tabindex="0"
														aria-controls="example2" rowspan="1" colspan="1"
														aria-sort="ascending"
														aria-label="Rendering engine: activate to sort column descending">Question
														Id</th>
													<th class="sorting" tabindex="0" aria-controls="example2"
														rowspan="1" colspan="1"
														aria-label="Engine version: activate to sort column ascending">User
														Name</th>
													<th class="sorting" tabindex="0" aria-controls="example2"
														rowspan="1" colspan="1"
														aria-label="Engine version: activate to sort column ascending">User
														Email</th>
													<th class="sorting" tabindex="0" aria-controls="example2"
														rowspan="1" colspan="1"
														aria-label="Engine version: activate to sort column ascending">Subject</th>
													<th class="sorting" tabindex="0" aria-controls="example2"
														rowspan="1" colspan="1"
														aria-label="Engine version: activate to sort column ascending">Question
														Content</th>
													<th class="sorting" tabindex="0" aria-controls="example2"
														rowspan="1" colspan="1"
														aria-label="Engine version: activate to sort column ascending">Question
														Status</th>
													<th class="sorting" tabindex="0" aria-controls="example2"
														rowspan="1" colspan="1"
														aria-label="Engine version: activate to sort column ascending">Action</th>
												</tr>
											</thead>
											<tbody>
												<c:forEach items="${listQuestions }" var="question">
													<tr role="row" class="odd">
														<td class="dtr-control sorting_1">${question.qId }</td>
														<td>${question.name }</td>
														<td>${question.email }</td>
														<td>${question.subject }</td>
														<td>${question.qContent }</td>
														<td>${question.qStatus }</td>
														<td><a
															href="initUpdateQuestion.htm?qId=${question.qId }"><button
																	class="btn btn-warning">Update</button></a> <%-- <a
															href="deleteQuestion.htm?qId=${question.qId }"><button
																	class="btn btn-danger">Delete</button></a> --%></td>
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
		</div>
	</section>
</div>

<%@include file="../home/footer.jsp"%>
