<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>MVC Spring Boot</title>
    <!-- CSS only -->

    <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.12.0/css/jquery.dataTables.min.css">
    <!-- CSS only -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
    <script type="text/javascript" language="javascript" src="https://code.jquery.com/jquery-3.5.1.js"></script>
    <script type="text/javascript" language="javascript" src="https://cdn.datatables.net/1.12.0/js/jquery.dataTables.min.js" defer ></script>
    <script>
        $(document).ready(function () {
            $('#example').DataTable();
        });
    </script>
</head>
<body>
<div class="container">

    <section class="vh-100" style="background-color: #eee;">
        <div class="container h-100">
            <a href="login" class="btn btn-primary m-2">Logout</a>
            <div class="row d-flex justify-content-center align-items-center h-100">
                <div class="col-12 col-xl-11">
                    <div class="card text-black" style="border-radius: 25px;">
                        <div class="card-body p-md-5">
                            <div class="row justify-content-center">
                                <div class="col-12 order-2 order-lg-1">

                                    <p class="text-center h1 fw-bold mb-5 mx-1 mx-md-4 mt-4"> Products List</p>
                                    <div class="active-member">
                                        <div class="table-responsive">
                                            <table id="example" class="display table table-xs mb-0" style="width:100%">
                                                <thead>
                                                <tr>
                                                    <th>Product</th>
                                                    <th>Price</th>
                                                    <th>Category</th>
                                                </tr>
                                                </thead>
                                                <tbody>
                                                <c:forEach items="${products }" var="category">
                                                    <tr>

                                                        <div>
                                                            <td>${category.productName }</td>
                                                            <td>${category.productPrice }</td>
                                                            <td>${category.category.name}</td>


                                                        <%--                                    <c:out value="${personne.name } ${personne.email }"></c:out>--%>
                                                        </div>
                                                    </tr>

                                                </c:forEach>
                                                </tbody>
                                                <tfoot>
                                                <tr>
                                                    <th>Product</th>
                                                    <th>Price</th>
                                                    <th>Category</th>
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
