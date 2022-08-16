<%--
  Created by IntelliJ IDEA.
  User: HB
  Date: 2021/8/4
  Time: 22:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>新增书籍</title>
<%--    引入Bootstrap--%>
    <link
    href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet"
    >
</head>
<body>
<div class="container">
  <div class="1">
    <div class="col-md-12 column">
      <div class="page-header">
        <h1>
          <small>新增书籍</small>
        </h1>
      </div>
    </div>
  </div>
  <form action="${pageContext.request.contextPath}/book/addBook" method="post">
    书籍名称：<input type="text" name="bookName"><br>
    书籍数量：<input type="text" name="bookCounts"><br>
    书籍详情：<input type="text" name="detail"><br>
    <input type="submit" value="添加">
  </form>
</div>
</body>
</html>
