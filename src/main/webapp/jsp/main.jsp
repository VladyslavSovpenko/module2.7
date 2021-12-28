<!DOCTYPE html>
<%! int day = 3; %>
<%! int fontSize; %>
<html>
<head>
<title>Main page</title>
<jsp:include page="headers.jsp" /></head>
<body>
<jsp:include page="navigation.jsp" />

<div style="text-align: right"><a href="<%=request.getContextPath()%>/logout">Logout</a></div>


<p>Today's date: <%= (new java.util.Date()).toLocaleString()%></p>

<jsp:text>
               Welcome to JSP Programming
            </jsp:text>
<p>
             <% if (day == 1 || day == 7) { %>
                     <p> Today is weekend</p>
                  <% } else { %>
                     <p> Today is not weekend</p>
                  <% } %>

                        <%
                           switch(day) {
                              case 0:
                                 out.println("It\'s Sunday.");
                                 break;
                              case 1:
                                 out.println("It\'s Monday.");
                                 break;
                              case 2:
                                 out.println("It\'s Tuesday.");
                                 break;
                              case 3:
                                 out.println("It\'s Wednesday.");
                                 break;
                              case 4:
                                 out.println("It\'s Thursday.");
                                 break;
                              case 5:
                                 out.println("It\'s Friday.");
                                 break;
                              default:
                                 out.println("It's Saturday.");
                           }
                        %>
<p>
<span>Hello <%=session.getAttribute("user")%></span>
                          <%for ( fontSize = 1; fontSize <= 3; fontSize++){ %>
                                 <font color = "green" size = "<%= fontSize *3%>">
                                    JSP Tutorial
                              </font><br />
                              <%}%>



</body>
</html>