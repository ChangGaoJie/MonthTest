<%--
  Created by IntelliJ IDEA.
  User: 鑫森淼焱
  Date: 2019/9/23
  Time: 9:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script src="${pageContext.request.contextPath}/static/js/jquery-3.2.1.js"></script>
<link href="${pageContext.request.contextPath}/static/bootstrap-3.3.7-dist/css/bootstrap.css" rel="stylesheet" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/static/bootstrap-3.3.7-dist/table/bootstrap-table.css"/>
<script src="${pageContext.request.contextPath}/static/bootstrap-3.3.7-dist/js/bootstrap.js"></script>
<script src="${pageContext.request.contextPath}/static/bootstrap-3.3.7-dist/table/bootstrap-table.js"></script>
<script src="${pageContext.request.contextPath}/static/bootstrap-3.3.7-dist/table/locale/bootstrap-table-zh-CN.js"></script>
<html>
<head>
    <title>Title</title>
</head>
<body>
<select id="orderBy" name="orderBy">
    <option value="count_tui" selected>总推荐</option>
    <option value="count_click">总点击</option>
    <option value="week_tui">周推荐</option>
</select>
<table id="table"></table>
</body>
    <script>
        /*boostraptable展示所有用户信息分页方法*/
        $(function(){
            getList();
        })
        //初始化表格
        function getList(){
            var orderBy =  $("select option:selected").val();
            $("#table").bootstrapTable({
                url:"${pageContext.request.contextPath}/book/getAllBook?orderBy="+orderBy,//请求的路径
                pagination:true,//分页的开关，默认是关闭的
                sortable: true, //是否启用排序
                sidePagination:"client",//客户端分页
                showRefresh:true,//显示刷新按钮
                pageSize: 10,
                pageNumber: 1,
                pageList: [1, 2],
                //排序方式
                sortOrder: "desc",//排序
                sortName: 'addrDefault',//排序字段
                columns: [//field对应的是entity中的属性  title:列名
                    {
                        field: 'id', // 返回json数据中的name
                        title: '序号', // 表格表头显示文字
                        formatter:function(value,row,index){
                            return index+1;
                        }
                    }, {
                        field: 'name',
                        title: '书名'
                    }, {
                        field: 'author',
                        title: '作者',

                    },  {
                        field: 'type',
                        title: '类型'
                    }, {
                        field: 'num',
                        title: '总字数'
                    }, {
                        field: 'countTui',
                        title: '总推荐'
                    },  {
                        field: "countClick",
                        title:'总点击'

                    },
                    {
                        title: "周推荐",
                        field:'weekTui',

                    }
                ]

            });
        }


        $("#orderBy").change(function () {
            $("#table").bootstrapTable("destroy");
            getList();

        })
    </script>
</html>
