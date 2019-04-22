<%@page import="java.time.LocalDateTime"%>
<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>JSP Example</title>
    </head>
    <body>
        <!-- This will generate different responses depending on the time of the WEB website. -->
        <%= LocalDateTime.now() %>
    </body>
</html>