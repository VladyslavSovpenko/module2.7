<!DOCTYPE html>
<html lang="en">
<head>

    <title>View user page</title>
      <jsp:include page="headers.jsp" />
</head>
<body>
<jsp:include page="navigation.jsp" />

<% ua.model.Skills skills = (ua.model.Skills)request.getAttribute("skills"); %>


<div class="container">
    <div class="container">
        <div class="btn-toolbar" role="toolbar" aria-label="Toolbar with button groups">
            <div class="btn-group mr-2" role="group" aria-label="First group">
                <a href="/skills" type="button" class="btn btn-success">Back to skills</a>

            </div>
        </div>

        <div class="row">
            <div class="mb-3">
                <label for="name" class="form-label">Id</label>
                <input type="text" disabled class="form-control" value="<%=skills.getId()==null ? "" : skills.getId()%>"
                       id="id" placeholder="id">
            </div>

            <div class="mb-3">
                <label for="number" class="form-label">Language</label>
                <input type="email" class="form-control" value="<%=skills.getLanguage()==null ? "" : skills.getLanguage()%>"
                       id="language" placeholder="language">
            </div>

           <div class="mb-3">
           <label for="id" class="form-label">Skill Rate</label>
           <input type="email"  class="form-control" value="<%=skills.getSkillRate()==null ? "" : skills.getSkillRate()%>"
           id="skillRate" placeholder="skillRate">
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
 let language=document.getElementById('language');
 let skillRate=document.getElementById('skillRate');
 let id=document.getElementById('id');

    function save() {
     let body = {
     <% if(skills.getId() != null) {%>
                              id: id.value,
                       <% }%>
        language: language.value,
        skillRate: skillRate.value,

      }
      <% if(skills.getId() == null) {%>
            let url = '/skills';
            let method= 'POST';
      <% } else {%>
            let url = '/skills/<%= skills.getId() %>';
              let method= 'PUT';
      <% } %>

fetch(url, {
            method: method,
            body: JSON.stringify(body)
        })
        .then( _ => {
            window.location.href = '/skills';
        }
        );
    }
</script>

</body>
</html>