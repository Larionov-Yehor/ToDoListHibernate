<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link rel="stylesheet" href="/resources/css/style.css">
</head>
<body>

<table  border="0" cellspacing="0" cellpadding="0">
    <tr class="header" align="middle" valign="middle">
        <td>
            <form action="/home" method="get">
                <button class="backButton" type="submit"><</button>
            </form>
        </td>
        <td>
            <label class="taskListHeader">${taskList.getName()}</label>
        </td>
        <td>
            <form action="/new_task" method="post">
                <button class="newButton" type="submit" name="listId" onclick="window.location='/new_task'" value="${taskList.getId()}">+</button>
            </form>
        </td>
    </tr>
    <%--<tr>
        <td colspan="3">

        </td>
        <td>
        </td>
        <td>
        </td>
    </tr>--%>

    <c:forEach items="${undone}" var="item">
        <tr>
            <td class="taskName" align="middle" valign="middle">
                ${item.getName()}
            </td>
            <td>
            </td>
            <td align="middle" valign="middle">
              ${item.getDueDate()}
            </td>
        </tr>
        <tr>
            <td colspan="3" align="left" valign="middle">
                    ${item.getDescription()}
            </td>
            <td>
            </td>
            <td>
            </td>

        </tr>
        <tr>
            <form action="/taskMarker" method="post">
                <td>
                    <button class="markTaskButton" type="submit" name="taskId" value="${item.getId()}">Done</button>
                </td>
            </form>
            <form action="/edit_task" method="post">
                <td>
                    <button class="editButton" type="submit" name="taskId" value="${item.getId()}">Edit</button>
                </td>
            </form>
            <form action="/taskDelete" method="post">
                <td>
                    <button class="deleteTaskButton" type="submit" name="taskId" value="${item.getId()}">Delete</button>
                </td>
            </form>
        </tr>
    </c:forEach>
<%--
    <tr>
        <td colspan="2">
            <h4>Completed:</h4>
        </td>
        <td>
        </td>
        <td>
        </td>
    </tr>
--%>


    <c:forEach items="${done}" var="item">
        <tr>
            <td class="completedTaskName"  align="middle" valign="middle">
                ${item.getName()}
            </td>
            <td>
            </td>
            <td  align="middle" valign="middle">
                ${item.getDueDate()}
            </td>
        </tr>
        <tr>
            <td colspan="3" align="left" valign="middle">
                    ${item.getDescription()}
            </td>
            <td>
            </td>
            <td>
            </td>

        </tr>
        <tr>
            <form action="/taskMarker" method="post">
                <td>
                    <button class="buttonForCompletedTask" type="submit" name="taskId" value="${item.getId()}">not Done</button>
                </td>
            </form>
            <form action="/edit_task" method="post">
                <td>
                    <button class="buttonForCompletedTask" type="submit" name="taskId" value="${item.getId()}">Edit</button>
                </td>
            </form>
            <form action="/taskDelete" method="post">
                <td>
                    <button class="buttonForCompletedTask" type="submit" name="taskId" value="${item.getId()}">Delete</button>
                </td>
            </form>
        </tr>
    </c:forEach>


</table>


</body>
</html>