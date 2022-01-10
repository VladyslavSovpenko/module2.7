<!DOCTYPE html>
<html>
<head>
    <title>Projects page</title>
   <jsp:include page="headers.jsp" />
    </head>

<jsp:include page="navigation.jsp" />

<div class="container">
    <div class="row">
        <h2>Projects page</h2>
    </div>
    <div class="row">
        <div class="btn-toolbar" role="toolbar" aria-label="Toolbar with button groups">
            <div class="btn-group me-2" role="group" aria-label="Second group">
                <a href="/developers/new" type="button" class="btn btn-primary">New record</a>
            </div>
        </div>
        <table class="table">
            <thead>
            <tr>
                <th scope="col">Id</th>
                <th scope="col">Name</th>
                 <th scope="col">Language</th>
                  <th scope="col">Cost</th>
                   <th scope="col">Date added</th>
            </tr>
            </thead>
            <tbody>
            <%
            Object[] projects = (Object[]) request.getAttribute("projects");
                for(Object objProject : projects){
                ua.model.Project project = (ua.model.Project) objProject;
                %>

                <tr>
                    <td><%= project.getId() %></td>
                    <td><%= project.getName()  %></td>
                    <td><%= project.getLanguage()  %></td>
                    <td><%= project.getCost() %></td>
                    <td><%= project.getDate()  %></td>
                    <td>
                            <div class="btn-toolbar" role="toolbar" aria-label="Toolbar with button groups">
                                <div class="btn-group mr-2" role="group" aria-label="First group">
                                    <a href="/projects/<%= project.getId() %>" type="button" class="btn btn-warning">Edit</a>
                                    <a href="/projects/<%= project.getId() %>"type="button" class="btn btn-danger">Remove</a>
                                </div>

                            </div>
                        </td>
                 </tr>

            <% } %>

            </tbody>
        </table>
    </div>
</div>

</body>
</html>