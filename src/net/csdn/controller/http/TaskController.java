package net.csdn.controller.http;

import com.google.inject.Inject;
import net.csdn.annotation.rest.At;
import net.csdn.document.Task;
import net.csdn.modules.http.ApplicationController;
import net.csdn.modules.http.support.HttpStatus;
import net.csdn.service.task.TaskService;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import static net.csdn.filter.FilterHelper.BeforeFilter.only;
import static net.csdn.modules.http.RestRequest.Method.*;

/**
 * 6/8/13 WilliamZhu(allwefantasy@gmail.com)
 */
public class TaskController extends ApplicationController {


    static {
        beforeFilter("nameValidate", map(
                only, list("cancelTask", "removeTask")
        ));

        beforeFilter("taskCreateValidate", map(
                only, list("createTask")
        ));
    }

    @At(path = "/tasks/list", types = GET)
    public void list() {
        render(Task.findAll());
    }

    private Task task;

    @At(path = "/tasks/create", types = POST)
    public void createTask() {
        taskService.createTask(task);
        render(OK);
    }

    @At(path = "/tasks/cancel", types = PUT)
    public void cancelTask() {
        taskService.cancelTask(param("name"));
        render(OK);
    }

    @At(path = "/tasks/remove", types = {DELETE, PUT})
    public void removeTask() {
        taskService.removeTask(param("name"));
        render(OK);
    }

    private void nameValidate() {
        if (isEmpty(param("name"))) render(HttpStatus.HttpStatusBadRequest,
                map("ok", false, "message", "name should not be empty")
        );
    }

    private void taskCreateValidate() {
        task = Task.create(params());
        if (!task.valid()) render(HttpStatus.HttpStatusBadRequest,
                map("ok", false, "message", JSONArray.fromObject(task.validateResults).toArray())
        );
    }

    @Inject
    private TaskService taskService;
    private static String OK = JSONObject.fromObject(map("ok", true, "message", "")).toString();
}
