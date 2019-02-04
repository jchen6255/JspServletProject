<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<jsp:include page="header.jsp"></jsp:include>
	<div class="container">

<table class="table" id="parent-list">
  <thead class="thead-light">
    <tr>
      <th scope="col">Hotel NO</th>
      <th scope="col">Hotel Name</th>
      <th scope="col">Location</th>
      <th scope="col">Check In</th>
      <th scope="col">Check Out</th>
      <th scope="col">Rating</th>
      <th scope="col">Price</th>
    </tr>
  </thead>
  <tbody>
 
<c:forEach items="${list}" var="li">
<tr >
      <td scope="row" id="fno">${li.hotelNum}</td>
      <td>${li.name}</td>
      <td>${li.location}</td>
      <td>${li.checkin}</td>
      <td>${li.checkout}</td>
      <td>${li.rating}</td>
      <td>${li.price}</td>
      <td>
    <form action="bookHotel.jsp">
      <input type="submit" value="Book">
     </form> 
      </td>
    </tr>
</c:forEach>
</tbody>
</table>
<c:if test="${list.size()==0}">
  <h3>No Hotel available</h3>
  
  </c:if>
</div>
</body>
</html>