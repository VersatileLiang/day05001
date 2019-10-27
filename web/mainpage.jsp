<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>邮件管理系统</title>
    <%--    <!-- -------------------JS------------------------- -->--%>
    <%--    <script src="//res.layui.com/layui/dist/layui.js?t=1572110336094"></script>--%>
    <%--&lt;%&ndash;    <script type="text/javascript" src="jquery-2.1.4/jquery.min.js"></script>&ndash;%&gt;--%>
    <%--&lt;%&ndash;    <script type="text/javascript" src="layui/lay/modules/layer.js"></script>&ndash;%&gt;--%>

    <%--    <!-- -------------------CSS------------------------- -->--%>
    <%--    <link rel="stylesheet" href="//res.layui.com/layui/dist/css/layui.css?t=1572110336094" media="all">--%>
    <%--&lt;%&ndash;    <link rel="stylesheet" href="layui/css/modules/layer/default/layer.css">&ndash;%&gt;--%>
    <link rel="stylesheet" href="jquery-2.1.4/layui/css/layui.css">
    <script src="jquery-2.1.4/layui/layui.js"></script>
    <script type="text/javascript"></script>
    <script type="text/javascript">
        function getInfo() {
            $.ajax({
                type: "post",
                url: "getAdminUsername.do",
                data: undefined,
                success: function (result) {
                    $("#adminUsername").html(result);
                }
            });
        }
    </script>
</head>
<body class="layui-layout-body">
<div class="layui-layout layui-layout-admin">
    <div class="layui-header layui-bg-blue">
        <div class="layui-logo layui-colorpicker-basis-black">邮件管理系统</div>
        <!-- 头部区域（可配合layui已有的水平导航） -->
        <ul class="layui-nav layui-layout-left">
            <li onclick="adminUsers()" class="layui-nav-item"><a>已发送</a></li>
            <li onclick="adminMassage()" class="layui-nav-item"><a>用户中心</a></li>
        </ul>
        <ul class="layui-nav layui-layout-right">
            <li class="layui-nav-item">
                <a href="javascript:;">
                    <img src="http://t.cn/AiOTwDEU" class="layui-nav-img">
                    <span id="adminUsername">飞翔</span>
                </a>
                <dl class="layui-nav-child">
                    <dd><a href="">基本资料</a></dd>
                    <dd><a href="">安全设置</a></dd>
                </dl>
            </li>
            <li class="layui-nav-item"><a href="logOut.do">退出登录</a></li>
        </ul>
    </div>

    <!-- 左侧导航栏 -->
    <div class="layui-side layui-bg-cyan">
        <div class="layui-side-scroll">
            <!-- 左侧导航区域（可配合layui已有的垂直导航） -->
            <ul class="layui-nav layui-bg-cyan layui-nav-tree"  lay-filter="test">
                <li class="layui-nav-item layui-nav-itemed">
                    <a class="" href="javascript:;">查看用户密码</a>
                    <dl class="layui-nav-child" lay-filter="demo">
                        <dd onclick=""><a href="javascript:;">修改密码</a></dd>
                    </dl>
                </li>
            </ul>
        </div>
    </div>

    <!-- ---------内容主体区域------------- -->
    <div class="layui-body">

        <div class="layui-layer-border">
            <h4 id="promptBox">查看用户密码>修改密码</h4>
        </div>
        <table class="layui-table" lay-data="{ height:500, url:'/day05001/getAllUsers.do', page:true, id:'idTest'}" lay-filter="demo">
            <thead>
            <tr>
                <th lay-data="{type:'checkbox', fixed: 'left'}"></th>
                <th lay-data="{field:'bemail', width:180, sort: true, fixed: true}">用户名</th>
                <th lay-data="{field:'bpwd', width:180}">密码</th>
                <th lay-data="{fixed: 'right', width:178, align:'center', toolbar: '#barDemo'}"></th>
            </tr>
            </thead>
        </table>

        <script type="text/html" id="barDemo">
            <a class="layui-btn layui-btn-primary layui-btn-xs" lay-event="detail">查看</a>
            <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">修改</a>
        </script>
    </div>

    <div class="layui-footer">
        <!-- 底部固定区域 -->底部固定区域
        <span id="bottomTip">底部固定区域</span>
    </div>
</div>
<script>
    //JavaScript代码区域
    layui.use('element', function(){
        var element = layui.element;

    });
    function adminUsers() {
        document.getElementById("left_leader").src='users/usersLeft';
    }
    function adminqAnda() {
        document.getElementById("left_leader").src='/admin/QuestionsAndAnswers/qAndaLeft';
    }
    function adminArticle() {
        document.getElementById("left_leader").src='/admin/article/articleLeft';
    }
    function adminMassage() {
        document.getElementById("left_leader").src='/admin/massage/msgLeft';
    }
    function getAllUsers() {
        document.getElementById("contentBodyArea").src='allUsers';
    }
    function getSingleUser() {
        document.getElementById("contentBodyArea").src='singleUser';
    }

    layui.use('table', function(){
        var table = layui.table;
        //监听表格复选框选择
        table.on('checkbox(demo)', function(obj){
            console.log(obj)
        });
        //监听工具条
        table.on('tool(demo)', function(obj){
            var data = obj.data;
            if(obj.event === 'detail'){
                layer.confirm('邮件id：'+ data.t_id + '<br>' +
                    '标题：' + data.title + '<br>' +
                    '内容：' + data.content + '<br>' +
                    '', function(index){
                    layer.close(index);
                });

            } else if(obj.event === 'del'){ //删除
                layer.confirm('真的要修改这个密码么', function(index){
                    var load = layer.load(1, {
                        shade: [0.1,'#fff'] //0.1透明度的白色背景
                    });
                    $.ajax({
                        type: "post",
                        url: "/day05001/deleteEmail.do",
                        data: {
                            t_id : data.t_id
                        },
                        success: function (result) {
                            obj.del();//删除行
                            layer.msg("成功"),setTimeout(
                                function () {
                                    layer.close(index);
                                    if (result == "成功"){

                                    } else {

                                    }
                                },1500
                            );//删除成功！
                        }
                    });
                    layer.close(index);
                    layer.close(load);
                });
            }
        });

        var $ = layui.$, active = {
            getCheckData: function(){ //获取选中数据
                var checkStatus = table.checkStatus('idTest')
                    ,data = checkStatus.data;
                layer.alert(JSON.stringify(data));
            }
            ,getCheckLength: function(){ //获取选中数目
                var checkStatus = table.checkStatus('idTest')
                    ,data = checkStatus.data;
                layer.msg('选中了：'+ data.length + ' 个');
            }
            ,isAll: function(){ //验证是否全选
                var checkStatus = table.checkStatus('idTest');
                layer.msg(checkStatus.isAll ? '全选': '未全选')
            }
        };

        $('.demoTable .layui-btn').on('click', function(){
            var type = $(this).data('type');
            active[type] ? active[type].call(this) : '';
        });
    });
</script>
</body>
</html>
