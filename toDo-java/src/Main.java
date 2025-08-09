import javax.swing.*;
import java.awt.*;

public class Main {
  public static void main(String[] args) {
    SwingUtilities.invokeLater(() -> {
      createAndShowGUI();
    });
    }

  private static void createAndShowGUI() {
    JFrame frame = new JFrame("My toDo");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(800, 600);
    frame.setLayout(new BorderLayout());
    JLabel panel = new JLabel("Welcome to my ToDo", SwingConstants.CENTER);
    frame.add(panel, BorderLayout.CENTER);

    JTextField taskInput = new JTextField();
    JButton addButton = new JButton("Add Task");

    JPanel inputPanel = new JPanel();
    inputPanel.setLayout(new FlowLayout());
    inputPanel.add(taskInput);
    inputPanel.add(addButton);

    frame.add(inputPanel, BorderLayout.SOUTH);

    frame.setVisible(true);
  }
}