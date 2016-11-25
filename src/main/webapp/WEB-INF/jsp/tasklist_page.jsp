<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>

</head>
<body>

<a href="/home"> <input type="submit" value="back"> </a>

&nbsp &nbsp

<br>

Tasklist: &nbsp  ${taskList.getName()}
<br>
<br>
Tasks :
<br>
<c:forEach items="${taskListForPage}" var="item">

    &nbsp <label style="color: brown"> ${item.getName()} </label> &nbsp ${item.getDueDate()}

    <a href="/taskDelete?taskId=${item.getId()}"> <input type="submit" value="remove"> </a> &nbsp
    <a href="/marker?taskId=${item.getId()}"> <input type="submit" value="mark as done"> </a>
    <br>
    &nbsp ${item.getDescription()}
    <br>
    <br>

</c:forEach>


<a href="/listRemover?taskListId=${tasklist.getId()}"> <input type="submit" value="Remove list ${tasklist.getName()}"> </a>

</body>
</html>