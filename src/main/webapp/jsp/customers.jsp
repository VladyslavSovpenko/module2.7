<!DOCTYPE html>
<html>
<head>
    <title>Customers page</title>
   <jsp:include page="headers.jsp" />
    </head>

<jsp:include page="navigation.jsp" />

<div class="container">
    <div class="row">
        <h2>Customers page</h2>
    </div>
    <div class="row">
        <div class="btn-toolbar" role="toolbar" aria-label="Toolbar with button groups">
            <div class="btn-group me-2" role="group" aria-label="Second group">
                <a href="/customers/new" type="button" class="btn btn-primary">New record</a>
            </div>
        </div>
        <table class="table">
            <thead>
            <tr>
                <th scope="col">Id</th>
                <th scope="col">Name</th>
                 <th scope="col">Country</th>

             </tr>
            </thead>
            <tbody>

            <%
            Object[] customers = (Object[]) request.getAttribute("customers");
                for(Object objCustomers : customers){
                ua.model.Customers customer = (ua.model.Customers) objCustomers;
                %>

                <tr>
                    <td><%= customer.getId()  %></td>
                    <td><%= customer.getName()  %></td>
                    <td><%= customer.getCountry()  %></td>

                    <td>
                            <div class="btn-toolbar" role="toolbar" aria-label="Toolbar with button groups">
                                <div class="btn-group mr-2" role="group" aria-label="First group">
                                    <a href="/customers/<%= customer.getId() %>" type="button" class="btn btn-warning">Edit</a>
                                    <a href="/customers?deleteId=<%= customer.getId() %>"type="button" class="btn btn-danger">Remove</a>
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