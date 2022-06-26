<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
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
            <div class="row d-flex justify-content-center align-items-center h-100">
                <div class="col-lg-12 col-xl-11">
                    <div class="card text-black" style="border-radius: 25px;">
                        <div class="card-body p-md-5">
                            <div class="row justify-content-center">
                                <div class="col-md-10 col-lg-6 col-xl-5 order-2 order-lg-1">

                                    <form action="storeProduct" method="post">
                                        Enter Product name : <input type ="text" class="form-control"  name="name"> <br>
                                        Enter Product Price : <input type ="text" class="form-control"  name="price"> <br>
                                        <select class="form-control" name="category">
                                            <c:forEach items="${categories }" var="category">

                                                <option value="${category.id}">${category.name}</option>
                                            </c:forEach>

                                        </select>

                                        <input type="submit" value="Submit" class="btn btn-success">
                                    </form>

                                    <p class="text-center h1 fw-bold mb-5 mx-1 mx-md-4 mt-4">Add Product</p>
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
