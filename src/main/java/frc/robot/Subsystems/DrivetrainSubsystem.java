package frc.robot.Subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkBase.IdleMode;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.DriveConstants;
import frc.robot.Constants.EncoderConstants;

public class DrivetrainSubsystem extends SubsystemBase {
    
    //Motor controllers
    private final CANSparkMax frontRightMotor = new CANSparkMax(DriveConstants.kFRPort, MotorType.kBrushed);
    private final CANSparkMax frontLeftMotor = new CANSparkMax(DriveConstants.kFLPort, MotorType.kBrushed);
    private final CANSparkMax backRightMotor = new CANSparkMax(DriveConstants.kBRPort, MotorType.kBrushed);
    private final CANSparkMax backLeftMotor = new CANSparkMax(DriveConstants.kBLPort, MotorType.kBrushed);

    //Drivetrain (not swerve :[)
    DifferentialDrive drive = new DifferentialDrive(frontLeftMotor, frontRightMotor);
    
    Encoder leftEncoder = new Encoder(1, 0);
    //Didn't work before
    Encoder rightEncoder = new Encoder(4, 5);

    /**Subsystem for the drivetrain */
    public DrivetrainSubsystem() {
        backLeftMotor.follow(frontLeftMotor);
        backRightMotor.follow(frontRightMotor);

        frontLeftMotor.setInverted(true);
        backLeftMotor.setInverted(true);
        leftEncoder.setDistancePerPulse(EncoderConstants.distancePerPulse);
        rightEncoder.setDistancePerPulse(EncoderConstants.distancePerPulse);
    }

    /**Drives the robot according to arcade drive */
    public void arcadeDrive(double spd, double rot) {
        drive.arcadeDrive(spd,rot);
    }

    public Command setBrake() {
        return runOnce(() -> {
            backLeftMotor.setIdleMode(IdleMode.kBrake);
            backRightMotor.setIdleMode(IdleMode.kBrake);
            frontLeftMotor.setIdleMode(IdleMode.kBrake);
            frontRightMotor.setIdleMode(IdleMode.kBrake);
        });
    }

    public Command setCoast() {
        return runOnce(() -> {
            backLeftMotor.setIdleMode(IdleMode.kCoast);
            backRightMotor.setIdleMode(IdleMode.kCoast);
            frontLeftMotor.setIdleMode(IdleMode.kCoast);
            frontRightMotor.setIdleMode(IdleMode.kCoast);
        });
    }

    public double rightEncoderDistance() {
        return rightEncoder.getDistance();
    }

    public double leftEncoderDistance() {
        return leftEncoder.getDistance();
    }

    public double velocity() {
        return leftEncoder.getRate();
    }

    public void periodic() {
        SmartDashboard.putNumber("Distance L", leftEncoderDistance());
    }
    
}
