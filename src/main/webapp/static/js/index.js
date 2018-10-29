if (top !== self) {
    top.location.href = location.href;
}
layui.cache.base = '<%=basePath %>static/lay/';
layui.cache.root = '<%=basePath %>';
layui.use('index',function () {
    $(".layui-side-menu .layui-nav-item").eq(0).addClass("layui-nav-itemed")
});