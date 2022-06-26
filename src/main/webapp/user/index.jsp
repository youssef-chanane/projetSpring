<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>MVC Spring Boot</title>
    <!-- CSS only -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
</head>
<body>
<div class="container">

    <section class="vh-100" style="background-color: #eee;">
        <div class="container h-100">
            <a href="login" class="btn btn-primary m-2">Logout</a>

            <div class="row d-flex justify-content-center align-items-center h-100">
                <div class="col-lg-12 col-xl-11">
                    <div class="card text-black" style="border-radius: 25px;">
                        <div class="card-body p-md-5">
                            <div class="row justify-content-center">
                                <div class="col-md-10 col-lg-6 col-xl-5 order-2 order-lg-1">

                                    <p class="text-center h1 fw-bold mb-5 mx-1 mx-md-4 mt-4"> Users List</p>
                                    <form action="createUsers" method="get"><br>
                                        <button type="submit" class="btn btn-success mb-1">Add User</button>
                                    </form>
                                    <div class="active-member">
                                        <div class="table-responsive">
                                            <table id="example" class="display table table-xs mb-0" style="width:100%">
                                                <thead>
                                                <tr>
                                                    <th>Users</th>
                                                    <th>Role</th>
                                                    <th>Action</th>
                                                </tr>
                                                </thead>
                                                <tbody>
                                                <c:forEach items="${users }" var="category">
                                                    <tr>

                                                        <div>
                                                            <td>${category.name }</td>
                                                            <td>${category.role }</td>
                                                            <td>

                                                                <a class="btn btn-danger" href="/deleteUser?id=${category.id}" >Suprimer</a>
                                                            </td>
                                                                <%--                                    <c:out value="${personne.name } ${personne.email }"></c:out>--%>
                                                        </div>
                                                    </tr>

                                                </c:forEach>
                                                </tbody>
                                                <tfoot>
                                                <tr>
                                                    <th>Users</th>
                                                    <th>Action</th>
                                                </tr>
                                                </tfoot>
                                            </table>
                                        </div>
                                    </div>

                                </div>

                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
</div>
</body>
</html>
