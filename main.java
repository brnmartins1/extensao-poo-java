package taskmanager;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        // Criar instâncias do taskmanager e notificationservice
        taskmanager taskManager = new taskmanager();
        notificationservice notificationService = new notificationservice();
        
        // Verificar se há tarefas existentes
        List<task> tasks = taskManager.listTasks();
        if (tasks.isEmpty()) {
            // Exibir mensagem solicitando ao usuário para agendar uma tarefa
            System.out.println("Nenhuma tarefa encontrada.");
            System.out.println("Agende sua tarefa aqui.");
            
            try (// Solicitar dados da nova tarefa ao usuário
			Scanner scanner = new Scanner(System.in)) {
				System.out.print("Digite o título da tarefa: ");
				String title = scanner.nextLine();
				
				System.out.print("Digite a descrição da tarefa: ");
				String description = scanner.nextLine();
				
				System.out.print("Digite a data de vencimento (YYYY-MM-DD): ");
				LocalDate dueDate = LocalDate.parse(scanner.nextLine());
				
				// Criar e adicionar nova tarefa
				task newTask = new task(title, description, dueDate);
				taskManager.addTask(newTask);
			}
            
            System.out.println("Tarefa adicionada com sucesso!");
        } else {
            // Checar tarefas atrasadas e enviar notificações
            List<task> overdueTasks = taskManager.getOverdueTasks();
            for (task task : overdueTasks) {
                notificationService.sendNotification(task);
            }
            
            // Listar todas as tarefas
            System.out.println("Lista de Tarefas:");
            for (task task : taskManager.listTasks()) {
                System.out.println(task);
            }
        }
    }
}
