package com.c57lee.javafxdatepickercell;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.Stage;
import javafx.util.Callback;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        Group root = new Group();

        TableView employeeTable = new TableView<>();
        employeeTable.setEditable(true);

        TableColumn<Employee,Long> employeeIDTableColumn = new TableColumn<>("ID");
        employeeIDTableColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        employeeIDTableColumn.setEditable(false);

        TableColumn<Employee,String> firstNameColumn = new TableColumn<>("First Name");
        firstNameColumn.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        firstNameColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        firstNameColumn.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Employee, String>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<Employee, String> e) {
                Employee changed = (Employee) e.getTableView().getItems().get(e.getTablePosition().getRow());
                changed.setFirstName(e.getNewValue());
                //controller.updateEmployee(changed);
            }
        });

        TableColumn<Employee,String> lastNameColumn = new TableColumn<>("Last Name");
        lastNameColumn.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        lastNameColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        lastNameColumn.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Employee, String>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<Employee, String> e) {
                Employee changed = (Employee) e.getTableView().getItems().get(e.getTablePosition().getRow());
                changed.setLastName(e.getNewValue());
                //controller.updateEmployee(changed);
            }
        });


        TableColumn<Employee, Date> dobColumn = new TableColumn<>("Date of Birth");
        dobColumn.setCellValueFactory(new PropertyValueFactory<>("dob"));
        dobColumn.setCellFactory(new Callback<TableColumn<Employee, Date>, TableCell<Employee, Date>>() {
            @Override
            public TableCell<Employee, Date> call(TableColumn<Employee, Date> param) {
                return new DatePickerCell<>(param);
            }
        });
        dobColumn.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Employee, Date>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<Employee, Date> e) {
                Employee changed = (Employee) e.getTableView().getItems().get(e.getTablePosition().getRow());
                changed.setDob(e.getNewValue());
                //controller.updateEmployee(changed);
            }
        });

        TableColumn<Employee, Date> startDateColumn = new TableColumn<>("Start Date");
        startDateColumn.setCellValueFactory(new PropertyValueFactory<>("startDate"));
        startDateColumn.setCellFactory(new Callback<TableColumn<Employee, Date>, TableCell<Employee, Date>>() {
            @Override
            public TableCell<Employee, Date> call(TableColumn<Employee, Date> param) {
                return new DatePickerCell<>(param);
            }
        });
        startDateColumn.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Employee, Date>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<Employee, Date> e) {
                Employee changed = (Employee) e.getTableView().getItems().get(e.getTablePosition().getRow());
                changed.setStartDate(e.getNewValue());
                //controller.updateEmployee(changed);
            }
        });

        TableColumn<Employee,Date> endDateColumn = new TableColumn<>("End Date");
        endDateColumn.setCellValueFactory(new PropertyValueFactory<>("endDate"));
        endDateColumn.setCellFactory(new Callback<TableColumn<Employee, Date>, TableCell<Employee, Date>>() {
            @Override
            public TableCell<Employee, Date> call(TableColumn<Employee, Date> param) {
                return new DatePickerCell<>(param);
            }
        });
        endDateColumn.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Employee, Date>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<Employee, Date> e) {
                Employee changed = (Employee) e.getTableView().getItems().get(e.getTablePosition().getRow());
                changed.setEndDate(e.getNewValue());
                //controller.updateEmployee(changed);
            }
        });


        TableColumn<Employee,String> socialSecurityColumn = new TableColumn<>("SSN");
        socialSecurityColumn.setCellValueFactory(new PropertyValueFactory<>("ssn"));

        employeeTable.getColumns().addAll(employeeIDTableColumn,firstNameColumn,lastNameColumn,dobColumn,startDateColumn,endDateColumn,socialSecurityColumn);

        // Mock Data Entries

        Employee employee1 = new Employee();
        employee1.setId(1L);
        employee1.setFirstName("Charles");
        employee1.setLastName("Lee");
        employee1.setDob(Date.valueOf("1988-01-25"));
        employee1.setStartDate(Date.valueOf(LocalDate.now()));
        employee1.setEndDate(null);
        employee1.setSsn("1959294033");
        employeeTable.getItems().add(employee1);


        root.getChildren().add(employeeTable);

        Scene scene = new Scene(root);
        stage.setTitle("DatePickerCell Demo");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

    // Mock object
    public class Employee{
        private Long id;
        private String firstName;
        private String lastName;
        private Date dob;
        private Date startDate;
        private Date endDate;
        private String ssn;

        public Employee(){
            super();
        }

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        public Date getDob() {
            return dob;
        }

        public void setDob(Date dob) {
            this.dob = dob;
        }

        public Date getStartDate() {
            return startDate;
        }

        public void setStartDate(Date startDate) {
            this.startDate = startDate;
        }

        public Date getEndDate() {
            return endDate;
        }

        public void setEndDate(Date endDate) {
            this.endDate = endDate;
        }

        public String getSsn() {
            return ssn;
        }

        public void setSsn(String ssn) {
            this.ssn = ssn;
        }

        
    }
}