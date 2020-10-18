package com.Taller;

import java.util.StringTokenizer;

import org.zeromq.SocketType;
import org.zeromq.ZMQ;
import org.zeromq.ZContext;

public class Suscriber 
{
    public static void main(String [] args)
    {
        try (ZContext context = new ZContext()) 
        {
            System.out.println("Collecting artists from cricker server");
            
            ZMQ.Socket subscriber = context.createSocket(SocketType.SUB);
            
            //subscriber.connect("tcp://localhost:5556");
            //subscriber.connect("tcp://192.168.0.14:5556");
            
            String filter = (args.length > 0) ? args[0] : "10001 ";
            
            subscriber.subscribe(filter.getBytes(ZMQ.CHARSET));

            int update_nbr;
            String nameArtist = " ", publishDate = " ", publishHour = " ", message = " ";

            for (update_nbr = 0; update_nbr < 100; update_nbr++) 
            {
                String string = subscriber.recvStr(0).trim();
                
                StringTokenizer sscanf = new StringTokenizer(string, " ");
                nameArtist = String.valueOf(sscanf.nextToken());
                publishDate = String.valueOf(sscanf.nextToken());
                publishHour = String.valueOf(sscanf.nextToken());
                message = String.valueOf(sscanf.nextToken());
            }

            System.out.println(nameArtist + publishDate + publishHour + message);
        }   
    }
    
}
