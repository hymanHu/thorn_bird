<div class="modal fade" id="editModal" tabindex="-1" role="dialog" aria-labelledby="editLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="bootbox-close-button close" data-dismiss="modal"
					aria-hidden="true">&times;</button>
				<h4 class="modal-title">User Edit</h4>
			</div>
			<div class="modal-body">
				<form class="form-horizontal">
					<input type="hidden" id="idForEditPage" value="" />
					<div class="form-group row">
						<label class="control-label col-md-3">Email</label>
						<div class="col-md-8">
							<input id="emailForEditPage" name="email" class="form-control" 
								type="text" readonly="readonly">
						</div>
					</div>
					<div class="form-group row">
						<label class="control-label col-md-3">User Name</label>
						<div class="col-md-8">
							<input id="userNameForEditPage" name="userName" class="form-control" 
								type="text" readonly="readonly">
						</div>
					</div>
					<input type="hidden" id="userImageForEditPage" name="userImage" value=""/>
					<div class="form-group row">
						<label class="control-label col-md-3">Roles</label>
						<div class="col-md-8" id="rolesForEditPage" name="roles"></div>
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