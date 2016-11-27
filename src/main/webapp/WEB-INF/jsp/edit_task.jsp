<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>

</head>
<body>
<a href="/home"> <input type="submit" value="back"> </a>

<form action="/save_edited_task">


    <input type="hidden" name="task_id" value="${task.getId()}">
    <input type="text" name="task_name" value="${task.getName()}">

    <br>
    <textarea name ="task_description" rows="10" cols="50" >${task.getDescription()}</textarea>
    <br>
    <input type="date" name="task_date" value="${task.getDueDate()}">
    <br>

    <select name="task_list">
        <c:forEach items="${taskLists}" var="item">

            <option value="${item.getId()}"> ${item.getName()} </option>

        </c:forEach>
    </select>
    <br>
    <input type="submit" value="Save">


</form>

</body>
</html>