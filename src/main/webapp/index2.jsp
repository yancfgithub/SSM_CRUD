<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
    <script src="js/jquery-3.4.1.js"></script>
    <script src="js/jquery.serializejson.js"></script>
</head>

<body>
<script type="text/javascript">
    $(function () {
        show()

        function show() {

            $.ajax({
                url:"food/selectAll",
                type:"get",
                dataType:"json",
                success:function(ret) {
                    $("#tbody").empty();
                    $.each(ret,function(i,food){
                        console.log(i)
                        $("#tbody").append("<tr><td>"+food.fid+"</td><td>"
                            +food.fname+"</td><td>"
                            +"<button type='button' id='updateBtn' onclick='updateFood("+food.fid+")'>修改</button>"
                            +"<button type='button' id='deleteBtn' onclick='deleteFood("+food.fid+")'>删除</button>"
                        );
                    })
                }
            })
        }

        updateFood = function (fid) {
            // window.location.href="update.html?id="+id;
            console.log("修改值"+fid)
        }

        deleteFood = function (fid) {
            $.ajax({
                url:"food/"+fid,
                type:"post",
                dataType:"json",
                success:function(ret) {
                    if(ret) {
                        window.location.reload();
                    }
                }
            })
        }


        $("#addBtn").click(function () {
            console.log("添加")

            var data2 = JSON.stringify($("#subForm").serializeJSON());

            console.log(data2);
            $.ajax({
                url:"food/insert",
                type:"post",
                data:data2,
                dataType: "json",
                contentType: "application/json;charset=utf-8",
                success:function (ret) {
                    if(ret) {
                        window.location.reload();
                    }
                }
            })
        })


        $("#ranBtn").click(function () {
            $.ajax({
                url:"food/checkedFood",
                type:"post",
                dataType: "json",
                contentType: "application/json;charset=utf-8",
                success:function(ret) {
                    console.log("123123")
                    $("#checkedFood").val(ret.fname);
                }
            })
        })
    })

</script>

    <table border="1" width="300px">
        <tbody>
            <tr>
                <td>编号</td>
                <td>名称</td>
                <td>操作</td>
            </tr>
        </tbody>

        <tbody id="tbody">
        </tbody>
    </table>

<form id="subForm">
    <input name="fid" type="hidden"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    <br/>名称:<input name="fname" />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    <br/><button type="button" id="addBtn">添加</button>
</form>
    <br/><button type="button" id="ranBtn">随机挑选</button><br/>
    <p>选中的食物是:<input type="text" id="checkedFood" disabled="disabled"></p>
</body>
</html>