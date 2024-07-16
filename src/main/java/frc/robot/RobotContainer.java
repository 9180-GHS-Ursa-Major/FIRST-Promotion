// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.button.CommandJoystick;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.Commands.Drive.ArmControlUp;
import frc.robot.Commands.Drive.Intake;
import frc.robot.Commands.Drive.JoystickDrive;
import frc.robot.Commands.Drive.Spitty;
import frc.robot.Constants.OperatorConstants;
import frc.robot.Subsystems.ArmSubsystem;
import frc.robot.Subsystems.DrivetrainSubsystem;
import frc.robot.Subsystems.IntakeSubsytem;

public class RobotContainer {

  //Subsytems
  private final ArmSubsystem armSubsystem = new ArmSubsystem();
  private final DrivetrainSubsystem drivetrainSubsystem = new DrivetrainSubsystem();
  private final IntakeSubsytem intakeSubsytem = new IntakeSubsytem();

  //Commands
  private final JoystickDrive drive = new JoystickDrive(drivetrainSubsystem);
  private final ArmControlUp arm = new ArmControlUp(armSubsystem);
  private final Intake intake = new Intake(intakeSubsytem);
  private final Spitty spitty = new Spitty(intakeSubsytem);

  //Triggers
  private final Trigger in = new Trigger(armController.rightBumper());
  private final Trigger out = new Trigger(armController.leftBumper());
  private final Trigger brake = new Trigger(driverController.button(3));
  private final Trigger coast = new Trigger(driverController.button(4));


  public static final CommandJoystick driverController = 
      new CommandJoystick(OperatorConstants.kDrivercontrollerPort);

  public static final CommandXboxController armController = 
      new CommandXboxController(OperatorConstants.kArmControllerPort);
  

  public RobotContainer() {
    configureBindings();
  }

  private void configureBindings() {

    brake.onTrue(drivetrainSubsystem.setBrake());
    coast.onTrue(drivetrainSubsystem.setCoast());
    in.whileTrue(intake);
    out.whileTrue(spitty);
    drivetrainSubsystem.setDefaultCommand(drive);
    armSubsystem.setDefaultCommand(arm);
  }

  public Command getAutonomousCommand() {
    return Commands.print("No autonomous command configured");
  }
}
