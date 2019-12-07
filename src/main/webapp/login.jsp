<%--
  Created by IntelliJ IDEA.
  User: 鑫森淼焱
  Date: 2019/8/22
  Time: 21:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath }/static/layui/css/layui.css">
    <script src="${pageContext.request.contextPath}/static/js/jquery-3.2.1.js"></script>
    <script src="${pageContext.request.contextPath}/static/layui/layui.js"></script>

</head>
<body>
<fieldset class="layui-elem-field layui-field-title" style="margin-top:30px;">
    <legend style="text-align:center;">登录用户</legend>
</fieldset>

<div class="layui-row layui-col-md2 layui-col-md-offset5">
    <div class="layui-row">
        <form id="reform" class="layui-form layui-form-pane" method="POST">


            <div class="layui-form-item">
                <label class="layui-form-label">用户名</label>
                <div class="layui-input-block">
                    <input type="text" name="name" lay-verify="required" placeholder="请输入" autocomplete="off" class="layui-input" />
                </div>
            </div>

            <div class="layui-form-item">
                <label class="layui-form-label">密码</label>
                <div class="layui-input-block">
                    <input type="password" name="password"  lay-verify="pass" placeholder="请输入密码" autocomplete="off" class="layui-input" />
                </div>
            </div>


            <div class="layui-form-item">
                <button  class="layui-btn layui-btn-fluid" lay-submit="" onclick="login()" lay-filter="demo1">登录</button>
            </div>


        </form>

    </div>
</div>


</body>
</html>
<!-- js for form input and submit -->
<script>



    layui.use(['form'], function(){
        var form = layui.form;

        //自定义验证规则
        form.verify({
            pass: [/(.+){6,12}$/, '密码必须6到12位'],
        });

    });

   function login() {
        var name = $("input[name='name']").val();
        var password = $("input[name='password']").val();

        $.ajax({
            url:"${pageContext.request.contextPath}/login/loginOne",
            dataType:"json",
            type:"post",
            data:{name:name,
                password:password},
            success:function(data){
                alert(data.msg)
            }
        })
     }
</script>
