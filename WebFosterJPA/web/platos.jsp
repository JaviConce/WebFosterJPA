<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="entities.Producto"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!doctype html>
<html lang="en">

<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.11.2/css/all.css">
    <link rel="stylesheet" href="css/mycss.css">
    <title>Foster Hollywood</title>
</head>

<body>
    <div class="container bg-light">
        <header>
            <img src="img/logo.png" alt="logo" />
        </header>
        <%String categoria = (String)session.getAttribute("categoria"); %>
        <div id="carouselExampleInterval" class="carousel slide" data-ride="carousel">
            <div class="carousel-inner">
                <div class="carousel-item" data-interval="3000">
                    <img src="img/slider1.png" class="d-block w-100" alt="slider1">
                    <div class="carousel-caption d-none d-md-block">
					  <h1 class="text-azul"><%=categoria %></h1>
					</div>
                </div>
                <div class="carousel-item active" data-interval="3000">
                    <img src="img/slider2.png" class="d-block w-100" alt="slider2">
                    <div class="carousel-caption d-none d-md-block">
					  <h1 class="text-azul"><%=categoria %></h1>
					</div>

                </div>
                <div class="carousel-item" data-interval="3000">
                    <img src="img/slider3.png" class="d-block w-100" alt="slider3">
                    <div class="carousel-caption d-none d-md-block">
					  <h1 class="text-azul"><%=categoria %></h1>
					</div>

                </div>
            </div>
            <a class="carousel-control-prev" href="#carouselExampleInterval" role="button" data-slide="prev">
                <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                <span class="sr-only">Previous</span>
              </a>
              <a class="carousel-control-next" href="#carouselExampleInterval" role="button" data-slide="next">
                <span class="carousel-control-next-icon" aria-hidden="true"></span>
                <span class="sr-only">Next</span>
              </a>
        </div>
        <div class="row py-5">
      <%
      
        List<Producto> productos = (List<Producto>)session.getAttribute("productos");
        	for (int i=0;i<productos.size();i++){
        		Producto producto = productos.get(i);
        %>
            <div class="col-lg-4 col-md-6">
            	<a href="Controller?op=detail&i=<%=i%>">
                <div class="card">
                    <img src="<%=producto.getImagen()%>" class="card-img-top" alt="<%=producto.getTitulo()%>">
                    <div class="card-body">
                      <h3 class="card-title text-center"><%=producto.getTitulo()%></h2>
                    </div>
                </div>
                </a>
            </div>
            <%} %>
        </div>
        <p class="pb-5"></p>
        <footer class="fixed-bottom container">
            <h1>Foster Hollywood</h1>
        </footer>
    </div>

    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
    <script src="js/myjs.js"></script>
</body>

</html>