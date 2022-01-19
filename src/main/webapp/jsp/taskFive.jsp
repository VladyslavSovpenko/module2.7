<!DOCTYPE html>
<html lang="en">
<head>

    <title>View user page</title>
      <jsp:include page="headers.jsp" />
</head>
<body>
<jsp:include page="navigation.jsp" />

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
                <th scope="col">Date added</th>
                <th scope="col">Name</th>
                <th scope="col">Number of developers</th>
            </tr>
            </thead>
            <tbody>
            <%
             Object[] list = (Object[]) request.getAttribute("list");
             for(Object objList : list){
             ua.model.ProjectList project = (ua.model.ProjectList) objList;
             %>
             <tr>
                    <td><%= project.getDateAdded() %></td>
                    <td><%= project.getName()  %></td>
                     <td><%= project.getCount()  %></td>
            </tr>
            <%}%>
            </tbody>
        </table>
    </div>
</body>
</html>