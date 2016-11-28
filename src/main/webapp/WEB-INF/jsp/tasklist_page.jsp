<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>

</head>
    <body>

    <table>
             <tr>
                <td>
                    <a href="/home"> <input type="submit" value="back"> </a>
                </td>
                <td>
                 ${taskList.getName()}
                </td>
                <td>
                     <form action="/new_task" method="post">
                        <button type="submit" name="listId" onclick="window.location='/new_task'" value="${taskList.getId()}">+</button>
                     </form>
                </td>
            </tr>
            <tr>
                <td>
                    Have to do:
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
                <td>
                        <label style="color: brown"> ${item.getName()} </label>
                </td>
                <td>
                    <a href="/taskMarker?taskId=${item.getId()}"> <input type="submit" value="mark as done"> </a>
                </td>
            </tr>
            <tr>
                <td>
                    ${item.getDescription()}
                </td>
                <td>
                    <a href="/edit_task?taskId=${item.getId()}"> <input type="submit" value="edit"> </a>
                </td>
                <form action="/taskDelete" method="post">
                    <td>
                        <button class="deleteButton" type="submit" name="taskId" value="${item.getId()}">-</button>
                    </td>
                </form>
            </tr>
        </c:forEach>
        <tr>
            <td>
                <br>
                Completed:
            </td>
            <td>
            </td>
            <td>
            </td>
        </tr>
        <c:forEach items="${done}" var="item">
            <tr>
                <td>
                    <label style="color: greenyellow"> ${item.getName()} </label>
                </td>
                <td>
                    <a href="/taskMarker?taskId=${item.getId()}"> <input type="submit" value="mark as done"> </a>
                </td>
                <td>
                        ${item.getDueDate()}
                </td>
            </tr>
            <tr>
                <td>
                        ${item.getDescription()}
                </td>
                <td>
                    <a href="/edit_task?taskId=${item.getId()}"> <input type="submit" value="edit"> </a>
                </td>
                <form action="/taskDelete" method="post">
                    <td>
                        <button class="deleteButton" type="submit" name="taskId" value="${item.getId()}">-</button>
                    </td>
                </form>
            </tr>
        </c:forEach>

    </table>


    </body>
</html>