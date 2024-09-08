package taskmanager;
public class notificationservice {
    // Enviar notificação para uma tarefa atrasada
    public void sendNotification(task task) {
        if (task.isOverdue()) {
            System.out.println("ALERTA: A tarefa '" + task.getTitle() + "' está atrasada!");
        }
    }
}
