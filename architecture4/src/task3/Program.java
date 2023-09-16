package task3;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

public class Program {

    /**
     * Разработать контракты и компоненты системы "Покупка онлайн билетов на автобус в час пик"
     * <p>
     * 1. Предусловия.
     * 2. Постусловия.
     * 3. Инвариант.
     * 4. Определить абстрактные и конкретные классы.
     * 5. Определить интерфейсы.
     * 6. Реализовать наследование.
     * 7. Выявить компоненты.
     * 8. Разработать Диаграмму компонент используя нотацию UML 2.0. Общая без деталей.
     */

    public static void main(String[] args) {


        Core core = new Core();
        MobileApp mobileApp = new MobileApp(core.getTicketProvider(), core.getCustomerProvider());
        BusStation busStation = new BusStation(core.getTicketProvider());

        if (mobileApp.buyTicket("11000000221")) {
            System.out.println("Клиент успешно купил билет.");
            mobileApp.searchTicket(new Date());
            Collection<Ticket> tickets = mobileApp.getTickets();
            if (busStation.checkTicket(tickets.stream().findFirst().get().getQrcode())) {
                System.out.println("Клиент успешно прошёл в автобус. ");
            }
        }
    }
}

class Core {

    private final CustomerProvider customerProvider;
    private final TicketProvider ticketProvider;
    private final PaymentProvider paymentProvider;
    private final Database database;

    public Core() {
        database = new Database();
        customerProvider = new CustomerProvider(database);
        paymentProvider = new PaymentProvider();
        ticketProvider = new TicketProvider(database, paymentProvider);
    }

    public TicketProvider getTicketProvider() {
        return ticketProvider;
    }

    public CustomerProvider getCustomerProvider() {
        return customerProvider;
    }
}

/**
 * Покупатель
 */
class Customer {

    private static int counter = 0;

    private final int id;

    private Collection<Ticket> tickets;

    {
        id = ++counter;
    }

    public Customer() {
    }

    public Customer(Collection<Ticket> tickets) {
        this.tickets = tickets;
    }

    public int getId() {
        return id;
    }

    public Collection<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(Collection<Ticket> tickets) {
        this.tickets = tickets;
    }
}

/**
 * Билет
 */
class Ticket {

    private static int counter = 0;

    private int id;
    private int customerId;
    private Date date;
    private String qrcode;
    private boolean enable = true;

    {
        id = ++counter;
    }


    public Ticket() {
    }


    public Ticket(int customerId, String qrcode) {
        this.customerId = customerId;
        this.qrcode = qrcode;
    }

    public Ticket(int customerId, Date date, String qrcode) {
        this.customerId = customerId;
        this.date = date;
        this.qrcode = qrcode;
    }

    public Ticket(Date date, String qrcode) {
        this.date = date;
        this.qrcode = qrcode;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }

    public int getId() {
        return id;
    }

    public int getCustomerId() {
        return customerId;
    }

    public Date getDate() {
        return date;
    }

    public String getQrcode() {
        return qrcode;
    }

    public boolean isEnable() {
        return enable;
    }
}


/**
 * База данных
 */
class Database {

    private static int counter;
    private Collection<Ticket> tickets = new ArrayList<>();
    private Collection<Customer> customers = new ArrayList<>();

    public Database() {
        for (int i = 0; i < 10; i++) {
            String qrcode = "qrcode" + Integer.toString(i);
            Ticket ticket = new Ticket(0, new Date(), qrcode);
            tickets.add(ticket);
        }
        customers.add(new Customer(tickets));
    }


    public Collection<Ticket> getTickets() {
        return tickets;
    }

    public Collection<Customer> getCustomers() {
        return customers;
    }

    /**
     * Получить актуальную стоимость билета
     *
     * @return
     */
    public double getTicketAmount() {
        return 45;
    }

    /**
     * Получить идентификатор заявки на покупку билета
     *
     * @param clientId
     * @return
     */
    public int createTicketOrder(int clientId) {
        return ++counter;
    }
}


class PaymentProvider {

    public PaymentProvider() {
    }

    public boolean buyTicket(int orderId, String cardNo, double amount) {
        //TODO: Обращение к платёжному шлюзу, попытка выполнить списание средств ...
        return true;
    }
}


class CustomerProvider {
    private Database database;

    public CustomerProvider(Database database) {
        this.database = database;
    }

    public Customer getCustomer(String login, String password) {
        return new Customer();
    }

}

/**
 * Автобусная станция
 */
