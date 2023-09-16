package task3;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

public class TicketProvider {
    private final Database database;
    private final PaymentProvider paymentProvider;

    public TicketProvider(Database database, PaymentProvider paymentProvider) {
        this.database = database;
        this.paymentProvider = paymentProvider;
    }


    /**
     * Получить коллекцию билетов по идентификатору пользователя и дате билета
     * @param clientId Идентификатор клиента
     * @param date Дата билета
     * @return Коллекцию билетов нужного клиента и нужной даты
     * @throws RuntimeException Исключение при обработке операции поиска
     */
    public Collection<Ticket> searchTicket(int clientId, Date date) throws RuntimeException{

        // Предусловие
        if (clientId < 0) {
            throw new RuntimeException("Некорректный id клиента");
        }

        if (date.compareTo(new Date()) <= 0) {
            throw new RuntimeException("Дата билета просрочена");
        }

        // Выполнение основного кода подпрограммы

        Collection<Ticket> tickets = new ArrayList<>();
        for (Ticket ticket : database.getTickets()) {
            if (ticket.getCustomerId() == clientId && ticket.getDate().equals(date)) {
                tickets.add(ticket);
            }
        }
        // Постусловие
        if (tickets.isEmpty()) {
            throw new RuntimeException("Билеты не найдены.");
        }

        return tickets;

    }

    /**
     * Купить билет
     * @param clientId Идентификатор клиента
     * @param cardNo Номер карты
     * @return Результат покупки билета
     * @throws RuntimeException Исключение при обработке покупки билета
     */
    public boolean buyTicket(int clientId, String cardNo) throws RuntimeException{
        int LENGTH_CARD_NO = 16;
        // Предусловие
        if (clientId < 0) {
            throw new RuntimeException("Некорректный id клиента");
        }

        if (cardNo.length() != LENGTH_CARD_NO) {
            throw new RuntimeException("Некорректный номер карты");
        }


        int orderId = database.createTicketOrder(clientId);
        double amount = database.getTicketAmount();

        // Постусловие
        if (!paymentProvider.buyTicket(orderId, cardNo, amount)) {
            throw new RuntimeException("Неполучилось купить билет");
        }
        return paymentProvider.buyTicket(orderId, cardNo, amount);
    }

    /**
     * Проверить билет
     * @param qrcode qr код
     * @return Совпадение qr кода в базе данных
     */
    public boolean checkTicket(String qrcode) {
        int MIN_LENGTH_QRCODE = 6;
        int MAX_LENGTH_QRCODE = 16;
        // Предусловие
        if(qrcode.isEmpty()) {
            throw new RuntimeException("Некорректный qrCode");
        }
        if (qrcode.length() < MIN_LENGTH_QRCODE || qrcode.length() > MAX_LENGTH_QRCODE) {
            throw new RuntimeException("Некорректный qrCode");
        }

        for (Ticket ticket : database.getTickets()) {
            if (ticket.getQrcode().equals(qrcode)) {
                ticket.setEnable(false);
                // Save database ...
                return true;
            }
        }
        return false; // Мы ожидаем, что qrCode может не совпадать с базой данных, поэтому постусловия нет
    }

}