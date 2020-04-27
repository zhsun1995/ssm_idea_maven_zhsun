<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" import="java.util.*"%>

<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<html>
<head>
    <title>显示信息</title>
</head>
<body>
    <button id="showAll">查询</button>
    <button id="add">插入</button>
    <table class="table table-bordered table-hover" id="table1" border="1px solid #ccc">

        <thead>
        <tr>
            <th>员工编号</th>
            <th>姓名</th>
            <th>籍贯</th>
            <th>工资</th>
            <th>操作</th>
        </tr>
        </thead>
        <tbody id="tbody0">
        </tbody>
    </table>

    <%--引入ajax--%>
    <script type="text/javascript" src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
<%--    <script type="text/javascript" src="js/jsShowInfo.js"></script>--%>
    <script type="text/javascript">
        let tbody0 = "";
        let curPath=window.document.location.href;
        // 去除主机地址的路径
        let pathName=window.document.location.pathname;
        let pos=curPath.indexOf(pathName);
        //获取主机地址，如： http://localhost:8083
        let localhostPaht=curPath.substring(0,pos);
        //获取带"/"的项目名，如：/ssmdemo
        let projectName=pathName.substring(0,pathName.substr(1).indexOf('/')+1);

        $(document).ready(function(){
            $("#showAll").click(function () {
                $.ajax({
                    type: "post",
                    url: "showAll",
                    dataType: "json",
                    contentType: "application/json;charset=UTF-8",
                    success: function (msg) {
                        if(0 != msg.length){
                            tbody0 = "";
                            outPrintData(msg);
                            $("#tbody0").html(tbody0);
                        } else{
                            window.alert("没有数据！")
                        }
                    },
                    error: function () {
                        window.alert("错误！")
                    }
                });
            });


            $("#add").click(function () {
                // 页面跳转
                window.location.href = localhostPaht+projectName + "/addInformation";
            });
        });

        /**
         * 将信息显示在表格中部
         * @param msg
         */
        function outPrintData(msg){

            for (let i = 0; i < msg.length; i++) {
                tbody0+="<tr id = '"+i+"'>";
                tbody0+="<td>";
                tbody0+=msg[i].uid;
                tbody0+="</td>";
                tbody0+="<td>";
                tbody0+=msg[i].name;
                tbody0+="</td>";
                tbody0+="<td>";
                tbody0+=msg[i].place;
                tbody0+="</td>";
                tbody0+="<td>";
                tbody0+=msg[i].salary;
                tbody0+="</td>";
                tbody0+="<td>";
                tbody0+="<a href='javascript:toUpdateInfo("+msg[i].uid+",\""+msg[i].name+"\",\""+msg[i].place+"\"," +
                    ""+msg[i].salary+")'>更新&nbsp</a>";
                tbody0+="<a href='javascript:void(0)' onClick=deleteDate("+msg[i].uid+","+i+")>删除</a>";
                tbody0+="</td>";
                tbody0+="</tr>";
            }
        }

        /**
         * 携带信息去更新界面
         * @param uid
         * @param name
         * @param place
         * @param salary
         * @param index
         */
        function toUpdateInfo(uid, name, place, salary){
            let informationExtend = {
                "uid": uid, "name": name,
                "place": place, "salary": salary
            };
            let jsonData = JSON.stringify(informationExtend);
            $.ajax({
                type: "post",
                url: "toUpdateInfo",
                dataType: "json",
                data: jsonData,
                contentType: "application/json;charset=UTF-8",
                success: function (msg) {
                    if("1" == msg){
                        // 页面跳转
                        window.location.href = localhostPaht+projectName + "/updateInformation";
                    }
                },
                error: function () {
                    window.alert("更新错误！")
                }
            });
        }

        /**
         * 删除数据
         * @param uid
         * @param index
         */
        function deleteDate(uid, index) {
            $.ajax({
                url: 'delete',
                type: 'post',
                data: 'uid='+uid,
                success: function(msg) {
                    if ("1" == msg) {
                        window.alert("数据删除成功！");
                        delOneTableRow(index);
                    } else {
                        window.alert("数据删除失败！");
                    }
                },
                error:function( jqXHR){
                    window.alert("删除错误！")
                }
            });
        }

        /**
         * 从表格中删除一行
         * @param index
         */
        function delOneTableRow(index) {
            let x = document.getElementById(""+index+"");
            x.parentNode.removeChild(x);
        }
    </script>

</body>
</html>