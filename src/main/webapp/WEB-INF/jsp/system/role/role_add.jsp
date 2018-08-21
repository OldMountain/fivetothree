<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<script type="text/javascript">
	//保存
	var submitFlag = true;
	function save() {
	    var roleName = $("#roleName").val();
	    if(!roleName){
	        swal("名称不能为空","","success");
	        return;
		}
	    var params = {
            roleName: roleName
	    };
	    if(!submitFlag){
            swal("请勿重复提交","","success");
	        return;
		}
	    $.ajax({
	        url: 'role/add.do',
	        type: 'post',
	        data: params,
	        dataType: 'json',
			beforeSend:function () {
                submitFlag = false;
            },
	        success: function (result) {
                submitFlag = true;
                $.closeModal();
	            if (result.status == 'success') {
	                $.loadViewOrModal("role/list.view");
	            }else {
                    swalAlert(result.message,swalIcon.SUCCESS);
	            }
	        }
	    })
	}
	
	
</script>

<div>
<input name="parentId" id="parentId" value="${parentId }" type="hidden">

	<div class="form-group">
		<label for="roleName">名称</label>
		<input type="text" name="roleName" class="form-control" id="roleName" placeholder="名称">
	</div>
<c:if test="${QX.add == 1}">
	<a class="btn btn-primary" onclick="save();">保存</a>
	<a class="btn btn-danger" onclick="$.closeModal();">关闭</a>
</c:if>
<c:if test="${QX.add == 0}">
	<div>
		您没有权限新增
	</div>
</c:if>
</div>


