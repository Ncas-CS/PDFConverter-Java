package com.to_pdf;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class Main extends JFrame implements ActionListener {
    JPanel window=new JPanel();
    JTextField inputLoc=new JTextField();
    JTextField outputLoc=new JTextField();
    JButton inputBtn=new JButton();
    JButton outputBtn=new JButton();
    JButton convertAndSaveBtn=new JButton();
    String[] formats={"Doc","Docx","Html","Png","Jpg"};
    JComboBox inputFormat=new JComboBox(formats);
    JTextField outputFormat=new JTextField("PDF");
    JLabel to =new JLabel("To");
    Main(){
        setBounds(100,100,500,300);
        setTitle("PDF Converter");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setLayout(new CardLayout());
        add(window());
        setVisible(true);
    }
    public JPanel window(){
        window.setBackground(Color.darkGray);
        window.setLayout(null);

        inputLoc.setBounds(47,60,300,34);
        outputLoc.setBounds(47,110,300,34);
        inputBtn.setBounds(350,60,90,34);
        outputBtn.setBounds(350,110,90,34);
        convertAndSaveBtn.setBounds(280,160,160,34);

        inputLoc.setText("Select your file input location");
        inputLoc.setForeground(Color.gray);
        outputLoc.setText("Select your file out location");
        outputLoc.setForeground(Color.gray);
        to.setBounds(146,160,20,34);
        to.setHorizontalAlignment(JLabel.CENTER);
        to.setForeground(Color.lightGray);

        inputFormat.setBounds(47,160,90,34);
        outputFormat.setBounds(177,160,60,34);
        outputFormat.setFocusable(false);
        outputFormat.setEditable(false);
        outputFormat.setHorizontalAlignment(JTextField.CENTER);

        inputBtn.setText("Upload");
        inputBtn.setForeground(Color.darkGray);
        inputBtn.setFocusable(false);
        inputBtn.addActionListener(this);
        outputBtn.setText("Download");
        outputBtn.setForeground(Color.darkGray);
        outputBtn.setFocusable(false);
        outputBtn.addActionListener(this);
        convertAndSaveBtn.setText("Convert & Save");
        convertAndSaveBtn.setForeground(Color.darkGray);
        convertAndSaveBtn.setFocusable(false);
        convertAndSaveBtn.addActionListener(this);

        window.add(inputLoc);
        window.add(outputLoc);
        window.add(inputBtn);
        window.add(outputBtn);
        window.add(inputFormat);
        window.add(outputFormat);
        window.add(convertAndSaveBtn);
        window.add(to);

        return window;
    }
    public static void main(String[] args) {
	new Main();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == inputBtn) {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setCurrentDirectory(new File("."));
            FileNameExtensionFilter filter = new FileNameExtensionFilter("All Files", "txt","doc","docx","html","png","jpg");
            fileChooser.setFileFilter(filter);

            int response = fileChooser.showOpenDialog(null);

            if (response == JFileChooser.APPROVE_OPTION) {
                File file = new File(fileChooser.getSelectedFile().getAbsolutePath());
                inputLoc.setText(fileChooser.getSelectedFile().getAbsolutePath());
                inputLoc.setForeground(Color.darkGray);
            }
        }
        if (e.getSource() == outputBtn) {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setCurrentDirectory(new File("."));
            FileNameExtensionFilter filter = new FileNameExtensionFilter("PDF", "pdf");
            fileChooser.setFileFilter(filter);

            int response = fileChooser.showOpenDialog(null);

            if (response == JFileChooser.APPROVE_OPTION) {
                File file = new File(fileChooser.getSelectedFile().getAbsolutePath());
                outputLoc.setText(fileChooser.getSelectedFile().getAbsolutePath());
                outputLoc.setForeground(Color.darkGray);
            }
        }
        if(e.getSource()==convertAndSaveBtn){
            String format= (String) inputFormat.getSelectedItem();
        }
    }
}
