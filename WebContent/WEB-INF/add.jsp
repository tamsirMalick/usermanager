<%--
  Created by IntelliJ IDEA.
  User: Malik ibn Zeynab
  Date: 08/02/2020
  Time: 15:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<title>Ajouter un client</title>
<link rel="stylesheet" type="text/css" href="../css/bootstrap/css/accueil.css">
<link rel="stylesheet" type="text/css" href="../css/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="../css/bootstrap/css/font-awesome.min.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round">
<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body style="background: #f5f5f5;">
	<div  class="d-flex justify-content-center">
		<c:choose>
			<c:when test="${empty user.userId}">
				<div class="right-form-agile table-wrapper">
					<!-- content -->
					<div class="sub-main-w3" >
						<h3>Ajouter client</h3>
						<p></p>
						<form action="#" method="post">
							<div class="form-style-agile">
								<label>Nom</label>
								<div class="pom-agile">
									<span class="fa fa-user"></span> <input placeholder="Nom"
										name="firstname" type="text" required>
								</div>
							</div>
							<div class="form-style-agile">
								<label>Prénom</label>
								<div class="pom-agile">
									<span class="fa fa-user"></span> <input placeholder="Prénom"
										name="lastname" type="text" required>
								</div>
							</div>
							<div class="form-style-agile">
								<label>Email</label>
								<div class="pom-agile">
									<span class="fa fa-envelope-open"></span> <input
										placeholder="Email" name="email" type="email" required>
								</div>
							</div>
							<div class="form-style-agile">
								<label>Téléphone</label>
								<div class="pom-agile">
									<span class="fa fa-envelope-open"></span> <input
										placeholder="Téléphone" name="phone" type="text" required>
								</div>
							</div>
							<div class="form-style-agile">
								<label>Password</label>
								<div class="pom-agile">
									<span class="fa fa-key"></span> <input placeholder="Password"
										name="password" type="password" id="password1" required>
								</div>
							</div>
							<input type="submit" value="Ajouter">
						</form>
					</div>
				</div>
			</c:when>
			<c:otherwise>
				<div class="right-form-agile">
					<!-- content -->
					<div class="sub-main-w3">
						<h3>Modifier client</h3>
						<p></p>
						<form action="#" method="post">
							<div class="form-style-agile">
								<label>Nom</label>
								<div class="pom-agile">
									<span class="fa fa-user"></span> <input placeholder="Nom"
										name="firstname" type="text" value="<c:out value="${user.firstname}"/>">
								</div>
							</div>
							<div class="form-style-agile">
								<label>Prénom</label>
								<div class="pom-agile">
									<span class="fa fa-user"></span> <input placeholder="Prénom"
										name="lastname" type="text" value="<c:out value="${user.lastname}"/>">
								</div>
							</div>
							<div class="form-style-agile">
								<label>Email</label>
								<div class="pom-agile">
									<span class="fa fa-envelope-open"></span> <input
										placeholder="Email" name="email" type="email"  value="<c:out value="${user.email}"/>">
								</div>
							</div>
							<div class="form-style-agile">
								<label>Téléphone</label>
								<div class="pom-agile">
									<span class="fa fa-envelope-open"></span> <input
										placeholder="Téléphone" name="phone" type="text" value="<c:out value="${user.phone}"/>">
								</div>
							</div>
							<div class="form-style-agile">
								<label>Password</label>
								<div class="pom-agile">
									<span class="fa fa-key"></span> <input placeholder="Password"
										name="password" type="password" id="password1" value="<c:out value="${user.password}"/>">
								</div>
							</div>
							<input type="submit" value="Modifier">
						</form>
					</div>
				</div>
			</c:otherwise>
		</c:choose>
	</div>
</body>
</html>
