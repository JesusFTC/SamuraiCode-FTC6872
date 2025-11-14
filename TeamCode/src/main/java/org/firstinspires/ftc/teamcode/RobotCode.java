package org.firstinspires.ftc.teamcode;


import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.Servo;


public class RobotCode extends OpMode {
    DcMotorEx m_Shooter1;
    DcMotorEx m_Shooter2;
    DcMotorEx m_Intake;
    public Servo Servo90;


    @Override
    public void init() {
        m_Shooter1=hardwareMap.get(DcMotorEx.class, "Shooter1");
        m_Shooter2=hardwareMap.get(DcMotorEx.class, "Shooter2");
        m_Intake=hardwareMap.get(DcMotorEx.class, "Intake");
        Servo90=hardwareMap.get(Servo.class, "Servo");

        m_Shooter1.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        m_Shooter1.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    }

    @Override
    public void loop() {
    telemetry.addData("Shooter1 Velocity", m_Shooter1.getVelocity());

    //intake
    if(gamepad1.left_trigger >= 0.1){
        m_Intake.setPower(1);
    }
    if(gamepad1.left_bumper){
        m_Intake.setPower(0);
    }

    //Shooter
    if (gamepad1.right_trigger >= 0.1){
        m_Shooter1.setPower(1);
        m_Shooter2.setPower(-1);
    }
    else {
        m_Shooter1.setPower(0);
        m_Shooter2.setPower(0);
    }

    //condicionales

    if(m_Intake.getPower() > 0 && m_Shooter1.getVelocity() < 500){
        Servo90.setPosition(0);
    }
    if(m_Shooter1.getVelocity() >= 1200){
        Servo90.setPosition(0.5);
    }

    }
}