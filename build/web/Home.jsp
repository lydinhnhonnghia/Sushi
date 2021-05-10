<%-- 
    Document   : Home
    Created on : Mar 4, 2019, 12:18:23 AM
    Author     : kynhanht
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="css/home.css">
        <link rel="stylesheet" href="css/layout.css">
    </head>
    <body>
        <div class="site-wrapper">
            <jsp:include page="Header.jsp"/>
            <div class="content-wrapper">
                <div class="container">
                    <div class="content-left">
                        <div class="section">
                            <div class="content">
                                <a href="#"><img src="images/introduction1.jpg"></a>
                            </div>
                        </div>
                        <c:forEach var="x" items="${sushies}">
                            <c:url var="sushiDetail" value="SushiDetailController">
                                <c:param name="id" value="${x.id}"/>
                            </c:url>
                            <div class="section intro">
                                <div class="content">
                                    <div class="intro-title">
                                        <a href="${sushiDetail}">${x.name}</a>
                                    </div>
                                    <div class="img">
                                        <a href="${sushiDetail}"><img src="${x.picture}"></a>
                                    </div>
                                    ${x.shortDescription}
                                </div>
                            </div>                   
                        </c:forEach>
                        <div class="section">
                            <div class="content">
                                <div class="page" id="homePage">
                                    <c:forEach var="i" begin="1" end="${pages}">
                                        <c:url var="homePage" value="HomeController">
                                            <c:param name="page" value="${i}"/>
                                        </c:url>
                                        <c:choose>
                                            <c:when test="${page==i}">
                                                <a href="${homePage}" class="disabled-link">${i}</a>
                                            </c:when>
                                            <c:otherwise>
                                                <a href="${homePage}">${i}</a>
                                            </c:otherwise>
                                        </c:choose>
                                    </c:forEach>
                                </div>
                            </div>
                        </div>
                    </div>
                    <jsp:include page="Share.jsp"/>
                </div>
            </div>
            <jsp:include page="Footer.jsp"/>
        </div>
    </body>
</html>
