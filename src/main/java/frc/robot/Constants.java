package frc.robot;

public final class Constants {
    
    public static class OperatorConstants {
        public static final int kDrivercontrollerPort = 0;
        public static final int kArmControllerPort = 1;
    }

    public static class DriveConstants {
        public static final int kFRPort = 2;
        public static final int kFLPort = 1;
        public static final int kBLPort = 3;
        public static final int kBRPort = 4;
    }

    public static class EncoderConstants {
        public static final double wheelDiameterInches = 6;
        public static final double encoderResolution = 2048.0;
        public static final double wheelCircumference = Math.PI * wheelDiameterInches;
        public static final double distancePerPulse = wheelCircumference / encoderResolution;
    }

    public static class ArmConstants {
        public static final int kArmPort1 = 5;
        public static final int kArmPort2 = 8;
    }

    public static class IntakeConstants {
        public static final int kIntakePort1 = 0;
        public static final int kIntakePort2 = 7;
        public static final double intakeSpeed = 0.50;
        public static final double intakeTime = 2.0;
    }

    public class InitPhrases {
        public static final String drive = "Driving...";
        public static final String armup = "Controlling arm up...";
        public static final String armdown = "Sending arm down...";
        public static final String intake = "Intaking...";
        public static final String outtake = "Dropping...";
    }
}
