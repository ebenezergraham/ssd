<%--
  Created by IntelliJ IDEA.
  User: ebenezergraham
  Date: 5/30/19
  Time: 1:31 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
  <head>
    <title>Simple Site</title>
  </head>
  <body>
  <p>Message in index.jsp <%= request.getAttribute("payload")%></p>
  </body>
</html>
