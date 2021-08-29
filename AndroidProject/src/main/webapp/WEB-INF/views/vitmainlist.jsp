<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
 <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

				 
		<div class = "container">
   		<h3> 추천상품 </h3>
   		
	     <c:if test="${!empty list}">
            <c:forEach var="vo" items="${list}" end="4">
              	  
              		
   				<div class="col-md-2 mr-5" style="height:100%, width:100%; border:1px solid #D6D6D6; overflow:hidden; ">
   					
                    	<c:if test = "${vo.base64 ne null }">
                    		 <img src="data:image/png;base64,${vo.base64}" width="150px" height="150px"> <br/> 
                    		<hr style = "border-color: #D6D6D6"/>
                    		
                    		<div style="white-space : nowrap; overflow : hidden; text-overflow:ellipsis;"> ${vo.name} </div> <br/>  
                    	</c:if>
                		<c:if test = "${vo.base64 eq null }">
                    		no image
                    	</c:if>
                    
                </div>
		  </c:forEach>
        </c:if>
            <c:if test="${empty list}"> 자료가 없습니다 </c:if>
	</div>
</body>
</html>