package com.Taller;

import java.util.*;
import org.zeromq.SocketType;
import org.zeromq.ZMQ;
import org.zeromq.ZContext;

public class Publisher 
{
    public static void main(String[] args) throws Exception 
    {
        try (ZContext context = new ZContext()) 
        {
            ZMQ.Socket publisher = context.createSocket(SocketType.PUB);

            publisher.bind("tcp://*:5556");
            publisher.bind("ipc://cricker");

            while (!Thread.currentThread().isInterrupted()) 
            {
                int num = 1;
                String nameArtist, publishDate, publishHour, message;
                String months[] = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
                GregorianCalendar date = new GregorianCalendar();
    
                nameArtist = "Artist " + num;
                publishDate = months[date.get(Calendar.MONTH)] + " " + date.get(Calendar.DATE) + " " + date.get(Calendar.YEAR);
                publishHour = date.get(Calendar.HOUR) + ":" + date.get(Calendar.MINUTE) + ":" + date.get(Calendar.SECOND);
                message = "This is the artist one\n";

                String update = String.format("%s %s %s %s", nameArtist, publishDate, publishHour, message);
                
                publisher.send(update, 0);

                num++;
            }
        }
    }
}
