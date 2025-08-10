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

    JPanel inputPanel = new JPanel();
    inputPanel.setLayout(new FlowLayout());
    inputPanel.add(taskInput);
    inputPanel.add(addButton);
    inputPanel.add(deleteButton);

    frame.add(inputPanel, BorderLayout.SOUTH);

    DefaultListModel<String> taskListModel = new DefaultListModel<>();
    JList<String> taskList = new JList<>(taskListModel);
    JScrollPane scrollPane = new JScrollPane(taskList);
    frame.add(scrollPane, BorderLayout.CENTER);

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