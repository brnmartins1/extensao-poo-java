package taskmanager;

import java.util.ArrayList;
import java.util.List;

public class taskmanager {
    private List<task> tasks;

    // Construtor
    public taskmanager() {
        this.tasks = new ArrayList<>();
    }

    // Adicionar uma nova tarefa
    public void addTask(task task) {
        tasks.add(task);
    }

    // Remover uma tarefa
    public void removeTask(task task) {
        tasks.remove(task);
    }

    // Editar uma tarefa existente
    public void editTask(task oldTask, task newTask) {
        int index = tasks.indexOf(oldTask);
        if (index != -1) {
            tasks.set(index, newTask);
        }
    }

    // Listar todas as tarefas
    public List<task> listTasks() {
        return tasks;
    }

    // Obter tarefas que estão atrasadas
    public List<task> getOverdueTasks() {
        List<task> overdueTasks = new ArrayList<>();
        for (task task : tasks) {
            if (task.isOverdue()) {
                overdueTasks.add(task);
            }
        }
        return overdueTasks;
    }
}
