<%--
  index
  User: luhangqi
  Date: 2018/11/11
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="layui-fluid">
    <div class="layui-row layui-col-space15">
        <div class="layui-col-md8">
            <div class="layui-row layui-col-space15">
                <div class="layui-col-md6">
                    <div class="layui-card">
                        <div class="layui-card-header">快捷方式</div>
                        <div class="layui-card-body">

                            <div class="layui-carousel layadmin-carousel layadmin-shortcut">
                                <div carousel-item>
                                    <ul class="layui-row layui-col-space10">
                                        <li class="layui-col-xs3">
                                            <a lay-href="home/homepage1">
                                                <i class="layui-icon layui-icon-console"></i>
                                                <cite>主页一</cite>
                                            </a>
                                        </li>
                                        <li class="layui-col-xs3">
                                            <a lay-href="home/homepage2">
                                                <i class="layui-icon layui-icon-chart"></i>
                                                <cite>主页二</cite>
                                            </a>
                                        </li>
                                        <li class="layui-col-xs3">
                                            <a lay-href="component/layer/list">
                                                <i class="layui-icon layui-icon-template-1"></i>
                                                <cite>弹层</cite>
                                            </a>
                                        </li>
                                        <li class="layui-col-xs3">
                                            <a lay-href="/senior/im/">
                                                <i class="layui-icon layui-icon-chat"></i>
                                                <cite>聊天</cite>
                                            </a>
                                        </li>
                                        <li class="layui-col-xs3">
                                            <a lay-href="component/progress/index">
                                                <i class="layui-icon layui-icon-find-fill"></i>
                                                <cite>进度条</cite>
                                            </a>
                                        </li>
                                        <li class="layui-col-xs3">
                                            <a lay-href="app/workorder/list">
                                                <i class="layui-icon layui-icon-survey"></i>
                                                <cite>工单</cite>
                                            </a>
                                        </li>
                                        <li class="layui-col-xs3">
                                            <a lay-href="user/user/list">
                                                <i class="layui-icon layui-icon-user"></i>
                                                <cite>用户</cite>
                                            </a>
                                        </li>
                                        <li class="layui-col-xs3">
                                            <a lay-href="set/system/website">
                                                <i class="layui-icon layui-icon-set"></i>
                                                <cite>设置</cite>
                                            </a>
                                        </li>
                                    </ul>
                                    <ul class="layui-row layui-col-space10">
                                        <li class="layui-col-xs3">
                                            <a lay-href="set/user/info">
                                                <i class="layui-icon layui-icon-set"></i>
                                                <cite>我的资料</cite>
                                            </a>
                                        </li>
                                        <li class="layui-col-xs3">
                                            <a lay-href="set/user/info">
                                                <i class="layui-icon layui-icon-set"></i>
                                                <cite>我的资料</cite>
                                            </a>
                                        </li>
                                        <li class="layui-col-xs3">
                                            <a lay-href="set/user/info">
                                                <i class="layui-icon layui-icon-set"></i>
                                                <cite>我的资料</cite>
                                            </a>
                                        </li>
                                        <li class="layui-col-xs3">
                                            <a lay-href="set/user/info">
                                                <i class="layui-icon layui-icon-set"></i>
                                                <cite>我的资料</cite>
                                            </a>
                                        </li>
                                        <li class="layui-col-xs3">
                                            <a lay-href="set/user/info">
                                                <i class="layui-icon layui-icon-set"></i>
                                                <cite>我的资料</cite>
                                            </a>
                                        </li>
                                        <li class="layui-col-xs3">
                                            <a lay-href="set/user/info">
                                                <i class="layui-icon layui-icon-set"></i>
                                                <cite>我的资料</cite>
                                            </a>
                                        </li>
                                        <li class="layui-col-xs3">
                                            <a lay-href="set/user/info">
                                                <i class="layui-icon layui-icon-set"></i>
                                                <cite>我的资料</cite>
                                            </a>
                                        </li>
                                        <li class="layui-col-xs3">
                                            <a lay-href="set/user/info">
                                                <i class="layui-icon layui-icon-set"></i>
                                                <cite>我的资料</cite>
                                            </a>
                                        </li>
                                    </ul>

                                </div>
                            </div>

                        </div>
                    </div>
                </div>
                <div class="layui-col-md6">
                    <div class="layui-card">
                        <div class="layui-card-header">我的世界服务器</div>
                        <div class="layui-card-body">

                            <div class="layui-carousel layadmin-carousel layadmin-backlog">
                                <div carousel-item>
                                    <ul id="serverInfo" class="layui-row layui-col-space10">
                                        <div id="server-load"
                                             style="text-align: center;position: relative;height: 100%">
                                            <img src="${ctx}static/layadmin/layui/css/modules/layer/default/loading-2.gif"
                                                 style="position: absolute;top: 30%">
                                        </div>
                                        <script id="serverInfoTemp" type="text/html">
                                            <li class="layui-col-xs6">
                                                <a lay-href="app/content/comment.html" class="layadmin-backlog-body">
                                                    <h3>motd</h3>
                                                    <p id="description"
                                                       style="font-style: normal;font-size: 15px;font-weight: 300;color: #009688;width: 98%;overflow: hidden;text-overflow: ellipsis;white-space: nowrap">
                                                        {{ d.description }}
                                                    </p>
                                                </a>
                                            </li>
                                            <li class="layui-col-xs6">
                                                <a lay-href="app/content/comment.html" class="layadmin-backlog-body">
                                                    <h3>图标</h3>
                                                    <p><cite>
                                                        <img width="30" src="{{ d.favicon }}">
                                                    </cite></p>
                                                </a>
                                            </li>
                                            <li class="layui-col-xs6">
                                                <a lay-href="app/content/comment.html" class="layadmin-backlog-body">
                                                    <h3>在线人数</h3>
                                                    <p><cite>
                                                        {{ d.players.online }}
                                                    </cite></p>
                                                </a>
                                            </li>
                                            <li class="layui-col-xs6">
                                                <a lay-href="app/content/comment.html" class="layadmin-backlog-body">
                                                    <h3>最大人数</h3>
                                                    <p><cite>
                                                        {{ d.players.max }}
                                                    </cite></p>
                                                </a>
                                            </li>
                                        </script>
                                    </ul>
                                    <ul class="layui-row layui-col-space10">
                                        <li class="layui-col-xs6">
                                            <a href="javascript:;" class="layadmin-backlog-body">
                                                <h3>待审友情链接</h3>
                                                <p><cite style="color: #FF5722;">5</cite></p>
                                            </a>
                                        </li>
                                    </ul>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="layui-col-md12">
                    <div class="layui-card">
                        <div class="layui-card-header">数据概览</div>
                        <div class="layui-card-body">

                            <div class="layui-carousel layadmin-carousel layadmin-dataview" data-anim="fade" lay-filter="LAY-index-dataview">
                                <div carousel-item id="LAY-index-dataview">
                                    <div><i class="layui-icon layui-icon-loading1 layadmin-loading"></i></div>
                                    <div></div>
                                    <div></div>
                                </div>
                            </div>

                        </div>
                    </div>
                    <div class="layui-card">
                        <div class="layui-tab layui-tab-brief layadmin-latestData">
                            <ul class="layui-tab-title">
                                <li class="layui-this">今日热搜</li>
                                <li>今日热帖</li>
                            </ul>
                            <div class="layui-tab-content">
                                <div class="layui-tab-item layui-show">
                                    <table id="LAY-index-topSearch"></table>
                                </div>
                                <div class="layui-tab-item">
                                    <table id="LAY-index-topCard"></table>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <div class="layui-col-md4">
            <div class="layui-card">
                <div class="layui-card-header">版本信息</div>
                <div class="layui-card-body layui-text">
                    <table class="layui-table">
                        <colgroup>
                            <col width="100">
                            <col>
                        </colgroup>
                        <tbody>
                        <tr>
                            <td>当前版本</td>
                            <td>
                                <script type="text/html" template>
                                    v{{ layui.admin.v }}
                                    <a href="http://fly.layui.com/docs/3/" target="_blank" style="padding-left: 15px;">更新日志</a>
                                </script>
                            </td>
                        </tr>
                        <tr>
                            <td>基于框架</td>
                            <td>
                                <script type="text/html" template>
                                    layui-v{{ layui.v }}
                                </script>
                            </td>
                        </tr>
                        <tr>
                            <td>主要特色</td>
                            <td>单页面 / 响应式 / 清爽 / 极简</td>
                        </tr>
                        <tr>
                            <td>获取渠道</td>
                            <td style="padding-bottom: 0;">
                                <div class="layui-btn-container">
                                    <a href="http://www.layui.com/admin/" target="_blank" class="layui-btn layui-btn-danger">获取授权</a>
                                    <a href="http://fly.layui.com/download/layuiAdmin/" target="_blank" class="layui-btn">立即下载</a>
                                </div>
                            </td>
                        </tr>
                        </tbody>
                    </table>
                </div>
            </div>

            <div class="layui-card">
                <div class="layui-card-header">效果报告</div>
                <div class="layui-card-body layadmin-takerates">
                    <div class="layui-progress" lay-showPercent="yes">
                        <h3>转化率（日同比 28% <span class="layui-edge layui-edge-top" lay-tips="增长" lay-offset="-15"></span>）</h3>
                        <div class="layui-progress-bar" lay-percent="65%"></div>
                    </div>
                    <div class="layui-progress" lay-showPercent="yes">
                        <h3>签到率（日同比 11% <span class="layui-edge layui-edge-bottom" lay-tips="下降" lay-offset="-15"></span>）</h3>
                        <div class="layui-progress-bar" lay-percent="32%"></div>
                    </div>
                </div>
            </div>

            <div class="layui-card">
                <div class="layui-card-header">实时监控</div>
                <div class="layui-card-body layadmin-takerates">
                    <div class="layui-progress" lay-showPercent="yes">
                        <h3>CPU使用率</h3>
                        <div class="layui-progress-bar" lay-percent="58%"></div>
                    </div>
                    <div class="layui-progress" lay-showPercent="yes">
                        <h3>内存占用率</h3>
                        <div class="layui-progress-bar layui-bg-red" lay-percent="90%"></div>
                    </div>
                </div>
            </div>

            <div class="layui-card">
                <div class="layui-card-header">产品动态</div>
                <div class="layui-card-body">
                    <div class="layui-carousel layadmin-carousel layadmin-news" data-autoplay="true" data-anim="fade" lay-filter="news">
                        <div carousel-item>
                            <div><a href="http://fly.layui.com/docs/2/" target="_blank" class="layui-bg-red">layuiAdmin 快速上手文档</a></div>
                            <div><a href="http://fly.layui.com/vipclub/list/layuiadmin/" target="_blank" class="layui-bg-green">layuiAdmin 会员讨论专区</a></div>
                            <div><a href="http://www.layui.com/admin/#get" target="_blank" class="layui-bg-blue">获得 layui 官方后台模板系统</a></div>
                        </div>
                    </div>
                </div>
            </div>

            <div class="layui-card">
                <div class="layui-card-header">
                    作者心语
                    <i class="layui-icon layui-icon-tips" lay-tips="要支持的噢" lay-offset="5"></i>
                </div>
                <div class="layui-card-body layui-text layadmin-text">
                    <p>一直以来，layui 秉承无偿开源的初心，虔诚致力于服务各层次前后端 Web 开发者，在商业横飞的当今时代，这一信念从未动摇。即便身单力薄，仍然重拾决心，埋头造轮，以尽可能地填补产品本身的缺口。</p>
                    <p>在过去的一段的时间，我一直在寻求持久之道，已维持你眼前所见的一切。而 layuiAdmin 是我们尝试解决的手段之一。我相信真正有爱于 layui 生态的你，定然不会错过这一拥抱吧。</p>
                    <p>子曰：君子不用防，小人防不住。请务必通过官网正规渠道，获得 <a href="http://www.layui.com/admin/" target="_blank">layuiAdmin</a>！</p>
                    <p>—— 贤心（<a href="http://www.layui.com/" target="_blank">layui.com</a>）</p>
                    <div class="layui-fluid">
                        <div class="layui-row layui-col-space15">
                            <div class="layui-col-md12">
                                <div class="layui-card">
                                    <div class="layui-card-header">面板外的操作示例</div>
                                    <div class="layui-card-body">

                                        <div class="layui-btn-container LAY-senior-im-chat-demo">
                                            <button class="layui-btn" data-type="chat">自定义会话</button>
                                            <button class="layui-btn" data-type="message">接受好友的消息</button>
                                            <button class="layui-btn" data-type="messageAudio">接受音频消息</button>
                                            <button class="layui-btn" data-type="messageVideo">接受视频消息</button>
                                            <button class="layui-btn" data-type="messageTemp">接受临时会话消息</button>

                                            <br>

                                            <button class="layui-btn" data-type="add">申请好友</button>
                                            <button class="layui-btn" data-type="addqun">申请加群</button>
                                            <button class="layui-btn" data-type="addFriend">同意好友</button>
                                            <button class="layui-btn" data-type="addGroup">增加群组到主面板</button>
                                            <button class="layui-btn" data-type="removeFriend">删除主面板好友</button>
                                            <button class="layui-btn" data-type="removeGroup">删除主面板群组</button>

                                            <br>
                                            <button class="layui-btn" data-type="setGray">置灰离线好友</button>
                                            <button class="layui-btn" data-type="unGray">取消好友置灰</button>

                                            <button class="layui-btn" data-type="kefu1">在线客服一</button>
                                            <button class="layui-btn" data-type="kefu2">在线客服二</button>

                                            <button class="layui-btn" data-type="mobile">移动端版本</button>
                                        </div>

                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

    </div>
