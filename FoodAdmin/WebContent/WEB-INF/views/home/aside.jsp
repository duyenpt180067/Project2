F<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<aside class="main-sidebar sidebar-dark-primary elevation-4" style="min-height:100%;position:fixed;">
    <!-- Brand Logo -->
    <a href="<c:url value="/AdminController/home"/>" class="brand-link">
      <img src="<c:url value="/resources/assests/dist/img/AdminLTELogo.png"/>" alt="AdminLTE Logo" class="brand-image img-circle elevation-3" style="opacity: .8">
      <span class="brand-text font-weight-light">Admin</span>
    </a>

    <!-- Sidebar -->
    <div class="sidebar">
      <!-- Sidebar user (optional) -->
      <div class="user-panel mt-3 pb-3 mb-3 d-flex">
        <!--<div class="image">
          <img src="<c:url value="/resources/assests/dist/img/user2-160x160.jpg"/>" class="img-circle elevation-2" alt="User Image">
        </div>-->
        <div class="info">
				<a href="<c:url value="/AdminController/home"/>" class="d-block">List: </a>
			</div>
      </div>

      <!-- SidebarSearch Form 
      <div class="form-inline">
        <div class="input-group" data-widget="sidebar-search">
          <input class="form-control form-control-sidebar" type="search" placeholder="Search" aria-label="Search">
          <div class="input-group-append">
            <button class="btn btn-sidebar">
              <i class="fas fa-search fa-fw"></i>
            </button>
          </div>
        </div>
      </div>-->

      <!-- Sidebar Menu -->
      <nav class="mt-2" >
        <ul class="nav nav-pills nav-sidebar flex-column" data-widget="treeview" role="menu" data-accordion="false">
          <!-- Add icons to the links using the .nav-icon class
               with font-awesome or any other icon font library -->
          <li class="nav-item">
            <a href="/FoodAdmin/AdminController/categories/list.htm" class="nav-link">
              <!--<i class="nav-icon fas fa-tachometer-alt"></i>-->
              <i class="nav-icon fas fa-utensils"></i>
              <p>Category</p>
            </a>
          </li>
          <li class="nav-item">
            <a href="/FoodAdmin/AdminController/food/list.htm" class="nav-link">
              <i class="nav-icon fas fa-utensils"></i>
              <p>Food</p>
            </a>
          </li>
          <!-- <li class="nav-item">
            <a href="/FoodAdmin/AdminController/fd/list.htm" class="nav-link">
              <i class="nav-icon fas fa-utensils"></i>
              <p>Food Detail</p>
            </a>
          </li> -->
          <li class="nav-item">
            <a href="/FoodAdmin/AdminController/web_user/list.htm" class="nav-link">
              <i class="nav-icon fas fa-utensils"></i>
              <p>User</p>
            </a>
          </li>
          <li class="nav-item">
            <a href="/FoodAdmin/AdminController/bonus/list.htm" class="nav-link">
              <i class="nav-icon fas fa-utensils"></i>
              <p>Deal</p>
            </a>
          </li>
          <li class="nav-item">
            <a href="/FoodAdmin/AdminController/blog/list.htm" class="nav-link">
              <i class="nav-icon fas fa-utensils"></i>
              <p>Blog</p>
            </a>
          </li>
          <li class="nav-item">
            <a href="/FoodAdmin/AdminController/comment/list.htm" class="nav-link">
              <i class="nav-icon fas fa-utensils"></i>
              <p>Comment</p>
            </a>
          </li>
          <li class="nav-item">
            <a href="/FoodAdmin/AdminController/faq/list.htm" class="nav-link">
              <i class="nav-icon fas fa-utensils"></i>
              <p>Faq</p>
            </a>
          </li>
          <li class="nav-item">
            <a href="/FoodAdmin/AdminController/systems/list.htm" class="nav-link">
              <i class="nav-icon fas fa-utensils"></i>
              <p>System</p>
            </a>
          </li>
          <li class="nav-item">
            <a href="/FoodAdmin/AdminController/question/list.htm" class="nav-link">
              <i class="nav-icon fas fa-utensils"></i>
              <p>Question</p>
            </a>
          </li>
          <li class="nav-item">
            <a href="/FoodAdmin/AdminController/answer/list.htm" class="nav-link">
              <i class="nav-icon fas fa-utensils"></i>
              <p>Answer</p>
            </a>
          </li>
          <li class="nav-item">
            <a href="/FoodAdmin/AdminController/favorite/list.htm" class="nav-link">
              <i class="nav-icon fas fa-utensils"></i>
              <p>Favorite</p>
            </a>
          </li>
          <li class="nav-item">
            <a href="/FoodAdmin/AdminController/image_food/list.htm" class="nav-link">
              <i class="nav-icon fas fa-utensils"></i>
              <p>Image</p>
            </a>
          </li>
          <li class="nav-item">
            <a href="/FoodAdmin/AdminController/orders/list.htm" class="nav-link">
              <i class="nav-icon fas fa-utensils"></i>
              <p>Orders</p>
            </a>
          </li>
          <li class="nav-item">
            <a href="/FoodAdmin/AdminController/size/list.htm" class="nav-link">
              <i class="nav-icon fas fa-utensils"></i>
              <p>Size</p>
            </a>
          </li>
          <li class="nav-item">
            <a href="/FoodAdmin/AdminController/slider/list.htm" class="nav-link">
              <i class="nav-icon fas fa-utensils"></i>
              <p>Slider</p>
            </a>
          </li>
        </ul>
      </nav>
      <!-- /.sidebar-menu -->
    </div>
    <!-- /.sidebar -->
  </aside>