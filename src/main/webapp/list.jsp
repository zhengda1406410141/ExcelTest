<%@page contentType="text/html; charset=UTF-8" language="java" %>
<%@include file="common/tag.jsp"%>
<!DOCTYPE html>
<html>
<head>
    <title>导入列表</title>
    <%@include file="common/head.jsp" %>

</head>
<body>
<div class="container">
    <div class="panel panel-default">
        <div class="panel-heading text-center">
            <h2>列表</h2>
        </div>
        <div class="panel-body">
            <table class="table table-hover">
                <thead>
                <tr>
                    <th>名称</th>
                    <th>年龄</th>
                    <th>工龄</th>
                    <th>工资</th>
                    <th>手机号码</th>
                    <th>邮箱</th>
                </tr>
                </thead>
                <tbody onload="validatePhone()">
                <c:forEach items="${list}" var="entity">
                    <tr>
                        <td>${entity.name}</td>
                        <td>${entity.age}</td>
                        <td>${entity.workAge}</td>
                        <td>${entity.wages}</td>
                        <td>
                                <input  name="showContent" type="text" value="${entity.phone}" onkeyup="validatePhone(this.value)" id="${entity.phone}">
                        </td>
                        <td>
                                <input  name="showContent" type="text" value="${entity.email}" onkeyup="changeContent(this, 'show')" id="${entity.email}">
                        </td>
                        <td>
                            <button name="save" type="button" class="btn btn-info btn-sm" onclick="saveData(this)">提交</button>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>

        </div>
    </div>
</div>
<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="http://apps.bdimg.com/libs/jquery/2.0.0/jquery.min.js"></script>

<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="http://apps.bdimg.com/libs/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<script type="text/javascript">
    var data = {
        'border':'1px solid red'
    }
    $(function () {
        alert("start")
        var patrn=/^[0-9]{1,20}$/;
        // var patrnEmail=/w+([-+.]\w+)*@\w+([-.] \w+)*\.\w+([-.]\w+)*/;
        var patrnEmail= /^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+((\.[a-zA-Z0-9_-]{2,3}){1,2})$/;
        var dataLength = $("tbody tr td:nth-child(5)");
        for (var i = 0; i <dataLength.length;i++){
            var phoneData = $("tbody tr:eq("+i+") td:nth-child(5)").find("input").val();
            console.log(phoneData);
            if (!patrn.exec(phoneData)){
                $("tbody tr:eq("+i+") td:nth-child(5)").css(data);
            }
        }
        for (var i = 0; i <dataLength.length;i++){
            var phoneData = $("tbody tr:eq("+i+") td:nth-child(6)").find("input").val();
            console.log(phoneData);
            $("tbody tr:eq("+i+") td:nth-child(6)").find("input").css(data);
            if (patrnEmail.test(phoneData)){
                $("tbody tr:eq("+i+") td:nth-child(6)").css(data);
            }
        }
    })
</script>
</body>
</html>