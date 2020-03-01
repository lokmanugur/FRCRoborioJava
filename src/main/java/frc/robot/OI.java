/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.button.Button;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.commands.MotionSquences;

/**
 * Add your docs here.
 */
public class OI {
    private Joystick Joystick = new Joystick(Constants.JOYSTIC_PORT_NUMBER);
    private Button button = new JoystickButton(Joystick, Constants.AUTONOMOUS_BUTTON);
    

    public OI(){
        button.whenPressed(new MotionSquences());
    }
    
    public double getRawAxis(int axis){
        return getAccelerator(Joystick.getRawAxis(axis)); 
    }

    public boolean getButton(int button) {
        return Joystick.getRawButton(button);
    }

    public double getAccelerator(double accelerate){
       double rawAxis=Joystick.getRawAxis(3);
        if(rawAxis<0)
        return rawAxis*accelerate;
        else
        return rawAxis*(-accelerate);
    }
}

