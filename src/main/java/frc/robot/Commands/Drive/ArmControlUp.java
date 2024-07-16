package frc.robot.Commands.Drive;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Robot;
import frc.robot.RobotContainer;
import frc.robot.Constants.InitPhrases;
import frc.robot.Subsystems.ArmSubsystem;

public class ArmControlUp extends Command {
    
    @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})

    private final ArmSubsystem m_ArmSubsystem;

    public ArmControlUp(ArmSubsystem armSubsystem) {
        m_ArmSubsystem = armSubsystem;
        addRequirements(armSubsystem);
    }

    @Override
    public void initialize() {
        System.out.println(InitPhrases.armup);
    }

    @Override
    public void execute() {
        double armSpeed = RobotContainer.armController.getRightY();

        m_ArmSubsystem.armControl(armSpeed);
    }

    @Override
    public boolean isFinished() {
        return false;
    }
}
