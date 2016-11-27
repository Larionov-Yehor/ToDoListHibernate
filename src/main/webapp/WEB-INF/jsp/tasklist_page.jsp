<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>

</head>
    <body>

    <a href="/home"> <input type="submit" value="back"> </a>

    <br>

    Tasklist: &nbsp ${taskList.getName()}
    <br>

    <form action="/new_task" method="post">
        <button type="submit" name="listId" onclick="window.location='/new_task'" value="${taskList.getId()}">+</button>
    </form>
    <br>
        Tasks to do:
    <br>
    <c:forEach items="${undone}" var="item">

        &nbsp
        <label style="color: brown"> ${item.getName()} </label> &nbsp ${item.getDueDate()}

        <a href="/taskDelete?taskId=${item.getId()}"> <input type="submit" value="remove"> </a> &nbsp
        <a href="/taskMarker?taskId=${item.getId()}"> <input type="submit" value="mark as done"> </a>
        <a href="/edit_task?taskId=${item.getId()}"> <input type="submit" value="edit"> </a>
        <br>
        &nbsp ${item.getDescription()}
        <br>

    </c:forEach>

    <br>
    <br>
        Completed tasks:
    <br>
    <c:forEach items="${done}" var="item">

        &nbsp <label style="color: green"> ${item.getName()} </label> &nbsp ${item.getDueDate()}

        <a href="/taskDelete?taskId=${item.getId()}"> <input type="submit" value="remove"> </a> &nbsp
        <a href="/taskMarker?taskId=${item.getId()}"> <input type="submit" value="mark as done"> </a>
        <br>
        &nbsp ${item.getDescription()}
        <br>
        <br>

    </c:forEach>


    </body>
</html>