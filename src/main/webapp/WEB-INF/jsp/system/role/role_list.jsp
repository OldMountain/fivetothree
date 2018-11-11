<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link type="text/css" rel="stylesheet" href="${ctx}plugins/ztree/zTreeStyle.css"/>
<div class="layui-fluid">
    <div class="layui-row layui-col-space15">
        <div class="layui-col-md12">
            <div class="layui-card">
                <div class="layui-card-body" pad15>
                    <table id="role-table" class="layui-table" lay-filter="roleTable">

                    </table>
                    <script type="text/html" id="bar-role">
                        <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="option">权限</a>
                    </script>
                </div>
            </div>
        </div>
    </div>
</div>
<script src="${ctx}plugins/ztree/jquery.ztree.all.min.js" type="application/javascript"></script>
<script src="${ctx}static/js/role/role.js"></script>