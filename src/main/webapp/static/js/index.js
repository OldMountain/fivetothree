if (top !== self) {
    top.location.href = location.href;
}
layui.use('index',function () {
    $(".layui-side-menu .layui-nav-item").eq(0).addClass("layui-nav-itemed")
});