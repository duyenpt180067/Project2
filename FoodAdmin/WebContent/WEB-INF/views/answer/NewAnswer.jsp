<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<!DOCTYPE html>

<%@include file="../home/header.jsp"%>
<%@include file="../home/aside.jsp"%>
<div class="content-wrapper">
	<section class="content-header">
		<div class="container-fluid">
			<div class="row mb-2">
				<div class="col-sm-6">
					<h1>Create Answer</h1>
				</div>
				<div class="col-sm-6">
					<ol class="breadcrumb float-sm-right">
						<li class="breadcrumb-item"><a href="/FoodAdmin/AdminController/home">Home</a></li>
						<li class="breadcrumb-item active">Add Answer</li>
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
								<h3 class="card-title">Answer Form</h3>
							</div>
							<!-- /.card-header -->
							<!-- form start -->
							<f:form action="addAnswer.htm" modelAttribute="answerNew">
								<div class="card-body">
									<div class="form-group">
										<label for="qId">Question Id</label>
										<f:select path="question.qId" class="form-control">
											<c:forEach items="${listQuestions }" var="question">
												<f:option value="${question.qId }">${question.qId }</f:option>
											</c:forEach>
										</f:select>
									</div>
									<div class="form-group">
										<label for="content">Answer Content</label>
										<textarea name="answerContent" class="form-control"
											placeholder="Answer Content" class="note-codable" aria-multiline="true"></textarea>
									</div>
								</div>
								<!-- /.card-body -->

								<div class="card-footer" style="background-color: white;">
									<button type="submit" class="btn btn-primary">Add</button>
									<button class="btn btn-dark">
										<a href="/FoodAdmin/AdminController/answer/list.htm" style="color: white;">Back</a>
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
	
</script>