<%--
  Created by IntelliJ IDEA.
  User: daiyun
  Date: 2018-6-4
  Time: 17:32
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ page isELIgnored="false"%>
<%
    String contextPath = request.getContextPath();
    request.setAttribute("contextPath", contextPath);
%>
<script src="${contextPath}/resources/js/jquery.js"></script>
<script src="${contextPath}/resources/bootstrap-3.3.7-dist/js/bootstrap.js"></script>
<link href="${contextPath}/resources/bootstrap-3.3.7-dist/css/bootstrap.css" rel="stylesheet">
<script src="${contextPath}/resources/toastr/toastr.js"></script>
<link href="${contextPath}/resources/toastr/toastr.css" rel="stylesheet" />
