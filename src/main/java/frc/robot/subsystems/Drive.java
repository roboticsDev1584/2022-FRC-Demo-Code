// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.*;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Drive extends SubsystemBase {
  /** Creates a new Drive. */
  public CANSparkMax driveLeft1;
  public CANSparkMax driveLeft2;

  public CANSparkMax driveRight1;
  public CANSparkMax driveRight2;

  public Drive() {
    //initializes the motors to CANSparkMax motors (from the imported library), their ports (14, 15, 1, and 17), and the type of motor (they are all DC brushless motors)
    driveLeft1 = new CANSparkMax(14, MotorType.kBrushless);
    driveLeft2 = new CANSparkMax(15, MotorType.kBrushless);

    driveRight1 = new CANSparkMax(1, MotorType.kBrushless);
    driveRight2 = new CANSparkMax(17, MotorType.kBrushless);
  }

  public void setPower(double leftPower, double rightPower) {
    //this sets the drive chassis motor modes so that they move normally
    driveLeft1.setIdleMode(IdleMode.kCoast);
    driveLeft2.setIdleMode(IdleMode.kCoast);
    driveRight1.setIdleMode(IdleMode.kCoast);
    driveRight2.setIdleMode(IdleMode.kCoast);

    //this links both left motors and both right motors together
    driveLeft2.follow(driveLeft1);
    driveRight2.follow(driveRight1);

    //this sets the motor speeds of driveLeft1 and driveRight1 (which in turn are mimicked by driveLeft2 and driveRight2)
    //.set() function sets the power of the motor, and a negative sign is used for the left motors' power so that it is inverted from the right side (allowing it to move straight)
    driveLeft1.set(-Math.pow(leftPower, 3));
    driveRight1.set(Math.pow(rightPower, 3));
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
