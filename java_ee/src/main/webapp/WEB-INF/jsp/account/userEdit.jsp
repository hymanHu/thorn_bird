<div th:fragment="editModal" class="modal fade" id="editModal" tabindex="-1"
	role="dialog" aria-labelledby="editLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<h4 class="modal-title" id="editLabel"
					style="font-size: 18px; font-weight: 500;">User Edit</h4>
				<button type="button" class="close" data-dismiss="modal"
					aria-hidden="true">&times;</button>
			</div>
			<div class="modal-body">
				<form class="form-horizontal">
					<input type="hidden" name="userId" id="userIdForEditPage" value=""/>
					<div class="form-group row">
						<label class="control-label col-md-3">User Name</label>
						<div class="col-md-8">
							<input id="userNameForEditPage" name="userName" class="form-control" 
								type="text" placeholder="Enter user name">
						</div>
					</div>
					<div class="form-group row">
						<label class="control-label col-md-3">Password</label>
						<div class="col-md-8">
							<input id="passwordForEditPage" name="password" class="form-control" 
								type="text" placeholder="Enter password">
						</div>
					</div>
				</form>
			</div>
			<div class="modal-footer">
				<!-- data-dismiss="modal"关闭模态框 -->
				<a class="btn btn-secondary" href="#" data-dismiss="modal">
					<i class="fa fa-fw fa-lg fa-times-circle"></i>Cancel
				</a>
				<button id="editBtn" data-dismiss="modal" 
					class="btn btn-primary" type="button">
					<i class="fa fa-fw fa-lg fa-check-circle"></i>Submit
				</button>
			</div>
		</div>
	</div>
</div>