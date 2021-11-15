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
					<h1>Create Question</h1>
				</div>
				<div class="col-sm-6">
					<ol class="breadcrumb float-sm-right">
						<li class="breadcrumb-item"><a href="#">Home</a></li>
						<li class="breadcrumb-item active">Add Question</li>
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
								<h3 class="card-title">Question Form</h3>
							</div>
							<!-- /.card-header -->
							<!-- form start -->
							<f:form action="addQuestion.htm" modelAttribute="QuestionNew">
								<div class="card-body">
									<div class="form-group">
										<label for="name">User Name</label>
										<input type="text" name="name" class="form-control" placeholder="User Name"/>
									</div>
									<div class="form-group">
										<label for="qName">User Email</label>
										<input type="email" name="email" class="form-control" placeholder="User Email"/>
									</div>
									<div class="form-group">
										<label for="subject">Subject</label>
										<input type="text" name="subject" class="form-control" placeholder="Subject"/>
									</div>
									<div class="form-group">
										<label for="qContent">Question Content</label>
										<textarea name="qContent" class="form-control"
											placeholder="Content" class="note-codable" aria-multiline="true"></textarea>
									</div>
									<div class="form-group">
										<label for="status">Status</label>
										<f:select path="qStatus" class="form-control">
											<f:option value="true">Show</f:option>
											<f:option value="false">Not Show</f:option>
										</f:select>
									</div>
								</div>
								<!-- /.card-body -->

								<div class="card-footer" style="background-color: white;">
									<button type="submit" class="btn btn-primary">Add</button>
									<button class="btn btn-dark">
										<a href="/FoodAdmin/AdminController/question/list.htm" style="color: white;">Back</a>
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