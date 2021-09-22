<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix = "sql"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Payment Gateway</title>
</head>
<body>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script>
    $(document).on("focusout", "#id1", function(){
              $.ajax({
                 type:"GET",
                 url:"http://localhost:8282/getcust/"+$("#id1").val(),
                 success: function(data) {
                     //Response from the controller comes here
                     var json = JSON.stringify(data);
                     //Bind it to fields like these
                     $("#name1").val(data.c_name);
                     $("#balance1").val(data.balance);
                     $("#od1").val(data.od);
                 }
              })
        })
    </script>
    <form>
        ID : <input type="text" name="id" id ="id1"><br><br>
        Name : <input type="text"  name="name" id = "name1"><br><br>
        Balance : <input type="number" name="balance" id="balance1"><br><br>
        OverDraft : <input type="text" name="od" id="od1"><br><br>
    </form>

</body>
</html>