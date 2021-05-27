<%--
  Created by IntelliJ IDEA.
  User: alina
  Date: 05.02.2021
  Time: 20:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/header.jsp" %>

<div class="card-body">
    <div class="table-responsive">
        <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
            <h1 class="h3 mb-2 text-gray-800">Remove user account</h1>
            <script LANGUAGE="JavaScript">
                function confirmSubmit () {
                    var agree = confirm("Are you sure you want to remove the selected user?");
                    if (agree) return true; else return false;
                }
            </script>

            <form action="/user/delete" method="POST">
                <label><b> User ID: </b></label><br>
                <input type="text" name="id" value="${user.id}" disabled><br>

                <br><label><b> User Name: </b></label><br>
                <input value="${user.username}" name="username" type="text" size="50" disabled><br>

                <br><label><b> E-Mail: </b></label><br>
                <input value="${user.email}" name="email" type="email" size="50" disabled><br>
                <br>
                <INPUT TYPE='submit' value='Delete' name='delete' onClick='return confirmSubmit()' class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm"><i
                    class="fas fa-download fa-sm text-white-50">
            </form>
            <span>
                    <a href="/user/list" class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm"><i
                            class="fas fa-download fa-sm text-white-50"></i>Return</a>
                </span>
            <%--                <label>ID</label>--%>
            <%--                <c:out value="${user.id}"></br>--%>
            <%--                </c:out>--%>
            <%--                <br>--%>
            <%--                <label>User Name</label>--%>
            <%--                <c:out value="${user.username}"></br>--%>
            <%--                </c:out>--%>
            <%--                <br>--%>
            <%--                <label>E-mail:</label>--%>
            <%--                <c:out value="${user.email}"></br>--%>
            <%--                </c:out>--%>
            <%--                </c:if>--%>
            <%--                </c:forEach>--%>
            </form>
        </table>
        <%@ include file="/footer.jsp" %>

        result = window.confirm('Are you sure you want to remove the selected user?')