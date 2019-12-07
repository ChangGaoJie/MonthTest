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

<div style="margin-top: 30px">
    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    <button type="button" value="昌平" onclick="selectArea('昌平')"  class="btn btn-default" class=".col-md-offset-1">昌平</button>
    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    <button type="button" value="朝阳" onclick="selectArea('朝阳')"  class="btn btn-default"  class=".col-md-offset-1">朝阳</button>
    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    <button type="button" value="大兴" onclick="selectArea('大兴')" class="btn btn-default"  class=".col-md-offset-1">大兴</button>
    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    <button type="button" value="丰台" onclick="selectArea('丰台')" class="btn btn-default"  class=".col-md-offset-1">丰台</button>
    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    <button type="button" value="海淀" onclick="selectArea('海淀')" class="btn btn-default"  class=".col-md-offset-1">海淀</button>
    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    <button type="button" value="石景山" onclick="selectArea('石景山')" class="btn btn-default"  class=".col-md-offset-1">石景山</button>
    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    <button type="button" value="顺义" onclick="selectArea('顺义')" class="btn btn-default"  class=".col-md-offset-1">顺义</button>
    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    <button type="button" value="通州" onclick="selectArea('通州')" class="btn btn-default" class=".col-md-offset-1">通州</button>
    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    <select id="orderBy" name="orderBy">
        <option value="no" selected>请选择</option>
        <option value="price">价格排序</option>
    </select>
</div>

<table id="table"></table>
</body>
    <script>
        /*boostraptable展示所有用户信息分页方法*/
        $(function(){
            getList(1);
        })
        //初始化表格
        function getList(area){

            var orderBy =  $("select option:selected").val();

            $("#table").bootstrapTable({
                url:"${pageContext.request.contextPath}/room/getAllRoom?orderBy="+orderBy+"&area="+area,//请求的路径
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
                        field: 'rent',
                        title: '出租',

                    },  {
                        field: 'sequence',
                        title: '平方'
                    }, {
                        field: 'floor',
                        title: '楼层'
                    }, {
                        field: 'space',
                        title: '居室'
                    },  {
                        field: "station",
                        title:'站名'

                    },{
                        field: "mi",
                        title:'米数'

                    },{
                        field: "price",
                        title:'价格'

                    },
                    {
                        title: "区名",
                        field:'area',

                    },
                    {
                        title: "地址",
                        field:'address',

                    }
                ]

            });
        }


        $("#orderBy").change(function () {
            $("#table").bootstrapTable("destroy");
            getList(1);

        })

        function selectArea(area){
            $("#table").bootstrapTable("destroy");
            getList(area);
        }

    </script>
</html>
