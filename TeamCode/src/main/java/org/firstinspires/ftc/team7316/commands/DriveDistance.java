package org.firstinspires.ftc.team7316.commands;

import android.util.Log;

import org.firstinspires.ftc.team7316.util.Hardware;
import org.firstinspires.ftc.team7316.util.commands.Command;
import org.firstinspires.ftc.team7316.util.copypastaLib.CombinedPath;
import org.firstinspires.ftc.team7316.util.subsystems.Subsystem;
import org.firstinspires.ftc.team7316.util.subsystems.Subsystems;

public class DriveDistance extends Command {
    int ticks;
    public DriveDistance(int ticks){
        this.ticks=ticks;
    }
    @Override
    public void init() {
        for (int i = 0; i < 10; i++) {
            Log.d("init", "------------------------");
        }
        Subsystems.instance.driveCode.resetMotors();
        if(ticks>0){
            Subsystems.instance.driveCode.setMotorPaths(new CombinedPath.LongitudalTrapezoid(0,ticks,1500,1500));
        }
        else {
            Subsystems.instance.driveCode.setMotorPaths((new CombinedPath.LongitudalTrapezoid(0,ticks,-1500,-1500)));
        }

    }

    @Override
    public void loop(){
        Subsystems.instance.driveCode.driveWithPID();
    }

    @Override
    public boolean shouldRemove() {
        return Subsystems.instance.driveCode.checkMotorsFinished();
    }

    @Override
    protected void end() {
        Subsystems.instance.driveCode.driveMotorSet(0,0);
    }
}
