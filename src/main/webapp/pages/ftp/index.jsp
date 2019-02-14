<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/sys/common.jsp" %>
<%@include file="ftp_js.jsp" %>
<html>
<head>
    <link href="${contextPath}/resources/css/ftp.css" rel="stylesheet">
    <title>全部文件</title>
</head>
<body>
<div id="center_title">
    <h1>文件管理</h1>
</div>
<div id="content">

    <div id="title" style="float: left">
        <%--<button type="button" class="btn" style="background-color: #9acfea;">
            <a href="${contextPath}/ftp/index">全部文件</a>
        </button>--%>
        <div id="operationBtn">
            <button type="button" class="btn btn-default" data-toggle="modal" data-target="#myModal">新建文件夹</button>
            <button type="button" class="btn btn-default" data-toggle="modal" data-target="#myModal_upload">上传文件</button>
            <button type="button" class="btn btn-default" onclick="refreshFolder()">刷新</button>
            <button type="button" class="btn btn-default" onclick="delConfirm()">删除</button>
        </div>
    </div>
    <%--显示文件--%>
    <div id="show_file" style="margin-top: 20px;clear:both;">

    </div>
</div>
<c:import url="modal_box.jsp"/>
<c:import url="modal_del.jsp"/>
<c:import url="modal_upload.jsp"/>
</body>
</html>
