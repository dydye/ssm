<%--
  Created by IntelliJ IDEA.
  User: daiyun
  Date: 2018-6-6
  Time: 23:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/sys/common.jsp" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#myModal_upload">
    提问（点击弹出模态窗口）
</button>
<div class="modal fade" id="myModal_upload" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button data-dismiss="modal" class="close" type="button"><span aria-hidden="true">×</span><span class="sr-only">Close</span></button>
                <h4 class="modal-title">提问</h4>
            </div>
            <div class="modal-body">
                <p>问题描述</p>
                <textarea class="form-control"></textarea>
            </div>
            <div class="modal-footer">
                <button data-dismiss="modal" class="btn btn-default" type="button">关闭</button>
                <button class="btn btn-primary" type="button">提交</button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->
</div>

<div style="height:200px"></div>
<script>
    var clearFlag = 0;
    var count = 3;//设置3秒后自动消失
    var showModal = function(){
        $("#my-modal-alert").toggle();//显示模态框

        /*$("#my-modal-alert").draggable({//设置模态框可拖动（需要引入jquery-ui.min.js）
            handle: ".modal-header"
        });*/

        clearFlag = self.setInterval("autoClose()",1000);//每过一秒调用一次autoClose方法
    }

    var autoClose = function(){
        if(count>0){
            $("#num").html(count + "秒后窗口将自动关闭");
            count--;
        }else if(count<=0){
            window.clearInterval(clearFlag);
            $("#num").html("");
            $("#my-modal-alert").fadeOut("slow");
            count = 3;
            $("#my-modal-alert").toggle();
        }
    }


        function showPopover(target, msg) {
            target.attr("data-original-title", msg);
            $('[data-toggle="tooltip"]').tooltip();
            target.tooltip('show');
            target.focus();

            //2秒后消失提示框
            var id = setTimeout(
                function () {
                    target.attr("data-original-title", "");
                    target.tooltip('hide');
                }, 2000
            );
        }
    showPopover($("#tableName"),"表名已存在");
</script>
</body>
</html>
