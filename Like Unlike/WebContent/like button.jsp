<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
String getData =(String) session.getAttribute("call");
out.print(""+getData);
	if("unlike".equals(getData) && getData!= null) {
		
		%>
		
		<button id="toggle" onclick="myFunction()">UnLike</button>
		
		<%
	} else {
		
%>
		
		<button id="toggle" onclick="myFunction()">Like</button>
		
		<%
	}
	
%>


        <script>

            function myFunction() {
                var change = document.getElementById("toggle");
                if (change.innerHTML == "Like")
                {
                    change.innerHTML = "Unlike";
                    document.location.href="http://localhost:8081/Recommndation_System/LikeUnlikeController?id=111&call=like";
                }
                else {
                    change.innerHTML = "Like";
                    document.location.href="http://localhost:8081/Recommndation_System/LikeUnlikeController?id=11&call=unlike";
                }
            }

        </script>
</body>
</html>