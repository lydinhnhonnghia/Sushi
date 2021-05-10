<%-- 
    Document   : ListSushies
    Created on : Mar 6, 2019, 11:49:25 PM
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
        <link rel="stylesheet" href="css/listSushies.css">
    </head>
    <body>
        <div class="site-wrapper">
            <jsp:include page="Header.jsp"/>
            <div class="content-wrapper">
                <div class="container">
                    <div class="content-left">
                        <div class="sushi-introduction">
                            Menu and Price list
                        </div>
                        <c:forEach var="x" items="${sushies}">
                            <div class="section">
                                <div class="content">
                                    <div class="sushi-title">
                                        <div class="sushi-menu">Menu${x.id}</div>
                                        <div class="sushi-price">Price</div>
                                    </div>
                                    <div class="sushi-content-title">
                                        <div class="sushi-menu">${x.name}</div>
                                        <div class="sushi-price">${x.price}</div>
                                    </div>
                                    <div class="sushi-description">
                                        ${x.menuDescription}
                                    </div>
                                </div>
                            </div>
                        </c:forEach>
                        <div class="section">
                            <div class="content">
                                <div 
                                    class="page" id="listPage">
                                    <c:forEach var="i" begin="1" end="${pages}">
                                        <c:url var="listSushies" value="ListSushiesController">
                                            <c:param name="page" value="${i}"/>
                                        </c:url>
                                        <c:choose>
                                            <c:when test="${page==i}">
                                                <a href="${listSushies}" class="disabled-link">${i}</a>
                                            </c:when>
                                            <c:otherwise>
                                                <a href="${listSushies}">${i}</a>
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
