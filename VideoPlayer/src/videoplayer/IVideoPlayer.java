/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package videoplayer;

import java.awt.event.*;
import javax.media.ControllerEvent;

/**
 *
 * @author Jun
 */
public interface IVideoPlayer 
{
    public void actionPerformed(ActionEvent e);
    
    public void controllerUpdate(ControllerEvent ce);
    
    public void getFile();
    
    public void CreateFile();
}
