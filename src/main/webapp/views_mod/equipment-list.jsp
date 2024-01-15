<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Equipment Management Application</title>

    <link rel="stylesheet"
          href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
          crossorigin="anonymous">
</head>

</head>
<body>
<header>
    <nav class="navbar navbar-expand-md navbar-dark"
         style="background-color: tomato">
        <div>
            <a href="https://www.javaguides.net" class="navbar-brand"> Equipment
                App</a>
        </div>

        <ul class="navbar-nav">
            <li><a href="<%=request.getContextPath()%>/equipment"
                   class="nav-link">Equipments</a></li>
        </ul>
    </nav>
</header>

<div class="row">
    <!-- <div class="alert alert-success" *ngIf='message'>{{message}}</div> -->

    <div class="container">
        <h3 class="text-center">List of Equipments</h3>
        <hr>
        <div class="container text-left">

            <a href="<%=request.getContextPath()%>/equipment/new"
               class="btn btn-success">Add Equipment</a>
        </div>
        <br>
        <table class="table table-bordered">
            <thead>
            <tr>
                <th>Id</th>
                <th>Site</th>
                <th>Etat</th>
            </tr>
            </thead>
            <tbody>
            <!--   for (Equipment equipment: equipments) {  -->
            <c:forEach var="equipment" items="${listEquipment}">

                <tr>
                    <td><c:out value="${equipment.id}" /></td>
                    <td><c:out value="${equipment.site}" /></td>
                    <td><c:out value="${equipment.etat}" /></td>

                    <td><a href="<%=request.getContextPath()%>/equipment/edit?id=<c:out value='${equipment.id}' />">Edit</a>
                        &nbsp;&nbsp;&nbsp;&nbsp; <a
                                href="<%=request.getContextPath()%>/equipment/delete?id=<c:out value='${equipment.id}' />">Delete</a></td>

                    <!--  <td><button (click)="updateTodo(equipment.id)" class="btn btn-success">Update</button>
                              <button (click)="deleteTodo(equipment.id)" class="btn btn-warning">Delete</button></td> -->
                </tr>
            </c:forEach>
            <!-- } -->
            </tbody>

        </table>
    </div>
</div>

<jsp:include page="../common/footer.jsp"></jsp:include>
</body>
</html>