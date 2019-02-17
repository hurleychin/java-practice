package com.evil.mongodb;

import com.evil.mongodb.entity.Employee;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.ServerAddress;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;
import org.mongodb.morphia.query.Query;

import java.util.List;

/**
 * @author qinhu
 * @date 2018-09-05
 * http://mongodb.github.io/morphia/1.3/getting-started/quick-tour/#saving-data
 */
public class MorphiaDemo {
    public static void main(String[] args) {
        final Morphia morphia = new Morphia();

        // tell Morphia where to find your classes
        // can be called multiple times with different packages or classes
        morphia.mapPackage("com.evil.mongodb");

        // create the Datastore connecting to the default port on the local host
        final Datastore datastore = morphia.createDatastore(new MongoClient("192.168.0.102",27017), "testdb");
        datastore.ensureIndexes();
        final Employee elmer = new Employee("Elmer Fudd", 50000.0);
        datastore.save(elmer);

        final Query<Employee> query = datastore.createQuery(Employee.class);
        final List<Employee> employees = query.asList();

        System.out.println(employees);
    }
}
