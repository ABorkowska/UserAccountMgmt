<%--
  Created by IntelliJ IDEA.
  User: alina
  Date: 02.02.2021
  Time: 17:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/header.jsp" %>

<!-- Begin Page Content -->
<div class="container-fluid">

<!-- Page Heading -->
<div class="d-sm-flex align-items-center justify-content-between mb-4">
    <h1 class="h3 mb-0 text-gray-800">Users List</h1>
    <a href="/user/add" class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm"><i
            class="fas fa-download fa-sm text-white-50"></i>Add User</a>
</div>


                <!-- Users table -->
            <div class="card-body">
               <div class="table-responsive">
                <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                   <thead>
                   <tr>
                      <th>User ID</th>
                      <th>User Name</th>
                      <th>E-Mail</th>
                      <th>Action</th>
                      <th>Action</th>
                      <th>Action</th>
                   </tr>
                   </thead>
                   <tbody>
                        <c:forEach var="user" items="${users}">
                   <tr>
                        <td> ${user.id} </td>
                        <td> ${user.username} </td>
                        <td> ${user.email} </td>
                        <td><a href="/user/display?id=${user.id}">Display</a></td>
                        <td><a href="/user/edit?id=${user.id}">Edit</a></td>
                        <td><a href="/user/delete?id=${user.id}">Delete</a></td>
                   </tr>
                        </c:forEach>
                   </tbody>
                </table>
               </div>
            </div>
        </div>
    </div>
<%@ include file="/footer.jsp" %>
</body>
</html>
