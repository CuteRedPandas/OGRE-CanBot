// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import frc.robot.commands.ArcadeDriveCmd;
import frc.robot.commands.CrushCan;
import frc.robot.subsystems.Crusher;
import frc.robot.subsystems.Drivetrain;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

public class RobotContainer {

  public final Drivetrain drivetrain = new Drivetrain();
  public final Crusher crusher = new Crusher();

  private final Joystick pilotController = new Joystick(0);

  public RobotContainer() {
    drivetrain.setDefaultCommand(
          new ArcadeDriveCmd(drivetrain, () -> pilotController.getRawAxis(1), () -> pilotController.getRawAxis(3))
    );
    crusher.setDefaultCommand(new CrushCan(crusher, 0));

    configureButtonBindings();
  }

  private void configureButtonBindings() {
    new JoystickButton(pilotController, Constants.kRightTriggerAxis).whileTrue(new CrushCan(crusher, 0.5));
    new JoystickButton(pilotController, Constants.kLeftTriggerAxis).whileTrue(new CrushCan(crusher, -0.5));
  }

  public Command getAutonomousCommand() {
    return null;
  }

}
