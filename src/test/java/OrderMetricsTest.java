import com.zhilyuk.entity.Customer;
import com.zhilyuk.entity.Order;
import com.zhilyuk.entity.OrderItem;
import com.zhilyuk.service.TotalIncome;
import com.zhilyuk.service.impl.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static com.zhilyuk.entity.Category.BEAUTY;
import static com.zhilyuk.entity.Category.ELECTRONICS;
import static com.zhilyuk.entity.Category.BOOKS;
import static com.zhilyuk.entity.Category.CLOTHING;
import static com.zhilyuk.entity.Category.TOYS;
import static com.zhilyuk.entity.Category.HOME;
import static com.zhilyuk.entity.OrderStatus.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class OrderMetricsTest {
    private static final List<Order> orders = new ArrayList<>();

    @BeforeAll
    static void setupOrdersDataset() {
        Order order1 = new Order(
                LocalDateTime.of(2026, 4, 26, 23, 52, 52),
                new Customer("Alex", "qwerty@gmail.com", LocalDateTime.of(2024, 12, 31, 23, 59, 30), 21, "Moscow"),
                new ArrayList<>(List.of(
                        new OrderItem("Brush", 1, 14.44, BEAUTY),
                        new OrderItem("Chair", 4, 256.46, HOME)
                )),
                NEW
        );

        Order order2 = new Order(
                LocalDateTime.of(2026, 4, 20, 10, 15, 10),
                new Customer("Nikita", "nikita@mail.by",
                        LocalDateTime.of(1998, 3, 12, 14, 20, 0), 26, "Minsk"),
                new ArrayList<>(List.of(
                        new OrderItem("Laptop", 1, 1200.00, ELECTRONICS),
                        new OrderItem("Mouse", 1, 25.50, ELECTRONICS)
                )),
                PROCESSING
        );

        Order order3 = new Order(
                LocalDateTime.of(2026, 4, 18, 9, 40, 30),
                new Customer("Olga", "olga@tut.by",
                        LocalDateTime.of(1995, 7, 5, 9, 0, 0), 30, "Grodno"),
                new ArrayList<>(List.of(
                        new OrderItem("Dress", 1, 89.99, CLOTHING)
                )),
                DELIVERED
        );

        Order order4 = new Order(
                LocalDateTime.of(2026, 4, 15, 12, 10, 5),
                new Customer("Sergey", "sergey@by.com",
                        LocalDateTime.of(1987, 11, 22, 18, 30, 0), 38, "Brest"),
                new ArrayList<>(List.of(
                        new OrderItem("Table", 1, 150.00, HOME),
                        new OrderItem("Lamp", 2, 40.00, HOME)
                )),
                NEW
        );

        Order order5 = new Order(
                LocalDateTime.of(2026, 4, 10, 16, 55, 45),
                new Customer("Anna", "anna@bel.by",
                        LocalDateTime.of(2000, 2, 14, 8, 10, 0), 24, "Vitebsk"),
                new ArrayList<>(List.of(
                        new OrderItem("Book", 3, 15.99, BOOKS),
                        new OrderItem("Notebook", 2, 3.50, HOME)
                )),
                CANCELLED
        );

        Order order6 = new Order(
                LocalDateTime.of(2026, 4, 8, 11, 22, 33),
                new Customer("Pavel", "pavel@minsk.by",
                        LocalDateTime.of(1992, 6, 1, 12, 0, 0), 33, "Minsk"),
                new ArrayList<>(List.of(
                        new OrderItem("Phone", 1, 999.99, ELECTRONICS),
                        new OrderItem("Headphones", 1, 99.99, ELECTRONICS)
                )),
                DELIVERED
        );

        Order order7 = new Order(
                LocalDateTime.of(2026, 4, 5, 14, 44, 12),
                new Customer("Irina", "irina@by.net",
                        LocalDateTime.of(1989, 9, 9, 10, 0, 0), 36, "Mogilev"),
                new ArrayList<>(List.of(
                        new OrderItem("Shoes", 1, 59.99, CLOTHING)
                )),
                PROCESSING
        );

        Order order8 = new Order(
                LocalDateTime.of(2026, 4, 3, 19, 30, 0),
                new Customer("Dmitry", "dima@belmail.by",
                        LocalDateTime.of(1997, 1, 30, 7, 45, 0), 29, "Gomel"),
                new ArrayList<>(List.of(
                        new OrderItem("Monitor", 1, 300.00, ELECTRONICS)
                )),
                NEW
        );

        Order order9 = new Order(
                LocalDateTime.of(2026, 4, 1, 8, 5, 55),
                new Customer("Tatiana", "tanya@by.org",
                        LocalDateTime.of(1993, 4, 18, 13, 15, 0), 33, "Minsk"),
                new ArrayList<>(List.of(
                        new OrderItem("Pillow", 2, 25.00, HOME),
                        new OrderItem("Blanket", 1, 45.00, HOME)
                )),
                DELIVERED
        );

        orders.add(order1);
        orders.add(order2);
        orders.add(order3);
        orders.add(order4);
        orders.add(order5);
        orders.add(order6);
        orders.add(order7);
        orders.add(order8);
        orders.add(order9);
    }

    @Test
    void shouldReturnCorrectUniqueCities() {
        UniqueCitiesImpl uniqueCitiesImpl = new UniqueCitiesImpl();
        List<String> uniqueCities = uniqueCitiesImpl.uniqueCities(orders);
        assertEquals(7, uniqueCities.size());
        assertTrue(uniqueCities.contains("Grodno"));
    }

    @Test
    void shouldReturnCorrectTotalIncome() {
        TotalIncomeImpl totalIncomeImpl = new TotalIncomeImpl();
        double totalIncome = totalIncomeImpl.totalIncome(orders);
        assertEquals(1284.97, totalIncome);
    }

    @Test
    void shouldReturnCorrectPopularBySalesProduct() {
        PopularBySalesProductImpl popularBySalesProductImpl = new PopularBySalesProductImpl();
        String popularBySalesProduct = popularBySalesProductImpl.popularBySalesProduct(orders);
        assertEquals("Chair",  popularBySalesProduct);
    }

    @Test
    void shouldReturnCorrectAverageCheck() {
        AverageCheckImpl averageCheckImpl = new AverageCheckImpl();
        double averageCheck = averageCheckImpl.averageCheck(orders);
        assertEquals(428.3233333333333,  averageCheck);
    }

    @Test
    void shouldReturnCorrectCustomersMoreFiveOrders() {
        CustomersMoreFiveOrdersImpl customersMoreFiveOrdersImpl = new CustomersMoreFiveOrdersImpl();
        List<Customer> customersMoreFiveOrders = customersMoreFiveOrdersImpl.customersMoreFiveOrders(orders);
        List<Customer> expectedCustomersMoreFiveOrders = new ArrayList<>();
        assertEquals(expectedCustomersMoreFiveOrders, customersMoreFiveOrders);
    }

}
