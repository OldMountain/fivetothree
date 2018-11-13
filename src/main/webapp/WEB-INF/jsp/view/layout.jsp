<%--
  layout
  User: luhangqi
  Date: 2018/11/11
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="layui-layout layui-layout-admin">
    <div class="layui-header">
        <!-- 头部区域 -->
        <ul class="layui-nav layui-layout-left">
            <li class="layui-nav-item layadmin-flexible" lay-unselect>
                <a href="javascript:;" layadmin-event="flexible" title="侧边伸缩">
                    <i class="layui-icon layui-icon-shrink-right" id="LAY_app_flexible"></i>
                </a>
            </li>
            <!--<li class="layui-nav-item layui-this layui-hide-xs layui-hide-sm layui-show-md-inline-block">
              <a lay-href="" title="">
                控制台
              </a>
            </li>-->
            <li class="layui-nav-item layui-hide-xs" lay-unselect>
                <a href="http://www.layui.com/admin/" target="_blank" title="前台">
                    <i class="layui-icon layui-icon-website"></i>
                </a>
            </li>
            <li class="layui-nav-item" lay-unselect>
                <a href="javascript:;" layadmin-event="refresh" title="刷新">
                    <i class="layui-icon layui-icon-refresh-3"></i>
                </a>
            </li>
            <li class="layui-nav-item layui-hide-xs" lay-unselect>
                <input type="text" placeholder="搜索..." autocomplete="off" class="layui-input layui-input-search" layadmin-event="serach" lay-action="template/search/keywords=">
            </li>
        </ul>
        <ul class="layui-nav layui-layout-right" lay-filter="layadmin-layout-right">

            <li class="layui-nav-item" lay-unselect>
                <a lay-href="app/message/" layadmin-event="message">
                    <i class="layui-icon layui-icon-notice"></i>

                    <!-- 如果有新消息，则显示小圆点 -->
                    <!--<script type="text/html" template lay-url="./json/message/new.js">-->
                    <!--{{# if(d.data.newmsg){ }}-->
                    <!--<span class="layui-badge-dot"></span>-->
                    <!--{{# } }}-->
                    <!--</script>-->

                </a>
            </li>
            <li class="layui-nav-item layui-hide-xs" lay-unselect>
                <a href="javascript:;" layadmin-event="theme">
                    <i class="layui-icon layui-icon-theme"></i>
                </a>
            </li>
            <li class="layui-nav-item layui-hide-xs" lay-unselect>
                <a href="javascript:;" layadmin-event="note">
                    <i class="layui-icon layui-icon-note"></i>
                </a>
            </li>
            <li class="layui-nav-item layui-hide-xs" lay-unselect>
                <a href="javascript:;" layadmin-event="fullscreen">
                    <i class="layui-icon layui-icon-screen-full"></i>
                </a>
            </li>
            <li class="layui-nav-item" lay-unselect>
                <!--<script type="text/html" template lay-url="./json/user/session.js"-->
                <!--lay-done="layui.element.render('nav', 'layadmin-layout-right');">-->
                <!--<a href="javascript:;">-->
                <!--<cite>{{ d.data.username }}</cite>-->
                <!--</a>-->
                <!--<dl class="layui-nav-child">-->
                <!--<dd><a lay-href="set/user/info">基本资料</a></dd>-->
                <!--<dd><a lay-href="set/user/password">修改密码</a></dd>-->
                <!--<hr>-->
                <!--<dd layadmin-event="logout" style="text-align: center;"><a>退出</a></dd>-->
                <!--</dl>-->
                <!--</script>-->
            </li>

            <li class="layui-nav-item layui-hide-xs" lay-unselect>
                <a href="javascript:;" layadmin-event="about"><i class="layui-icon layui-icon-more-vertical"></i></a>
            </li>
            <li class="layui-nav-item layui-show-xs-inline-block layui-hide-sm" lay-unselect>
                <a href="javascript:;" layadmin-event="more"><i class="layui-icon layui-icon-more-vertical"></i></a>
            </li>
        </ul>
    </div>

    <!-- 侧边菜单 -->
    <div class="layui-side layui-side-menu">
        <div class="layui-side-scroll">
            <div class="layui-logo" lay-href="">
                <span>秋天不回来</span>
            </div>

            <ul class="layui-nav layui-nav-tree" lay-shrink="all" id="LAY-system-side-menu" lay-filter="layadmin-system-side-menu">
                <jsp:include page="menu.jsp"></jsp:include>
            </ul>

            <%--<ul class="layui-nav layui-nav-tree" lay-filter="test">--%>
                <%--<!-- 侧边导航: <ul class="layui-nav layui-nav-tree layui-nav-side"> -->--%>
                <%--<li class="layui-nav-item layui-nav-itemed">--%>
                    <%--<a href="javascript:;">默认展开</a>--%>
                    <%--<dl class="layui-nav-child">--%>
                        <%--<dd><a href="javascript:;">选项1</a></dd>--%>
                        <%--<dd><a href="javascript:;">选项2</a></dd>--%>
                        <%--<dd><a href="">跳转</a></dd>--%>
                    <%--</dl>--%>
                <%--</li>--%>
                <%--<li class="layui-nav-item">--%>
                    <%--<a href="javascript:;">解决方案</a>--%>
                    <%--<dl class="layui-nav-child">--%>
                        <%--<dd><a href="">移动模块</a></dd>--%>
                        <%--<dd><a href="">后台模版</a></dd>--%>
                        <%--<dd><a href="">电商平台</a></dd>--%>
                    <%--</dl>--%>
                <%--</li>--%>
                <%--<li class="layui-nav-item"><a href="">产品</a></li>--%>
                <%--<li class="layui-nav-item"><a href="">大数据</a></li>--%>
            <%--</ul>--%>


        </div>
    </div>


    <!-- 页面标签 -->
    <script type="text/html" template lay-done="layui.element.render('nav', 'layadmin-pagetabs-nav')">
        {{# if(layui.setter.pageTabs){ }}
        <div class="layadmin-pagetabs" id="LAY_app_tabs">
            <div class="layui-icon layadmin-tabs-control layui-icon-prev" layadmin-event="leftPage"></div>
            <div class="layui-icon layadmin-tabs-control layui-icon-next" layadmin-event="rightPage"></div>
            <div class="layui-icon layadmin-tabs-control layui-icon-down">
                <ul class="layui-nav layadmin-tabs-select" lay-filter="layadmin-pagetabs-nav">
                    <li class="layui-nav-item" lay-unselect>
                        <a href="javascript:;"></a>
                        <dl class="layui-nav-child layui-anim-fadein">
                            <dd layadmin-event="closeThisTabs"><a href="javascript:;">关闭当前标签页</a></dd>
                            <dd layadmin-event="closeOtherTabs"><a href="javascript:;">关闭其它标签页</a></dd>
                            <dd layadmin-event="closeAllTabs"><a href="javascript:;">关闭全部标签页</a></dd>
                        </dl>
                    </li>
                </ul>
            </div>
            <div class="layui-tab" lay-unauto lay-allowClose="true" lay-filter="layadmin-layout-tabs">
                <ul class="layui-tab-title" id="LAY_app_tabsheader">
                    <li lay-id="/"><i class="layui-icon layui-icon-home"></i></li>
                </ul>
            </div>
        </div>
        {{# } }}
    </script>


    <!-- 主体内容 -->
    <div class="layui-body" id="LAY_app_body">
        <div class="layadmin-tabsbody-item layui-show"></div>
    </div>

    <!-- 辅助元素，一般用于移动设备下遮罩 -->
    <div class="layadmin-body-shade" layadmin-event="shade"></div>

</div>
<script>
    layui.use('tool', function(){
        var tool = layui.tool;
        tool.loadMenuStatus();
    });
</script>
