package videoplayer;

import java.awt.event.*;
import java.io.File;
import java.io.FileNotFoundException;
import Console.*;
import Utilities.*;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import javax.media.*;
import javax.swing.*;

/**
 *
 * @author Jun
 */
public class VideoPlayer extends javax.swing.JFrame implements ActionListener, ControllerListener, IVideoPlayer{

    private File _file;
    private final IConsole _console;
    private Player _player;
    
    public VideoPlayer() 
    {
        _console = new ConsoleFactory().GetConsole();
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jMenu1.setText("File");
        jMenu1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu1ActionPerformed(evt);
            }
        });

        jMenuItem1.setText("OPEN");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        setSize(new java.awt.Dimension(416, 339));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jMenu1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu1ActionPerformed
    }//GEN-LAST:event_jMenu1ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        getFile();
        CreateFile();
    }//GEN-LAST:event_jMenuItem1ActionPerformed
    
    @Override
    public void actionPerformed(ActionEvent e){}

    @Override
    public void controllerUpdate(ControllerEvent ce) 
    {
        try
        {
            Container container = getContentPane();
            if(ce instanceof RealizeCompleteEvent)
            {
                Component visualComponent = _player.getVisualComponent();
                if(visualComponent != null)
                {
                    container.add(visualComponent,BorderLayout.CENTER);
                }
                
                Component controllerContainer = _player.getControlPanelComponent();
                if(controllerContainer != null)
                {
                    container.add(controllerContainer,BorderLayout.SOUTH);
                }
                
                container.doLayout();
            }
        }
        catch(Exception e)
        {
            _console.WriteLine(e.getMessage());
        }
    }

    @Override
    public void getFile() 
    {
        try
        {
            JFileChooser chooseFile = new JFileChooser();
            chooseFile.showOpenDialog(this);
            _file = chooseFile.getSelectedFile();
            if(!_file.exists())
            {
                _console.WriteLine("FileNotFoundException: Could not find file");
                throw new FileNotFoundException();
            }
        }
        catch(Exception e)
        {
            _console.WriteLine(e.getMessage());
        }
    }
    
    @Override
    public void CreateFile() 
    {
        try 
        {
            _player = Manager.createRealizedPlayer(_file.toURL());
            _player.addControllerListener(this);
            _player.realize();
        } 
        catch (Exception e) 
        {
            _console.WriteLine(e.getMessage());
        }
    }
    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VideoPlayer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VideoPlayer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VideoPlayer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VideoPlayer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VideoPlayer().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JMenu jMenu1;
    public javax.swing.JMenuBar jMenuBar1;
    public javax.swing.JMenuItem jMenuItem1;
    // End of variables declaration//GEN-END:variables
    


    
}
