<%-- 
    Document   : header
    Created on : Mar 3, 2019, 11:31:18 PM
    Author     : kynhanht
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="css/header.css">
        <link rel="stylesheet" href="css/layout.css">
    </head>
    <body>
        <div class="header-wrapper">
            <div class="container">
                <div class="title-wrapper">
                    <div class="header-title">
                        The SuShi Restaurant
                    </div>
                    <div class="sub-subtitle">
                        Welcome to this website
                    </div>
                </div>
                <div class="navbar" id="menu">
                    <ul class="nav">
                        <c:choose>
                            <c:when test="${currentPage==0}">
                                <li><a href="HomeController" class="keepHightLight-link">Home</a></li>
                                <li><a href="ListSushiesController">Menu and Price list</a></li>
                                <li><a href="FindController">Find us</a></li>
                            </c:when>
                            <c:when test="${currentPage==1}">
                                <li><a href="HomeController">Home</a></li>
                                <li><a href="ListSushiesController" class="keepHightLight-link">Menu and Price list</a></li>
                                <li><a href="FindController">Find us</a></li>
                            </c:when>
                            <c:otherwise>
                                <li><a href="HomeController">Home</a></li>
                                <li><a href="ListSushiesController">Menu and Price list</a></li>
                                <li><a href="FindController" class="keepHightLight-link">Find us</a></li>
                            </c:otherwise>
                        </c:choose>
                    </ul>
                </div>
            </div>
        </div>
    </body>
</html>
