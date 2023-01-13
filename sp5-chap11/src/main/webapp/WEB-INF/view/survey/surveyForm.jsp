<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Survey</title>
</head>
<body>
	<h2>설문조사</h2>
	<form method="post">
		<c:forEach var="q" items="${questions}" varStatus="status">
			<p>
				${status.index+1}.${q.title}<br/>
				<c:if test="${q.choice}">
					<c:forEach var="option" items="${q.options}">
						<label>
							<input type="radio" name="responses[${status.index}]" value="${option}">${option}
						</label>
					</c:forEach>
				</c:if>
				<c:if test="${!q.choice}">
					<input type="text" name="responses[${status.index}]">
				</c:if>
			</p>
		</c:forEach>
		<p>
			<label>
				응답자 위치:<br>
				<input type="text" name="res.location">
			</label><br/>
		</p>
		<p>
			<label>
				응답자 나이:<br>
				<input type="text" name="res.age">
			</label><br/>
		</p>
		<input type="submit" value="전송">
	</form>

</body>
</html>