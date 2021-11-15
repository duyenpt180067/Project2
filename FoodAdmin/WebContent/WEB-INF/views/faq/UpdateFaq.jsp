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
					<h1>Update Faq</h1>
				</div>
				<div class="col-sm-6">
					<ol class="breadcrumb float-sm-right">
						<li class="breadcrumb-item"><a href="#">Home</a></li>
						<li class="breadcrumb-item active">Update Faq</li>
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
							<f:form action="updateFaq.htm" modelAttribute="FaqUp">
								<div class="card-body">
									<div class="form-group">
										<label for="faqId">Faq Id</label> 
										<f:input path="faqId" readonly="true" class="form-control" />
									</div>
									<div class="form-group">
										<label for="faqQuestion">Faq Question</label>
										<f:textarea path="faqQuestion" class="form-control note-codable" aria-multiline="true"/>
									</div>
									<div class="form-group">
										<label for="faqAnswer">Faq Answer</label>
										<f:textarea path="faqAnswer" class="form-control note-codable" aria-multiline="true"/>
									</div>
									<div class="form-group">
										<label for="created">Created</label> 
										<input type="date" name="created" value="${FaqUp.created }" class="form-control" />
									</div>
									<div class="form-group">
										<label for="priority">Priority</label> 
										<f:input type="number" path="priorities" class="form-control" />
									</div>
								</div>
								<!-- /.card-body -->

								<div class="card-footer" style="background-color: white;">
									<button type="submit" class="btn btn-warning">Update</button>
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