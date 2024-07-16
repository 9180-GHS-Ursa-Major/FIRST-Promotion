package frc.robot.Commands.Drive;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.RobotContainer;
import frc.robot.Constants.InitPhrases;
import frc.robot.Subsystems.DrivetrainSubsystem;

public class JoystickDrive extends Command {
    @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})

    private final DrivetrainSubsystem m_drivetrainSubsystem;

    public JoystickDrive(DrivetrainSubsystem drivetrainSubsystem) {
        m_drivetrainSubsystem = drivetrainSubsystem;
        addRequirements(drivetrainSubsystem);
    }

    @Override
    public void initialize() {
        System.out.println(InitPhrases.drive);
    }

    @Override
    public void execute() {
        double rot = -RobotContainer.driverController.getX();
        double speed = RobotContainer.driverController.getY();

        m_drivetrainSubsystem.arcadeDrive(speed, rot);
    }

    @Override
    public boolean isFinished() {
        return false;
    }
}
