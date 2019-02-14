<%--
  Created by IntelliJ IDEA.
  User: daiyun
  Date: 2018-6-6
  Time: 14:27
  To change this template use File | Settings | File Templates.
--%>
<%-- 模态框 --%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%--data-backdrop="false"去除遮罩层--%>
<div class="modal fade" id="myModal" data-backdrop="false">
    <div class="modal-dialog" >
        <div class="modal-content">

            <!-- 模态框头部 -->
            <div class="modal-header">
                <h4 class="modal-title">新建文件夹</h4>
                <button type="button" class="close" data-dismiss="modal">&times;</button>
            </div>

            <!-- 模态框主体 -->
            <div class="modal-body">
                <div class="input-group input-group-lg">
                    <span class="input-group-addon" id="basic-addon1">名称</span>
                    <input type="text" class="form-control" placeholder="新建文件夹" aria-describedby="basic-addon1" id="new_folder">
                </div>
            </div>

            <!-- 模态框底部 -->
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">关闭</button>
                <button type="button" class="btn btn-secondary" data-dismiss="modal" onclick="mkdir()">保存</button>
            </div>

        </div>
    </div>
</div>
