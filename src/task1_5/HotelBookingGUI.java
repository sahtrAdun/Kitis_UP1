package task1_5;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class Hotel {
    private String name;
    private int roomsAvailable;
    private double pricePerNight;

    public Hotel(String name, int roomsAvailable, double pricePerNight) {
        this.name = name;
        this.roomsAvailable = roomsAvailable;
        this.pricePerNight = pricePerNight;
    }

    public String getName() { return name; }
    public int getRoomsAvailable() { return roomsAvailable; }
    public double getPricePerNight() { return pricePerNight; }

    public boolean bookRoom() {
        if (roomsAvailable > 0) {
            roomsAvailable--;
            return true;
        }
        return false;
    }
}

class BookingSystem {
    private java.util.List<Hotel> hotels;

    public BookingSystem() {
        hotels = new java.util.ArrayList<>();
        hotels.add(new Hotel("Гранд Отель", 5, 5000.0));
        hotels.add(new Hotel("Эконом Отель", 10, 1500.0));
        hotels.add(new Hotel("Бизнес Отель", 3, 8000.0));
    }

    public java.util.List<Hotel> getHotels() { return hotels; }

    public String bookHotel(String hotelName, String guestName) {
        for (Hotel hotel : hotels) {
            if (hotel.getName().equals(hotelName)) {
                if (hotel.bookRoom()) {
                    return "Бронь подтверждена для " + guestName + " в отеле " + hotelName;
                } else {
                    return "Извините, в отеле " + hotelName + " нет свободных номеров";
                }
            }
        }
        return "Отель не найден";
    }
}

public class HotelBookingGUI {
    private JFrame frame;
    private JComboBox<String> hotelComboBox;
    private JTextField nameField;
    private JTextArea resultArea;
    private BookingSystem bookingSystem;

    public HotelBookingGUI() {
        bookingSystem = new BookingSystem();
        initialize();
    }

    private void initialize() {
        frame = new JFrame("Система бронирования отелей");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 400);
        frame.setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel(new GridLayout(3, 2, 10, 10));

        inputPanel.add(new JLabel("Выберите отель:"));
        hotelComboBox = new JComboBox<>();
        for (Hotel hotel : bookingSystem.getHotels()) {
            hotelComboBox.addItem(hotel.getName() + " (" + hotel.getPricePerNight() + " руб./ночь)");
        }
        inputPanel.add(hotelComboBox);

        inputPanel.add(new JLabel("Ваше имя:"));
        nameField = new JTextField();
        inputPanel.add(nameField);

        JButton bookButton = new JButton("Забронировать");
        bookButton.setBackground(Color.GREEN);
        bookButton.addActionListener(new BookButtonListener());

        JButton exitButton = new JButton("Выход");
        exitButton.setBackground(Color.RED);
        exitButton.addActionListener(e -> System.exit(0));

        JPanel buttonPanel = new JPanel(new FlowLayout());
        buttonPanel.add(bookButton);
        buttonPanel.add(exitButton);

        resultArea = new JTextArea();
        resultArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(resultArea);

        frame.add(inputPanel, BorderLayout.NORTH);
        frame.add(buttonPanel, BorderLayout.CENTER);
        frame.add(scrollPane, BorderLayout.SOUTH);

        frame.setVisible(true);
    }

    private class BookButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String selectedHotel = (String) hotelComboBox.getSelectedItem();
            String hotelName = selectedHotel.split(" ")[0];
            String guestName = nameField.getText().trim();

            if (guestName.isEmpty()) {
                resultArea.setText("Пожалуйста, введите ваше имя");
                return;
            }

            String result = bookingSystem.bookHotel(hotelName, guestName);
            resultArea.setText(result);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new HotelBookingGUI());
    }
}