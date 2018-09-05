package com.evil.mongodb.entity;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.*;

import java.util.List;

/**
 * @author qinhu
 * @date 2018-09-05
 */
@Entity("employees")
@Indexes(
        @Index(value = "salary", fields = @Field("salary"))
)
public class Employee {
        @Id
        private ObjectId id;
        private String name;
        @Reference
        private Employee manager;
        @Reference
        private List<Employee> directReports;
        @Property("wage")
        private Double salary;

        public Employee(String name, Double salary) {
                this.name = name;
                this.salary = salary;
        }

        @Override
        public String toString() {
                return "Employee{" +
                        "id=" + id +
                        ", name='" + name + '\'' +
                        ", manager=" + manager +
                        ", directReports=" + directReports +
                        ", salary=" + salary +
                        '}';
        }
}
