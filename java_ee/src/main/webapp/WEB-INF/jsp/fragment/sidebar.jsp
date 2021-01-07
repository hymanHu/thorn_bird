<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false"  %>
<!-- Main Sidebar Container -->
<aside class="main-sidebar sidebar-dark-primary elevation-4">
	<!-- Brand Logo -->
	<a href="index3.html" class="brand-link"> <img
		src="/static/img/AdminLTELogo.png" alt="AdminLTE Logo"
		class="brand-image img-circle elevation-3" style="opacity: .8">
		<span class="brand-text font-weight-light">JAVA EE</span>
	</a>

	<!-- Sidebar -->
	<div class="sidebar">
		<!-- Sidebar user panel (optional) -->
		<div class="user-panel mt-3 pb-3 mb-3 d-flex">
			<div class="image">
				<img src="/static/img/user2-160x160.jpg" class="img-circle elevation-2"
					alt="User Image">
			</div>
			<div class="info">
				<a href="#" class="d-block" name="userName">${sessionScope.user.userName} </a>
			</div>
		</div>

		<!-- Sidebar Menu -->
		<nav class="mt-2">
			<ul class="nav nav-pills nav-sidebar flex-column" data-widget="treeview" role="menu" data-accordion="false">
				<li class="nav-item">
					<a href="/dashboard" class="nav-link">
						<i class="nav-icon fas fa-tachometer-alt"></i>
						<p>仪表盘</p>
					</a>
				</li>
				<li class="nav-item has-treeview">
					<a href="#" class="nav-link">
						<i class="nav-icon fas fa-user-circle"></i>
						<p>账户模块<i class="right fas fa-angle-left"></i></p>
					</a>
					<ul class="nav nav-treeview">
						<li class="nav-item">
							<a href="#" class="nav-link">
								<i class="far fa-circle nav-icon"></i>
								<p>个人主页</p>
							</a>
						</li>
						<li class="nav-item">
							<a href="/account/users" class="nav-link">
								<i class="far fa-circle nav-icon"></i>
								<p>用户列表</p>
							</a>
						</li>
					</ul>
				</li>
				<li class="nav-item has-treeview">
					<a href="#" class="nav-link">
						<i class="nav-icon fas fa-list-ol"></i>
						<p>考试模块<i class="right fas fa-angle-left"></i></p>
					</a>
					<ul class="nav nav-treeview">
						<li class="nav-item">
							<a href="/exam/questions" class="nav-link">
								<i class="far fa-circle nav-icon"></i>
								<p>试题列表</p>
							</a>
						</li>
						<li class="nav-item">
							<a href="/exam/papers" class="nav-link" target="_blank">
								<i class="far fa-circle nav-icon"></i>
								<p>试卷列表</p>
							</a>
						</li>
						<li class="nav-item">
							<a href="/exam/achievements" class="nav-link" target="_blank">
								<i class="far fa-circle nav-icon"></i>
								<p>成绩列表</p>
							</a>
						</li>
					</ul>
				</li>
				<li class="nav-item has-treeview">
					<a href="#" class="nav-link">
						<i class="nav-icon fas fa-cubes"></i>
						<p>爬虫模块<i class="right fas fa-angle-left"></i></p>
					</a>
					<ul class="nav nav-treeview">
						<li class="nav-item">
							<a href="#" class="nav-link">
								<i class="far fa-circle nav-icon"></i>
								<p>大学列表</p>
							</a>
						</li>
						<li class="nav-item">
							<a href="#" class="nav-link">
								<i class="far fa-circle nav-icon"></i>
								<p>冠状病毒列表</p>
							</a>
						</li>
					</ul>
				</li>
				<li class="nav-item has-treeview">
					<a href="#" class="nav-link">
						<i class="nav-icon fas fa-leaf"></i>
						<p>测试模块<i class="right fas fa-angle-left"></i></p>
					</a>
					<ul class="nav nav-treeview">
						<li class="nav-item">
							<a href="/test/index" class="nav-link">
								<i class="far fa-circle nav-icon"></i>
								<p>Jsp测试页</p>
							</a>
						</li>
					</ul>
				</li>
				<li class="nav-header">MULTI LEVEL EXAMPLE</li>
				<li class="nav-item">
					<a href="#" class="nav-link">
						<i class="fas fa-circle nav-icon"></i>
						<p>Level 1</p>
					</a>
				</li>
				<li class="nav-item has-treeview">
					<a href="#" class="nav-link">
						<i class="nav-icon fas fa-circle"></i>
						<p>
							Level 1 <i class="right fas fa-angle-left"></i>
						</p>
					</a>
					<ul class="nav nav-treeview">
						<li class="nav-item">
							<a href="#" class="nav-link">
								<i class="far fa-circle nav-icon"></i>
								<p>Level 2</p>
							</a>
						</li>
						<li class="nav-item has-treeview">
							<a href="#" class="nav-link">
								<i class="far fa-circle nav-icon"></i>
								<p>
									Level 2 <i class="right fas fa-angle-left"></i>
								</p>
							</a>
							<ul class="nav nav-treeview">
								<li class="nav-item">
									<a href="#" class="nav-link">
										<i class="far fa-dot-circle nav-icon"></i>
										<p>Level 3</p>
									</a>
								</li>
								<li class="nav-item">
									<a href="#" class="nav-link">
										<i class="far fa-dot-circle nav-icon"></i>
										<p>Level 3</p>
									</a>
								</li>
								<li class="nav-item">
									<a href="#" class="nav-link">
										<i class="far fa-dot-circle nav-icon"></i>
										<p>Level 3</p>
									</a>
								</li>
							</ul>
						</li>
					</ul>
				</li>
			</ul>
		</nav>
		<!-- /.sidebar-menu -->
	</div>
	<!-- /.sidebar -->
</aside>