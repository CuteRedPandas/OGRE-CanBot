// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Drivetrain extends SubsystemBase {
  /** Creates a new Drivetrain. */
  
  private WPI_TalonSRX leftBackMotor = new WPI_TalonSRX(Constants.kLeftBackMotor);
  private WPI_TalonSRX leftFrontMotor = new WPI_TalonSRX(Constants.kLeftFrontMotor);
  private WPI_TalonSRX rightFrontMotor = new WPI_TalonSRX(Constants.kRightFrontMotor);
  private WPI_TalonSRX rightBackMotor = new WPI_TalonSRX(Constants.kRightBackMotor);

  private MotorControllerGroup leftMotors = new MotorControllerGroup(leftBackMotor, leftFrontMotor);
  private MotorControllerGroup rightMotors = new MotorControllerGroup(rightBackMotor, rightFrontMotor);

  public Drivetrain() {
    rightMotors.setInverted(true);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

    public void setMotors(double leftSpeed, double rightSpeed) {
      leftMotors.set(leftSpeed);
      rightMotors.set(rightSpeed);  
    }
}
