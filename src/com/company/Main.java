package com.company;

import javax.swing.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.text.DecimalFormat;

public class Main {
    public static void main(String[] args) throws Exception {

        String start = JOptionPane.showInputDialog("Enter the Start time using \"HH:mm:ss\" format:");
        String stop = JOptionPane.showInputDialog("Enter the Stop time using \"HH:mm:ss\" format:");
        String[] options = {"Yes", "No"};
        ImageIcon icon = new ImageIcon();
        String n = (String)JOptionPane.showInputDialog(null, "Is the call on the same network?",
                "Calls", JOptionPane.QUESTION_MESSAGE, icon, options, options[1]);
        System.out.println(n);
        SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
        DecimalFormat df = new DecimalFormat("#.##");

        long Milliseconds, Milliseconds1 ;
        long Seconds, Seconds1, Seconds2, Seconds3, Seconds4 = 0, Seconds5 ;
        long Minutes, Minutes1, Minutes2 = 0 ;
        long Hours, Hours1, Hours2 = 0 ;
        double charges, charges1, charges2 = 0 ;
        double vat = 1.16;
        double rate1 = 3, rate2 = 4, rate3 = 5;

        /* try { */
        Date Start = format.parse(start);
        Date Stop = format.parse(stop);
        Date Morning = format.parse("06:00:00");
        Date Evening = format.parse("18:00:00");
        Date Midnight_24 = format.parse("24:00:00");
        Date Midnight_00 = format.parse("00:00:00");

        if (n.equals("Yes")) {

            // after 6 am to 6 pm
            if ((Start.getTime() <= Evening.getTime()) && (Start.getTime()) > (Morning.getTime()) && (Stop.getTime() > Morning.getTime()) && (Stop.getTime() <= Evening.getTime())) {
                Milliseconds = Stop.getTime() - Start.getTime();
                Seconds = Milliseconds / 1000;

                Seconds4 = Milliseconds / 1000 % 60;
                Minutes2 = Milliseconds / (1000 * 60) % 60;
                Hours2 = Milliseconds / (60 * 60 * 1000) % 24;
                System.out.println("Seconds " + Seconds);

                if (Seconds <= 120) {
                    charges2 = Seconds * rate2 / 60.0;
                } else {
                    charges2 = (Seconds * rate2) * vat / 60.0;
                }

            }

            // after 6 pm to 11.59 pm
            if ((Stop.getTime() > Evening.getTime()) && (Start.getTime() <= Midnight_24.getTime()) && (Start.getTime() > Evening.getTime())) {
                Milliseconds = Stop.getTime() - Start.getTime();
                Seconds = Milliseconds / 1000;
                if (Seconds <= 120) {
                    charges2 = (Seconds * rate2) / 60.0;
                } else {
                    charges2 = (Seconds * rate2) * vat / 60.0;
                }

                Seconds4 = Milliseconds / 1000 % 60;
                Minutes2 = Milliseconds / (1000 * 60) % 60;
                Hours2 = Milliseconds / (60 * 60 * 1000) % 24;
            }

            // after 6 pm to 6 am
            if ((Start.getTime() <= Midnight_24.getTime()) && (Start.getTime() > Evening.getTime()) && (Stop.getTime() >= Midnight_00.getTime()) && (Stop.getTime() <= Morning.getTime())) {
                Milliseconds = (Midnight_24.getTime() - Start.getTime());
                Milliseconds1 = (Stop.getTime() - Midnight_00.getTime());
                Seconds = Milliseconds / 1000;
                Seconds1 = Milliseconds1 / 1000;
                Seconds5 = Seconds + Seconds1;

                if (Seconds5 <= 120) {
                    charges = (Seconds * rate1) / 60.0;
                    charges1 = (Seconds1 * rate1) / 60.0;
                    charges2 = charges + charges1;
                } else {
                    charges = (Seconds * rate1) * vat / 60.0;
                    charges1 = (Seconds1 * rate1) * vat / 60.0;
                    charges2 = charges + charges1;
                }

                Seconds2 = Milliseconds / 1000 % 60;
                Minutes = Milliseconds / (1000 * 60) % 60;
                Hours = Milliseconds / (60 * 60 * 1000) % 24;
                Seconds3 = Milliseconds1 / 1000 % 60;
                Minutes1 = Milliseconds1 / (1000 * 60) % 60;
                Hours1 = Milliseconds1 / (60 * 60 * 1000) % 24;

                Seconds4 = Seconds2 + Seconds3;
                Minutes2 = Minutes + Minutes1;
                Hours2 = Hours + Hours1;
            }

            // from 12am to 6 am
            if ((Start.getTime() <= Morning.getTime()) && (Start.getTime() >= Midnight_00.getTime()) && (Stop.getTime() <= Morning.getTime())) {
                Milliseconds = Stop.getTime() - Start.getTime();
                Seconds = Milliseconds / 1000;
                if (Seconds <= 120) {
                    charges2 = (Seconds * rate1) / 60.0;
                } else {
                    charges2 = (Seconds * rate1) * vat / 60.0;
                }
                Seconds4 = Milliseconds / 1000 % 60;
                Minutes2 = Milliseconds / (1000 * 60) % 60;
                Hours2 = Milliseconds / (60 * 60 * 1000) % 24;
            }

            // from 12 am to 6 pm
            if ((Start.getTime() <= Morning.getTime()) && (Start.getTime() >= Midnight_00.getTime()) && (Stop.getTime() > Morning.getTime()) && (Stop.getTime() <= Evening.getTime())) {
                Milliseconds = Morning.getTime() - Start.getTime();
                Seconds = Milliseconds / 1000;
                Milliseconds1 = Stop.getTime() - Morning.getTime();
                Seconds1 = Milliseconds1 / 1000;

                Seconds5 = Seconds + Seconds1;
                if (Seconds5 <= 120) {
                    charges = (Seconds * rate1) / 60.0;
                    charges1 = (Seconds1 * rate2) / 60.0;
                    charges2 = charges + charges1;
                } else {
                    charges = (Seconds * rate1) * vat / 60.0;
                    charges1 = (Seconds1 * rate2) * vat / 60.0;
                    charges2 = charges + charges1;
                }

                Seconds2 = Milliseconds / 1000 % 60;
                Minutes = Milliseconds / (1000 * 60) % 60;
                Hours = Milliseconds / (60 * 60 * 1000) % 24;
                Seconds3 = Milliseconds1 / 1000 % 60;
                Minutes1 = Milliseconds1 / (1000 * 60) % 60;
                Hours1 = Milliseconds1 / (60 * 60 * 1000) % 24;

                Seconds4 = Seconds2 + Seconds3;
                Minutes2 = Minutes + Minutes1;
                Hours2 = Hours + Hours1;
            }

            // after 6 am to 11:59 pm
            if ((Start.getTime() <= Evening.getTime()) && (Start.getTime() > Morning.getTime()) && (Stop.getTime() > Evening.getTime()) && (Stop.getTime() <= Midnight_24.getTime())) {
                Milliseconds = Evening.getTime() - Start.getTime();
                Seconds = Milliseconds / 1000;
                Milliseconds1 = Stop.getTime() - Evening.getTime();
                Seconds1 = Milliseconds1 / 1000;

                Seconds5 = Seconds + Seconds1;
                if (Seconds5 <= 120) {
                    charges = (Seconds * rate1) / 60.0;
                    charges1 = (Seconds1 * rate2) / 60.0;
                    charges2 = charges + charges1;
                } else {
                    charges = (Seconds * rate1) * vat / 60.0;
                    charges1 = (Seconds1 * rate2) * vat / 60.0;
                    charges2 = charges + charges1;
                }

                Seconds2 = Milliseconds / 1000 % 60;
                Minutes = Milliseconds / (1000 * 60) % 60;
                Hours = Milliseconds / (60 * 60 * 1000) % 24;
                Seconds3 = Milliseconds1 / 1000 % 60;
                Minutes1 = Milliseconds1 / (1000 * 60) % 60;
                Hours1 = Milliseconds1 / (60 * 60 * 1000) % 24;

                Seconds4 = Seconds2 + Seconds3;
                Minutes2 = Minutes + Minutes1;
                Hours2 = Hours + Hours1;
            }

        } else if (n.equals("No")) {
            // start < stop
            Milliseconds = Stop.getTime() - Start.getTime();
            if (Milliseconds >= 0) {
                Seconds = Milliseconds / 1000;
                Seconds4 = Milliseconds / 1000 % 60;
                Minutes2 = Milliseconds / (1000 * 60) % 60;
                Hours2 = Milliseconds / (60 * 60 * 1000) % 24;

                if (Seconds <= 120) {
                    charges2 = (Seconds * rate3) / 60.0;
                } else {
                    charges2 = (Seconds * rate3) * vat / 60.0;
                }
            } else {
                // start < stop
                Milliseconds = (Midnight_24.getTime() - Start.getTime());
                Milliseconds1 = (Stop.getTime() - Midnight_00.getTime());
                Seconds = Milliseconds / 1000;
                Seconds1 = Milliseconds1 / 1000;

                Seconds5 = Seconds + Seconds1;
                if (Seconds5 <= 120) {
                    charges = (Seconds * rate3) / 60.0;
                    charges1 = (Seconds1 * rate3) / 60.0;
                    charges2 = charges + charges1;
                } else {
                    charges = (Seconds * rate3) * vat / 60.0;
                    charges1 = (Seconds1 * rate3) * vat / 60.0;
                    charges2 = charges + charges1;
                }

                Seconds2 = Milliseconds / 1000 % 60;
                Minutes = Milliseconds / (1000 * 60) % 60;
                Hours = Milliseconds / (60 * 60 * 1000) % 24;
                Seconds3 = Milliseconds1 / 1000 % 60;
                Minutes1 = Milliseconds1 / (1000 * 60) % 60;
                Hours1 = Milliseconds1 / (60 * 60 * 1000) % 24;

                Seconds4 = Seconds2 + Seconds3;
                Minutes2 = Minutes + Minutes1;
                Hours2 = Hours + Hours1;
            }
        } else {
            JOptionPane.showMessageDialog(null, "Invalid input on the carrier dialog");
        }
        JOptionPane.showMessageDialog(null, "Call Duration:  " + Hours2 + " Hours, " + Minutes2 + " Minutes, " + Seconds4 + " Seconds. Your total charge is KSh. " + df.format(charges2));
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null, "Invalid time input");
//            System.out.println(e.getMessage());
//        }
    }
}