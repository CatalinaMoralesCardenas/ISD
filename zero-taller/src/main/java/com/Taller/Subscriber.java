package com.Taller;

import org.zeromq.SocketType;
import org.zeromq.ZMQ;
import org.zeromq.ZContext;

public class Subscriber
{
    public String getArtist( int code )
    {
        String string = " ";
        while (!Thread.currentThread().isInterrupted()) 
        {
            try (ZContext context = new ZContext()) 
            {
                System.out.println("Collecting artists from cricket server");
                ZMQ.Socket subscriber = context.createSocket(SocketType.SUB);
                
                subscriber.connect("tcp://localhost:5556");
                
                String filter = String.valueOf(code);
                subscriber.subscribe(filter.getBytes(ZMQ.CHARSET));
                string = subscriber.recvStr(0).trim();
                return string;
            }
        }
        return string;
    }
}