package org.firstinspires.ftc.team7316.commands;

import org.firstinspires.ftc.team7316.util.Scheduler;
import org.firstinspires.ftc.team7316.util.commands.Command;

public class TestAutoPath extends Command {
    @Override
    public void init() {
    }

    @Override
    public void loop() {
        Scheduler.instance.add(new DriveDistance(10));
    }

    @Override
    public boolean shouldRemove() {
        return false;
    }

    @Override
    protected void end() {

    }
}
