<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>  
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL fn 라이브러리</title>
</head>
<body>
	<c:set value="No pain. No gain." var="str1" />
	
	<h2>1. 길이 구하기</h2>
	${fn:length(str1)}
	
	<h2>2. 특정 문자열이 포함되어 있는지 확인</h2>
	No가 존재하는가? ${fn:contains(str1, 'No')}<br>
	no가 존재하는가? ${fn:contains(str1, 'no')}<br>
	
	<c:if test="${fn:containsIgnoreCase(str1, 'no')}">
		문장에 no라는 문자열이 존재한다.(대소문자 구별 안함)
	</c:if>
	
	<h2>3. 특정 문자열로 시작하는지 확인</h2>
	No로 시작하는가? ${fn:startsWith(str1, 'No')}
	
	<h2>4. 특정 문자열로 끝나는지 확인</h2>
	n으로 끝나는가? ${fn: endsWith(str1, 'n')}<br>
	.으로 끝나는가? ${fn: endsWith(str1, '.')}<br>
	
	<h2>5. 문자열 치환</h2>
	<c:set var="str2" value="I love chicken." />
	${str2} <br>
	${fn: replace(str2, 'chicken', 'bread')}
	
	<h2>6. 구분자로 잘라서 배열 만들기</h2>
	${fn:split(str1, '.')[0]}<br>
	${fn:split(str1, '.')[1]}
	
	<h2>7. 문자열 추출</h2>
	<%-- I love chicken. --%>
	${fn:substring(str2, 2, 6)}
	
	<h2>8. 모두 소문자로 변경</h2>
	${fn:toLowerCase(str2)}
	
	<h2>9. 모두 대문자로 변경</h2>
	${fn:toUpperCase(str2)}
	
	<h2>10. 앞뒤 여백 제거</h2>
	<c:set var="str3" value="       h  e  ll  o      " />
	<pre>${str3}</pre>
	<pre>${fn:trim (str3)}</pre>
	
</body>
</html>