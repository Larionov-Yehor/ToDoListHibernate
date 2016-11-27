<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>

<head>
    <link rel="stylesheet" href="/resources/css/style.css">
</head>

    <body>
    <table>

        <tr class="headerLists">
            <td>
                <h1> Tasklists:</h1>
            </td>
            <td>
            </td>
            <td>
                <button class="newListButton" type="submit" onclick="window.location='/new_tasklist'">+</button>
            </td>
        </tr>

        <c:forEach items="${taskLists}" var="item">
             <tr>
                    <td>
                        <a href="/tasklist_page?taskListId=${item.getId()}">  <h2> ${item.getName()}</h2></a>
                    </td>
                    <td>
                        <%--<a href="/tasklist_page?taskListId=${item.getId()}">  <h2> ${item.getName()}</h2></a>--%>
                    </td>

                        <form action="/deleteList" method="post">
                             <td>
                            <button class="deleteButton" type="submit" name="listId" value="${item.getId()}">-</button>
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