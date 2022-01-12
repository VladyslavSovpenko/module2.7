<!DOCTYPE html>
<html lang="en">
<head>

    <title>View customer`s page</title>
      <jsp:include page="headers.jsp" />
</head>
<body>
<jsp:include page="navigation.jsp" />

<% ua.model.Customers customers = (ua.model.Customers)request.getAttribute("customers"); %>


<div class="container">
    <div class="container">
        <div class="btn-toolbar" role="toolbar" aria-label="Toolbar with button groups">
            <div class="btn-group mr-2" role="group" aria-label="First group">
                <a href="/customers" type="button" class="btn btn-success">Back to customers</a>

            </div>
        </div>

        <div class="row">
            <div class="mb-3">
                <label for="name" class="form-label">Id</label>
                <input type="text" disabled class="form-control" value="<%=customers.getId()==null ? "" : customers.getId()%>"
                       id="id" placeholder="id">
            </div>

            <div class="mb-3">
                <label for="number" class="form-label">Name</label>
                <input type="email" class="form-control" value="<%=customers.getName()==null ? "" : customers.getName()%>"
                       id="name" placeholder="name">
            </div>

           <div class="mb-3">
           <label for="id" class="form-label">Country</label>
           <input type="email"  class="form-control" value="<%=customers.getCountry()==null ? "" : customers.getCountry()%>"
           id="country" placeholder="country">
           </div>


           <div class="row">
                   <div class="btn-toolbar" role="toolbar" aria-label="Toolbar with button groups">
                       <div class="btn-group me-2" role="group" aria-label="Second group">
                           <button onclick="save()" type="button" class="btn btn-primary">Save</button>
                       </div>
                </div>

            </div>

    </div>

<script>
 let country=document.getElementById('country');
 let name=document.getElementById('name');
 let id=document.getElementById('id');

    function save() {
     let body = {
     <% if(customers.getId() != null) {%>
                              id: id.value,
                       <% }%>
        country: country.value,
        name: name.value,

      }
      <% if(customers.getId() == null) {%>
            let url = '/customers';
            let method= 'POST';
      <% } else {%>
            let url = '/customers/<%= customers.getId() %>';
              let method= 'PUT';
      <% } %>

fetch(url, {
            method: method,
            body: JSON.stringify(body)
        })
        .then( _ => {
            window.location.href = '/customers';
        }
        );
    }
</script>

</body>
</html>