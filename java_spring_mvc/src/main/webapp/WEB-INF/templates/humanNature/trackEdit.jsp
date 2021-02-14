<div class="modal fade" id="editModal" tabindex="-1" role="dialog" aria-labelledby="editLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="bootbox-close-button close" data-dismiss="modal"
					aria-hidden="true">&times;</button>
				<h4 class="modal-title">Track Edit</h4>
			</div>
			<div class="modal-body">
				<form class="form-horizontal">
					<input type="hidden" id="idForEditPage" value="" />
					<div class="form-group row">
						<label class="control-label col-md-3">Target</label>
						<div class="col-md-8 input-group">
							<input id="targetForEditPage" name="target" class="form-control" 
								type="text" placeholder="Enter target name">
						</div>
					</div>
					<div class="form-group row">
						<label class="control-label col-md-3">Track type</label>
						<div class="col-md-8 input-group">
							<select id="typeForEditPage" name="type" class="form-control"></select>
						</div>
					</div>
					<div class="form-group row">
						<label class="control-label col-md-3">Description</label>
						<div class="col-md-8 input-group">
							<textarea rows="2" cols="10" id="descriptionForEditPage" 
								name="description" class="form-control" ></textarea>
						</div>
					</div>
					<div class="form-group row">
						<label class="control-label col-md-3">Assessment</label>
						<div class="col-md-8 input-group">
							<input id="assessmentForEditPage" name="assessment" class="form-control" 
								type="number" min="-10" max="10" onkeyup="this.value=this.value.replace(/\D/g,'')">
						</div>
					</div>
					<div class="form-group row">
						<label class="control-label col-md-3">Date Time</label>
						<div class="col-md-8 input-group">
							<input id="dateTimeForEditPage" name="dateTime" class="form-control" type="text">
							<span class="input-group-addon">
								<i class="fa fa-calendar bigger-110"></i>
							</span>
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