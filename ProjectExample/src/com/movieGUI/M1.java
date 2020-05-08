package com.movieGUI;

import com.Main;
import com.GUI.RegistrationGUI;

import javax.swing.*;
import javax.swing.tree.VariableHeightLayoutCache;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;

import static java.awt.Font.SERIF;

public class M1 extends Container {
    private JLabel fone;
    private JLabel titel;
    private JButton buttonBack;
    JComboBox chisla;
    private JComboBox chisla1;
    private JComboBox chisla2;
    private JLabel studentLabel;
    private JLabel childLabel;
    private JLabel adultLabel;
    private JCheckBox food;
    private JButton buttonNext;

    private JLabel opisanie;

    public M1(){
        setSize(900,600);
        setLayout(null);

        Integer []ages=new Integer[6];
        for (int i = 0; i <6 ; i++) {
            ages[i]=i;
        }

        Font font = new Font("Arial", Font.BOLD, 25);
        titel=new JLabel("Камуфляж и шпионаж");
        titel.setBounds(300,50,350,30);
        titel.setForeground(Color.WHITE);
        titel.setFont(font);
        add(titel);

        chisla=new JComboBox(ages);
        chisla.setBounds(500,300,100,30);
        add(chisla);

        chisla1=new JComboBox(ages);
        chisla1.setBounds(500,350,100,30);
        add(chisla1);

        chisla2=new JComboBox(ages);
        chisla2.setBounds(500,400,100,30);
        add(chisla2);

        childLabel=new JLabel();
        ImageIcon iconchild=createIcon("/com/posters/child.jpg");
        childLabel.setIcon(iconchild);
        childLabel.setBounds(250,300,100,30);
        add(childLabel);

        JLabel tg800 = new JLabel();
        ImageIcon icon800=createIcon("/com/posters/800.jpeg");
        tg800.setIcon(icon800);
        tg800.setBounds(350,300,100,30);
        add(tg800);

        studentLabel=new JLabel();
        ImageIcon iconstud=createIcon("/com/posters/st.jpg");
        studentLabel.setIcon(iconstud);
        studentLabel.setBounds(250,350,100,30);
        add(studentLabel);

        JLabel tg1000 = new JLabel();
        ImageIcon icon1000=createIcon("/com/posters/1000.jpeg");
        tg1000.setIcon(icon1000);
        tg1000.setBounds(350,350,100,30);
        add(tg1000);

        adultLabel=new JLabel();
        ImageIcon iconadult=createIcon("/com/posters/adult.jpg");
        adultLabel.setIcon(iconadult);
        adultLabel.setBounds(250,400,100,30);
        add(adultLabel);

        JLabel tg1200 = new JLabel();
        ImageIcon icon1200=createIcon("/com/posters/1200.jpeg");
        tg1200.setIcon(icon1200);
        tg1200.setBounds(350,400,100,30);
        add(tg1200);

        food=new JCheckBox("food");
        food.setBounds(400,450,100,30);
        add(food);

        buttonBack = new JButton("BACK");
        buttonBack.setBounds(20, 510, 80, 30);
        buttonBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.frame.selectMovieWindow.setVisible(true);

                Main.frame.m1.setVisible(false);
            }
        });
        add(buttonBack);

        buttonNext = new JButton("NEXT");
        buttonNext.setBounds(780, 510, 80, 30);
        buttonNext.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int index;
                index=(Integer)(food.isSelected()?1:0);
                String movieName="Камуфляж и шпионаж";
                int countStudent,countChild,countAdult;
                countStudent=(Integer)chisla1.getSelectedItem();
                countAdult=(Integer)chisla2.getSelectedItem();
                countChild=(Integer)chisla.getSelectedItem();
                String fullInfo;
                fullInfo="Камуфляж и шпионаж-"+countChild+"-"+countStudent+"-"+countAdult+"-"+index+"-";

                try {
                        FileWriter writer = new FileWriter("data.txt");
                        writer.write(fullInfo);
                        writer.close();
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }


                    if (index==1){
                    Main.frame.m1.setVisible(false);
                    Main.frame.food.setVisible(true);

                }

                if (index==0){
                    Main.frame.m1.setVisible(false);
                    Main.frame.bill.setVisible(true);
                }

                //Main.frame.selectMovieWindow.setVisible(false);

            }
        });
        add(buttonNext);

        font = new Font("Arial", Font.BOLD, 15);
        String s = "<html>" +
                "<p align = center> Super spy Lance Sterling (Will Smith) and scientist Walter Beckett (Tom " + "</p>" +
                "<p align = center> Holland) are almost exact opposites. Lance is smooth, suave and " + "</p>" +
                "<p align = center> debonair. Walter is...not. But when events take an unexpected turn, this" + "</p>" +
                "<p align = center> unlikely duo is forced to team up for the ultimate mission that will require" + "</p>" +
                "<p align = center> an almost impossible disguise - transforming Lance into the brave," + "</p>"  +
                "<p align = center> fierce, majestic...pigeon. Walter and Lance suddenly have to work as av" + "</p>"  +
                "<p align = center> team, or the whole world is in peril. <p>" +
                "</html>";
        opisanie = new JLabel(s);
        opisanie.setBounds(170,-120,600,600);
        opisanie.setFont(font);
        opisanie.setForeground(Color.white);
        add(opisanie);

        JLabel fone = new JLabel();
        ImageIcon icon = createIcon("/com/posters/fonM1.jpg");
        fone.setBounds(0,0,900,600);
        fone.setIcon(icon);
        add(fone);
    }

    protected static ImageIcon createIcon (String path){
        URL imgURL = RegistrationGUI.class.getResource(path);
        if (imgURL != null) {
            return new ImageIcon(imgURL);
        } else {
            System.err.println("File not found " + path);
            return null;
        }
    }
}