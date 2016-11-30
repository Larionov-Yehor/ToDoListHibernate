function deleteTaskList(id) {
    $.ajax({
        async: false,
        type: "DELETE",
        url: "/taskList/"+id
    })
}

