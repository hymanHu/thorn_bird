<div class="modal fade" id="editModal" tabindex="-1" role="dialog" aria-labelledby="editLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="bootbox-close-button close" data-dismiss="modal"
					aria-hidden="true">&times;</button>
				<h4 class="modal-title">Resource Edit</h4>
			</div>
			<div class="modal-body">
				<form class="form-horizontal">
					<input type="hidden" id="idForEditPage" value="" />
					<div class="form-group row">
						<label class="control-label col-md-3">Permission</label>
						<div class="col-md-8">
							<input id="permissionForEditPage" name="permission" class="form-control" 
								type="text" placeholder="Enter resource email">
						</div>
					</div>
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