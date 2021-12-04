<%-- 
    Document   : home.jsp
    Created on : Dec 3, 2021, 6:06:22 PM
    Author     : ACER
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page isELIgnored="false" %>
<%@include file="include.jsp"  %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    </head>
    <body>
        <h1>Halaman Admin-List KAS Anggota</h1>
        cek DB: ${msg}
        <p>
        <table class="table table-striped table-bordered">
            <tr class="thead-dark">
                <th>ID</th>
                <th>Nik</th>
                <th>Nama</th>
                <th>Alamat</th>
                <th>Pembayaran</th>
                <th>Action</th>
            </tr>
            <c:forEach items="${listAnggota}" var="ang"> 
                <tr>
                    <td>${ang.id}</td>
                    <td>${ang.nik}</td>
                    <td>${ang.nama}</td>
                    <td>${ang.alamat}</td>
                    <td>${ang.pembayaran}</td>
                    <td>
                        <button class="btn btn-primary"
                                onclick="window.location.href='kas-form.html?action=edit&id=${ang.id}'">
                        Edit    
                        </button>
                        <button class="btn btn-danger"
                                onclick="window.location.href='kas-form.html?action=delete&id=${ang.id}'">
                        Delete    
                        </button>
                    </td>
                </tr>
            </c:forEach>
        </table>    
        </p>
        <p>
            <button class="btn btn-primary" onclick="window.location.href='kas-form.html'">
                Add Anggota
            </button>
        </p>
    </body>
</html>
