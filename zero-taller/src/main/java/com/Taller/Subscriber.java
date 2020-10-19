package com.Taller;

import java.util.StringTokenizer;

import org.zeromq.SocketType;
import org.zeromq.ZMQ;
import org.zeromq.ZContext;

public class Subscriber
{
    public static void main(String[] args)
    {
        try (ZContext context = new ZContext()) 
        {
            System.out.println("Collecting artists from cricket server");
            ZMQ.Socket subscriber = context.createSocket(SocketType.SUB);
            
            subscriber.connect("tcp://localhost:5556");
            
            int update_nbr;
            long total_temp = 0;
            int code = 1;
            for (update_nbr = 0; update_nbr < 10; update_nbr++) 
            {
                String filter = String.valueOf(code);
                subscriber.subscribe(filter.getBytes(ZMQ.CHARSET));
                String string = subscriber.recvStr(0).trim();
                
                StringTokenizer sscanf = new StringTokenizer(string, " ");
                int id = Integer.valueOf(sscanf.nextToken());
                String artist = String.valueOf(sscanf.nextToken());
                String publishDate = String.valueOf(sscanf.nextToken());
                String publishHour = String.valueOf(sscanf.nextToken());
                String message = String.valueOf(sscanf.nextToken());

                System.out.println(artist + " " + publishDate + " " + publishHour + " " + message);
                code++;
            }
        }
    }
}