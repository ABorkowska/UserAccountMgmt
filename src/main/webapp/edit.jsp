<%--
  Created by IntelliJ IDEA.
  User: alina
  Date: 04.02.2021
  Time: 18:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/header.jsp" %>

<div class="card-body">
    <div class="table-responsive">
        <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">

            <h1 class="h3 mb-2 text-gray-800">Edit User data</h1>
            <p class="mb-4">Note: User ID is unique and cannot be modified</p>

            <form action="/user/edit" method="post">
                <label><b> User ID: </b></label><br>
                <input type="text" name="id" value="${user.id}" disabled><br>
                <br><label><b> User Name: </b></label><br>
                <input value="${user.username}" name="username" type="text" size="50"><br>
                <br><label><b> E-Mail: </b></label><br>
                <input value="${user.email}" name="email" type="email" size="50"><br>
                <br><label><b> Password: </b></label><br>
                <input type="password" name="password" size="50" placeholder="Set new password"><br>
                <br>
                <button class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm"><i
                        class="fas fa-download fa-sm text-white-50"></i>Save
                </button>
                <span>
                    <a href="/user/list" class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm"><i
                    class="fas fa-download fa-sm text-white-50"></i>Return</a>
                </span>

            </form>

            <%@ include file="/footer.jsp" %>
