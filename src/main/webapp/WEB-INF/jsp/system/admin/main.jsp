<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<section class="content">
    <div class="row">
        <div class="col-xs-12">
            <div class="box box-primary">
                <div class="box-body">
                    <div style="text-align: center">
                        <h1>首页，欢迎登陆未完成品管理系统</h1>
                        <form action="/file/upload" enctype="multipart/form-data">
                            <input type="file" name="files">
                            <button type="submit">上传</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
