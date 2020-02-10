<%--
  Created by IntelliJ IDEA.
  User: Malik ibn Zeynab
  Date: 08/02/2020
  Time: 15:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>liste client</title>
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css" href="../css/bootstrap/css/style.css">
<!--===============================================================================================-->
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round">
<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body style="background: #f5f5f5; font-family: 'Varela Round', sans-serif; font-size: 13px;">
	<div class="container">
		<div class="table-wrapper">
			<div class="table-title">
				<div class="row">
					<div class="col-sm-6">
						<h2>
							Gesiton <b>Clients</b>
						</h2>
					</div>
					<div class="col-sm-6">
						<a href="#addEmployeeModal" class="btn btn-success"
							data-toggle="modal"><i class="material-icons">&#xE147;</i> <span>Ajouter un client</span></a>
					</div>
				</div>
			</div>
			<table class="table table-striped table-hover">
				<thead>
					<tr>
						<th class="column1">UserID</th>
						<th>Nom</th>
						<th>Prénom</th>
						<th>Email</th>
						<th>Téléphone</th>
						<th>Mot de passe</th>
						<th>Actions</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<c:forEach var="user" items="${users}">
							<tr>
								<td><c:out value="${user.userId}" /></td>
								<td><c:out value="${user.firstname}" /></td>
								<td><c:out value="${user.lastname}" /></td>
								<td><c:out value="${user.email}" /></td>
								<td><c:out value="${user.phone}" /></td>
								<td><c:out value="${user.password}"/></td>
								<td>
									<a href="add?userId=${user.userId}" class="edit"><i class="material-icons" data-toggle="tooltip" title="Edit">&#xE254;</i></a> 
									<a href="delete?userId=${user.userId}" class="delete" onclick="return confirm('En êtes vous sûr de vouloir supprimé ?')"><i class="material-icons" data-toggle="tooltip" title="Delete">&#xE872;</i></a>
								</td>
							</tr>
						</c:forEach>						
					</tr>

				</tbody>
			</table>
		</div>
	</div>
	<!-- Edit Modal HTML -->
	<div id="addEmployeeModal" class="modal fade">
		<div class="modal-dialog">
			<div class="modal-content">
				<form method="post" action="add">
					<div class="modal-header">
						<h4 class="modal-title">Ajouter un client</h4>
						<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
					</div>
					<div class="modal-body">
						<div class="form-group">
							<label>Nom</label> <input type="text" name="firstname" class="form-control" required>
						</div>
						<div class="form-group">
							<label>Prénom</label> <input type="text" name="lastname" class="form-control" required>
						</div>
						<div class="form-group">
							<label>Email</label> <input type="email" name="email" class="form-control" required>
						</div>
							<div class="form-group">
							<label>Téléphone</label> <input type="text" name="phone" class="form-control" required>
						</div>
							<div class="form-group">
							<label>Mot de passe</label> <input type="text" name="password" class="form-control" required>
						</div>
					</div>
					<div class="modal-footer">
						<input type="button" class="btn btn-default" data-dismiss="modal" value="Annuler"> 
						<input type="submit" class="btn btn-success" value="Ajouter">
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>
