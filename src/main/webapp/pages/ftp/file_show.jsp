<%--
  Created by IntelliJ IDEA.
  User: daiyun
  Date: 2018-6-5
  Time: 21:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/sys/common.jsp" %>

<div class="panel panel-default">
    <div class="panel-heading">
        <input type="hidden" value="${folder.relativePath}" property="globalRelativePath" id="globalRelativePath">
        <span>${folder.relativePath}</span>
    </div>
    <div class="panel-body">
        <table class="table table-hover">
            <tbody>

            <c:if test="${folder.level != 0}">
                <tr style="cursor: pointer;" onclick="getPreviousFiles(this)">
                    <td>...</td>
                </tr>
            </c:if>

            <c:if test="${empty folder.fileCatagories}">
                <tr>
                    <td style="text-align: center">
                            <h3 style="color: #999999">无文件</h3>
                    </td>
                </tr>
            </c:if>

            <c:if test="${not empty folder.fileCatagories}">
            <c:forEach items="${folder.fileCatagories}" var="fileCatagory" varStatus="varStatus">
                <tr style="cursor: pointer;" onclick="getNextFiles(this)">
                    <c:if test="${folder.level == 0}">
                        <input type="hidden" value="${fileCatagory.file.path}" id="filePath_${varStatus.index}">
                        <input type="hidden" value="${fileCatagory.isDirectory}" id="isDirectory_${varStatus.index}">
                    </c:if>
                    <c:if test="${folder.level != 0}">
                        <input type="hidden" value="${fileCatagory.file.path}" id="filePath_${varStatus.index + 1}">
                        <input type="hidden" value="${fileCatagory.isDirectory}"
                               id="isDirectory_${varStatus.index + 1}">
                    </c:if>
                    <td>
                        <label>
                            <input type="checkbox" name="List_Selected" value="${fileCatagory.file.path}"
                                   onclick="stopPropergation()">
                        </label>
                        <c:if test="${fileCatagory.isDirectory == true}">
                            <img src="${contextPath}/resources/images/folder.png" class="file_img">
                        </c:if>
                        <c:if test="${fileCatagory.isDirectory == false}">
                            <img src="${contextPath}/resources/images/file.png" class="file_img">
                        </c:if>
                            ${fileCatagory.file.name}

                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        <input type="hidden" value="${folder.relativePath}" property="relativePath">
        </c:if>
    </div>
</div>

