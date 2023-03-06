// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import java.util.function.Supplier;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Drivetrain;

public class ArcadeDriveCmd extends CommandBase {
  
private final Drivetrain drivetrain;
private final Supplier<Double> speedFunction, turnFunction;

  public ArcadeDriveCmd(Drivetrain drivetrain, //
      Supplier<Double> speedFunction, Supplier<Double> turnFunction) {
    this.speedFunction = speedFunction;
    this.turnFunction = turnFunction;
    this.drivetrain = drivetrain;
    addRequirements(drivetrain);
  }

  @Override 
  public void initialize() {
    System.out.println("ArcadeDriveCmd started!");
  }

  @Override
  public void execute() {
    double realTimeSpeed = speedFunction.get();
    double realTimeTurn = turnFunction.get();

    double left = realTimeSpeed + realTimeTurn;
    double right = realTimeSpeed - realTimeTurn;
    drivetrain.setMotors(left, right);
  }

  @Override
  public void end(boolean interrupted) {
    System.out.println("ArcadeDriveCmd ended!");
  }

  @Override
  public boolean isFinished() {
    return false;
  }
}
