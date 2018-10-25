package org.firstinspires.ftc.team7316.commands;

import org.firstinspires.ftc.team7316.util.Constants;
import org.firstinspires.ftc.team7316.util.commands.Command;
import org.firstinspires.ftc.team7316.util.input.OI;
import org.firstinspires.ftc.team7316.util.subsystems.DriveCode;
import org.firstinspires.ftc.team7316.util.subsystems.Subsystem;
import org.firstinspires.ftc.team7316.util.subsystems.Subsystems;

public class TeleopDrive extends Command {
    double leftset=0;
    double rightset=0;
    double centerset=0;
    double leftspeed=0;
    double rightspeed=0;
    double centerspeed=0;
    boolean fast;
    @Override
    public void init() {

    }

    @Override
    public void loop() {
        if(OI.instance.gp1.rightTriggerWrapper.pressedState()){
            fast= true;
        }
        else {
            fast=false;
        }
        double leftTarget = OI.instance.gp1.left_stick.getY();
        double rightTarget = OI.instance.gp1.left_stick.getY();
        leftTarget+=OI.instance.gp1.right_stick.getX();
        rightTarget-=OI.instance.gp1.right_stick.getX();
        double centerTarget=OI.instance.gp1.left_stick.getX();

        if(Math.abs(leftset)<Math.abs(leftTarget)){
            leftset+=(Math.abs(leftTarget)/leftTarget)* Constants.ACCELERATION_SPEED;
        }
        if (Math.abs(rightset)<Math.abs(rightTarget)){
            rightset+=(Math.abs(rightTarget)/rightTarget)* Constants.ACCELERATION_SPEED;
        }
        if (Math.abs(centerset)<Math.abs(centerTarget)){
            centerset+=(Math.abs(centerTarget)/centerTarget)* Constants.ACCELERATION_SPEED;
        }
        if (>leftTarget){
            leftset=leftTarget;
        }
        if (rightset>rightTarget){
            rightset=rightTarget;
        }
        if(centerset>centerTarget){
            centerset=centerTarget;
        }
        if (fast==false){
            leftset*=.6;
            rightset*=.6;
            centerset*=.6;
        }
        Subsystems.instance.driveCode.driveMotorSet(leftset,rightset);
        Subsystems.instance.driveCode.strafeMotorSet(centerset);
    }

    @Override
    public boolean shouldRemove() {
        return false;
    }

    @Override
    protected void end() {

    }
}
