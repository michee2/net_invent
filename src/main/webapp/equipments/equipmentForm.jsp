<%--
  Created by IntelliJ IDEA.
  User: aho
  Date: 16/01/2024
  Time: 10:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
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

    <!-- Custom fonts for this template -->
    <link href="../templates/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
    <link
            href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
            rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="../templates/css/sb-admin-2.min.css" rel="stylesheet">

    <!-- Custom styles for this page -->
    <link href="../templates/vendor/datatables/dataTables.bootstrap4.min.css" rel="stylesheet">

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
                <div class="container col-md-5">
                    <div class="card">
                        <div class="card-body">
                            <c:if test="${equipment != null}">
                            <form class="p-2 needs-validation" action="<%=request.getContextPath()%>/equipment/update" method="post">
                                </c:if>
                                <c:if test="${equipment == null}">
                                <form class="p-2 needs-validation" novalidate action="<%=request.getContextPath()%>/equipment/add" method="post">
                                    </c:if>

                                    <c:if test="${equipment != null}">
                                        <input type="hidden" name="id" value="<c:out value='${equipment.id}' />" />
                                    </c:if>

                                    <div class="row mb-3 gx-3">
                                        <div class="col">
                                            <c:choose>
                                                <c:when test="${equipment != null}">
                                                    <!-- Code to execute when the condition is true -->
                                                    <input type="text" name="name" class="form-control form-control-lg" value="${equipment.name}" required>
                                                </c:when>
                                                <c:otherwise>
                                                    <!-- Code to execute when the condition is false (equivalent to 'else') -->
                                                    <input type="text" name="name" class="form-control form-control-lg" placeholder="Name" required>
                                                </c:otherwise>
                                            </c:choose>
                                            <div class="invalid-feedback">Name is required!</div>
                                        </div>

                                        <div class="col">
                                            <c:choose>
                                                <c:when test="${equipment != null}">
                                                    <!-- Code to execute when the condition is true -->
                                                    <input type="text" name="provider" class="form-control form-control-lg" value="${equipment.provider}" required>
                                                </c:when>
                                                <c:otherwise>
                                                    <!-- Code to execute when the condition is false (equivalent to 'else') -->
                                                    <input type="text" name="provider" class="form-control form-control-lg" placeholder="Provider" required>
                                                </c:otherwise>
                                            </c:choose>
                                            <div class="invalid-feedback">Provider is required!</div>
                                        </div>
                                    </div>

                                    <div class="mb-3">
                                        <fieldset class="form-group">
                                            <label>Status</label>
                                            <select class="form-control mb-3" id="status" name="status">
                                                <option value="Bon">BON</option>
                                                <option value="Mauvais">MAUVAIS</option>
                                            </select>
                                        </fieldset>
                                        <div class="invalid-feedback">Status is required!</div>
                                    </div>

                                    <div class="mb-3">
                                        <fieldset class="form-group">
                                            <label>Type</label>
                                            <select class="form-control mb-3" id="type" name="type">
                                                <option value="Router">ROUTER</option>
                                                <option value="Switch">SWITCH</option>
                                            </select>
                                        </fieldset>
                                        <div class="invalid-feedback">Type is required!</div>
                                    </div>

                                    <div class="mb-3">
                                        <c:choose>
                                            <c:when test="${equipment != null}">
                                                <!-- Code to execute when the condition is true -->
                                                <input type="text" name="serial_number" class="form-control form-control-lg" value="${equipment.serial_number}" required>
                                            </c:when>
                                            <c:otherwise>
                                                <!-- Code to execute when the condition is false (equivalent to 'else') -->
                                                <input type="text" name="serial_number" class="form-control form-control-lg" placeholder="Serial Number" required>
                                            </c:otherwise>
                                        </c:choose>
                                        <div class="invalid-feedback">Serial Number is required!</div>
                                    </div>

                                    <fieldset class="form-group">
                                        <label>Site</label>
                                        <select class="form-control mb-3" id="site" name="site">
                                            <c:forEach var="site" items="${sites}">

                                                <c:choose>
                                                    <c:when test="${siteEquipment.id == site.id}">
                                                        <!-- Code to execute when the condition is true -->
                                                        <option value="${site.id}" selected><c:out value="${site.name}" /></option>
                                                    </c:when>
                                                    <c:otherwise>
                                                        <!-- Code to execute when the condition is false (equivalent to 'else') -->
                                                        <option value="${site.id}"><c:out value="${site.name}" /></option>
                                                    </c:otherwise>
                                                </c:choose>

                                            </c:forEach>
                                            <!-- Ajoutez d'autres options selon vos besoins -->
                                        </select>
                                    </fieldset>

                                    <div class="row mb-3 gx-3">
                                        <div class="col">
                                            <button class="btn btn-secondary btn-block btn-lg" type="button" onclick="window.history.back()">Cancel</button>
                                        </div>

                                        <div class="col">
                                            <c:if test="${equipment != null}">
                                                <input type="submit" value="Update" class="btn btn-success btn-block btn-lg" id="edit-equipment-btn">
                                            </c:if>
                                            <c:if test="${equipment == null}">
                                                <input type="submit" value="Add" class="btn btn-primary btn-block btn-lg" id="add-equipment-btn">
                                            </c:if>
                                        </div>
                                    </div>

                                </form>
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

<!-- Bootstrap core JavaScript-->
<script src="../templates/vendor/jquery/jquery.min.js"></script>
<script src="../templates/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

<!-- Core plugin JavaScript-->
<script src="../templates/vendor/jquery-easing/jquery.easing.min.js"></script>

<!-- Custom scripts for all pages-->
<script src="../templates/js/sb-admin-2.min.js"></script>

<!-- Page level plugins -->
<script src="../templates/vendor/datatables/jquery.dataTables.min.js"></script>
<script src="../templates/vendor/datatables/dataTables.bootstrap4.min.js"></script>

<!-- Page level custom scripts -->
<script src="../templates/js/demo/datatables-demo.js"></script>

<script>
    // Example starter JavaScript for disabling form submissions if there are invalid fields
    (function () {
        'use strict'

        // Fetch all the forms we want to apply custom Bootstrap validation styles to
        var forms = document.querySelectorAll('.needs-validation')

        // Loop over them and prevent submission
        Array.prototype.slice.call(forms)
            .forEach(function (form) {
                form.addEventListener('submit', function (event) {
                    if (!form.checkValidity()) {
                        event.preventDefault()
                        event.stopPropagation()
                    }

                    form.classList.add('was-validated')
                }, false)
            })
    })()
</script>

</body>

</html>