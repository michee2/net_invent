<%--
  Created by IntelliJ IDEA.
  User: aho
  Date: 15/01/2024
  Time: 23:16
  To change this template use File | Settings | File Templates.
--%>
<ul class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion" id="accordionSidebar">

    <!-- Sidebar - Brand -->
    <a class="sidebar-brand d-flex align-items-center justify-content-center" href="<%=request.getContextPath()%>/home">
        <div class="sidebar-brand-icon rotate-n-15">
            <i class="fas fa-server"></i>
        </div>
        <div class="sidebar-brand-text mx-3">NetInvent</div>
    </a>

    <!-- Divider -->
    <hr class="sidebar-divider my-0">

    <!-- Nav Item - Dashboard -->
    <li class="nav-item active">
        <a class="nav-link" href="<%=request.getContextPath()%>/home">
            <i class="fas fa-home"></i>
            <span>Dashboard</span></a>
    </li>

    <!-- Divider -->
    <hr class="sidebar-divider">

    <!-- Nav Item - Equipments -->
    <li class="nav-item">
        <a class="nav-link" href="<%=request.getContextPath()%>/equipment">
            <i class="fas fa-server"></i>
            <span>Equipments</span></a>
    </li>

    <!-- Divider -->
    <hr class="sidebar-divider">

    <!-- Nav Item - Logs -->
    <li class="nav-item">
        <a class="nav-link" href="<%=request.getContextPath()%>/log">
            <i class="fas fa-list fa-sm fa-fw mr-2 text-gray-400"></i>
            <span>Logs</span></a>
    </li>

    <!-- Divider -->
    <hr class="sidebar-divider">

    <!-- Nav Item - Users -->
    <li class="nav-item">
        <a class="nav-link" href="<%=request.getContextPath()%>/user">
            <i class="fas fa-users fa-sm fa-fw mr-2 text-gray-400"></i>
            <span>Users</span></a>
    </li>


    <!-- Divider -->
    <hr class="sidebar-divider d-none d-md-block">

    <!-- Sidebar Toggler (Sidebar) -->
    <div class="text-center d-none d-md-inline">
        <button class="rounded-circle border-0" id="sidebarToggle"></button>
    </div>

</ul>