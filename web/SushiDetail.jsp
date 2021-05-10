<%-- 
    Document   : SushiDetail
    Created on : Mar 7, 2019, 1:11:26 AM
    Author     : kynhanht
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sushi Detail</title>
        <link rel="stylesheet" href="css/layout.css">
        <link rel="stylesheet" href="css/sushiDetail.css">
    </head>
    <body>
        <div class="site-wrapper">
            <jsp:include page="Header.jsp"/>
            <div class="content-wrapper">
                <div class="container">
                    <div class="content-left">
                        <div class="section">
                            <div class="content">
                                <div class="introduction-title">${sushi.name}</div>
                                <div class="sushi-detail-img">
                                    <img src="${sushi.picture}">
                                </div>
                                ${sushi.detailDescription}
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
