<%--
  Created by IntelliJ IDEA.
  User: aho
  Date: 16/01/2024
  Time: 10:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>SB Admin 2 - Tables</title>

    <jsp:include page="../templates/head.jsp"></jsp:include>

</head>

<body id="page-top">

<!-- Page Wrapper -->
<div id="wrapper">

    <!-- Sidebar -->
    <jsp:include page="../templates/sidebar.jsp"></jsp:include>
    <!-- End of Sidebar -->

    <!-- Content Wrapper -->
    <div id="content-wrapper" class="d-flex flex-column">

        <!-- Main Content -->
        <div id="content">

            <!-- Topbar -->
            <jsp:include page="../templates/navbar.jsp"></jsp:include>
            <!-- End of Topbar -->

            <!-- Begin Page Content -->
            <div class="container-fluid">

                <!-- Page Heading -->
                <h1 class="h3 mb-2 text-gray-800">Equipments</h1>

                <!-- DataTales Example -->
                <div class="card shadow mb-4">
                    <div class="card-header py-3">
                        <a href="<%=request.getContextPath()%>/equipment/new">
                            <h6 class="m-0 font-weight-bold btn btn-primary text-right">Add New Equipment</h6>
                        </a>
                    </div>
                    <div class="card-body">
                        <div class="table-responsive">
                            <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                                <thead>
                                <tr>
                                    <th>#</th>
                                    <th>Name</th>
                                    <th>Type</th>
                                    <th>Serial Number</th>
                                    <th>Status</th>
                                    <th>Provider</th>
                                    <th>Site</th>
                                    <th>Action</th>
                                </tr>
                                </thead>
                                <tfoot>
                                <tr>
                                    <th>#</th>
                                    <th>Name</th>
                                    <th>Type</th>
                                    <th>Serial Number</th>
                                    <th>Status</th>
                                    <th>Provider</th>
                                    <th>Site</th>
                                    <th>Action</th>
                                </tr>
                                </tfoot>

                                <tbody>
                                <!--   for (Equipment equipment: equipments) {  -->
                                <c:forEach var="equipment" items="${listEquipment}">

                                    <tr>
                                        <td><c:out value="${equipment.id}" /></td>
                                        <td><c:out value="${equipment.name}" /></td>
                                        <td><c:out value="${equipment.type}" /></td>
                                        <td><c:out value="${equipment.serial_number}" /></td>
                                        <td><c:out value="${equipment.status}" /></td>
                                        <td><c:out value="${equipment.provider}" /></td>
                                        <td><c:out value="${equipment.site.getName()}" /></td>

                                        <td class="d-flex flex-row">

                                            <a class="p-2 bd-highlight" href="<%=request.getContextPath()%>/equipment/more?id=<c:out value='${equipment.id}' />">
                                                <i class="fas fa-plus"></i>
                                            </a>

                                            <a class="p-2 bd-highlight" href="<%=request.getContextPath()%>/equipment/edit?id=<c:out value='${equipment.id}' />">
                                                <i class="fas fa-pencil-alt"></i>
                                            </a>

                                            <a class="p-2 bd-highlight" href="<%=request.getContextPath()%>/equipment/delete?id=<c:out value='${equipment.id}' />">
                                                <i class="fas fa-trash-alt"></i>
                                            </a>

                                        </td>

                                    </tr>
                                </c:forEach>
                                <!-- } -->
                                </tbody>

                            </table>
                        </div>
                    </div>
                </div>

            </div>
            <!-- /.container-fluid -->

        </div>
        <!-- End of Main Content -->

        <!-- Footer -->
        <jsp:include page="../templates/footer.jsp"></jsp:include>
        <!-- End of Footer -->

    </div>
    <!-- End of Content Wrapper -->

</div>
<!-- End of Page Wrapper -->

<!-- Scroll to Top Button-->
<a class="scroll-to-top rounded" href="#page-top">
    <i class="fas fa-angle-up"></i>
</a>

<!-- Logout Modal-->
<div class="modal fade" id="logoutModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
     aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Ready to Leave?</h5>
                <button class="close" type="button" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">×</span>
                </button>
            </div>
            <div class="modal-body">Select "Logout" below if you are ready to end your current session.</div>
            <div class="modal-footer">
                <button class="btn btn-secondary" type="button" data-dismiss="modal">Cancel</button>
                <a class="btn btn-primary" href="login.html">Logout</a>
            </div>
        </div>
    </div>
</div>

<jsp:include page="../templates/script.jsp"></jsp:include>

</body>

</html>