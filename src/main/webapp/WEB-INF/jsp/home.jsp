
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>

<head>
    <link rel="stylesheet" href="/resources/css/style.css">
</head>

<body>
<table  border="0" cellspacing="0" cellpadding="0">

    <tr class="header"  align="middle" valign="middle">
        <td colspan="2"  align="middle" valign="middle">
            <label class="taskListHeader"> Tasklists</label>
        </td>
        <td>
            <button class="newButton" type="submit" onclick="window.location='/new_tasklist'">+</button>
        </td>
    </tr>

    <c:forEach items="${taskLists}" var="item">
        <tr>
            <td>
                <a href="/tasklist_page?taskListId=${item.getId()}">
                    <label class="taskListName"> ${item.getName()}</label></a>
            </td>

            <td>
            </td>
            <form action="/deleteList" method="post">
                <td align="center">
                <button class="deleteListButton" type="submit" name="listId" value="${item.getId()}">-</button>
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