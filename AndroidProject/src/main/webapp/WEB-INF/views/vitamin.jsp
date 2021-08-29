<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib  prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
 <table class="table" style="border:1px solid #cccccc">
		        <thead>
		            <tr>
		                <th style="border:1px solid #D6D6D6;">상품정보</th>
			       </tr>
		        </thead>
        
		        <tbody>
		        
		                <c:if test="${!empty list}">
		                 <c:forEach var="vo" items="${list}">
		                  <tr>
		                 
				                <c:if test = "${vo.base64 ne null }">
				                    <td style="border:1px solid #D6D6D6;" width="300px">
				                    	<img src="data:image/png;base64,${vo.base64}" width="100px" height="100px"/>  
				                   			${vo.name}</td>
				                    
				                  </c:if>
				              
				                
				              	<c:if test = "${vo.base64 eq null }">
				              		<td style="border:1px solid #D6D6D6;">
               							no image
               						</td>
      							</c:if>  	     
				                    	     
				            
				                </tr>
		                  
		                </c:forEach>
		            </c:if>
		            <c:if test="${empty list}">
		                <tr>
		                    <td colspan="5">자료가 없습니다.</td>
		                </tr>
		            </c:if>
		        </tbody>
   			 </table>
</body>
</html>