package curso.java.hibernate;

import curso.java.hibernate.data.EmployeeRepository;
import curso.java.hibernate.data.entity.Employee;
import curso.java.hibernate.data.entity.Scope;
import curso.java.hibernate.data.entity.Task;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@SpringBootApplication
@EnableJpaAuditing
public class HibernateExampleApp implements CommandLineRunner {

  private Logger logger = LoggerFactory.getLogger(this.getClass());

  @Autowired
  EmployeeRepository repository;

  public static void main(String[] args) {
    SpringApplication.run(HibernateExampleApp.class, args);
  }

  @Override
  public void run(String... args) throws Exception {


    Employee emp2 = new Employee();
    emp2.setEmail("new Employee email");
    emp2.setFirstName("Bart");
    emp2.setLastName("Simpson");

    emp2.setTasks(getTasks());


    repository.save(emp2);
    Optional<Employee> emp = repository.findById(2L);
    emp.ifPresent(employee -> logger.info("Employee id 2 -> {}", emp.get()));

    repository.findAll().forEach(System.out::println);
  }

  private Set<Task> getTasks() {

    Set<Task> tasks = new HashSet<>();

    // Crear ámbitos
    Scope scope1 = new Scope();
    scope1.setScopeName("Prioritario");
    scope1.setScopeDescription("Es urgente terminarlo");

    Scope scope2 = new Scope();
    scope2.setScopeName("Secundario");
    scope2.setScopeDescription("No es urgente terminarlo");

    // Crear tarea 1 con su ámbito
    Task task1 = new Task();
    task1.setTaskName("report generation");
    task1.setTaskDescription("Daily report generation");
    task1.setScope(scope1); // Asignar el ámbito creado anteriormente
    tasks.add(task1);

    // Crear tarea 2 con su ámbito
    Task task2 = new Task();
    task2.setTaskName("view generation");
    task2.setTaskDescription("Daily view generation");
    task2.setScope(scope2); // Asignar el ámbito creado anteriormente
    tasks.add(task2);

    return tasks;
  }
}