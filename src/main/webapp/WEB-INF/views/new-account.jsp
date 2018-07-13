<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<jsp:include page="templates/header.jsp" />
</head>
<body>
	<h2>Effectuer une opération de virement interne :</h2>
	<div class="container">
		<c:choose>
			<c:when test="${ empty result or result.error }">
				<form method="post">
					<c:if test="${ not empty result }">
						<div class="alert alert-danger" role="alert">${ result.content }</div>
					</c:if>
					<div class="form-group">
						<label for="balance">Solde de départ</label>
						<input id="balance" name="balance" class="form-control"
							type="number" step="0.05" min="0" />
					</div>
					<div class="form-group">
						<label for="label">Libellé</label>
						<input id="label" name="label" maxlength="255" class="form-control" />
					</div>
					<div class="form-group">
						<label for="number">Numéro</label>
						<input id="number" name="number" type="number" class="form-control" />
					</div>
					<button class="btn btn-primary btn-lg">Valider</button>
				</form>
			</c:when>
			<c:otherwise>
				<div class="alert alert-success" role="alert">${ result.content }</div>
			</c:otherwise>
		</c:choose>
	</div>
	<jsp:include page="templates/footer.jsp" />
</body>
</html>