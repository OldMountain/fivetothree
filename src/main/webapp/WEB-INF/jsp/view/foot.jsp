<script src="${ctx}static/js/jquery-3.2.1.min.js"></script>
<script src="${ctx}static/lay/layui/layui.js"></script>
<script>
    layui.config({
        base: '${ctx}static/lay/' //静态资源所在路径
    }).extend({
        index: 'lib/index' //主入口模块
    })
</script>
