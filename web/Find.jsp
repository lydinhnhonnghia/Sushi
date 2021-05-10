<%-- 
    Document   : Find
    Created on : Mar 4, 2019, 10:30:53 PM
    Author     : kynhanht
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="css/layout.css">
        <link rel="stylesheet" href="css/find.css">
    </head>
    <body>
        <div class="site-wrapper">
            <jsp:include page="Header.jsp"/>
            <div class="content-wrapper">
                <div class="container">
                    <div class="content-left">
                        <div class="section">
                            <div class="content find">
                                <div class="introduction-title">Find us</div>
                                <ul>
                                    <li class="item">
                                        <div class="content-title">Address and contact:</div>
                                        <div>${contact.address}</div>
                                        <br>
                                        <div><span>Tel: </span><a href="#">${contact.phone}</a></div>
                                        <div><span>Email: </span><a href="#">${contact.email}</a></div>
                                    </li>
                                    <li class="item">
                                        <div class="content-title">Opening hours:</div>
                                        <c:forEach var="x" items="${openingHours}">
                                            <div>${x.day} ${x.time}</div>
                                        </c:forEach>
                                    </li>
                                </ul>
                            </div>
                        </div>
                        <div class="section find">
                            <img src="${contact.mapPicture}">
                        </div>
                    </div>
                    <jsp:include page="Share.jsp"/>
                </div>
            </div>
            <jsp:include page="Footer.jsp"/>
        </div>
    </body>
</html>