</div>


<script>
    //加载 controller 目录下的对应模块
    /*

      小贴士：
        这里 console 模块对应 的 console.js 并不会重复加载，
        然而该页面的视图则是重新插入到容器，那如何保证能重新来控制视图？有两种方式：
          1): 借助 layui.factory 方法获取 console 模块的工厂（回调函数）给 layui.use
          2): 直接在 layui.use 方法的回调中书写业务代码，即:
              layui.use('console', function(){
                //同 console.js 中的 layui.define 回调中的代码
              });

      这里我们采用的是方式1。其它很多视图中采用的其实都是方式2，因为更简单些，也减少了一个请求数。

    */
    layui.use('console', layui.factory('console')).use(['index', 'laytpl'], function () {
        var laytpl = layui.laytpl;
        getMcServerInfo(laytpl, layer);
        function getMcServerInfo(laytpl, layer) {
            var params = {};
            $.ajax({
                url: '${ctx}api/mc/getServerInfo',
                type: 'post',
                data: params,
                dataType: 'json',
                success: function (result) {
                    laytpl(serverInfoTemp.innerHTML).render(result.data.serverData, function (html) {
                        $("#serverInfo").html(html);
                        $("#server-load").hide();
                        $("#description").mouseover(function () {
                            var _this = this;
                            layer.tips($(this).html(), this, {
                                tips: 3, time: 0, success: function (layero, index) {
                                    $(_this).mouseleave(function () {
                                        layer.close(index)
                                    })
                                }
                            });
                        })

                    })
                }
            })
        }
    });
</script>