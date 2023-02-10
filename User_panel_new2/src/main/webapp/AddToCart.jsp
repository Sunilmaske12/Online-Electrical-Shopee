<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="com.codeo.shop.entity.Product" %>
    <%@page import="java.sql.*"%>
    <%@page import="java.util.List"%>
    <%@page import="com.codeo.shop.entity.Cart" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add to Cart</title>
</head>
<body>
    <h2>Products in your Cart:</h2>
    <table>
        <tr>
            <th>Product ID</th>
            <th>Product Name</th>
            <th>Price</th>
            <th>Discount</th>
        </tr>
        <%
            Cart cart = (Cart) session.getAttribute("cart");
            List<Product> products = cart.getProducts();
            for (Product product : products) {
        %>
        <tr>
            <td><%= product.getCid() %></td>
            <td><%= product.getProd_name() %></td>
            <td><%= product.getProd_price() %></td>
            <td><%=product.getProd_discount()%></td>
        </tr>
        <%
            }
        %>
    </table>
</body>
</html>
