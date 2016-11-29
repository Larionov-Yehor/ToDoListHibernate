
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>

<head>
    <link rel="stylesheet" href="/resources/css/style.css">
</head>

<body>
<table>

    <tr class="header"  align="middle" valign="middle">
        <td colspan="2" class="taskListHeader"  align="middle" valign="middle">
           Tasklists:
        </td>

        <td>
            <button class="newButton" type="submit" onclick="window.location='/new_tasklist'">+</button>
        </td>
    </tr>

    <c:forEach items="${taskLists}" var="item">
        <tr>
            <td>
                <a href="/tasklist_page?taskListId=${item.getId()}"><h2> ${item.getName()}</h2></a>
            </td>
            <td>
            </td>

            <form action="/deleteList" method="post">
                <td>
                    <button class="deleteButton" type="submit" name="listId" value="${item.getId()}">delete</button>
                </td>
            </form>

        </tr>
    </c:forEach>
    <tr>
        <td>
        </td>
        <td>

        </td>
        <td>

        </td>
    </tr>

</table>
</body>
</html>