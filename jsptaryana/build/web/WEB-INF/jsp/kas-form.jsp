<%-- 
    Document   : kas-form
    Created on : Nov 23, 2021, 9:53:42 AM
    Author     : acer
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div class="contaner"
            <h2>Data Anggota ${message}</h2>
            <div class="row">
                <div class="col-md-6">
                    <form action="kas-form.html" modelAttribute="ang" method="POST"
                        <div class="form-group">
                            <input type="text" class="form-control" name="nik" placeholder="Nik" value="${ang.nik}"/>
                        </div> 
                        <div class="form-group">
                            <input type="text" class="form-control" name="nama" placeholder="Nama" value="${ang.nama}"/>
                        </div>
                        <div class="form-group">
                            <input type="text" class="form-control" name="alamat" placeholder="Alamat" value="${ang.alamat}"/>
                        </div>
                        <div class="form-group">
                            <input type="text" class="form-control" name="pembayaran" placeholder="Pembayaran" value="${ang.pembayaran}"/>
                        </div>
                        <input type="hidden" name="id" value="${ang.id!=null?ang.id:0}"/>
                        <button type="submit" class="btn btn-primary">Save</button>
                    </form>
                </div>        
            </div>
            <a href="${pageContext.request.contextPath}/home.html"/>Back</a>
        </div>
    </body>
</html>
