<!DOCTYPE html>
<html>
<head>
    <title>Developers page</title>
   <jsp:include page="headers.jsp" />
    </head>

<jsp:include page="navigation.jsp" />

<div class="container">
    <div class="row">
        <h2>Companies page</h2>
    </div>
    <div class="row">
        <div class="btn-toolbar" role="toolbar" aria-label="Toolbar with button groups">
            <div class="btn-group me-2" role="group" aria-label="Second group">
                <a href="/companies/new" type="button" class="btn btn-primary">New record</a>
            </div>
        </div>
        <table class="table">
            <thead>
            <tr>
                <th scope="col">Id</th>
                <th scope="col">Name</th>
                 <th scope="col">Number of projects</th>

             </tr>
            </thead>
            <tbody>
            <%
            Object[] companies = (Object[]) request.getAttribute("companies");
                for(Object objCompany : companies){
                ua.model.Companies company = (ua.model.Companies) objCompany;
                %>

                <tr>
                    <td><%= company.getId() %></td>
                    <td><%= company.getName()  %></td>
                    <td><%= company.getNumber()  %></td>

                    <td>
                            <div class="btn-toolbar" role="toolbar" aria-label="Toolbar with button groups">
                                <div class="btn-group mr-2" role="group" aria-label="First group">
                                    <a href="/companies/<%= company.getId() %>" type="button" class="btn btn-warning">Edit</a>
                                    <a href="/companies/delete/<%= company.getId() %>"type="button" class="btn btn-danger">Remove</a>
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