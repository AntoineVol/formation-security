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
		<form method="post">
			<div class="form-group">
				<label for="debit">Compte à débiter</label>
				<select id="debit" name="debitId" class="custom-select">
					<jsp:include page="templates/account-options.jsp" />
				</select>
			</div>
			<div class="form-group">
				<label for="credit">Compte à créditer</label>
				<select id="credit" name="creditId" class="custom-select">
					<jsp:include page="templates/account-options.jsp" />
				</select>
			</div>
			<div class="form-group">
				<label for="credit">Montant (€)</label>
				<input type="number" min="0" required />
			</div>
			<button class="btn btn-primary btn-lg">Valider</button>
		</form>
	</div>
	<jsp:include page="templates/footer.jsp" />
</body>
</html>