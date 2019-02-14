<%--
  Created by IntelliJ IDEA.
  User: daiyun
  Date: 2018-6-8
  Time: 13:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<div class="modal fade" id="myModal_upload" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" data-backdrop="false">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button data-dismiss="modal" class="close" type="button" onclick="refreshFolder()">
                    <span aria-hidden="true">×</span>
                    <span class="sr-only">Close</span>
                </button>
                <h4 class="modal-title">上传文件</h4>
            </div>
            <div class="modal-body">
                <form id="uploadForm" enctype="multipart/form-data" method="post">
                    <input type="file" name="file" id="file" multiple="multiple">
                </form>
            </div>
            <%--上传进度--%>
            <div id="progressBarParent" class="progress progress-striped active" style="display: none">
                <div id="progressBar" class="progress-bar progress-bar-info" role="progressbar" aria-valuemin="0" aria-valuenow="0"
                     aria-valuemax="100" style="width: 0%">
                </div>
            </div>

            <div class="modal-footer">
                <button  class="btn btn-default" data-dismiss="modal" type="button" onclick="refreshFolder()">关闭</button>
                <button  class="btn btn-primary" data-dismiss="modal" type="button" onclick="uploadFiles()" id="uploadBtn">提交</button>
            </div>
        </div>
    </div>
</div>

<div style="height:200px"></div>
