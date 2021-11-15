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
					<h1>Answer Tables</h1>
				</div>
				<div class="col-sm-6">
					<ol class="breadcrumb float-sm-right">
						<li class="breadcrumb-item"><a href="/FoodAdmin/AdminController/home">Home</a></li>
						<li class="breadcrumb-item active">Answer Tables</li>
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
							<a href="initAddAnswer.htm" class="add"><button
									class="btn btn-info">
									Add Answer <i class="fas fa-plus"></i>
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
														aria-label="Rendering engine: activate to sort column descending">Answer
														Id</th>
													<th class="sorting" tabindex="0" aria-controls="example2"
														rowspan="1" colspan="1"
														aria-label="Platform(s): activate to sort column ascending">Question
														Id</th>
													<th class="sorting" tabindex="0" aria-controls="example2"
														rowspan="1" colspan="1"
														aria-label="Engine version: activate to sort column ascending">Content</th>
													<th class="sorting" tabindex="0" aria-controls="example2"
														rowspan="1" colspan="1"
														aria-label="Engine version: activate to sort column ascending">Action</th>
												</tr>
											</thead>
											<tbody>
												<c:forEach items="${listAnswers }" var="answer">
													<tr role="row" class="odd">
														<td class="dtr-control sorting_1">${answer.answerId }</td>
														<td>${answer.question.qId }</td>
														<td>${answer.answerContent }</td>
														<td><a
															href="initUpdateAnswer.htm?answerId=${answer.answerId }"><button
																	class="btn btn-warning">Update</button></a> <a
															href="deleteAnswer.htm?answerId=${answer.answerId }"><button
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
		</div>
	</section>
</div>

<%@include file="../home/footer.jsp"%>
