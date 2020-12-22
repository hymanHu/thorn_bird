<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false"%>
<div th:fragment="editModal" class="modal fade" id="editModal" tabindex="-1"
	role="dialog" aria-labelledby="editLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<h4 class="modal-title" id="editLabel"
					style="font-size: 18px; font-weight: 500;">修改试题</h4>
				<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
			</div>
			<div class="modal-body">
				<form class="form-horizontal">
					<input type="hidden" id="questionIdForEditPage" value=""/>
					<div class="form-group row">
						<label class="control-label col-md-3">试题类型</label>
						<div class="col-md-8">
							<select id="typeForEditPage" name="type" class="form-control"></select>
						</div>
					</div>
					<div class="form-group row">
						<label class="control-label col-md-3">试题阶段</label>
						<div class="col-md-8">
							<select id="flagForEditPage" name="flag" class="form-control"></select>
						</div>
					</div>
					<div class="form-group row">
						<label class="control-label col-md-3">试题内容</label>
						<div class="col-md-8">
							<input id="contentForEditPage" name="content" class="form-control" 
								type="text" placeholder="Enter content">
						</div>
					</div>
					<div class="form-group row">
						<label class="control-label col-md-3">试题分值</label>
						<div class="col-md-8">
							<input id="scoreForEditPage" name="score" class="form-control" 
								type="number" disabled="disabled" placeholder="Enter score">
						</div>
					</div>
					<div class="form-group row">
						<label class="control-label col-md-3">选项 A</label>
						<div class="col-md-8">
							<input id="optionAForEditPage" name="optionA" class="form-control" 
								type="text" placeholder="Enter optionA">
						</div>
					</div>
					<div class="form-group row">
						<label class="control-label col-md-3">选项 B</label>
						<div class="col-md-8">
							<input id="optionBForEditPage" name="optionB" class="form-control" 
								type="text" placeholder="Enter optionB">
						</div>
					</div>
					<div class="form-group row">
						<label class="control-label col-md-3">选项 C</label>
						<div class="col-md-8">
							<input id="optionCForEditPage" name="optionC" class="form-control" 
								type="text" placeholder="Enter optionC">
						</div>
					</div>
					<div class="form-group row">
						<label class="control-label col-md-3">选项 D</label>
						<div class="col-md-8">
							<input id="optionDForEditPage" name="optionD" class="form-control" 
								type="text" placeholder="Enter optionD">
						</div>
					</div>
					<div class="form-group row">
						<label class="control-label col-md-3">参考答案</label>
						<div class="col-md-8">
							<input id="referenceAnswerForEditPage" name="referenceAnswer" class="form-control" 
								type="text" placeholder="Enter reference Answer">
						</div>
					</div>
					<div class="form-group row">
						<label class="control-label col-md-3">备注</label>
						<div class="col-md-8">
							<input id="commentForEditPage" name="comment" class="form-control" 
								type="text" placeholder="Enter reference Answer">
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