<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>

</head>
<body>
<input type="submit" value="Add taskList" onclick="window.location='/jsp/new_tasklist.jsp'">

&nbsp&nbsp

<input type="submit"  value="Add task" onclick="window.location='/newTask'">
<br>

Tasklists:

<br>

<c:forEach items="${taskLists}" var="item">

    &nbsp ${item.getName()} &nbsp <a href="/tasklist_page?taskListId=${item.getId()}"> view tasks </a>
    <br>

</c:forEach>


</body>
</html>