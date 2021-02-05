<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://shiro.apache.org/tags" prefix="shiro" %>

<div id="sidebar" class="sidebar responsive ace-save-state">
	<div class="sidebar-shortcuts" id="sidebar-shortcuts">
		<div class="sidebar-shortcuts-large" id="sidebar-shortcuts-large">
			<button class="btn btn-success">
				<i class="ace-icon fa fa-signal"></i>
			</button>
			<button class="btn btn-info">
				<i class="ace-icon fa fa-pencil"></i>
			</button>
			<button class="btn btn-warning">
				<i class="ace-icon fa fa-users"></i>
			</button>
			<button class="btn btn-danger">
				<i class="ace-icon fa fa-cogs"></i>
			</button>
		</div>

		<div class="sidebar-shortcuts-mini" id="sidebar-shortcuts-mini">
			<span class="btn btn-success"></span> <span class="btn btn-info"></span>
			<span class="btn btn-warning"></span> <span class="btn btn-danger"></span>
		</div>
	</div>
	<!-- /.sidebar-shortcuts -->

	<ul class="nav nav-list">
		<li class="active">
			<a href="/common/dashboard">
				<i class="menu-icon fa fa-tachometer"></i>
				<span class="menu-text"> Dashboard </span>
			</a>
			<b class="arrow"></b>
		</li>

		<li class="">
			<a href="#" class="dropdown-toggle">
				<i class="menu-icon fa fa-desktop"></i>
				<span class="menu-text"> Account </span>
				<b class="arrow fa fa-angle-down"></b>
			</a>
			<b class="arrow"></b>
			<ul class="submenu">
				<li class="">
					<a href="/account/profile">
						<i class="menu-icon fa fa-caret-right"></i>Profile
					</a>
					<b class="arrow"></b>
				</li>
				<shiro:hasAnyRoles name="admin,manager">
				<li>
					<a href="/account/users">
						<i class="menu-icon fa fa-caret-right"></i>Users
					</a>
					<b class="arrow"></b>
				</li>
				<li>
					<a href="/account/roles">
						<i class="menu-icon fa fa-caret-right"></i>Roles
					</a>
					<b class="arrow"></b>
				</li>
				<li>
					<a href="/account/resources">
						<i class="menu-icon fa fa-caret-right"></i>Resources
					</a>
					<b class="arrow"></b>
				</li>
				</shiro:hasAnyRoles>
			</ul>
		</li>
		<li class="">
			<a href="#" class="dropdown-toggle">
				<i class="menu-icon fa fa-desktop"></i>
				<span class="menu-text"> Test </span>
				<b class="arrow fa fa-angle-down"></b>
			</a>
			<b class="arrow"></b>
			<ul class="submenu">
				<li class="">
					<a href="/test/index">
						<i class="menu-icon fa fa-caret-right"></i>index
					</a>
					<b class="arrow"></b>
				</li>
			</ul>
		</li>
		<li class="">
			<a href="#" class="dropdown-toggle">
				<i class="menu-icon fa fa-desktop"></i>
				<span class="menu-text"> 一级菜单 </span>
				<b class="arrow fa fa-angle-down"></b>
			</a>
			<b class="arrow"></b>
			<ul class="submenu">
				<li class="">
					<a href="#" class="dropdown-toggle">
						<i class="menu-icon fa fa-caret-right"></i> 二级菜单1 
						<b class="arrow fa fa-angle-down"></b>
					</a>
					<b class="arrow"></b>
					<ul class="submenu">
						<li class="">
							<a href="top-menu.html">
								<i class="menu-icon fa fa-caret-right"></i> 三级菜单1
							</a>
							<b class="arrow"></b>
						</li>
						<li class="">
							<a href="top-menu.html">
								<i class="menu-icon fa fa-caret-right"></i> 三级菜单2
							</a>
							<b class="arrow"></b>
						</li>
					</ul>
				</li>
				<li class="">
					<a href="typography.html">
						<i class="menu-icon fa fa-caret-right"></i> 二级菜单2
					</a>
					<b class="arrow"></b>
				</li>
			</ul>
		</li>
	</ul>
	<!-- /.nav-list -->

	<div class="sidebar-toggle sidebar-collapse" id="sidebar-collapse">
		<i id="sidebar-toggle-icon"
			class="ace-icon fa fa-angle-double-left ace-save-state"
			data-icon1="ace-icon fa fa-angle-double-left"
			data-icon2="ace-icon fa fa-angle-double-right">
		</i>
	</div>
</div>