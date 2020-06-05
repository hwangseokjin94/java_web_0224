<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

 <h3>request 에 담긴 DTO</h3>
 	<ul>
 		<li>${DTO.name}</li>
 		<li>${DTO.age}</li>
 		<li>${DTO.phone}</li>
 		<li>${DTO.address}</li>
 		<li>${DTO.gender}</li>
 		<li>${DTO.memo}</li>
 		<li>${DTO.date}</li>
 	</ul>

 <h3>session 에 담긴 DTO</h3>
  	<ul>
 		<li>${SDTO.name}</li>
 		<li>${SDTO.age}</li>
 		<li>${SDTO.phone}</li>
 		<li>${SDTO.address}</li>
 		<li>${SDTO.gender}</li>
 		<li>${SDTO.memo}</li>
 	</ul>
 
 <h3> request   map 에 담긴 DTO</h3>
  	<ul>
 		<li>${MAP.MDTO.name}</li>
 		<li>${MAP.MDTO.age}</li>
 		<li>${MAP.MDTO.phone}</li>
 		<li>${MAP.MDTO.address}</li>
 		<li>${MAP.MDTO.gender}</li>
 		<li>${MAP.MDTO.memo}</li>
 	</ul>
 
</body>
</html>