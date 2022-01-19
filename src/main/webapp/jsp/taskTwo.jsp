<!DOCTYPE html>
<html lang="en">
<head>

    <title>View user page</title>
      <jsp:include page="headers.jsp" />
</head>
<body>
<jsp:include page="navigation.jsp" />

<% ua.model.Project project = (ua.model.Project)request.getAttribute("project"); %>
<% Object[] developers = (Object[])request.getAttribute("developers"); %>


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
                <th scope="col">Id</th>
                <th scope="col">Sum</th>
            </tr>
            </thead>
            <tbody>
            <%

             for(Object objDeveloper : developers){
             ua.model.Developer developer = (ua.model.Developer) objDeveloper;
             %>
             <tr>
                <td><%= project.getName()  %></td>
                <td><%= developer.getName()  %></td>
            </tr>
            <% } %>

            </tbody>
        </table>
    </div>
</body>
</html>