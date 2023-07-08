<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
	var generator = 10;
	function doSomething() {
		//document.getElementById("pid").value = generator++;
	}
</script>
</head>
<body>
<h2>${ message }</h2>
<form action="add-product" onsubmit="doSomething()">
Enter name : <input name="name" />  <br />
Enter price : <input name="price" /> <br />
Enter quantity : <input  name="quantity" /> <br />
<input id="pid" name="id" type="hidden" />
<button type="submit">Add Product</button>
</form>
</body>
</html>