<%--
  Created by IntelliJ IDEA.
  User: alina
  Date: 03.02.2021
  Time: 20:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/header.jsp" %>

<div class="card-body">
    <div class="table-responsive">
        <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
            <h2>User Details</h2>

            <c:forEach var="user" items="${users}">
                <c:if test="${user.id==id}">
                    <b>ID: </b><c:out value="${user.id}"></br>
                </c:out>
                    <br>
                    <b>User Name: </b><c:out value="${user.username}"></br>
                </c:out>
                    <br>
                    <b>E-mail: </b><c:out value="${user.email}"></br>
                </c:out>
                </c:if>
            </c:forEach>
            <br>
            <br>
            <a href="/user/list" class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm"><i
                    class="fas fa-download fa-sm text-white-50"></i>Return</a>
        </table>
    </div>
</div>

<%@ include file="/footer.jsp" %>
