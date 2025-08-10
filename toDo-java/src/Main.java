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

    JTextField taskInput = new JTextField("New task", 20);
    JButton addButton = new JButton("Add Task");
    JButton deleteButton = new JButton("Delete Task");

    //Design buttons

    Font font = new Font ("SansSerif", Font.BOLD, 20);
    taskInput.setFont(font);
    addButton.setFont(font);
    deleteButton.setFont(font);

    JPanel inputPanel = new JPanel();
    inputPanel.setLayout(new FlowLayout());
    inputPanel.add(taskInput);
    inputPanel.add(addButton);
    inputPanel.add(deleteButton);

    inputPanel.setBackground(new Color(230, 230, 250));
    addButton.setBackground(new Color(144, 238, 144));
    deleteButton.setBackground(new Color(240, 128, 128));

    frame.add(inputPanel, BorderLayout.SOUTH);

    DefaultListModel<String> taskListModel = new DefaultListModel<>();
    JList<String> taskList = new JList<>(taskListModel);
    JScrollPane scrollPane = new JScrollPane(taskList);
    frame.add(scrollPane, BorderLayout.CENTER);

    taskList.setFont(font);
    taskList.setFixedCellHeight(30);

    addButton.addActionListener(e -> {
      String task = taskInput.getText().trim();
      if(!task.isEmpty()) {
        taskListModel.addElement(task);
        taskInput.setText("");
      }
    });

    deleteButton.addActionListener(e -> {
      int selectedIndex = taskList.getSelectedIndex();
      if(selectedIndex != -1) {
        taskListModel.remove(selectedIndex);
      }
    });

    frame.setVisible(true);
  }
}