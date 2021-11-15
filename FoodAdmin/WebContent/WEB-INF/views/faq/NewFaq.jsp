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
					<h1>Create Faq</h1>
				</div>
				<div class="col-sm-6">
					<ol class="breadcrumb float-sm-right">
						<li class="breadcrumb-item"><a href="#">Home</a></li>
						<li class="breadcrumb-item active">Add Faq</li>
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
								<h3 class="card-title">Faq Form</h3>
							</div>
							<!-- /.card-header -->
							<!-- form start -->
							<f:form action="addFaq.htm" modelAttribute="FaqNew">
								<div class="card-body">
									<div class="form-group">
										<label for="faqQuestion">Faq Question</label>
										<textarea name="faqQuestion" class="form-control"
											placeholder="Question" class="note-codable" aria-multiline="true"></textarea>
									</div>
									<div class="form-group">
										<label for="faqAnswer">Faq Answer</label>
										<textarea name="faqAnswer" class="form-control"
											placeholder="Answer" class="note-codable" aria-multiline="true"></textarea>
									</div>
									<div class="form-group">
										<label for="created">Created</label> <input type="date"
											name="created" class="form-control" />
									</div>
									<div class="form-group">
										<label for="priority">Priority</label> <input type="number"
											name="priorities" class="form-control" placeholder="Priority" />
									</div>
								</div>
								<!-- /.card-body -->

								<div class="card-footer" style="background-color: white;">
									<button type="submit" class="btn btn-primary">Add</button>
									<button class="btn btn-dark">
										<a href="/FoodAdmin/AdminController/faq/list.htm" style="color: white;">Back</a>
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