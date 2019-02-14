<%--
  Created by IntelliJ IDEA.
  User: daiyun
  Date: 2018-6-4
  Time: 15:51
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/sys/common.jsp" %>
<%
    //获取web服务器项目的真实物理路径
    String realPath = request.getSession().getServletContext().getRealPath("/");
    System.out.println("web服务器项目的真实物理路径:" + realPath);

    String relativelyPath=System.getProperty("user.dir");
    System.out.println("相对路径：" + relativelyPath);

    //得到包含工程名的当前页面全路径：request.getRequestURI()
    String requestURI = request.getRequestURI();
    System.out.println("工程名的当前页面全路径:" + requestURI);

    //得到工程名
    /*String contextPath = request.getSession().getServletContext().getContextPath();
    System.out.println("工程名：" + contextPath);
    System.out.println(request.getContextPath());*/

    //得到当前页面所在目录下全名称：request.getServletPath()
    String servletPath = request.getServletPath();
    System.out.println("得到当前页面所在目录下全名称:" + servletPath);

    //得到页面所在服务器的全路径：application.getRealPath("页面.jsp")
    String appRealPath = application.getRealPath("demo.jsp");
    System.out.println("得到页面所在服务器的全路径:" + appRealPath);

    //得到页面所在服务器的绝对路径：absPath=new java.io.File(application.getRealPath(request.getRequestURI())).getParent();

%>
<html>
<head>
    <%--IE=edge告诉IE使用最新的引擎渲染网页，chrome=1则可以激活Chrome Frame--%>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Title</title>

</head>
<body>
<table class="table table-hover">
    <thead>
    <th>头像</th>
    <th>名字</th>
    <th>HP</th>
    </thead>
    <tbody>
    <tr>
        <td><img width="20px" src="http://how2j.cn/study/bootstrap/lol/gareen.png"/></td>
        <td>盖伦</td>
        <td>616</td>
    </tr>
    <tr>
        <td><img width="20px" src="http://how2j.cn/study/bootstrap/lol/teemo.png"/></td>
        <td>提莫</td>
        <td>383</td>
    </tr>
    <tr>
        <td><img width="20px" src="http://how2j.cn/study/bootstrap/lol/akali.png"/></td>
        <td>阿卡丽</td>
        <td>448</td>
    </tr>
    </tbody>
</table>
</body>
</html>
