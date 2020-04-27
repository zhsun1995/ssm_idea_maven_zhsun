<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>更新信息</title>
</head>
<body>
    编号：<input id="uid" type="text" readonly="不可修改" value="${uid}"><br />
    姓名：<input id="name" type="text" value="${name}"><br />
    籍贯：<input id="place" type="text" value="${place}"><br />
    工资：<input id="salary" type="text" value="${salary}"><br />

    <button id="update">更新</button>
    <button id="cancel">取消</button>

    <script type="text/javascript" src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
    <script type="text/javascript">
        $(document).ready(function () {
            let curPath=window.document.location.href;
            // 去除主机地址的路径
            let pathName=window.document.location.pathname;
            let pos=curPath.indexOf(pathName);
            //获取主机地址，如： http://localhost:8083
            let localhostPaht=curPath.substring(0,pos);
            //获取带"/"的项目名，如：/ssmdemo
            let projectName=pathName.substring(0,pathName.substr(1).indexOf('/')+1);
            $("#update").click(function () {
                 let uid = document.getElementById("uid").value;
                 let name = document.getElementById("name").value;
                 let place = document.getElementById("place").value;
                 let salary = document.getElementById("salary").value;
                 let informationExtend = {
                     "uid": uid, "name": name,
                     "place": place, "salary": salary
                 };
                 let jsonData = JSON.stringify(informationExtend);

                 $.ajax({
                     type: "post",
                     url: "update",
                     dataType: "json",
                     data: jsonData,
                     contentType: "application/json;charset=UTF-8",
                     success: function (msg) {
                         if("1" == msg){
                             window.alert("修改完成！")
                             window.location.href = localhostPaht+projectName + "/showInformation";
                         } else {
                             window.alert("信息错误，重新修改！")
                         }
                     },
                     error: function () {
                         window.alert("错误！")
                     }
                 });
            });

            $("#cancel").click(function () {
                // 页面跳转
                window.location.href = localhostPaht+projectName + "/showInformation";
            });
        });
    </script>
</body>
</html>
