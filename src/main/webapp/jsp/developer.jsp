<!DOCTYPE html>
<html lang="en">
<head>

    <title>View user page</title>
      <jsp:include page="headers.jsp" />
</head>
<body>
<jsp:include page="navigation.jsp" />

<% ua.model.Developer developer = (ua.model.Developer)request.getAttribute("developer"); %>


<div class="container">
    <div class="container">
        <div class="btn-toolbar" role="toolbar" aria-label="Toolbar with button groups">
            <div class="btn-group mr-2" role="group" aria-label="First group">
                <a href="/developers" type="button" class="btn btn-success">Back to developers</a>

            </div>
        </div>

        <div class="row">
            <div class="mb-3">
                <label for="name" class="form-label">Developer name</label>
                <input type="text" class="form-control" value="<%=developer.getName()==null ? "" : developer.getName()%>"
                       id="name" placeholder="Name">
            </div>

            <div class="mb-3">
                <label for="salary" class="form-label">Developer salary</label>
                <input type="email" class="form-control" value="<%=developer.getSalary()==null ? "" : developer.getSalary()%>"
                       id="salary" placeholder="Salary">
            </div>

            <div class="mb-3">
                <label for="sex" class="form-label">Developer sex</label>
                <input type="email" class="form-control" value="<%=developer.getSex()==null ? "" : developer.getSex()%>"
                       id="sex" placeholder="Sex">
            </div>

            <div class="mb-3">
                <label for="age" class="form-label">Developer age</label>
                <input type="email" class="form-control" value="<%=developer.getAge()==null ? "" : developer.getAge()%>"
                       id="age" placeholder="Age">
            </div>

            <div class="mb-3">
            <label for="id" class="form-label">Developer id</label>
                 <input type="email" disabled class="form-control" value="<%=developer.getId()==null ? "" : developer.getId()%>"
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
 let salary=document.getElementById('salary');
 let sex=document.getElementById('sex');
let age=document.getElementById('age');
   let id=document.getElementById('id');

    function save() {
     let body = {
     <% if(developer.getId() != null) {%>
                              id: id.value,
                       <% }%>
        name: name.value,
        salary: salary.value,
        sex: sex.value,
        age: age.value,

      }
      <% if(developer.getId() == null) {%>
            let url = '/developers';
            let method= 'POST';
      <% } else {%>
            let url = '/developers/<%= developer.getId() %>';
              let method= 'PUT';
      <% } %>

fetch(url, {
            method: method,
            body: JSON.stringify(body)
        })
        .then( _ => {
            window.location.href = '/developers';
        }
        );
    }
</script>

</body>
</html>