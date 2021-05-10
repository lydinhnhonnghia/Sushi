<%-- 
    Document   : Share
    Created on : Mar 4, 2019, 12:40:18 AM
    Author     : kynhanht
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" href="css/share.css">
<body>
    <div class="content-right">
        <div class="share-header">
            Share this page
        </div>
        <div class="share-content">
            <c:forEach var="x" items="${shares}"> 
                <div>
                    <a href="${x.url}"><img src="images/gg.png"> Share on ${x.socialNetwork}</a>
                </div>
            </c:forEach>
        </div>

    </div>

