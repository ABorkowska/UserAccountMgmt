<%--
  Created by IntelliJ IDEA.
  User: alina
  Date: 03.02.2021
  Time: 19:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/header.jsp" %>

<!-- Page Heading -->
<h1 class="h3 mb-2 text-gray-800">Add User</h1>
<p class="mb-4">Registration details will be sent to the User automatically</p>

<script>
    function check (form) {
        for (i = 0; i < form.length; i++) {
            var field = form.elements[i];
            if (!field.disabled && !field.readonly && (field.type == "text" || field.type == "password" || field.type == "email") && field.value == "") {
                alert("Please fill in all fields");
                return false;
            }
        }
        return true;
    }
</script>

<form action="/user/add" method="POST" onsubmit="if (check(this)) return true; return false">>
    <label> E-Mail:</label><br>
    <input type="email" required name="email" autofocus size="50"><br>
    <label> User Name:</label><br>
    <input type="text" required name="username" size="50"><br>
    <label> Password:</label><br>
    <input type="password" required name="password" size="50"><br>
    <br>
    <button class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm"><i
            class="fas fa-download fa-sm text-white-50"></i>Save
    </button>
    <span>
    <a href="/user/list" class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm"><i
            class="fas fa-download fa-sm text-white-50"></i>Return</a>
    </span>
</form>
</div>
</div>
</div>
<%@ include file="/footer.jsp" %>

