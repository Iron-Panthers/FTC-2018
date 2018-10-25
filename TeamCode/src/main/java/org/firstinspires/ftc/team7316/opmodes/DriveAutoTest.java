package org.firstinspires.ftc.team7316.opmodes;

import android.util.Log;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.team7316.commands.DriveDistance;
import org.firstinspires.ftc.team7316.util.Constants;
import org.firstinspires.ftc.team7316.util.Hardware;
import org.firstinspires.ftc.team7316.util.Scheduler;
import org.firstinspires.ftc.team7316.util.input.OI;
import org.firstinspires.ftc.team7316.util.modes.AutoBaseOpMode;
import org.firstinspires.ftc.team7316.util.subsystems.Subsystem;
import org.firstinspires.ftc.team7316.util.subsystems.Subsystems;

@Autonomous
public class DriveAutoTest extends AutoBaseOpMode {

    double power = 0;

    @Override
    public void onInit() {
        Scheduler.instance.add(new DriveDistance(Constants.inchesToTicks(10)));
    }

    @Override
    public void onLoop() {
        telemetry.addData("Ticks", ((double)Hardware.instance.leftmotor.getCurrentPosition()) / (Constants.ENCODER_TICK_PER_REV * Constants.ENCODER_REV_PER_WHEEL_REV) * Constants.WHEEL_CIRCUMFERENCE);
    }
}
