import java.util.List;

public class Company {
    private String name;
    private Address address;
    private List<Employee> employees;

    public Company(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public void addEmployee(String name, String surname) {
        Person person = new Person(name, surname);
        Employee employee = new Employee(person, null);
        employees.add(employee);
        Utils.printAnswer("Dodano pracownika: " + name + " " + surname);
    }

    public void printEmployees() {
        System.out.println();
        for (int i = 0; i < employees.size(); i++) {
            System.out.println(i + " - " + employees.get(i));
        }

        System.out.println();
    }

    public void removeEmployee(int index) {
        if (invalidIndex(index)) return;

        Employee employee = employees.get(index);
        employees.remove(index);
        Utils.printAnswer("Pomyślnie zwolniono pracownika: %s %s".formatted(employee.getName(), employee.getSurname()));
    }

    public void editEmployee(int index) {
        if (invalidIndex(index)) return;

        Employee employee = employees.get(index);

        System.out.println("Edytujesz dane pracownika: " + employee.getName() + " " + employee.getSurname());

        String oldName = employee.getName();
        String oldSurname = employee.getSurname();

        employee.setName(Utils.inputString("Podaj nowe imię: "));
        employee.setSurname(Utils.inputString("Podaj nowe nazwisko: "));

        Utils.printAnswer("Zmieniono dane pracownika: %s %s na %s %s".formatted(oldName, oldSurname, employee.getName(), employee.getSurname()));
    }

    private boolean invalidIndex(int index) {
        if (index < 0 || index >= employees.size()) {
            Utils.printAnswer("Nie ma pracownika o podanym id");
            return true;
        }
        return false;
    }
}