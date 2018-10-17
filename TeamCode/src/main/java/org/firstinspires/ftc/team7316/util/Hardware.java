package org.firstinspires.ftc.team7316.util;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.team7316.util.motorwrappers.DCMotorWrapper;

/**
 * Contains all the hardware names and actual hardware objects
 */

public class Hardware {

    public static Hardware instance = null;

    public static final String tag = "IronPanthers";

    public static Telemetry telemetry;

    public DcMotor leftmotor;
    public DcMotor rightmotor;
    public DcMotor centermotor;
    public DcMotor climbmotor;

    public DCMotorWrapper leftmotorWrapper;
    public DCMotorWrapper rightmotorWrapper;
    public DCMotorWrapper centermotorWrapper;

    //Create all the hardware fields
    public final String leftMotorName = "lmotor";
    public final String rightMotorName = "rmotor";
    public final String centerMotorName = "cmotor";
    public final String climbMotorName = "clmotor";

    /**
     * Initialize all the hardware fields here
     */
    public Hardware (HardwareMap map) {
        leftmotor = map.dcMotor.get(leftMotorName);
        rightmotor= map.dcMotor.get(rightMotorName);
        centermotor=map.dcMotor.get(centerMotorName);
        climbmotor=map.dcMotor.get(climbMotorName);

        leftmotorWrapper = new DCMotorWrapper(leftmotor, new PID(Constants.DRIVE_P, Constants.DRIVE_I, Constants.DRIVE_D, Constants.DRIVE_F, 0));
        rightmotorWrapper = new DCMotorWrapper(rightmotor, new PID(Constants.DRIVE_P, Constants.DRIVE_I, Constants.DRIVE_D, Constants.DRIVE_F, 0));
        centermotorWrapper = new DCMotorWrapper(centermotor, new PID(Constants.DRIVE_P, Constants.DRIVE_I, Constants.DRIVE_D, Constants.DRIVE_F, 0));
    }

    public static void setHardwareMap(HardwareMap map) {
        instance = new Hardware(map);
    }

    public static void setTelemetry(Telemetry telemetry) {
        Hardware.telemetry = telemetry;
    }

    public static void log(String caption, Object value) {
        if (telemetry != null) {
            telemetry.addData(caption, value);
        }
    }
}