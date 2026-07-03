 <%@ page isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>

<h1 style="color:green;text-align:center">Show Report Page</h1>

<c:choose>
   <c:when test="${!empty doctorlist }">
   <table bgcolor="cyan" align="center" border="1">
     <tr>
         <th>DoctorId</th><th>DoctorName</th><th>Specialization</th><th>Fee</th><th>Qualification</th><th>Operation</th>
     </tr>
     <c:forEach var="doc" items="${doctorlist}">
        <tr>
            <td>${doc.did}</td>
            <td>${doc.dname}</td>
           <td>${doc.specialization}</td>
           <td>${doc.fee}</td>
            <td>${doc.qlfy}</td>
            <td><a href="edit?no=${doc.did }"><img src="images/edit.png" width="30px" height="30px"></a>&nbsp;&nbsp;
                   <a href="delete?no=${doc.did }" onclick=" return confirm('Do you really want to Delete ??')"><img src="images/delete.png" width="30px" height="30px"></a>
                      
            </td>
        </tr>
     </c:forEach>
   
   </table>
   </c:when>
   <c:otherwise>
       <h1 style="color:red;text-align:center">No Doctors Are Found</h1>
   </c:otherwise>
</c:choose>
<h1 style="color:red;text-align:center"><a href="register">Add Doctor<img src="images/add.jfif"></a></h1>
<br><br>
<h1 style="color:green;text-align:center">${resultMsg}</h1>
<br><br>
<h1 style="color:red;text-align:center"><a href="./">Home<img src="images/home.jfif"></a></h1>
