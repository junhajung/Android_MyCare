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
	        
<h3>판매 상품 등록</h3> 

	<form action="${pageContext.request.contextPath}/insert" method="post" enctype="multipart/form-data"> 
		
			


  	   	<label for="id">상품명 : </label>
   	 	 <input type="text" class="form-control" name="name"  placeholder="상품명" required/> <br/><br/>
   	 	 
		
  	   	<label for="id">비타민b1 : </label>
   	 	 <input type="number" class="form-control" name="vitaminb1" value="0"/> <br/><br/>
   	 	 
  	   	<label for="id">비타민b2 : </label>
   	 	 <input type="number" class="form-control" name="vitaminb2" value="0"/> <br/><br/>

  	 	 
  	   	<label for="id">비타민b3 : </label>
   	 	 <input type="number" class="form-control" name="vitaminb3" value="0" /> <br/><br/>
   	 	 
  	   	<label for="id">비타민b6 : </label>
   	 	 <input type="number" class="form-control" name="vitaminb6" value="0" /> <br/><br/>
   	 	 
  	   	<label for="id">비타민b7 : </label>
   	 	 <input type="number" class="form-control" name="vitaminb7" value="0"/> <br/><br/>
   	 	 
   	 	<label for="id">비타민b9 : </label>
   	 	 <input type="number" class="form-control" name="vitaminb9" value="0"/> <br/><br/>
  
   	 	<label for="id">비타민b12 : </label>
   	 	 <input type="number" class="form-control" name="vitaminb12" value="0"/> <br/><br/>
   	 	 
   	 	<label for="id">비타민C : </label>
   	 	 <input type="number" class="form-control" name="vitaminC" value="0"/> <br/><br/>
   	 	 
   	 	<label for="id">비타민D : </label>
   	 	 <input type="number" class="form-control" name="vitaminD" value="0"/> <br/><br/>
   	 	 
   	 	<label for="id">비타민E : </label>
   	 	 <input type="number" class="form-control" name="vitaminE" value="0"/> <br/><br/>
   	 	  	 	  

    	 <label for="id">마그네슘 : </label>
   	 	 <input type="number" class="form-control" name="magnesium"  value="0"/> <br/><br/>
   	 	 
  	   	<label for="id">셀레늄 : </label>
   	 	 <input type="number" class="form-control" name="selenium" value="0"/> <br/><br/>
   	 	 
   	 	<label for="id">아연 : </label>
   	 	 <input type="text" class="form-control" name="zinc" value="0"/> <br/><br/>
  
   	 	<label for="id">칼슘 : </label>
   	 	 <input type="number" class="form-control" name="calcium" value="0" /> <br/><br/>
   	 	 
   	 	<label for="id">철분 : </label>
   	 	 <input type="number" class="form-control" name="iron" value="0" /> <br/><br/>
   	 	 
   	 	<label for="id">유산균 : </label>
   	 	 <input type="number" class="form-control" name="bacteria"value="0" /> <br/><br/>
   	 	 
   	 	<label for="id">아스타잔틴 : </label>
   	 	 <input type="number" class="form-control" name="astaxanthin" value="0"/> <br/><br/>
   	 	 
   	 	<label for = "id"> 이미지 : </label>
   	 	 <input type="file" name="img1"  style="display: block;" id="files" required/> <br/>
     
        <input type="submit" value="상품등록" class="btn btn-success" value="제출" />
		
	</form>
	

</body>
</html>