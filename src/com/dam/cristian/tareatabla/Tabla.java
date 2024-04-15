package com.dam.cristian.tareatabla;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;

public class Tabla extends JFrame {

    private JPanel centerPanel;
    private JPanel dataEntryPanel;
    private JPanel selectCoursePanel;
    private JPanel panelWithTable;
    private JLabel nameTextIndicator;
    private JTextField nameText;
    private JLabel surnameTextIndicator;
    private JTextField surnameText;
    private JButton confirm;
    private JTable table;
    private DefaultTableModel modelTable;
    private String auxName;
    private String auxSurName;
    private String auxCourse;
    JComboBox<String> courses = new JComboBox<>();

    public Tabla() {
        setTitle("Tabla para insertar alumnos");
        setBounds(500, 500, 500, 500);
        setVisible(true);
        centerPanel = new JPanel();
        centerPanel.setPreferredSize(new Dimension(200, 300));
        centerPanel.setLayout(new BorderLayout());
        add(centerPanel);
        dataEntryPanel = new JPanel();
        dataEntryPanel.setLayout(new BoxLayout(dataEntryPanel, BoxLayout.Y_AXIS));
        centerPanel.add(dataEntryPanel, BorderLayout.WEST);
        selectCoursePanel = new JPanel();
        selectCoursePanel.setLayout(new BoxLayout(selectCoursePanel, BoxLayout.Y_AXIS));
        centerPanel.add(selectCoursePanel, BorderLayout.EAST);
        panelWithTable = new JPanel();
        panelWithTable.setLayout(new BorderLayout());
        centerPanel.add(panelWithTable, BorderLayout.CENTER);
        nameTextIndicator = new JLabel("NOME");
        dataEntryPanel.add(nameTextIndicator);
        nameText = new JTextField(1);
        nameText.setPreferredSize(new Dimension(60, 20));
        nameText.setMaximumSize(new Dimension(200, 20));
        nameText.setMinimumSize(new Dimension(200, 20));
        dataEntryPanel.add(nameText);
        surnameTextIndicator = new JLabel("APELIDO");
        dataEntryPanel.add(surnameTextIndicator);
        surnameText = new JTextField(22);
        surnameText.setPreferredSize(new Dimension(60, 20));
        surnameText.setMaximumSize(new Dimension(200, 20));
        surnameText.setMinimumSize(new Dimension(200, 20));
        dataEntryPanel.add(surnameText);
        DefaultComboBoxModel<String> courseList = new DefaultComboBoxModel<>();
        courses = new JComboBox<>(courseList);
        courses.setPreferredSize(new Dimension(60, 20));
        courses.setMaximumSize(new Dimension(200, 20));
        courses.setMinimumSize(new Dimension(200, 20));
        courseList.addElement("dam1");
        courseList.addElement("dam2");
        courseList.addElement("daw1");
        courseList.addElement("daw2");
        courseList.addElement("asir1");
        courseList.addElement("asir2");
        selectCoursePanel.add(courses);
        confirm = new JButton("AGREGAR TABLA");
        selectCoursePanel.add(confirm);
        modelTable = new DefaultTableModel(
                new Object[][]{
                        {auxName, auxSurName, auxCourse},

                },
                new Object[]{"Nome", "APELIDO", "CURSO"}
        );


        table = new JTable(modelTable);


        JScrollPane scrollPane = new JScrollPane(table);
        panelWithTable.add(scrollPane);

        confirm.addActionListener(this::selectContentTable);



    }

    public void selectContentTable(ActionEvent e) {

        auxName = nameText.getText();
        auxSurName = surnameText.getText();
        auxCourse = (String) courses.getSelectedItem();
        if(checkContentText()){
            confirm.setEnabled(true);
            Object[] row = {auxName, auxSurName, auxCourse};
            modelTable.addRow(row);
            nameText.setText("");
            surnameText.setText("");
        }



    }
        private boolean checkContentText () {

            return !auxName.isEmpty() && !auxSurName.isEmpty() && !auxCourse.isEmpty();
        }


    }

