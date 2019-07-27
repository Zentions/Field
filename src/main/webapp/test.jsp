<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>高家农田观测1</title>
<%
	pageContext.setAttribute("APP_PATH", request.getContextPath());
%>
<script type="text/javascript" src="${APP_PATH}/static/js/jquery.min.js"></script>
<link href="${APP_PATH}/static/bootstrap-3.3.7-dist/css/bootstrap.min.css" rel="stylesheet">
<script src="${APP_PATH}/static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
		<!-- button -->
		<div class="row">
			<div class="col-md-8 col-md-offset-2">
				<form class="form-horizontal">
					<div class="form-group">
						<label class="col-sm-3 control-label">node</label>
						<div class="col-sm-9">
							<input type="text" name="nodeid" class="form-control"
								id="user_name_input" placeholder="Zhang San" ajax-val="failure"> <span
								class="help-block"></span>
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-3 control-label">temperture</label>
						<div class="col-sm-9">
							<input type="text" class="form-control" name="temperture"
								id="user_identification_input" placeholder="370725199610094611" ajax-val="failure">
							<span class="help-block"></span>
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-3 control-label">light</label>
						<div class="col-sm-9">
							<input type="text" class="form-control" name="light"
								id="user_pass_input" placeholder="password" ajax-val="failure"> <span
								class="help-block"></span>
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-3 control-label">humidity</label>
						<div class="col-sm-9">
							<input type="text" class="form-control" name="humidity"
								id="user_pass_again_input" placeholder="password" ajax-val="failure"> <span
								class="help-block"></span>
						</div>
					</div>
					
					<div class="form-group">
						<div class="col-md-2 col-md-offset-5">
							<button type="button" class="btn btn-primary" id="user_save_btn" >
							<span class="glyphicon glyphicon-send" aria-hidden="true"> </span> 立即注册</button>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
	<div class="modal fade" id="resultTip" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="myModalLabel">温馨提示</h4>
            </div>
            <div class="modal-body" id="tipMsg">注册成功</div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
            </div>
        </div><!-- /.modal-content -->
    </div>
   </div>
	<script type="text/javascript">
	    $("form")[0].reset();
		
		$("#user_save_btn").click(function() {
			$.ajax({
				url : "${APP_PATH}/addMeasurement",
				type : "POST",
				data : $("form").serialize(),
				success : function(result) {
					//alert(result.msg);
					if(result.code==100){
						isSuccess= true;
					}else{
						$("#tipMsg").empty();
						$("#tipMsg").append("注册失败!");
					}
					$('#resultTip').modal({
	                       keyboard: false
	                });
				}
			});
		});
		
	</script>

</body>
</html>