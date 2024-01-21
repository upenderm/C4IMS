<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%
	System.out.println("******In jSP********" + request.getHeader("c4Token"));
%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>C4IMS</title>
<script>
	function clearFormFields() {
		$('registerationForm').each(function() {
			this.reset()
		});
	}
</script>
<script src="${contextPath}/js/jquery-2.1.3.min.js"></script>
<script type="text/javascript" src="${contextPath}/js/login2.js"></script>
<link rel="stylesheet" href="${contextPath}/css/login2.css">
</head>
<body>
	<div class="form">
		<c:if test="${not empty loginError}">
			<ul>
				<li style="color: red"><c:out value="${loginError}" /></li>
			</ul>
		</c:if>
		<ul class="tab-group">
			<li class="tab active" id="signinli"><a href="#login">Sign In</a></li>
			<li class="tab" id="signupli"><a href="#signup">Sign Up</a></li>
		</ul>

		<div class="tab-content">
			<div id="login">
				<h1>Welcome Back!</h1>

				<form action="${contextPath}/login" method="post" autocomplete="off">

					<div class="field-wrap">
						<label> Email Address<span class="req">*</span>
						</label> <input name="userName" type="email" required autocomplete="off" />
					</div>

					<div class="field-wrap">
						<label> Password<span class="req">*</span>
						</label> <input name="password" type="password" required
							autocomplete="off" />
					</div>

					<p class="forgot">
						<a href="#">Forgot Password?</a>
					</p>

					<button class="button button-block">Log In</button>

				</form>

			</div>
			<div id="signup">
				<h1>Sign Up for Free</h1>

				<form action="${contextPath}/registration" name="registerationForm"
					method="post" autocomplete="off" onload="clearFormFields()">

					<div class="top-row">
						<div class="field-wrap">
							<label> First Name<span class="req">*</span>
							</label> <input type="text" name="firstName" required autocomplete="off" />
						</div>

						<div class="field-wrap">
							<label> Last Name<span class="req">*</span>
							</label> <input type="text" name="lastName" required autocomplete="off" />
						</div>
					</div>

					<div class="field-wrap">
						<label> Email Address<span class="req">*</span>
						</label> <input type="email" name="email" required autocomplete="off" />
					</div>

					<div class="field-wrap">
						<label> Mobile<span class="req">*</span>
						</label> <input type="text" name="mobile" required autocomplete="off" />
					</div>

					<div class="field-wrap">
						<label> Set A Password<span class="req">*</span>
						</label> <input type="password" name="password" required
							autocomplete="off" />
					</div>

					<button type="submit" class="button button-block">Get
						Started</button>

				</form>

			</div>
		</div>
		<!-- tab-content -->

	</div>
	<!-- /form -->
	<input type="hidden" id="temp1" value="${loginError}">
</body>
</html>
