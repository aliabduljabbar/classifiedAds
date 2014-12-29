<%--
  User: ZSJ
  Date: 12/28/14
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>New post</title>
</head>
<body>

    <form action="CreateAd" method="post">
        <label for="f_title">Title:</label><input id="f_title" type="text" name="title">
        <br>
        <label for="f_quality">Quality:</label><input id="f_quality" type="number" name="quality" min="0" max="10" value="0">/10
        <br>
        <label for="f_price">Amount:</label><input id="f_price" type="number" name="price">
        <br>
        <input type="submit" value="Create">
    </form>

</body>
</html>