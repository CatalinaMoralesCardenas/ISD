package com.Taller;

import java.util.*;
import org.zeromq.SocketType;
import org.zeromq.ZMQ;
import org.zeromq.ZContext;

public class Publisher 
{
    public void displayRamdom ( ) throws Exception 
    {
        String[] messages = new String[] {"Hi", "How are you", "Thanks for be my subscriber", "Nice to meet you"};
        try (ZContext context = new ZContext()) 
        {
            ZMQ.Socket publisher = context.createSocket(SocketType.PUB);

            publisher.bind("tcp://*:5556");
            publisher.bind("ipc://artist");

            while (!Thread.currentThread().isInterrupted()) 
            {
                for (int i = 1; i < 5; i++) 
                {
                    String artist, publishDate, publishHour, message;
                    String months[] = { "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov","Dec" };
                    GregorianCalendar date = new GregorianCalendar();

                    artist = "Artist_" + i;
                    publishDate = months[date.get(Calendar.MONTH)] + "/" + date.get(Calendar.DATE) + "/"
                            + date.get(Calendar.YEAR);
                    publishHour = date.get(Calendar.HOUR) + ":" + date.get(Calendar.MINUTE) + ":"
                            + date.get(Calendar.SECOND);
                    message = messages[i];

                    String update = String.format("%d %s %s %s %s", i, artist, publishDate, publishHour, message);

                    publisher.send(update, 0);
                }
            }
        }
    }

    public void displayArtist ( String artist, String message ) throws Exception 
    {
        try (ZContext context = new ZContext()) 
        {
            ZMQ.Socket publisher = context.createSocket(SocketType.PUB);

            publisher.bind("tcp://*:5556");
            publisher.bind("ipc://artist");

            while (!Thread.currentThread().isInterrupted()) 
            {
                String publishDate, publishHour;
                String months[] = { "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov","Dec" };
                GregorianCalendar date = new GregorianCalendar();

                publishDate = months[date.get(Calendar.MONTH)] + "/" + date.get(Calendar.DATE) + "/" + date.get(Calendar.YEAR);
                publishHour = date.get(Calendar.HOUR) + ":" + date.get(Calendar.MINUTE) + ":" + date.get(Calendar.SECOND);

                String update = String.format("%d %s %s %s %s", 1, artist, publishDate, publishHour, message);

                publisher.send(update, 0);
            }
        }
    } 
}