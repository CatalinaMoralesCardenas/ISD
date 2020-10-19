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
            publisher.bind("ipc://artist");

            int code = 1;
            while (!Thread.currentThread().isInterrupted()) 
            {
                String artist, publishDate, publishHour, message;
                String months[] = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
                GregorianCalendar date = new GregorianCalendar();

                artist = "Artist_"+code;
                publishDate = months[date.get(Calendar.MONTH)] + "/" + date.get(Calendar.DATE) + "/" + date.get(Calendar.YEAR);
                publishHour = date.get(Calendar.HOUR) + ":" + date.get(Calendar.MINUTE) + ":" + date.get(Calendar.SECOND);
                message = "This_is_the_artist_"+code; 

                String update = String.format("%d %s %s %s %s", code, artist, publishDate, publishHour, message);
                
                publisher.send(update, 0);
                code++;
            }
        }
    }
}