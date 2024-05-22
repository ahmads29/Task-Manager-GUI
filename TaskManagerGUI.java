import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TaskManagerGUI extends JFrame {
    private PriorityTaskManager priorityTaskManager;
    private JTextArea taskDisplayArea;
    private JTextField nameField, descriptionField, dueDateField, priorityField;

    public TaskManagerGUI() {
        // Set up the frame
        setTitle("Task Manager");
        setSize(700, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Initialize TaskManager
        priorityTaskManager = new PriorityTaskManager(100);

        // Create components
        JLabel nameLabel = new JLabel("Name:");
        JLabel descriptionLabel = new JLabel("Description:");
        JLabel dueDateLabel = new JLabel("Due Date:");
        JLabel priorityLabel = new JLabel("Priority (1-100):");

        nameField = new JTextField(20);
        descriptionField = new JTextField(20);
        dueDateField = new JTextField(20);
        priorityField = new JTextField(20);

        JButton addButton = new JButton("Add Task");
        JButton displayButton = new JButton("Display Tasks");
        JButton finishButton = new JButton("Mark Task as Finished");
        JButton deleteButton = new JButton("Delete All Tasks");

        taskDisplayArea = new JTextArea(15, 40);
        JScrollPane scrollPane = new JScrollPane(taskDisplayArea);
        taskDisplayArea.setEditable(false);

        // Set up the layout
        JPanel inputPanel = new JPanel(new GridLayout(5, 2));
        inputPanel.add(nameLabel);
        inputPanel.add(nameField);
        inputPanel.add(descriptionLabel);
        inputPanel.add(descriptionField);
        inputPanel.add(dueDateLabel);
        inputPanel.add(dueDateField);
        inputPanel.add(priorityLabel);
        inputPanel.add(priorityField);
        inputPanel.add(addButton);
        inputPanel.add(displayButton);

        JPanel actionPanel = new JPanel(new GridLayout(1, 2));
        actionPanel.add(finishButton);
        actionPanel.add(deleteButton);

        // Add components to the frame
        add(inputPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
        add(actionPanel, BorderLayout.SOUTH);

        // Add action listeners
        addButton.addActionListener(new AddButtonListener());
        displayButton.addActionListener(new DisplayButtonListener());
        finishButton.addActionListener(new FinishButtonListener());
        deleteButton.addActionListener(new DeleteButtonListener());
    }

    // Action listener for Add Task button
    private class AddButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String name = nameField.getText();
            String description = descriptionField.getText();
            String dueDate = dueDateField.getText();
            int priority = Integer.parseInt(priorityField.getText());
            Task taskToAdd = new Task(name, description, dueDate, priority);
            priorityTaskManager.addTask(taskToAdd);
            taskDisplayArea.append("Task added successfully: " + name + "\n"); 
            clearFields();
        }
    }

    // Action listener for Display Tasks button
    private class DisplayButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            taskDisplayArea.setText(priorityTaskManager.getTaskListAsString());
        }
    }

    // Action listener for Mark Task as Finished button
    private class FinishButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String taskName = JOptionPane.showInputDialog("Enter Task Name to mark as finished:");
            if (taskName != null && !taskName.isEmpty()) {
                priorityTaskManager.markTaskAsFinished(taskName);
                taskDisplayArea.setText(""); 
                if (priorityTaskManager.isTaskFound()) {
                    JOptionPane.showMessageDialog(TaskManagerGUI.this, "Task marked as finished: " + taskName);
                } else {
                    JOptionPane.showMessageDialog(TaskManagerGUI.this, "Task not found: " + taskName, "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }

    // Action listener for Delete All Tasks button
    private class DeleteButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            priorityTaskManager.deleteAllTasks();
            taskDisplayArea.setText("All tasks deleted successfully");
        }
    }

    // Helper method to clear input fields
    private void clearFields() {
        nameField.setText("");
        descriptionField.setText("");
        dueDateField.setText("");
        priorityField.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new TaskManagerGUI().setVisible(true);
            }
        });
    }
}
