<%@ page  isELIgnored="false" isErrorPage="true" %>

<h1 style="color:red;text-align">400.jsp(500 Error page)</h1>
<h3 style="color:green;text-align:center">Internal problem(Server Side problem) -- Try Again</h3>

<table bgcolor="yellow" align="center" border="1">

     <tr>
      <td>Status</td>
       <td>${status }</td>
     </tr>
     
       <tr>
      <td>Message</td>
       <td>${message }</td>
     </tr>
       <tr>
      <td>Path</td>
       <td>${path }</td>
     </tr>
       <tr>
      <td>TimeStamp</td>
       <td>${timestamp }</td>
     </tr>
</table>