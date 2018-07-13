<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<c:url value="/css" var="cssUrl" />
<c:url value="/js" var="jsUrl" />

<script src="${jsUrl}/jquery-3.3.1.min.js"></script>
<script src="${jsUrl}/bootstrap.min.js"></script>
<script src="${jsUrl}/stepbystep-form.js"></script>

<link rel="stylesheet" href="${cssUrl}/bootstrap.min.css">
<link rel="stylesheet" href="${cssUrl}/stepbystep-form.css">

<c:if test="${ not empty client }">
	<title>${client.firstname} ${client.lastname}</title>
</c:if>