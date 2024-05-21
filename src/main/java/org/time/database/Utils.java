package org.time.database;
import org.time.model.Customer;

import java.util.ArrayList;
import java.util.List;

public class Utils {

    private static final List<Customer> Customer = new ArrayList<>();

    static {
        initData();
    }

    // Mô phỏng dữ liệu trong Database.
    private static void initData() {

        Customer customer = new Customer("Mai van hoan", "20/08/1983", "Ha Noi", "Google.com");
        Customer customer2 = new Customer("Nguyen Van Nam", "21/08/1983", "Bac Giang", "Google.com");
        Customer customer3 = new Customer("Tran Thai Hoa", "22/08/1983", "Nam Dinh", "Google.com");
        Customer customer4 = new Customer("Tran Dang Khoa", "17/08/1983", "Ha Tay", "Google.com");
        Customer customer5 = new Customer("Tran Dinh Thi", "19/08/1983", "Ha Noi", "Google.com");

        Customer.add(customer);
        Customer.add(customer2);
        Customer.add(customer3);
        Customer.add(customer4);
        Customer.add(customer5);
    }

    // Truy vấn bảng Department.
    public static List<Customer> queryCustomer() {
        return Customer;
    }

}
