<!DOCTYPE html>
<html lang="en">
<head>

    <title>View user page</title>
      <jsp:include page="headers.jsp" />
</head>
<body>
<jsp:include page="navigation.jsp" />

<% ua.model.Companies companies = (ua.model.Companies)request.getAttribute("companies"); %>


<div class="container">
    <div class="container">
        <div class="btn-toolbar" role="toolbar" aria-label="Toolbar with button groups">
            <div class="btn-group mr-2" role="group" aria-label="First group">
                <a href="/companies" type="button" class="btn btn-success">Back to companies</a>

            </div>
        </div>

        <div class="row">
            <div class="mb-3">
                <label for="name" class="form-label">Companies name</label>
                <input type="text" class="form-control" value="<%=companies.getName()==null ? "" : companies.getName()%>"
                       id="name" placeholder="Name">
            </div>

            <div class="mb-3">
                <label for="number" class="form-label">Number of projects</label>
                <input type="email" class="form-control" value="<%=companies.getNumber()==null ? "" : companies.getNumber()%>"
                       id="number" placeholder="Number">
            </div>

           <div class="mb-3">
           <label for="id" class="form-label">Companies id</label>
           <input type="email" disabled class="form-control" value="<%=companies.getId()==null ? "" : companies.getId()%>"
           id="id" placeholder="Id">
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
 let name=document.getElementById('name');
 let number=document.getElementById('number');
 let id=document.getElementById('id');

    function save() {
     let body = {
     <% if(companies.getId() != null) {%>
                              id: id.value,
                       <% }%>
        name: name.value,
        number: number.value,

      }
      <% if(companies.getId() == null) {%>
            let url = '/companies';
            let method= 'POST';
      <% } else {%>
            let url = '/companies/<%= companies.getId() %>';
              let method= 'PUT';
      <% } %>

fetch(url, {
            method: method,
            body: JSON.stringify(body)
        })
        .then( _ => {
            window.location.href = '/companies';
        }
        );
    }
</script>

</body>
</html>