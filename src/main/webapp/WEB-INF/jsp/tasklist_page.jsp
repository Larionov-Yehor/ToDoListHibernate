<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link rel="stylesheet" href="/resources/css/style.css">
</head>
    <body>

    <table>
             <tr class="header">
                <td>
                    <form action="/home" method="get">
                        <button class="backButton" type="submit"><</button>
                    </form>
                </td>
                <td>
                    <h1>${taskList.getName()}</h1>
                </td>
                <td>
                     <form action="/new_task" method="post">
                        <button class="newButton" type="submit" name="listId" onclick="window.location='/new_task'" value="${taskList.getId()}">+</button>
                     </form>
                </td>
            </tr>
            <tr>
                <td colspan="3">
                    <h3>Have to do:</h3>
                </td>
                <td>
                </td>
                <td>
                </td>
            </tr>

        <c:forEach items="${undone}" var="item">
            <tr>
                <td>
                        ${item.getDueDate()}
                </td>
                <td colspan="2">
                        <label> ${item.getName()} </label>
                </td>
                <td>

                </td>
            </tr>
            <tr>
                <td colspan="3">
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
        <tr>
            <td colspan="2">
                <h4>Completed:</h4>
            </td>
            <td>
            </td>
            <td>
            </td>
        </tr>


        <c:forEach items="${done}" var="item">
            <tr>
                <td>
                        ${item.getDueDate()}
                </td>
                <td colspan="2">
                    <label> ${item.getName()} </label>
                </td>
                <td>

                </td>
            </tr>
            <tr>
                <td colspan="3">
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