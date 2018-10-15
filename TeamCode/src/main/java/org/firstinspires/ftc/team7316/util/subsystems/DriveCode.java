package org.firstinspires.ftc.team7316.util.subsystems;

import org.firstinspires.ftc.team7316.util.Hardware;
import org.firstinspires.ftc.team7316.util.commands.Command;
import org.firstinspires.ftc.team7316.util.commands.TeleopDrive;

public class DriveCode extends Subsystem {
    @Override
    public void reset() {
        Hardware.instance.leftmotor.setPower(0);
        Hardware.instance.rightmotor.setPower(0);
        Hardware.instance.centermotor.setPower(0);
    }

    @Override
    public Command defaultAutoCommand() {
        return null;
    }
    TeleopDrive teleopDrive;
    @Override
    public Command defaultTeleopCommand() {
        return new TeleopDrive();
    }
    public void driveMotorSet(double leftset, double rightset){
        Hardware.instance.leftmotor.setPower(leftset);
        Hardware.instance.rightmotor.setPower(rightset);
    }
    public void strafeMotorSet(double power){
        Hardware.instance.centermotor.setPower(power);
    }
}
