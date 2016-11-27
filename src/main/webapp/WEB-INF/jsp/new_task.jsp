<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>

</head>
<body>
<a href="/home"> <input type="submit" value="back"> </a>

<form action="/add_new_task">
    <input type="hidden" name="listId" value="${taskList.getId()}">
    <input type="text" name="task_name" placeholder="enter title" required>
    <br>
    <textarea name ="task_description" rows="10" cols="50"></textarea>
    <br>
    <input type="date" name="task_date" placeholder="enter date" required>
    <br>


    <%--<select name="task_list">
        <c:forEach items="${taskLists}" var="item">

            <option value="${item.getId()}"> ${item.getName()} </option>

        </c:forEach>
    </select>--%>

    <input type="submit" value="Add Task">
    <br>


</form>

</body>
</html>