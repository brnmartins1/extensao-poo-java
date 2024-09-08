package taskmanager;
import java.time.LocalDate;

public class task {
    private String title;
    private String description;
    private LocalDate dueDate;
    private boolean isCompleted;

    // Construtor
    public task(String title, String description, LocalDate dueDate) {
        this.title = title;
        this.description = description;
        this.dueDate = dueDate;
        this.isCompleted = false;
    }

    // Getters e Setters
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void setCompleted(boolean completed) {
        isCompleted = completed;
    }

    // Método para verificar se a tarefa está atrasada
    public boolean isOverdue() {
        return LocalDate.now().isAfter(dueDate) && !isCompleted;
    }
    
    @Override
    public String toString() {
        return "task{" +
               "title='" + title + '\'' +
               ", description='" + description + '\'' +
               ", dueDate=" + dueDate +
               ", isCompleted=" + isCompleted +
               '}';
    }
}
