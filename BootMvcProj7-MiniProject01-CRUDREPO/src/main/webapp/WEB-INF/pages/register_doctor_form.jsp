<%@ page isELIgnored="false"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="frm" %>


<h1 style="color:green;text-align:center">Doctor Registration Page</h1>

<frm:form action="register" modelAttribute="docVo">
      <table align="center" bgcolor="yellow">
       <tr>
         <td>Doctor Name::</td>
         <td><frm:input type="text" path="dname"/></td>
       </tr>
        <tr>
         <td>Specialization::</td>
         <td><frm:input type="text" path="specialization"/></td>
       </tr>
        <tr>
         <td>Fee::</td>
         <td><frm:input type="text" path="fee"/></td>
       </tr>
        <tr>
         <td>Qualification::</td>
         <td><frm:input type="text" path="qlfy"/></td>
       </tr>
       <tr>
       <td><input type="submit" value="Register Doctor"/></td> 
       <td><input type="reset" value="Cancel"/></td> 
       
       </tr>
      </table>
</frm:form>