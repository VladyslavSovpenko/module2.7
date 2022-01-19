<!DOCTYPE html>
<html>
<head>
    <title>Developers page</title>
   <jsp:include page="headers.jsp" />
    </head>

<jsp:include page="navigation.jsp" />

<div class="container">
    <div class="row">
        <h2>Developers page</h2>
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
                 <th scope="col">Sex</th>
                  <th scope="col">Salary</th>
                   <th scope="col">Age</th>
                   <th scope="col">Actions</th>
             </tr>
            </thead>
            <tbody>
            <%
            Object[] developers = (Object[]) request.getAttribute("developers");
                for(Object objDeveloper : developers){
                ua.model.Developer developer = (ua.model.Developer) objDeveloper;
                %>

                <tr>
                    <td><%= developer.getId() %></td>
                    <td><%= developer.getName()  %></td>
                    <td><%= developer.getSex()  %></td>
                    <td><%= developer.getSalary() %></td>
                    <td><%= developer.getAge()  %></td>
                    <td>
                            <div class="btn-toolbar" role="toolbar" aria-label="Toolbar with button groups">
                                <div class="btn-group mr-2" role="group" aria-label="First group">
                                    <a href="/developers/<%= developer.getId() %>" type="button" class="btn btn-warning">Edit</a>
                                    <a href="/developers?deleteId=<%= developer.getId() %>"type="button" class="btn btn-danger">Remove</a>
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