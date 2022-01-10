<!DOCTYPE html>
<html lang="en">
<head>

    <title>View project page</title>
      <jsp:include page="headers.jsp" />
</head>
<body>
<jsp:include page="navigation.jsp" />

<% ua.model.Project project = (ua.model.Project)request.getAttribute("project"); %>


<div class="container">
    <div class="container">
        <div class="btn-toolbar" role="toolbar" aria-label="Toolbar with button groups">
            <div class="btn-group mr-2" role="group" aria-label="First group">
                <a href="/developers" type="button" class="btn btn-success">Back to developers</a>

            </div>
        </div>

        <div class="row">
            <div class="mb-3">
                <label for="name" class="form-label">Project name</label>
                <input type="text" class="form-control" value="<%=project.getName()==null ? "" : project.getName()%>"
                       id="name" placeholder="Name">
            </div>

            <div class="mb-3">
                <label for="salary" class="form-label">Project language</label>
                <input type="email" class="form-control" value="<%=project.getLanguage()==null ? "" : project.getLanguage()%>"
                       id="language" placeholder="Language">
            </div>

            <div class="mb-3">
                <label for="sex" class="form-label">Project cost</label>
                <input type="email" class="form-control" value="<%=project.getCost()==null ? "" : project.getCost()%>"
                       id="cost" placeholder="Cost">
            </div>

            <div class="mb-3">
                <label for="age" class="form-label">Project start date</label>
                <input type="email" disabled class="form-control" value="<%=project.getDate()==null ? "" : project.getDate()%>"
                       id="date" placeholder="Date">
            </div>

            <div class="mb-3">
            <label for="id" class="form-label">Project id</label>
                 <input type="email" disabled class="form-control" value="<%=project.getId()==null ? "" : project.getId()%>"
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
 let language=document.getElementById('language');
 let cost=document.getElementById('cost');
let date=document.getElementById('date');
   let id=document.getElementById('id');

    function save() {
     let body = {
     <% if(project.getId() != null) {%>
                              id: id.value,

                       <% }%>
        name: name.value,
        language: language.value,
        cost: cost.value,



      }
      <% if(project.getId() == null) {%>
            let url = '/projects';
            let method= 'POST';
      <% } else {%>
            let url = '/projects/<%= project.getId() %>';
              let method= 'PUT';
      <% } %>

fetch(url, {
            method: method,
            body: JSON.stringify(body)
        })
        .then( _ => {
            window.location.href = '/projects';
        }
        );
    }
</script>

</body>
</html>