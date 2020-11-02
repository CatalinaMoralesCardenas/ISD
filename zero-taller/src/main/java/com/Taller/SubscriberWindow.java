package com.Taller;

import java.util.StringTokenizer;

public class SubscriberWindow extends javax.swing.JFrame 
{
    private static final long serialVersionUID = 1L;

    public SubscriberWindow() 
    {
        initComponents();
    }

    private void initComponents() 
    {
        Artist1 = new javax.swing.JButton();
        Artist2 = new javax.swing.JButton();
        Artist3 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        TextInformation = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); 
        jLabel1.setText("Artist Information");

        Artist1.setText("Subscribe one Artist");
        Artist1.addActionListener(new java.awt.event.ActionListener() 
        {
            public void actionPerformed(java.awt.event.ActionEvent evt) 
            {
                Artist1ActionPerformed(evt);
            }
        });

        Artist2.setText("Subscribe two Artists");
        Artist2.addActionListener(new java.awt.event.ActionListener() 
        {
            public void actionPerformed(java.awt.event.ActionEvent evt) 
            {
                Artist2ActionPerformed(evt);
            }
        });

        Artist3.setText("Subscribe all Artists");
        Artist3.addActionListener(new java.awt.event.ActionListener() 
        {
            public void actionPerformed(java.awt.event.ActionEvent evt) 
            {
                Artist3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(195, 195, 195))
            .addGroup(layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Artist2, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Artist1, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Artist3, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39)
                .addComponent(TextInformation, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(32, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addComponent(jLabel1)
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Artist1)
                        .addGap(28, 28, 28)
                        .addComponent(Artist2)
                        .addGap(31, 31, 31)
                        .addComponent(Artist3))
                    .addComponent(TextInformation))
                .addContainerGap(45, Short.MAX_VALUE))
        );

        pack();
    }

    private String token(String string)
    {
        StringTokenizer sscanf = new StringTokenizer(string, " ");
        int id = Integer.valueOf(sscanf.nextToken());
        String artist = "Artist Name: " + String.valueOf(sscanf.nextToken()) + "\n";
        String publishDate = "Date: " + String.valueOf(sscanf.nextToken()) + "\n";
        String publishHour = "Hour: " + String.valueOf(sscanf.nextToken()) + "\n";
        String message = "Message: " + String.valueOf(sscanf.nextToken());

        return artist + publishDate + publishHour + message;
    }   

    private void Artist1ActionPerformed(java.awt.event.ActionEvent evt) 
    {
        Subscriber subscriber = new Subscriber( );
        String string = subscriber.getArtist( 1 );
        String text = token( string );
        TextInformation.setText( text );
    }

    private void Artist2ActionPerformed(java.awt.event.ActionEvent evt) 
    {
        Subscriber subscriber = new Subscriber( );
        String string1 = subscriber.getArtist( 1 );
        String string2 = subscriber.getArtist( 2 );
        String text = token( string1 ) + "\n" + token( string2 );
        TextInformation.setText( text );
    }

    private void Artist3ActionPerformed(java.awt.event.ActionEvent evt) 
    {
        Subscriber subscriber = new Subscriber( );
        String string1 = subscriber.getArtist( 1 );
        String string2 = subscriber.getArtist( 2 );
        String string3 = subscriber.getArtist( 3 );
        String text = token( string1 ) + "\n" + token( string2 ) + "\n" + token( string3 );
        TextInformation.setText( text );
    }
    
    public static void main(String args[]) 
    {
        try 
        {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) 
            {
                if ("Nimbus".equals(info.getName())) 
                {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } 
        catch (ClassNotFoundException ex) 
        {
            java.util.logging.Logger.getLogger(SubscriberWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } 
        catch (InstantiationException ex) 
        {
            java.util.logging.Logger.getLogger(SubscriberWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        catch (IllegalAccessException ex) 
        {
            java.util.logging.Logger.getLogger(SubscriberWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        catch (javax.swing.UnsupportedLookAndFeelException ex) 
        {
            java.util.logging.Logger.getLogger(SubscriberWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() 
        {
            public void run() 
            {
                new SubscriberWindow().setVisible(true);
            }
        });
    }

    private javax.swing.JButton Artist1;
    private javax.swing.JButton Artist2;
    private javax.swing.JButton Artist3;
    private javax.swing.JTextArea TextInformation;
    private javax.swing.JLabel jLabel1;
}
