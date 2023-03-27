<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@page isELIgnored="false"  %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
    <title>ownerdelete</title>
    <style>
         body{
        background-image:linear-gradient(rgba(1,1,1,.7),rgba(1,1,1,.7)),url('<c:url value="/resources/hall.jpg"/>');
        background-repeat:no-repeat;
        background-attachment:fixed; 
        background-size:cover;
        color: aliceblue;
        font-weight: bold;
        }
        h1{
            font-family: 'Times New Roman', Times, serif;
            background-color: rgb(8,35,37);
            height: 60px;
            color: aliceblue;
            text-align: center;
        }
    </style>
</head>
<body>
    <h1><b>SEE YOUR POST</b></h1>
    <div class="alert alert-danger" role="alert">
		<h5 class="text-center">${msg }</h5>
 	</div>
    <div class="col-md-8 offset-md-4">
        <form action="postdeleteown" method="post">
                <table>
                    <tr>
                        <td><label for="contno">ENTER CONTACT NO:</label></td>
                        <td><input name="contno" type="tel" placeholder="enter only numbers"></td>
                    </tr>
                    <tr>
                    	<td><label for="pswd">ENTER YOUR PASSWORD:</label></td>
                    	<td><input type="password" name="pswd" id="pswd" placeholder="Enter Correct Password" required></td>
                    </tr>
                    <tr>
                        <td><input type="hidden" name="utype" value="owner"></td>
                    </tr>
                </table>
                <div class="col-md-7 offset-md-1 mt-5">
                    <a href="owner" class="btn btn-outline-danger">GO BACK</a>
                    <button type="submit" class="btn btn-outline-success">UPLOAD POST</button>   
                </div>
        </form>
    </div>
</body>
</html>