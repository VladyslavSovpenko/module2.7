<!DOCTYPE html>
<html>
<head>
    <title>Special commands</title>
   <jsp:include page="headers.jsp" />
    </head>

<jsp:include page="navigation.jsp" />

<% ua.model.Skills skills = (ua.model.Skills)request.getAttribute("skills"); %>

<div class="container">
    <div class="row">
        <h2>Special commands</h2>
    </div>

        <table class="table">
            <thead>
            <tr>
                <th scope="col">Number of command</th>
                <th scope="col">Description</th>
                <th scope="col">Print</th>

             </tr>
            </thead>
            <tbody>

                <tr>
                    <td>1</td>
                    <td>Devs Salary On Separate Project</td>


                        <td>
                        <div class="row">
                                    <div class="mb-3">
                                        <label for="name" class="form-label"></label>
                                        <input type="text" disabled class="form-control" value=""
                                               id="task1" placeholder="Projects name">
                                    </div>
                        </td>
                        <td>
                                                <div class="btn-toolbar" role="toolbar" aria-label="Toolbar with button groups">
                                                <div class="btn-group me-2" role="group" aria-label="Second group">
                                                  <button onclick="save()" type="button" class="btn btn-primary">Send</button>
                                                </div>
                                                </div>
                                            </td>

                 </tr>

                <tr>
                    <td>2</td>
                    <td>List of developers on Project</td>

                    <td>
                                            <div class="row">
                                                        <div class="mb-3">
                                                            <label for="name" class="form-label"></label>
                                                            <input type="text" disabled class="form-control" value=""
                                                                   id="task2" placeholder="Projects name">
                                                        </div>
                                            </td>
                                            <td>
                                                                    <div class="btn-toolbar" role="toolbar" aria-label="Toolbar with button groups">
                                                                    <div class="btn-group me-2" role="group" aria-label="Second group">
                                                                      <button onclick="save()" type="button" class="btn btn-primary">Send</button>
                                                                    </div>
                                                                    </div>
                                                                </td>
                </tr>
                <tr>
                    <td>3</td>
                    <td>List of Developers with language</td>

<td>
                        <div class="row">
                                    <div class="mb-3">
                                        <label for="name" class="form-label"></label>
                                        <input type="text" disabled class="form-control" value=""
                                               id="task3" placeholder="Language">
                                    </div>
                        </td>
                        <td>
                                                <div class="btn-toolbar" role="toolbar" aria-label="Toolbar with button groups">
                                                <div class="btn-group me-2" role="group" aria-label="Second group">
                                                  <button onclick="save()" type="button" class="btn btn-primary">Send</button>
                                                </div>
                                                </div>
                                            </td>
                </tr>
                <tr>
                    <td>4</td>
                    <td>List of Developers with language level</td>

<td>
                        <div class="row">
                                    <div class="mb-3">
                                        <label for="name" class="form-label"></label>
                                        <input type="text" disabled class="form-control" value=""
                                               id="task4" placeholder="Language level">
                                    </div>
                        </td>
                        <td>
                                                <div class="btn-toolbar" role="toolbar" aria-label="Toolbar with button groups">
                                                <div class="btn-group me-2" role="group" aria-label="Second group">
                                                  <button onclick="save()" type="button" class="btn btn-primary">Send</button>
                                                </div>
                                                </div>
                                            </td>
                </tr>
                <tr>
                    <td>5</td>
                    <td>List of projects</td>
<td>
                        <div class="row">
                                    <div class="mb-3">
                                        <label for="name" class="form-label"></label>
                                        <input type="text" disabled class="form-control" value=""
                                               id="task5" placeholder="Projects name">
                                    </div>
                        </td>

<td>
                                                <div class="btn-toolbar" role="toolbar" aria-label="Toolbar with button groups">
<div class="btn-group me-2" role="group" aria-label="Second group">
<button onclick="save()" type="button" class="btn btn-primary">Send</button>
</div>
</div>
</td>

</tr>


            </tbody>
        </table>
    </div>
</div>

<script>
let task1=document.getElementById('task1');
let task2=document.getElementById('task2');
let task3=document.getElementById('task3');
let task4=document.getElementById('task4');
let task5=document.getElementById('task5');

    function save() {
     let body = {
     language: ta
     skillRate:
     }

      <% if(skills.getId() == null) {%>
            let url = '/special';
            let method= 'POST';
      <% }%>

fetch(url, {
            method: method,
            body: JSON.stringify(body)
        })
        .then( _ => {
            window.location.href = '/special';
        }
        );
    }
</script>



</body>
</html>