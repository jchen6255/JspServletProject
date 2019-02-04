<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<body>
<jsp:include page="header.jsp"></jsp:include>
    <h1>Best Hotel Offer</h1>

    <form action="validateHotel" method="get">
        where: <input type="text" name="city" required><br>
        Check-in <input type="date" name="checkIn"><br>
        Check-out <input type="date" name="checkOut"><br>
        room: <input type="number" name="numRoom"><br>
        <input type="submit" value="search">
    </form>
</body>
</html>