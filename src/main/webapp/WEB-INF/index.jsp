<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Sports API</title>
    <link rel="stylesheet" href="/webjars/bootstrap/4.5.0/css/bootstrap.min.css" />
    <script src="/webjars/jquery/3.5.1/jquery.min.js"></script>
    <script src="/webjars/bootstrap/4.5.0/js/bootstrap.min.js"></script>
</head>
<body>
  <div class="container">
  	<div class="jumbotron">
	    <h1>Sports!</h1>  	
  	</div>
  	
  	<div class="row">
  		<div class="col-sm-4">
  			<form:form action="/sport" method="post" modelAttribute="aSport">
  				<div class="form-group">
  					<label>Sport Name:</label>
  					<form:input path="name" class="form-control" />
  					<form:errors path="name" class="text-danger" />
  				</div>
  				<div class="form-group">
  					<label>Number of Required Players:</label>
  					<form:input type="number" path="requiredPlayers" class="form-control" />
  					<form:errors path="requiredPlayers" class="text-danger" />
  				</div>
  				<input type="submit" value="Add Sport" class="btn btn-primary" />
  			</form:form>
  			
  			<hr />
  			
  			<form:form action="/team" method="post" modelAttribute="aTeam">
  				<div class="form-group">
  					<label>Team Name:</label>
  					<form:input path="name" class="form-control" />
  					<form:errors path="name" class="text-danger" />
  				</div>
  				<div class="form-group">
  					<label>Location / City:</label>
  					<form:input path="location" class="form-control" />
  					<form:errors path="location" class="text-danger" />
  				</div>
  				<div class="form-group">
  					<label>Sport:</label>
  					<select name="sport" class="form-control">
  						<c:forEach items="${allSports}" var="sp">
  							<option value="${sp.id}">${sp.name}</option>
  						</c:forEach>
  					</select>
  				</div>
  				<div class="form-group">
  					<label>Team Mascot:</label>
  					<form:input path="mascot" class="form-control" />
  					<form:errors path="mascot" class="text-danger" />
  				</div>
  				<div class="form-group">
  					<label>Team Colors:</label>
  					<form:input type="color" path="colors" class="form-control" />
  					<form:errors path="colors" class="text-danger" />
  				</div>
  				<input type="submit" value="Add Team" class="btn btn-danger" />
  			</form:form>
  		</div>
  		<div class="col-sm-8">
  			<table class="table table-striped">
  				<tr class="bg-dark text-light">
  					<th>Team Name</th>
  					<th>Team Location</th>
  					<th>Sport</th>
  				</tr>
  				<c:forEach items="${allTeams}" var="team">
  					<tr>
  						<td>${team.name}</td>
  						<td>${team.location}</td>
  						<td>${team.sport.name}</td>
  					</tr>
  				</c:forEach>
  			</table>
  		</div>
  	</div>
  </div>
</body>
</html>