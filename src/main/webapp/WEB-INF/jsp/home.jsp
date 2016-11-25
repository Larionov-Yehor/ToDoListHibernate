<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>

</head>
<body>
<input type="submit" value="Add taskList" onclick="window.location='/new_tasklist'">&nbsp&nbsp
<input type="submit"  value="Add task" onclick="window.location='/new_task'">

<br>
Tasklists:
<br>
<c:forEach items="${taskLists}" var="item">
&nbsp ${item.getName()}
&nbsp <a href="/tasklist_page?taskListId=${item.getId()}">view tasks</a>


<form action="/deleteList" method="post">
<button type="submit" name = "listId" value="${item.getId()}">delete</button>
<br>
</form>

</c:forEach>

</body>
</html>

<%--

<a href="/deleteList?listId=${item.getId()}?listName=${item.getName()}"> <input type="submit" value="delete" method="post"> </a>--%>
