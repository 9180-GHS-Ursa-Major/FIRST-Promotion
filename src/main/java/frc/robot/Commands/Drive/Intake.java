package frc.robot.Commands.Drive;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constants.InitPhrases;
import frc.robot.Constants.IntakeConstants;
import frc.robot.Subsystems.IntakeSubsytem;

public class Intake extends Command {
    private final IntakeSubsytem intakeSubsytem;
    Timer timer = new Timer();

    public Intake(IntakeSubsytem intakeSubsytem) {
        this.intakeSubsytem = intakeSubsytem;
    }

    @Override
    public void initialize() {
        timer.reset();
        timer.start();
        System.out.println(InitPhrases.intake);
    }

    @Override
    public void execute() {
        intakeSubsytem.intake(IntakeConstants.intakeSpeed);
    }

    @Override
    public void end(boolean interrupted) {
        intakeSubsytem.stopIntake();
        timer.stop();
    }

    @Override
    public boolean isFinished() {
        return timer.get() >= IntakeConstants.intakeTime;
    }
}
