<!DOCTYPE html>
<html lang="en">
<head>

    <title>View user page</title>
      <jsp:include page="headers.jsp" />
</head>
<body>
<jsp:include page="navigation.jsp" />

<% ua.model.Project project = (ua.model.Project)request.getAttribute("project"); %>


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
                <th scope="col">Project name</th>
                <th scope="col">Sum</th>
            </tr>
            </thead>
            <tbody>
            <tr>
                    <td><%= project.getName() %></td>
                    <td><%= project.getCost()  %></td>
            </tr>
            </tbody>
        </table>



    </div>
</body>
</html>