<!DOCTYPE html>
<html lang="en">
<head>

    <title>View user page</title>
      <jsp:include page="headers.jsp" />
</head>
<body>
<jsp:include page="navigation.jsp" />

<% ua.model.Skills skills = (ua.model.Skills)request.getAttribute("skills"); %>


<div class="container">
    <div class="container">
        <div class="btn-toolbar" role="toolbar" aria-label="Toolbar with button groups">
            <div class="btn-group mr-2" role="group" aria-label="First group">
                <a href="/special" type="button" class="btn btn-success">Back to special</a>
            </div>
        </div>

<table class="table">
            <thead>
            <tr>
                <th scope="col">Language</th>
                <th scope="col">Developer</th>
            </tr>
            </thead>
            <tbody>
            <%
             Object[] developers = (Object[]) request.getAttribute("developers");
             for(Object objDeveloper : developers){
             ua.model.Developer developer = (ua.model.Developer) objDeveloper;
             %>
             <tr>
                    <td><%= skills.getLanguage() %></td>
                    <td><%= developer.getName()  %></td>
            </tr>
            <%}%>
            </tbody>
        </table>
    </div>
</body>
</html>