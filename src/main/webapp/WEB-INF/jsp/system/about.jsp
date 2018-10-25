<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="layui-card-header">版本信息</div>
<div class="layui-card-body layui-text layadmin-about">
    <script type="text/html" template>
        <p>当前版本：v${about.version}</p>
    </script>
    <div class="layui-btn-container">
        <a href="http://www.layui.com/admin/" target="_blank" class="layui-btn layui-btn-danger">获取授权</a>
        <a href="${about.url}" target="_blank" class="layui-btn">下载新版</a>
    </div>
</div>

<div class="layui-card-header">关于版权</div>
<div class="layui-card-body layui-text layadmin-about">

    <blockquote class="layui-elem-quote" style="border: none;">
        fivetothree 未经官网正规渠道授权擅自公开产品源文件、以及直接对产品二次出售的，我们将保留追究法律责任的权利。
    </blockquote>
    <p>© 2018 <a href="http://www.fivetothree.xin/" target="_blank">www.fivetothree.xin</a> 版权所有</p>
</div>
