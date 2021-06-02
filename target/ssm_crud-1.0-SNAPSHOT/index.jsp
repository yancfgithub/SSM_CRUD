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
        show(1,2)


        function show(pageNum, pageSize) {

            var name = $("input[name='name']").val();
            var age = $("input[name='age']").val();
            var address = $("input[name='address']").val();

            var a;
            var b;
            var c;

            $.ajax({
                url:"girl/page?pageNum="+pageNum+"&pageSize="+pageSize+"&name="+name+"&age="+age+"&address="+address,
                type:"get",
                dataType:"json",
                success:function(ret) {


                    console.log(ret)
                    console.log("ret"+ret.prePage)
                    $("tbody").empty();
                    $("#pre").remove();
                    $("#next").remove();
                    $.each(ret.list,function(i,girl){
                        $("tbody").append("<tr><td>"+girl.id+"</td><td>"
                            +girl.name+"</td><td>"
                            +girl.age+"</td><td>"
                            +girl.address+"</td><td>"
                            +"<button type='button' id='updateBtn' onclick='goTo("+girl.id+")'>修改</button>"
                            +"<button type='button' id='deleteBtn' onclick='deleteGirl("+girl.id+")'>删除</button>"
                        );
                    })

                    a = ret.prePage;
                    b = ret.pageSize;
                    c = ret.nextPage;
                    $("#saveBtn").after('<button type="button" id="pre" onclick="show2('+ret.prePage+','+ret.pageSize+')">上一页</button>'+
                        '<button type="button" id="next" onclick="show2('+ret.nextPage+','+ret.pageSize+')">下一页</button>')
                }
            })

        }

        $("#searchBtn").click(function(){
            show(1,2)
        })

        show2 = function(a,b) {
            show(a,b);
        }

        $("#saveBtn").click(function(){
            window.location.href="save.html";
            // alert(123)
        })


        goTo = function (id) {
            window.location.href="update.html?id="+id;
        }

        deleteGirl = function (id) {
            $.ajax({
                url:"girl/"+id,
                type:"post",
                dataType:"json",
                success:function(ret) {
                    if(ret) {
                        window.location.reload();
                    }
                }
            })
        }

    })


</script>
<form id="search">
    姓名:<input name="name" />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    年龄:<input name="age" />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    地址:<input name="address" />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    <button type="button" id="searchBtn">查询</button>
</form>
<table border="1" width="100%">
    <thead>
    <tr>
        <td>编号</td>
        <td>姓名</td>
        <td>年龄</td>
        <td>地址</td>
        <td>操作</td>
    </tr>
    </thead>
    <tbody>

    </tbody>
</table>
    <button type="button" id="saveBtn">新增</button>
</body>
</html>